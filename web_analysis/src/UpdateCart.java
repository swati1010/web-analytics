

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.DBConnection;
import codes.UserCredentials;

/**
 * Servlet implementation class UpdateCart
 */
@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCart() {
        super();
        // TODO Auto-generated constructor stub
    }
    static int hitsCount=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		

		Connection con = DBConnection.getDBConnection();

		String uname = UserCredentials.getUsername();
		String email = UserCredentials.getEmailId();
		int userid = UserCredentials.getUserid();
		String url = request.getRequestURL().toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date=new java.util.Date();  
		String d=dateFormat.format(date);


		try{
			


		if (hitsCount == 0) 
		{
			hitsCount++;
		PreparedStatement ps=con.prepareStatement("insert into  clicks(url,hits,date) values(?,?,?)");
				    ps.setString(1,url);
				    ps.setInt(2,hitsCount);
				   
				    ps.setString(3,d);	
				    int i=ps.executeUpdate();

		}
		else
		{

		hitsCount++;

		PreparedStatement ps3=con.prepareStatement("update clicks set hits='"+hitsCount+"' where date='"+d+"' and url='"+url+"'");
			  
			  
			  int j=ps3.executeUpdate();


		}
		}
		catch(Exception e){
			System.out.print(e);
		}


		
		
		
		try {
			String button = request.getParameter("cartbtn");
			
			String[] pvalues = request.getParameterValues("remove");
			String[] uvalues = request.getParameterValues("update");
			
			if(button.equals("Update Cart"))
			{
				if(!(pvalues == null))
				{
				for(int i=0; i < pvalues.length; i++)
				{
					PreparedStatement ps = con.prepareStatement("DELETE FROM cart WHERE productid = '" + pvalues[i] + "' AND userid = "+userid);
					int res = ps.executeUpdate();
				}
				}
				if(!(uvalues == null))
				{
				for(int i=0; i < uvalues.length; i++)
				{
					String qty = request.getParameter("qty"+uvalues[i]);
					System.out.println("here"+qty);
					String subtotal = request.getParameter("st"+uvalues[i]);
					String prodId = request.getParameter("pid"+uvalues[i]);
					int q = Integer.parseInt(qty);
					int st = Integer.parseInt(subtotal);
					int total = q*st;
					PreparedStatement ps = con.prepareStatement("UPDATE cart SET qty='" + qty + "',total='" + total + "' WHERE userid = " + userid + " and productid = '" + prodId + "'");
					int res = ps.executeUpdate();
				}
				}
				response.sendRedirect("cart.jsp");
			}
			else
				if(button.equals("Checkout"))
				{
					response.sendRedirect("checkout.jsp");
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.DBConnection;


/**
 * Servlet implementation class SetDiscount
 */
@WebServlet("/SetDiscount")
public class SetDiscount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetDiscount() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		try {
			String pid = request.getParameter("pid");
			int discount = Integer.parseInt(request.getParameter("pdesc"));
			String fromdt = request.getParameter("fdate");
			String todt = request.getParameter("tdate");
			
			PreparedStatement ps1=con.prepareStatement("select * from product where productId='"+pid+"'");
			ResultSet rs1=ps1.executeQuery();
			String smrp="";
			int prc=0;
			if(rs1.next()){
				smrp=rs1.getString("mrp");
				prc=Integer.parseInt(smrp);
			}
			int dis=prc*discount/100;
			int after_dis=prc-dis;
			
			
			System.out.println(prc);
			System.out.println(dis);
			PreparedStatement ps = con.prepareStatement("UPDATE product SET price='"+after_dis+"', discount= '" + discount + "',dfromdate= '" + fromdt + "',ftodate= '" + todt + "',after_dis='"+smrp+"' WHERE productId = '" + pid + "'");			int r = ps.executeUpdate();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("/setdiscount.jsp");
	        rd.forward(request, response);
	        out.print("<html><body><script>alert('Discount set sceessfuly to this product');</script></body></html>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

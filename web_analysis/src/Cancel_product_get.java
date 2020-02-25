

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.DBConnection;
import codes.EmailUtility;
import codes.UserCredentials;

/**
 * Servlet implementation class Cancel_product_get
 */
@WebServlet("/Cancel_product_get")
public class Cancel_product_get extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int hitsCount=0;
	 private static String host;
	    private static String port;
	    private static String user;
	    private static String pass;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancel_product_get() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		host = "smtp.gmail.com";
        port = "587";
        user = "analysis.customer@gmail.com";
        pass = "analysis123";
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
		try{
			
			int id=Integer.parseInt(request.getParameter("id"));
			PreparedStatement ps=con.prepareStatement("update invoice set status=0 where cid='"+userid+"' and id='"+id+"'");
			int i=ps.executeUpdate();
			
			PreparedStatement pse = con.prepareStatement("SELECT p_name,email from invoice where cid='"+userid+"' and status=0");
			ResultSet rse = pse.executeQuery();
			rse.last();
			String[] addresses = new String[rse.getRow()];
			rse.beforeFirst();
			int cnt = 0;
			String content="";
			while(rse.next())
			{
				content=rse.getString("p_name");
				addresses[cnt++] = rse.getString("Email");
			}
			
			
			
			
			
			String subject = "Your product key has been canceled ";
			
			EmailUtility.sendEmailWithAttachment(host, port, user, pass, addresses, subject, content);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">alert('Successful Done')</script>");		
			RequestDispatcher rd = request.getRequestDispatcher("your_account.jsp");
	        rd.include(request, response);
				
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}

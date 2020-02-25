

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
import codes.EmailUtility;

/**
 * Servlet implementation class Email_register
 */
@WebServlet("/Email_register")
public class Email_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
	 private static String host;
	    private static String port;
	    private static String user;
	    private static String pass;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Email_register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			
			int offid = 0;
			host = "smtp.gmail.com";
	        port = "587";
	        user = "analysis.customer@gmail.com";
	        pass = "analysis123";
	        	
			
			PreparedStatement pse = con.prepareStatement("SELECT Email from user where Email='"+email+"'");
			ResultSet rse = pse.executeQuery();
			rse.last();
			String[] addresses = new String[rse.getRow()];
			rse.beforeFirst();
			int cnt = 0;
	  
			while(rse.next())
			{
				addresses[cnt++] = rse.getString("Email");
			}
			
			String subject = "Registration";
			String content = "<html><body><div><p>Thank you for Registration</p></div></body></html>";
			EmailUtility.sendEmailWithAttachment(host, port, user, pass, addresses, subject, content);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">alert('Successful Done')</script>");		
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        rd.include(request, response);
	        
	        
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}

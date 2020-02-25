

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.DBConnection;
import codes.EmailUtility;

/**
 * Servlet implementation class Send_enq
 */
@WebServlet("/Send_enq")
public class Send_enq extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
	 private static String host;
	    private static String port;
	    private static String user;
	    private static String pass;
	    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send_enq() {
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
		PrintWriter pw=response.getWriter();
		try {
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String email=request.getParameter("email");
			String subject=request.getParameter("subject");
			String message=request.getParameter("message");
			int offid = 0;
			host = "smtp.gmail.com";
	        port = "587";
	        user = "befinalproj@gmail.com";
	        pass = "spkspkspk";
	        	//{"nausheen@jeettechnosolutions.com,dinbandhu@jeettechnosolutions.com,anilkumar@jeettechnosolutions.com,sarita@jeettechnosolutions.com,"};
			
			
			
			/*PreparedStatement pse = con.prepareStatement("select email from admin_login");
			ResultSet rse = pse.executeQuery();
			rse.last();
			String[] addresses = new String[rse.getRow()];
			rse.beforeFirst();
			int cnt = 0;
	  
			while(rse.next())
			{
				addresses[cnt++] = rse.getString("email");
			}*/
	        
	        String[] addresses = {"swatimp10@gmail.com"};
			
			
			String content = "<html><body><div><p>Name:- "+fname+"<br><label> email:-</label>"+email+"<br> description:-"+message+"<br> Mobile:-"+lname+"</p></div></body></html>";
			EmailUtility.sendEmailWithAttachment(host, port, user, pass, addresses, subject, content);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("contact.jsp").include(request, response);
	        out.print("<html><body><script>alert('Thank you');</script></body></html>");
	        
		} catch (Exception e) {
			// TODO: handle exception
			pw.print(e);
		}
	}

}



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import codes.DBConnection;
import codes.UserCredentials;

/**
 * Servlet implementation class Consumer_req
 */
@WebServlet("/Consumer_req")
public class Consumer_req extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consumer_req() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid=UserCredentials.getUserid();
		Connection con=DBConnection.getDBConnection();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		PrintWriter out=response.getWriter();

		try {
			PreparedStatement ps=con.prepareStatement("insert into consumer_req(fname,lname,email,subject,message,uid)values(?,?,?,?,?,'"+userid+"')");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, subject);
			ps.setString(5, message);
			int i=ps.executeUpdate();
			if(i!=0){
				out.println("<script type=\"text/javascript\">alert('Thanks ')</script>");		

				RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
		        rd.include(request, response);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

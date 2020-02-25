

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
import codes.GetSetIds;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
    String uname = "";
    String email = "";
    String pwd = "";
     String location="";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		try {
			uname = request.getParameter("username");
			email = request.getParameter("email");
			pwd = request.getParameter("password");
			location = request.getParameter("location");
			String date1="12/01/1012";
			PreparedStatement ps1 = con.prepareStatement("select * from user where Email = '" + email + "'");
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			{
				String msg = "Email already registered";
				String link = "customerlogin.jsp";
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp?msg="+msg+"&link="+link);
		        rd.forward(request, response);
			}
			else
			{
				int userid = GetSetIds.getUserId();
				
				PreparedStatement ps = con.prepareStatement("insert into user(UserId,Uname,Email,Password,location,user_identity,date) values(" + userid + ", '" + uname + "', '" + email + "', '" + pwd + "','"+location+"','new','"+date1+"')");
				int res = ps.executeUpdate();
				
				out.println("<script type=\"text/javascript\">alert('Successful Register')</script>");		

				RequestDispatcher rd = request.getRequestDispatcher("/Email_register?email="+email);
		        rd.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

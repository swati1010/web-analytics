

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
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
import javax.servlet.http.HttpSession;

import codes.DBConnection;
import codes.UserCredentials;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
	String uname = "";
	String pwd = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	      java.util.Date date=new java.util.Date();  
	      String d=dateFormat.format(date);
	      System.out.println(d); //2013/10/15 16:16:39
	      
	      
	      
	      
	      InetAddress ip=InetAddress.getLocalHost();
			 String s_ip=ip.toString();
		System.out.println(s_ip);
		try {
			uname = request.getParameter("username");
			System.out.println("user"+uname);
			pwd = request.getParameter("password");
			System.out.println(" pass "+pwd);

			PreparedStatement ps = con.prepareStatement("select * from user where email = '" + uname + "' and Password = '" + pwd + "'");
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				PreparedStatement ps1=con.prepareStatement("update user set start_time ='"+d+"',status=1,ip_address='"+s_ip+"',user_identity='repeated' where email='"+uname+"'" );
				int j=ps1.executeUpdate();
				 HttpSession session=request.getSession();  
			        session.setAttribute("name",uname);  
				UserCredentials.setUsername(rs.getString("Uname"));
				UserCredentials.setPassword(pwd);
				UserCredentials.setUserid(rs.getInt("UserId"));
				UserCredentials.setEmailId(""+rs.getString("Email"));
				RequestDispatcher rd = request.getRequestDispatcher("/Counts");
		        rd.forward(request, response);
			}
			else
			{
				out.println("<script type=\"text/javascript\">alert('Your email Id and password wrong')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		        rd.include(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

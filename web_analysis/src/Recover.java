

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.Captcha;
import codes.DBConnection;
import codes.EmailUtility;

/**
 * Servlet implementation class Recover
 */
@WebServlet("/Recover")
public class Recover extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String email = "";
    Connection con = DBConnection.getDBConnection();
    String newPwd = "";
    private static String host;
    private static String port;
    private static String user;
    private static String pass;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recover() {
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
			host = "smtp.gmail.com";
	        port = "587";
	        user = "analysis.customer@gmail.com";
	        pass = "analysis123";
			email = request.getParameter("email1");
			newPwd = Captcha.generateCaptcha();
			String[] respnt = {""+email};
			PreparedStatement ps = con.prepareStatement("update user set Password = '" + newPwd + "' where Email = '" + email + "'");
			int res = ps.executeUpdate();
			if(res > 0)
			{
				String subject = "Password Recovery Email";
				String content = "Your new Password is : " + newPwd + "";
				EmailUtility.sendEmailWithAttachment(host, port, user, pass, respnt, subject, content);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/customerlogin.jsp");
	        rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

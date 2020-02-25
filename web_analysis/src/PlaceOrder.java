


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codes.DBConnection;
import codes.GetSetIds;
import codes.UserCredentials;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con = DBConnection.getDBConnection();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
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
			HttpSession session = request.getSession(true);
			
			String totalsum=request.getParameter("sum");
			
			String country=request.getParameter("country");
			String name=request.getParameter("name");

			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String pin=request.getParameter("pin");

			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			
			int userid = UserCredentials.getUserid();
		
			PreparedStatement ps=con.prepareStatement("insert into user_detail(country,name,address,city,pin,email,phone,userid)values(?,?,?,?,?,?,?,?)");
			ps.setString(1,country);
			ps.setString(2,name);
			ps.setString(3,address);
			ps.setString(4,city);
			ps.setString(5,pin);
			ps.setString(6,email);
			ps.setString(7,phone);
			ps.setInt(8,userid);
			int i=ps.executeUpdate();
			
			response.sendRedirect("checkout3.jsp");
			System.out.println("succers");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

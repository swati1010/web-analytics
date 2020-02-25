

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.DBConnection;

/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/AddtoCart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCart() {
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
			System.out.println("here it is....");
			String name = "", email = "";
			String prodId = request.getParameter("pid");
			int userid = Integer.parseInt(request.getParameter("uid"));
			String qty = request.getParameter("qty");
			if(userid != 0)
			{
			
			System.out.println("here");
			PreparedStatement ps = con.prepareStatement("select * from user where UserId = " + userid + "");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				name = rs.getString("Uname");
				email = rs.getString("Email");
			}
			System.out.println("here "+name+" "+email);
			}
			response.sendRedirect("addtocart.jsp?prodId="+prodId+"&userid="+userid+"&cname="+name+"&email="+email+"&qty="+qty+"&shipping=0&backlink=single-product.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

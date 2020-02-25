

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import codes.DBConnection;
import codes.GetSetIds;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
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
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String pid = request.getParameter("pid");
			System.out.println(""+pid);
			String title = request.getParameter("ptitle");
			String descr = request.getParameter("pdesc");
			String brand = request.getParameter("pbrand");
			String linkofimg = request.getParameter("limg");
			String mrp = request.getParameter("mrp");
			String price = request.getParameter("price");
			String categories = request.getParameter("pcat");
			int prodid = GetSetIds.getProductid();
			String instk = request.getParameter("stock");
			String cod = request.getParameter("cod");
			String p_type = request.getParameter("p_type");
			System.out.println(""+instk+" "+cod);
			PreparedStatement ps1=con.prepareStatement("select productId from product where productId='"+pid+"'");
			ResultSet rs=ps1.executeQuery();
			
			if(rs.next()){
				out.println("<script type=\"text/javascript\">alert('productId already Exist')</script>");		

				RequestDispatcher rd = request.getRequestDispatcher("/addproduct.jsp");
		        rd.include(request, response);
			}
			else{
				PreparedStatement ps = con.prepareStatement("INSERT INTO product(ID, productId, title, description, imageUrlStr, mrp, price, categories, productBrand, inStock, codAvailable,p_type) VALUES (" + prodid + ", '" + pid + "', '" + title + "', '" + descr + "', '" + linkofimg + "', '" + mrp + "', '" + price + "', '" + categories + "', '" + brand + "', '" + instk + "', '" + cod + "','"+p_type+"')");
				int res = ps.executeUpdate();
			if(res > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/addproduct.jsp");
		        rd.forward(request, response);
		        out.print("<html><body><script>alert('Product Added Successfully');</script></body></html>");
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

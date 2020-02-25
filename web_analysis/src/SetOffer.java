

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

import weka.core.parser.JFlex.Out;
import codes.DBConnection;
import codes.EmailUtility;

/**
 * Servlet implementation class SetOffer
 */
@WebServlet("/SetOffer")
public class SetOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
	 private static String host;
	    private static String port;
	    private static String user;
	    private static String pass;
	    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetOffer() {
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
			String offer = request.getParameter("offers");
			String prodid = request.getParameter("products");
			int offid = 0;
			host = "smtp.gmail.com";
	        port = "587";
	        user = "analysis.customer@gmail.com";
	        pass = "analysis123";
	        	//{"nausheen@jeettechnosolutions.com,dinbandhu@jeettechnosolutions.com,anilkumar@jeettechnosolutions.com,sarita@jeettechnosolutions.com,"};
			PreparedStatement pso = con.prepareStatement("select offersid from offers where offer = '" + offer + "'");
			ResultSet rso = pso.executeQuery();
			if(rso.next())
			{
				offid = rso.getInt("offersid");
			}
			PreparedStatement ps = con.prepareStatement("update product set offers = " + offid + " where productId = '" + prodid + "'");
			int res = ps.executeUpdate();
			
			PreparedStatement pse = con.prepareStatement("SELECT distinct user.Email from user, cart WHERE user.UserId = cart.userid and cart.productid = '" + prodid + "'");
			ResultSet rse = pse.executeQuery();
			rse.last();
			String[] addresses = new String[rse.getRow()];
			rse.beforeFirst();
			int cnt = 0;
	  
			while(rse.next())
			{
				addresses[cnt++] = rse.getString("Email");
			}
			String title = "", imageurl = "";
			PreparedStatement psp = con.prepareStatement("select * from product where productId = '" + prodid + "'");
			ResultSet rsp  = psp.executeQuery();
			while(rsp.next())
			{
				title = rsp.getString("title");
				imageurl = rsp.getString("imageUrlStr");
			}
			String subject = "Offer - Mobile Shopping";
			String content = "<html><body><div><p>The new offer - "+offer+" on the Product "+title+"</p><img src='" + imageurl + "' alt='' height='500' width='200'/></div></body></html>";
			EmailUtility.sendEmailWithAttachment(host, port, user, pass, addresses, subject, content);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">alert('Successful Done')</script>");		
			RequestDispatcher rd = request.getRequestDispatcher("/setoffers.jsp");
	        rd.include(request, response);
	        
	        
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}



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

import codes.DBConnection;
import codes.GetSetIds;
import codes.UserCredentials;

/**
 * Servlet implementation class SetOffers
 */
@WebServlet("/SetOffers")
public class SetOffers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetOffers() {
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
			String offer = request.getParameter("offer");
			String offerprod = request.getParameter("ptitle");
			String fromdt = request.getParameter("fdate");
			String todt = request.getParameter("tdate");
			int offid = GetSetIds.getOfferid();
			PreparedStatement ps = con.prepareStatement("INSERT INTO offers(offersid, offer, productid, fromdate, todate) VALUES (" + offid + ", '" + offer + "', '" + offerprod + "', '" + fromdt + "', '" + todt + "')");
			int res = ps.executeUpdate();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("/setoffers.jsp");
	        rd.forward(request, response);
	        out.print("<html><body><script>alert('Offer Added sceessfuly !!!');</script></body></html>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

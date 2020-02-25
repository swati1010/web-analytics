

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
 * Servlet implementation class PaymentCard
 */
@WebServlet("/PaymentCard")
public class PaymentCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCard() {
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
			int userid = UserCredentials.getUserid();
			int orderid = Integer.parseInt(session.getAttribute("orderid").toString());
			String total = session.getAttribute("total").toString();
			String nameoncard = request.getParameter("nameoncard");
			String cardtype = request.getParameter("radios");
			String cardno = request.getParameter("cardno");
			String expdt = request.getParameter("expdate");
			String seccode = request.getParameter("securitycode");
			int paymentid = GetSetIds.getPaymentid();
			PreparedStatement ps = con.prepareStatement("INSERT INTO payment(paymentid, orderid, paymentmode, amount) VALUES (" + paymentid + ", " + orderid + ", 'COD', '" + total + "')");
			int res = ps.executeUpdate();
			if(res > 0)
			{
				int carddrtailsid = GetSetIds.getCarddetailid();
				PreparedStatement psc = con.prepareStatement("INSERT INTO carddetails(carddetailsid, userid, orderid, cardtype, cardholdername, cardno, cvv, expdate) VALUES (" + carddrtailsid + ", " + userid + ", " + orderid + ", '" + cardtype + "', '" + nameoncard + "', '" + cardno + "', '" + seccode + "', '" + expdt + "')");
				int r = psc.executeUpdate();
				if(r > 0)
				{
					PreparedStatement psd = con.prepareStatement("delete from cart where userid = "+userid);
					psd.executeUpdate();
					response.sendRedirect("paysuccess.jsp");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

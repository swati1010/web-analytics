package codes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetSetIds {
	public static int userId = 1;
	public static int productid = 1;
	public static int userdetailsid = 1;
	public static int orderid = 1;
	public static int reviewid = 1;
	public static int cartid = 1;
	public static int carddetailid = 1;
	public static int purchaseid = 1;
	public static int offerid = 1;
	public static int qty = 1;
	public static int payid = 1;
	
	
	
	
	public static Connection con = DBConnection.getDBConnection();
	
	public static int getQty() {
		return qty;
	}
	public static void setQty(int qty) {
		GetSetIds.qty = qty;
	}
	public static int getUserId() {
		try {
			PreparedStatement ps = con.prepareStatement("select UserId from user order by UserId desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				userId = rs.getInt("UserId") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userId;
	}
	public static int getProductid() {
		try {
			PreparedStatement ps = con.prepareStatement("select ID from product order by ID desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				productid = rs.getInt("ID") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return productid;
	}
	public static int getUserdetailsid() {
		try {
			PreparedStatement ps = con.prepareStatement("select userdetailsid from userdetails order by userdetailsid desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				userdetailsid = rs.getInt("userdetailsid") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userdetailsid;
	}
	public static int getOrderid() {
		try {
			PreparedStatement ps = con.prepareStatement("select orderid from ordertbl order by orderid desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				orderid = rs.getInt("orderid") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orderid;
	}
	public static int getReviewid() {
		try {
			PreparedStatement ps = con.prepareStatement("select ID from reviews order by ID desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				reviewid = rs.getInt("ID") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return reviewid;
	}
	public static int getCartid() {
		try {
			PreparedStatement ps = con.prepareStatement("select cartid from cart order by cartid desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				cartid = rs.getInt("cartid") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cartid;
	}
	public static int getCarddetailid() {
		try {
			PreparedStatement ps = con.prepareStatement("select carddetailsid from carddetails order by carddetailsid desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				carddetailid = rs.getInt("carddetailsid") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return carddetailid;
	}
	public static int getPurchaseid() {
		try {
			PreparedStatement ps = con.prepareStatement("select prodpurchaseid from prodpurchased order by prodpurchaseid desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				purchaseid = rs.getInt("prodpurchaseid") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return purchaseid;
	}
	public static int getOfferid() {
		try {
			PreparedStatement ps = con.prepareStatement("select offersid from offers order by offersid desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				offerid = rs.getInt("offersid") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return offerid;
	}
	
	public static int getPaymentid() {
		try {
			PreparedStatement ps = con.prepareStatement("select paymentid from payment order by paymentid desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				payid = rs.getInt("paymentid") + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return payid;
	}
	
	
	
}

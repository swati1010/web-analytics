
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="codes.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<%
String brand=request.getParameter("brand");
Connection con = DBConnection.getDBConnection();
String price=request.getParameter("price");
String name = request.getParameter("cname");

int p_type=Integer.parseInt(request.getParameter("p_type"));
int userid =UserCredentials.getUserid(); 
String prodId=request.getParameter("prodId");
String qty=request.getParameter("qty");
String shipping=request.getParameter("shipping");


/* PreparedStatement ps = con.prepareStatement("select UserId from user where Uname = '" + name + "' and Email = '" + email + "'");
ResultSet rs = ps.executeQuery();
if(rs.next())
{
	userid = rs.getInt("UserId");
} */


int cartid = GetSetIds.getCartid();


PreparedStatement ps2 = con.prepareStatement("select * from cart where productid='"+prodId+"' and userid='"+userid+"'");
ResultSet rs=ps2.executeQuery();
if(userid==0){
	out.println("<script type=\"text/javascript\">alert('Please Login first')</script>");		
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    rd.include(request, response);
}
else if(rs.next()){
	request.getRequestDispatcher("basket.jsp").forward(request,response);
}
else
{
PreparedStatement psi = con.prepareStatement("INSERT INTO cart(cartid, userid, productid, qty, subtotal, total, shippingcharges) VALUES (" + cartid + "," + userid + ",'" + prodId + "','" + qty + "','" + price + "', '" + price + "','" + shipping + "')");
int res = psi.executeUpdate();
response.sendRedirect("shop.jsp?p_type="+p_type+"&brand="+brand);


}
	//RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
   // rd.forward(request, response);	

%>
</body>
</html>
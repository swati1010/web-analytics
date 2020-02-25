
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="codes.*" %>
    <%@page import="java.text.SimpleDateFormat" %>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! static int hitsCount=0; %>
<%

Connection con = DBConnection.getDBConnection();

String uname = UserCredentials.getUsername();
String email = UserCredentials.getEmailId();
int userid = UserCredentials.getUserid();
String url = request.getRequestURL().toString();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
java.util.Date date=new java.util.Date();  
String d=dateFormat.format(date);


try{
	


if (hitsCount == 0) 
{
	hitsCount++;
PreparedStatement ps=con.prepareStatement("insert into  clicks(url,hits,date) values(?,?,?)");
		    ps.setString(1,url);
		    ps.setInt(2,hitsCount);
		   
		    ps.setString(3,d);	
		    int i=ps.executeUpdate();

}
else
{

hitsCount++;

	PreparedStatement ps3=con.prepareStatement("update clicks set hits='"+hitsCount+"' where date='"+d+"' and url='"+url+"'");
	  
	  
	  int j=ps3.executeUpdate();


}
String qt=request.getParameter("input");

int qty=Integer.parseInt(qt);
String p_id=request.getParameter("output"); 
System.out.print(p_id);




int sb=0;
int tl=0;
PreparedStatement ps1=con.prepareStatement("select subtotal from cart where userid='"+userid+"' and productid='"+p_id+"'");

ResultSet rs=ps1.executeQuery();

if(rs.next()){
	tl=rs.getInt("subtotal");
	 System.out.println(tl);
	 System.out.println(qty);
	 sb=qty*tl;
	 System.out.println(sb);
}

System.out.print("success");
PreparedStatement ps=con.prepareStatement("update cart set qty='"+qty+"',total='"+sb+"' where userid='"+userid+"' and productid='"+p_id+"'");

int i=ps.executeUpdate();

}
catch(Exception e){
	System.out.print(e);
}





	

/* request.getRequestDispatcher(".jsp").forward(request, response); */





%>
</body>
</html>
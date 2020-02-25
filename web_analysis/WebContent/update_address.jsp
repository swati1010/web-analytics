<%@page import="codes.UserCredentials"%>
<%@page import="codes.DBConnection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.*" %>    
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
}
catch(Exception e){
	System.out.print(e);
}






/* String sm=(String)session.getAttribute("sm");
int sum=Integer.parseInt(sm); */
int userid = UserCredentials.getUserid();
String country=request.getParameter("country");
String name=request.getParameter("name");

String address=request.getParameter("address");
String city=request.getParameter("city");
String pin=request.getParameter("pin");

String email=request.getParameter("email");
String phone=request.getParameter("phone");


PreparedStatement ps=con.prepareStatement("update user_detail set country=?,name=?,address=?,city=?,pin=?,email=?,phone=? where userid='"+userid+"'");
ps.setString(1,country);
ps.setString(2,name);
ps.setString(3,address);
ps.setString(4,city);
ps.setString(5,pin);
ps.setString(6,email);
ps.setString(7,phone);


int i=ps.executeUpdate();
if(i!=0){
	System.out.print("succedss");
 request.getRequestDispatcher("checkout1.jsp").forward(request,response);
}


%>
</body>
</html>
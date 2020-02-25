<%@page import="codes.DBConnection"%>
<%@page import="codes.UserCredentials"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>    

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String sb=request.getParameter("sum");

int tsum=Integer.valueOf(sb);
out.print(tsum);
int userid=UserCredentials.getUserid();
Connection con = DBConnection.getDBConnection();


 
int user=0;
 try{
	PreparedStatement ps=con.prepareStatement("select userid from  user_detail where userid='"+userid+"'");
	
	ResultSet rs=ps.executeQuery();
	
 if(tsum==0){
		out.println("<script type=\"text/javascript\">alert('No item in cart')</script>");	
		request.getRequestDispatcher("basket.jsp").include(request,response);
	}
	
 else if(rs.next()){
	request.getRequestDispatcher("checkout1.jsp").forward(request,response);
	
	}
	
	
	else{
		
		request.getRequestDispatcher("checkout1.jsp").forward(request,response); 
		
	}
	
}

catch(Exception e){
	out.print(e);
	
}

%>
</body>
</html>
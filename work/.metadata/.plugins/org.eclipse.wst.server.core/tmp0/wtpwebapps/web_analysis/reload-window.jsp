<%@page import="java.util.Arrays"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="codes.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
try{
	
Connection con = DBConnection.getDBConnection();

PreparedStatement ps = con.prepareStatement("select product.productId, product.title, reviews.prior,reviews.Review from reviews, product where product.productId = reviews.productId and reviews.prior like '%bad%'");
ResultSet rs = ps.executeQuery();
%>
<font face="verdana" size="2" color="red">
<%

while(rs.next())
{
	
%>
<marquee width="100%" direction="right">
<span class="text"><%=rs.getString("productId") %> - <%=rs.getString("title") %> - <%=rs.getString("Review") %> - <%=rs.getString("prior") %></span>
</marquee>
<%
} 
}
catch(Exception e){
	System.out.print(e);
}

%>
</font>.

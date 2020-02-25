<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="codes.UserCredentials"%>
<%@page import="codes.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@page import="java.text.*" %>
      <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
	
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
java.util.Date date=new java.util.Date();  
String d=dateFormat.format(date);


Connection con = DBConnection.getDBConnection();

String uname = UserCredentials.getEmailId();
long vs=0;
PreparedStatement ps=con.prepareStatement("select start_time,date,visit from user where email='"+uname+"'");
ResultSet rs=ps.executeQuery();
String date1="";
String veri="";
if(rs.next()){
	date1=rs.getString(1);
	veri=rs.getString(2);
	vs=rs.getLong(3);
	
	}






PreparedStatement ps1=con.prepareStatement("update user set end_time ='"+d+"',status=0 where email='"+uname+"'" );
int j=ps1.executeUpdate();

SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date d1 = df.parse(date1); 
Date d2 = df.parse(d); 
Calendar cal = Calendar.getInstance();
cal.setTime(d1);
cal.add(Calendar.MINUTE, 10);
String newTime = df.format(cal.getTime());

long diff = d2.getTime() - d1.getTime();

long diffMinutes = diff / (60 * 1000) % 60;





SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
java.util.Date date12=new java.util.Date();  
String daw=dateFormat1.format(date12);

if(daw.equals(veri)){
	
	long ds=vs+diffMinutes;
	
	PreparedStatement ps2=con.prepareStatement("update user set visit='"+ds+"' where email='"+uname+"'" );
	int i=ps2.executeUpdate();
}
else{
	System.out.print("hgf"+veri);
	PreparedStatement ps2=con.prepareStatement("update user set visit='"+diffMinutes+"',date='"+daw+"' where email='"+uname+"'" );
	int i=ps2.executeUpdate();
}








UserCredentials.setUserid(0);
UserCredentials.setUsername("");

request.getRequestDispatcher("index.jsp").include(request,response);
}
catch(Exception e){
	System.out.print(e);
}
/* */

  
%>
<script type="text/javascript">
alert("successful logout");
</script>

</body>

</html>
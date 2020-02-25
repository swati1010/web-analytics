<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="codes.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">

<head>
<script>
            function confirmGo(m,u) {
                if ( confirm(m) ) {
                    window.location = u;
                }
            }
        </script>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>
          Electric Smiling
    </title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- your stylesheet with modifications -->
    <link href="css/custom.css" rel="stylesheet">

    <script src="js/respond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">



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
}
catch(Exception e){
	System.out.print(e);
}


		
  
    
	
	
	%>

    <!-- *** TOPBAR ***
 _________________________________________________________ -->
    <div id="top">
        <div class="container">
            <div class="col-md-6 offer" data-animate="fadeInDown">
<!--                 <a href="#" class="btn btn-success btn-sm" data-animate-hover="shake">Offer of the day</a>  <a href="#">Get flat 35% off on orders over $50!</a>
 -->            </div>
            <div class="col-md-6" data-animate="fadeInDown">
                <ul class="menu">
                
                <%if(userid>=1){
                	
                	
                	%>
                	<li ><a  href="#"><i class="fa fa-user"></i><%=uname %> </a>
                	<li ><a  href="logout.jsp"><i class="fa fa-user"></i>Logout </a>
                	<%
                }
                else{
                	%>
                	<li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                    </li>
                    <li><a href="register.jsp">Register</a>
                    </li>
                	<%
                	
                }
                %>
                    
                    <li><a href="contact.jsp">Contact</a>
                    </li>
                   
                </ul>
            </div>
        </div>
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="Login">Customer login</h4>
                    </div>
                    <div class="modal-body">
                        <form action="Login" method="post">
                            <div class="form-group">
                                <input type="text" name="username" class="form-control" id="email-modal" placeholder="email">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" id="password-modal" placeholder="password">
                            </div>

                            <p class="text-center">
                                <button class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                            </p>

                        </form>

                        <p class="text-center text-muted">Not registered yet?</p>
                        <p class="text-center text-muted"><a href="register.jsp"><strong>Register now</strong></a>! It is easy and done in 1&nbsp;minute and gives you access to special discounts and much more!</p>

                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- *** TOP BAR END *** -->

    <!-- *** NAVBAR ***
 _________________________________________________________ -->

    <div class="navbar navbar-default yamm" role="navigation" id="navbar">
        <div class="container">
            <div class="navbar-header">

                <a class="navbar-brand home" href="index.html" data-animate-hover="bounce">
                    <img src="img/nameofwebsite.jpg" style="width: 126px;height: 58px;" alt="Obaju logo" class="hidden-xs">
                    <img src="img/logo-small.png" alt="Obaju logo" class="visible-xs"><span class="sr-only">Obaju - go to homepage</span>
                </a>
                <div class="navbar-buttons">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <i class="fa fa-align-justify"></i>
                    </button>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#search">
                        <span class="sr-only">Toggle search</span>
                        <i class="fa fa-search"></i>
                    </button>
                    
                </div>
            </div>
            <!--/.navbar-header -->

            <div class="navbar-collapse collapse" id="navigation">

                <ul class="nav navbar-nav navbar-left">
                    <li class="active"><a href="index.jsp">Home</a>
                    </li>
                    <li ><a href="shop.jsp?p_type=1&brand=mobile">Mobile</a>
                    </li>
                    <li ><a href="shop.jsp?p_type=4&brand=Laptop">Laptop</a>
                    </li>
                    <li ><a href="shop.jsp?p_type=2&brand=Headphone">Headphone</a>
                    </li>
                    <li ><a href="shop.jsp?p_type=3&brand=Speaker">Speaker</a>
                    </li>
                    <li ><a href="shop.jsp?p_type=5&brand=Printer">Printer</a>
                    </li>
                       <li ><a href="your_account.jsp">Your Account</a>
                    </li>

                  
                </ul>

            </div>
            <!--/.nav-collapse -->

            <div class="navbar-buttons">

                <div class="navbar-collapse collapse right" id="basket-overview">
                 <%
                    	String ucount = "";
                    String totalsum = "";
                    	PreparedStatement pscart = con.prepareStatement("SELECT COUNT(userid) AS usercount, SUM(total) AS totalsum FROM cart WHERE userid = " + userid + " GROUP BY userid");
                    	ResultSet rscart = pscart.executeQuery();
                    	if(rscart.next())
                    	{
                    		ucount = rscart.getInt("usercount")+"";
                    		totalsum = rscart.getInt("totalsum")+"";
                    	}
                    %>
                    <a href="basket.jsp?userid=<%=userid %>" class="btn btn-primary navbar-btn"><i class="fa fa-shopping-cart"></i><span class="hidden-sm"><%=ucount %> items in cart</span></a>
                </div>
                <!--/.nav-collapse -->

                <div class="navbar-collapse collapse right" id="search-not-mobile">
                    <button type="button" class="btn navbar-btn btn-primary" data-toggle="collapse" data-target="#search">
                        <span class="sr-only">Toggle search</span>
                        <i class="fa fa-search"></i>
                    </button>
                </div>

            </div>

            <div class="collapse clearfix" id="search">

                <form class="navbar-form" method="post" action="search.jsp">
                    <div class="input-group">
                        <input type="text" class="form-control" name="search" placeholder="Search">
                        <span class="input-group-btn">

			<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>

		    </span>
                    </div>
                </form>

            </div>
            <!--/.nav-collapse -->

        </div>
        <!-- /.container -->
    </div>  <center><table style="width: 76% !important;" class="table table-bordered table-striped">
<tr>
	<td>Product name</td>
	<td>Price</td>
	<td>Qty</td>
	<td>Total Amount</td>
	<td>Action</td>
	
</tr>

<%
PreparedStatement ps=con.prepareStatement("select * from invoice where cid='"+userid+"' and status=1");
ResultSet rs=ps.executeQuery();
String tl="";
int itl=0;

while(rs.next()){
	
tl=rs.getString("grand_total");
int ict=Integer.parseInt(tl);
itl=ict+itl;



%>

<tr>
	<td><%=rs.getString("p_name") %></td>
	<td><%=rs.getString("total_amt") %></td>
	<td><%=rs.getString("qty") %></td>
	<td><%=rs.getString("grand_total") %></td>
	<td><a href="javascript:confirmGo('Sure to cancel this product?','cancel_reason.jsp?id=<%=rs.getInt("id")%>')">Cancel</a></td>
	
	
</tr>


    <%
}
System.out.print(itl);
    %>
    <tr>
	<td  colspan="3">Grand Total</td>
	<td><%=itl %></td>
 
	
</tr>
  </table></center>
 
 <%
   PreparedStatement psb=con.prepareStatement("select * from bank_detail where uid='"+userid+"'");
   ResultSet rsb=psb.executeQuery();
   if(rsb.next()){
	 %>  
	   <center>
  <h2>Bank Detail</h2>
  
  <table style="width: 34% !important;" class="table table-bordered table-striped">
<tr>
	<td>Bank Name</td>
	<td><%=rsb.getString("bank_name") %></td>	
</tr>
<tr>
	<td>Name</td>
	<td><%=rsb.getString("name") %></td>	
</tr>
<tr>
	<td>A/c No.</td>
	<td><%=rsb.getString("account_name") %></td>	
</tr>
<tr>
	<td>IFSC Code</td>
	<td><%=rsb.getString("ifsc") %></td>	
</tr>
<tr>
	
	<td colspan="2"><a style="margin-left: 11em; font-size: 18px;" href="update_account.jsp">Edit Account</a></td>	
</tr>
  </table>
 </center>
 <%} %>
 
    
   
   <script type="text/javascript">
   window.onload = myfunction(){
	   var uname = UserCredentials.getUsername();
	   
   }
   </script>
    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    
    <!-- jQuery easing -->
    <script src="js/jquery.easing.1.3.min.js"></script>
    
    <!-- Main Script -->
    <script src="js/main.js"></script>
    
    <!-- Slider -->
    <script type="text/javascript" src="js/bxslider.min.js"></script>
	<script type="text/javascript" src="js/script.slider.js"></script>
</body>
</html>
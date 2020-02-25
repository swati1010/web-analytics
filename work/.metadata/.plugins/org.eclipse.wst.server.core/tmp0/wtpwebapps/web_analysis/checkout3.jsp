<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="codes.*" %>
      <%@page import="java.text.SimpleDateFormat" %>
<html lang="en">

<head>

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

<script>
    // WRITE THE VALIDATION SCRIPT IN THE HEAD TAG.
    function isNumber(evt) {
        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
            return false;

        return true;
    } 
    function isNumber1(evt) {
        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
            return false;

        return true;
    } 
    
    function ValidateNo() {
        var phoneNo = document.getElementById('tbNumbers');

    if (phoneNo.value == "" || phoneNo.value == null) {
            alert("Please enter your Mobile No.");
            return false;
        }
        if (phoneNo.value.length < 10 || phoneNo.value.length > 10) {
            alert("Mobile No. is not valid, Please Enter 10 Digit Mobile No.");
            return false;
        }

        
        return true;
        }
</script>

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
                    <li ><a href="index.jsp">Home</a>
                    </li>
                    <li><a href="shop.jsp?p_type=1&brand=mobile">Mobile</a>
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

            </div>            <!--/.nav-collapse -->

        </div>
        <!-- /.container -->
    </div>
    <!-- /#navbar -->

    <!-- *** NAVBAR END *** -->

    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>Checkout - Payment method</li>
                    </ul>
                </div>

                <div class="col-md-9" id="checkout">

                    <div class="box">
                        <form method="post" action="PaymentCard.jsp">
                            <h1>Checkout - Payment method</h1>
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="checkout1.jsp"><i class="fa fa-map-marker"></i><br>Address</a>
                                </li>
                               
                                <li class="active"><a href="#"><i class="fa fa-money"></i><br>Payment Method</a>
                                </li>
                                
                            </ul>

                            <div class="content">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>Paypal</h4>

                                            <p>We like it all.</p>

                                            <div class="box-footer text-center">

                                                <input type="radio" name="payment" value="payment1">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>Payment gateway</h4>

                                            <p>VISA and Mastercard only.</p>

                                            <div class="box-footer text-center">

                                                <input type="radio" name="payment" value="payment2">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>Cash on delivery</h4>

                                            <p>You pay when you get it.</p>

                                            <div class="box-footer text-center">

                                                <input type="radio" name="payment" value="payment3">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                            </div>
                            <!-- /.content -->

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="basket.html" class="btn btn-default"><i class="fa fa-chevron-left"></i>Back to Shipping method</a>
                                </div>
                                <div class="pull-right">
                                    <button type="submit" class="btn btn-primary">Continue to Order review<i class="fa fa-chevron-right"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->


                </div>
                <!-- /.col-md-9 -->

<%
                                    int i = 0;
                                    String pr="";
                                    int prc=0;
                                    int sum=0;
                                    
                                    Double dis=0.0;
                                    int idis=0;
                                    String af="";
	                                    PreparedStatement ps = con.prepareStatement("SELECT cart.qty,cart.subtotal, cart.total, cart.shippingcharges,product.price, cart.productid,product.p_type,product.mrp, product.title,product.discount, product.imageUrlStr FROM cart,product WHERE cart.productid = product.productId and cart.userid = " + userid + "");
	                                    ResultSet rs = ps.executeQuery();
	                                    while(rs.next())
	                                    {
	                                    	idis=rs.getInt("discount");
	                            			af=dis.toString();
	                                    pr=rs.getString("total");
	                                    prc=Integer.parseInt(pr);

	                                    sum=sum+prc;
	                                    System.out.println(sum);

	                                    }
	                                    
                                    %>
                <div class="col-md-3">

                    <div class="box" id="order-summary">
                        <div class="box-header">
                            <h3>Order summary</h3>
                        </div>
                        <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>

                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td>Order subtotal</td>
                                        <th>&#8377;<%=sum %></th>
                                    </tr>
                                    <tr>
                                        <td>Shipping and handling</td>
                                        <th>0</th>
                                    </tr>
                                    <tr>
                                        <td>Tax</td>
                                        <th>0.00</th>
                                    </tr>
                                    <tr class="total">
                                        <td>Total</td>
                                        <th>&#8377;<%=sum %></th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>

                </div>                <!-- /.col-md-3 -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->


        <!-- *** FOOTER ***
 _________________________________________________________ -->
        <div id="footer" data-animate="fadeInUp">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                       

                      
	
                       

                        <h4>User section</h4>
				
                        <ul>
                        <%
				if(userid>=1){
					
					 %>
					 <li ><a  href="logout.jsp"><i class="fa fa-user"></i>Logout </a>
					 
					 <%
				}
				else{
					
					%>
					  <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                            </li>
                            <li><a href="register.jsp">Regiter</a>
                            </li> 
					<%
				}
				
				%>
				
			

				
                           
                        </ul>

                        <hr class="hidden-md hidden-lg hidden-sm">

                    </div>
                    <!-- /.col-md-3 -->

                    <div class="col-md-3 col-sm-6">

                        <h4>Top categories</h4>

                        <h5>Electronic</h5>

                        <ul>
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
                        </ul>

                        

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->

                    <div class="col-md-3 col-sm-6">

                        

                        <a href="contact.html">Go to contact page</a>

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->



                    <!-- /.col-md-3 -->

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->




        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
       
        <!-- *** COPYRIGHT END *** -->



    </div>
    <!-- /#all -->


    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/modernizr.js"></script>
    <script src="js/bootstrap-hover-dropdown.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/front.js"></script>


</body>

</html>
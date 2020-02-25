<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="codes.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
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
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
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
                    <a class="btn btn-default navbar-toggle" href="basket.html">
                        <i class="fa fa-shopping-cart"></i>  <span class="hidden-xs">3 items in cart</span>
                    </a>
                </div>
            </div>
            <!--/.navbar-header -->

            <div class="navbar-collapse collapse" id="navigation">

                <ul class="nav navbar-nav navbar-left">
                    <li class="active"><a href="index.jsp">Home</a>
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
                        <li>Shopping cart</li>
                    </ul>
                </div>

                <div class="col-md-9" id="basket">

                    <div class="box">

                        <form method="post" action="checkout1.jsp">

                            <h1>Shopping cart</h1>
                            <p class="text-muted">You currently have <%=ucount %> item(s) in your cart.</p>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="2">Product</th>
                                            <th>Quantity</th>
                                            <th>Unit price</th>
                                            <th>Discount</th>
                                            <th colspan="2">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    int i = 0;
                                    String pr="";
                                    int prc=0;
                                    int sum=0;
                                    
                                    Double dis=0.0;
                                    int idis=0;
                                    String af="";
                                    int j=0;
	                                    PreparedStatement ps = con.prepareStatement("SELECT cart.qty,cart.subtotal,cart.total, cart.shippingcharges,product.price, cart.productid,product.p_type,product.mrp, product.title,product.discount, product.imageUrlStr FROM cart,product WHERE cart.productid = product.productId and cart.userid = " + userid + "");
	                                    ResultSet rs = ps.executeQuery();
	                                    while(rs.next())
	                                    {
	                                    	idis=rs.getInt("discount");
	                            			af=dis.toString();
	                                    pr=rs.getString("total");
	                                    prc=Integer.parseInt(pr);

	                                    sum=sum+prc;
	                                    System.out.println(sum);


	                                    
                                    %>
                                    
                                        <tr>
                                            <td>
                                                <a href="#">
                                                    <img src="<%=rs.getString("imageUrlStr") %>" alt="White Blouse Armani">
                                                </a>
                                            </td>
                                            <td><a href="single-product.jsp?productId=<%=rs.getString("productId")%>&p_type=<%=rs.getInt("p_type")%>"><%=rs.getString("title") %></a>
                                            </td>
                                            <td>
                                               <input type="button" style="width: 30px;" id="minus" class="minus<%=j %>" value="-" onclick="qtySpin(1, <%=i%>)">
								<input type="text"  style="width: 30px;" size="4" id="qty<%=i %>" class="a<%=j %>" title="Qty" name="qty" value="<%=rs.getString("qty")%>" min="0" step="1" ">
								<input type="hidden" size="4" id="p_id<%=i %>" class="b<%=j %>" title="Qty" name="pid" value="<%=rs.getString("productId")%>">
								<input type="button"  id="plus" class="plus<%=j %>"  style="width: 30px;" value="+" onclick="qtySpin(2, <%=i%>)">
								
                                               <% i = i+1; %>
                                               <% j = j+1; %>
		
                                            </td>
                                            <td>&#8377;<%=rs.getString("mrp")%></td>
                                            <td>&#8377;<%=idis%></td>
                                            <td>&#8377;<%=rs.getString("total")%></td>
                                            <td><a href="delete_product.jsp?pid=<%=rs.getString("productId")%>"><i class="fa fa-trash-o"></i></a>
                                            </td>
                                        </tr>
                                        
                                                                            </tbody>
                                                                            <%} %>
                                    <tfoot>
                                        <tr>
                                            <th colspan="5">Total</th>
                                            <th colspan="2">&#8377;<%=sum %></th>
                                        </tr>
                                       
                                    </tfoot>
                                     
                                </table>

                            </div>
                            <!-- /.table-responsive -->

                            <div class="box-footer">
                                <div class="pull-left">
                                </div>
                                <div class="pull-right">
                                   
                                    <a href="buy.jsp?sum=<%=sum%>" class="btn btn-primary">Proceed to checkout </a><i class="fa fa-chevron-right"></i>
                                    
                                </div>
                            </div>

                        </form>

                    </div>
                    <!-- /.box -->




                </div>
                <!-- /.col-md-9 -->

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
                                        <th>0.00</th>
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


                    

                </div>
                <!-- /.col-md-3 -->

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
                        </ul>

                        

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->

                    <div class="col-md-3 col-sm-6">

                     
                        <a href="contact.jsp">Go to contact page</a>

                        <hr class="hidden-md hidden-lg">
bas
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
     <script type="text/javascript">
        $(document).ready(function() {
            $('.minus0').click(function ()
            { 
                $.ajax({
                    type: "post",
                    url: "qty_update.jsp", //this is my servlet
                    data: "input=" +$('.a0').val()+"&output="+$('.b0').val(),
                    success: function(msg){  
                    	window.location.reload();     
                            $('#output').append(msg);
                    }
                });
            });
            
            
            $('.plus0').click(function ()
                    {
                        $.ajax({
                            type: "post",
                            url: "qty_update.jsp", //this is my servlet
                            data: "input=" +$('.a0').val()+"&output="+$('.b0').val(),
                            success: function(msg){ 
                            	window.location.reload();     
                                    $('#output').append(msg);
                            }
                        });
                    });
            
            
            $('.minus1').click(function ()
                    { 
                        $.ajax({
                            type: "post",
                            url: "qty_update.jsp", //this is my servlet
                            data: "input=" +$('.a1').val()+"&output="+$('.b1').val(),
                            success: function(msg){ 
                            	window.location.reload();     
                                    $('#output').append(msg);
                            }
                        });
                    });
                    
                    
                    $('.plus1').click(function ()
                            {
                                $.ajax({
                                    type: "post",
                                    url: "qty_update.jsp", //this is my servlet
                                    data: "input=" +$('.a1').val()+"&output="+$('.b1').val(),
                                    success: function(msg){  
                                    	window.location.reload();     
                                            $('#output').append(msg);
                                    }
                                });
                            });
                    $('.minus2').click(function ()
                            { 
                                $.ajax({
                                    type: "post",
                                    url: "qty_update.jsp", //this is my servlet
                                    data: "input=" +$('.a2').val()+"&output="+$('.b2').val(),
                                    success: function(msg){ 
                                    	window.location.reload();    
                                            $('#output').append(msg);
                                    }
                                });
                            });
                            
                            
                            $('.plus2').click(function ()
                                    {
                                        $.ajax({
                                            type: "post",
                                            url: "qty_update.jsp", //this is my servlet
                                            data: "input=" +$('.a2').val()+"&output="+$('.b2').val(),
                                            success: function(msg){  
                                            	window.location.reload();    
                                                    $('#output').append(msg);
                                            }
                                        });
                                    });
                            $('.minus3').click(function ()
                                    { 
                                        $.ajax({
                                            type: "post",
                                            url: "qty_update.jsp", //this is my servlet
                                            data: "input=" +$('.a3').val()+"&output="+$('.b3').val(),
                                            success: function(msg){  
                                            	window.location.reload();      
                                                    $('#output').append(msg);
                                            }
                                        });
                                    });
                                    
                                    
                                    $('.plus3').click(function ()
                                            {
                                                $.ajax({
                                                    type: "post",
                                                    url: "qty_update.jsp", //this is my servlet
                                                    data: "input=" +$('.a3').val()+"&output="+$('.b3').val(),
                                                    success: function(msg){   
                                                    	window.location.reload();     
                                                            $('#output').append(msg);
                                                    }
                                                });
                                            });
                                    $('.minus4').click(function ()
                                            { 
                                                $.ajax({
                                                    type: "post",
                                                    url: "qty_update.jsp", //this is my servlet
                                                    data: "input=" +$('.a4').val()+"&output="+$('.b4').val(),
                                                    success: function(msg){
                                                    	window.location.reload();    
                                                            $('#output').append(msg);
                                                    }
                                                });
                                            });
                                            
                                            
                                            $('.plus4').click(function ()
                                                    {
                                                        $.ajax({
                                                            type: "post",
                                                            url: "qty_update.jsp", //this is my servlet
                                                            data: "input=" +$('.a4').val()+"&output="+$('.b4').val(),
                                                            success: function(msg){   
                                                            	window.location.reload();     
                                                                    $('#output').append(msg);
                                                            }
                                                        });
                                                    });
            
            

        });
    </script>
 <script type="text/javascript">
    
function qtySpin(btnval, btnid){
	if(btnval == 1)
		{
			
			var qty = document.getElementById("qty"+btnid).value;
			if(Number(qty) > 0)
			document.getElementById("qty"+btnid).value = Number(qty)-1;
			
		}
	else
		if(btnval == 2)
		{
			var qty = document.getElementById("qty"+btnid).value;
			document.getElementById("qty"+btnid).value = Number(qty)+1;
		}
}
</script>
 
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
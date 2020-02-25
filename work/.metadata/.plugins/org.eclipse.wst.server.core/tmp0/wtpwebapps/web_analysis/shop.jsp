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

            </div>
            <!--/.nav-collapse -->

        </div>
        <!-- /.container -->
    </div>
    <!-- /#navbar -->

    <!-- *** NAVBAR END *** -->
<%
String brand=request.getParameter("brand");

%>
    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="index.jsp">Home</a>
                        </li>
                        <li><%=brand %></li>
                    </ul>
                </div>

                <div class="col-md-3">
                    <!-- *** MENUS AND FILTERS ***
 _________________________________________________________ -->
                    <div class="panel panel-default sidebar-menu">

                        <div class="panel-heading">
                            <h3 class="panel-title">Categories</h3>
                        </div>

                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked category-menu">
                                <li>
                                    <a href="category.html">Electronic <span class="badge pull-right"></span></a>
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
                                </li>
                                

                        </div>
                    </div>

                    

                               



                    <!-- *** MENUS AND FILTERS END *** -->

                    <div class="banner">
                        <a href="#">
                            <!-- <img src="img/banner.jpg" alt="sales 2014" class="img-responsive"> -->
                        </a>
                    </div>
                </div>

                <div class="col-md-9">
                   

                    

                    <div class="row products">


<%int p_type=Integer.parseInt(request.getParameter("p_type"));

                 Double dis=0.0;
                 int idis=0;
                 String af="";
		PreparedStatement ps = con.prepareStatement("select productId, title, mrp, price, discount, imageUrlStr,after_dis from product where p_type='"+p_type+"'");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			dis=rs.getDouble("after_dis");
			idis=rs.getInt("discount");
			af=dis.toString();

%>

                        <div class="col-md-4 col-sm-6">
                            <div class="product">
                                <div class="flip-container">
                                    <div class="flipper">
                                        <div class="front">
                                            <a href="detail.jsp?prodId=<%=rs.getString("productId")%>&brand=<%=brand %>">
                                                <img src="<%=rs.getString("imageUrlStr") %>" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                        <div class="back">
                                            <a href="detail.jsp?prodId=<%=rs.getString("productId")%>&brand=<%=brand %>">
                                                <img src="<%=rs.getString("imageUrlStr") %>" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <a href="detail.jsp?prodId=<%=rs.getString("productId")%>&brand=<%=brand %>" class="invisible">
                                    <img src="img/product1.jpg" alt="" class="img-responsive">
                                </a>
                                <div class="text">
                                    <h3><a href="detail.jsp?prodId=<%=rs.getString("productId")%>&brand=<%=brand %>"><%=rs.getString("title") %></a></h3>
                                    <p class="price"><ins>&#8377;<%=rs.getString("price") %><ins style="color: red;">&#8377;<%=idis%>%off</ins></ins> <del>&#8377;<%=af %></del></p>
                                    <p class="buttons">
                                        <a href="detail.jsp?prodId=<%=rs.getString("productId")%>&brand=<%=brand %>" class="btn btn-default">View detail</a>
                                        <a href="addtocart.jsp?prodId=<%=rs.getString("productId")%>&userid=<%=userid %>&cname=<%=uname %>&email=<%=email %>&p_type=<%=p_type %>&brand=<%=brand %>&price=<%=rs.getString("price") %>&qty=1&shipping=0" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </p>
                                </div>
                                <!-- /.text -->
                            </div>
                            <!-- /.product -->
                        </div>
<%} %>
                        


                      
                            <!-- /.product -->
                        </div>

                       
                   


                </div>
                <!-- /.col-md-9 -->
            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->


        <!-- *** FOOTER ***
 _________________________________________________________ -->
       <div id="footer" data-animate="fadeInUp">
            <div class="container">
                <div class="row">
                    <div class="col-md-2 col-sm-1">
                       

                      
	
                       

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

                        
                        <a href="contact.jsp">Go to contact page</a>

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
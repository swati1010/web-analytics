<%@page import="weka.core.Attribute"%>
<%@page import="weka.core.FastVector"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.sql.*" %>
    <%@ page import="codes.*" %>
       <%@page import="java.text.SimpleDateFormat" %><!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">
<link rel="stylesheet" href="css/rating.css">
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

<input type="hidden" name="amount" value="2.5">
	
<p id="abc"><span class="stars"><span style="width: 40.48px;"></span></span></p>

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
                    <li><a href="register.html">Register</a>
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
                                <input type="text" name="username" class="form-control" id="email-modal" placeholder="emial">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" id="password-modal" placeholder="password">
                            </div>

                            <p class="text-center">
                                <button class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                            </p>

                        </form>

                        <p class="text-center text-muted">Not registered yet?</p>
                        <p class="text-center text-muted"><a href="register.html"><strong>Register now</strong></a>! It is easy and done in 1&nbsp;minute and gives you access to special discounts and much more!</p>

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

                <form class="navbar-form" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search">
                        <span class="input-group-btn">

			<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>

		    </span>
                    </div>
                </form>

            </div>
            <!--/.nav-collapse -->
            <!--/.nav-collapse -->

        </div>
        <!-- /.container -->
    </div>
    <!-- /#navbar -->

    <!-- *** NAVBAR END *** -->

    <div id="all">

        <div id="content">
            <div class="container">
<% String brand=request.getParameter("brand"); %>
                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li><a href="#"><%=brand %></a>
                        </li>
                        
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
                          
                        </a>
                    </div>
                </div>

                <div class="col-md-9">
<%
String prodId =request.getParameter("prodId");
PreparedStatement psp = con.prepareStatement("select * from product where productId = '" + prodId + "'");
ResultSet rs=psp.executeQuery();
if(rs.next()){
	
	
	


%>
                    <div class="row" id="productMain">
                        <div class="col-sm-6">
                            <div id="mainImage">
                                <img src="<%=rs.getString("imageUrlStr") %>" alt="" class="img-responsive">
                            </div>

                            <div class="ribbon sale">
                                <div class="theribbon">SALE</div>
                                <div class="ribbon-background"></div>
                            </div>
                            <!-- /.ribbon -->

                            <div class="ribbon new">
                                <div class="theribbon">NEW</div>
                                <div class="ribbon-background"></div>
                            </div>
                            <!-- /.ribbon -->

                        </div>
                        <div class="col-sm-6">
                            <div class="box">
                                <h1 class="text-center"><%=rs.getString("title") %></h1>
                                <p class="goToDescription"><%=rs.getString("description") %>
                                </p>
                                <p class="price">&#8377;<%=rs.getString("price") %></p>

                                <p class="text-center buttons">
                                    <a href="addtocart.jsp?prodId=<%=rs.getString("productId")%>&userid=<%=userid %>&cname=<%=uname %>&email=<%=email %>&p_type=<%=rs.getString("p_type")  %>&brand=<%=brand %>&price=<%=rs.getString("price") %>&qty=1&shipping=0" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Add to cart</a> 
                                </p>


                            </div>

                            
                        </div>

                    </div>
<%} %>

                    <div class="box" id="details">
                        <h1>Review</h1>

                       

                        <hr>

                        <form action="UserReview" method="post">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" required="required" class="form-control" id="name" name="name">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" required="required" value="<%=email %>" name="email" class="form-control" id="email">
                            </div>
                            <div class="form-group">
                                <label for="password">Review</label>
                                <textarea required="required" name="review" id="" width="300px" cols="30" rows="4" class="form-control"  ></textarea>
                            </div>
                            
                            <p>Please rate this item:</p>
														<div class="rating-wrap-post">
                                                            <span class="star-cb-group">
      <input type="radio" required="required" id="rating-5" name="rating" value="5" required="required"/><label for="rating-5">5</label>
      <input type="radio" id="rating-4" name="rating" value="4"  required="required" /><label for="rating-4">4</label>
      <input type="radio" id="rating-3" name="rating" value="3" required="required" /><label for="rating-3">3</label>
      <input type="radio" id="rating-2" name="rating" value="2" required="required"/><label for="rating-2">2</label>
      <input type="radio" id="rating-1" name="rating" value="1"required="required" /><label for="rating-1">1</label>
     
    </span>
                                                        </div>
                                                       <input type="hidden" value="<%=prodId %>" name="hide"/>
                                                       <input type="hidden" value="<%=brand %>" name="brand"/>
                            
                            <div cl	ass="text-center">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-user-md"></i>Submit</button>
                            </div>
                        </form>

                           
                    </div>

                   
                        </div></div>
                        <center>
                       <h1> Top Customer Reviews</h1>
                       <table>
                       
                        <%
                        PreparedStatement pss=con.prepareStatement("select * from reviews where productid='"+prodId+"'");
    		  		ResultSet rss=pss.executeQuery();
    		  while(rss.next()){
    			  %>
    			  <tr><td><%=rss.getString("name") %>:</td>
    			  
    			  <td><%=rss.getString(3) %></td>
    			  </tr>
    			  
    			  <tr>
    			  
    			  <td colspan="2"><%=rss.getString(4) %><span style="font-size:165%;color:#ffb400;;">&starf;</span></td>
    			  </tr>
    			  
    			  
    			  <%
    			  
    			  
    		  }
                        
                        
                        %>
                        </table>
                  </center>      
                
                        
        <!-- /#content -->
<%-- <%
                    		PreparedStatement ps = con.prepareStatement("select * from reviews where productId='"+ prodId +"'");
                    		ResultSet rsr = ps.executeQuery();
                    		while(rsr.next())
                    		{
                    			%>
                    			<div>
                    			<table>
        
            <%
            String testText = ""+rsr.getString("Review");
            TextClassifier.thisClassString = "weka.classifiers.bayes.NaiveBayes";
            String fileName = "E:\\s_web\\web_analysis\\previews.csv";
			Path pathToFile = Paths.get(fileName);
			BufferedReader br = Files.newBufferedReader(pathToFile,
	                StandardCharsets.UTF_8); 
			String[] inputText = new String[162];
			String[] inputClasses = new String[162];
	            // read the first line from the text file
	            String line = br.readLine();
	            line = br.readLine();
	            // loop until all lines are read
	            int ii = 0;
	            while (line != null) {
	                // use string.split to load a string array with the values from
	                // each line of
	                // the file, using a comma as the delimiter
	                String[] attributes = line.split(",");
	                
	                inputText[ii] = attributes[1];
	                inputClasses[ii] = attributes[2];
	                line = br.readLine();
	                ii++;
	            }
	            
	            if (inputText.length != inputClasses.length) {
	                System.err.println("The length of text and classes must be the same!");
	                System.exit(1);
	            }

	            // calculate the classValues
	            HashSet classSet = new HashSet(Arrays.asList(inputClasses));
	            classSet.add("neutral");
	            String[] classValues = (String[])classSet.toArray(new String[0]);

	            //
	            // create class attribute
	            //
	            FastVector classAttributeVector = new FastVector();
	            for (int i = 0; i < classValues.length; i++) {
	                classAttributeVector.addElement(classValues[i]);
	            }
	            Attribute thisClassAttribute = new Attribute("class", classAttributeVector);

	            //
	            // create text attribute
	            //
	            FastVector inputTextVector = null;  // null -> String type
	            Attribute thisTextAttribute = new Attribute("text", inputTextVector);
	            for (int i = 0; i < inputText.length; i++) {
	                thisTextAttribute.addStringValue(inputText[i]);
	            }
	            
	            // add test cases (to be inserted into instances)
	            // just a singular test string
	            /*
	            String newTextString = newTestTextField.getText();
	            String[] newTextArray = new String[1];
	            newTextArray[0] = newTextString;
	            if (!"".equals(newTextString)) {
	                thisTextAttribute.addStringValue(newTextString);
	            }
	            */

	            // add the text of test cases
	            //for (int i = 0; i < testText.length; i++) {
	                thisTextAttribute.addStringValue(testText);
	           // }

	            //
	            // create the attribute information
	            //
	            FastVector thisAttributeInfo = new FastVector(2);
	            thisAttributeInfo.addElement(thisTextAttribute);
	            thisAttributeInfo.addElement(thisClassAttribute);


	            TextClassifier classifier = new TextClassifier(inputText, inputClasses, thisAttributeInfo, thisTextAttribute, thisClassAttribute, TextClassifier.thisClassString);

	            System.out.println("DATA SET:\n");
	            System.out.println(classifier.classify(TextClassifier.thisClassString));
				String[] str = {testText};
	            System.out.println("NEW CASES:\n");
	            System.out.println(classifier.classifyNewCases(str));
	            
	            String tcr = TextClassifier.caseresults;
	            
	            tcr = tcr.substring(0, tcr.length()-1);
	            System.out.println(""+tcr);
	            String results[] = tcr.split(",");
	            TextClassifier.caseresults = "";
	            if(tcr.equals("good") && Integer.parseInt(rsr.getString("Rating").toString()) >= 3)
	            {
            %>
            
            <tr>
         
           <td><p class="contact"><label for="name">Name :</label> <%=rsr.getString("name") %></p>
           <p class="contact"><label for="review">Review :</label> <%=rsr.getString("Review") %></p>
           <p class="contact"><label for="rating">Rating:</label><%=rsr.getString("Rating") %> <i id="istar1" class="fa fa-star" onclick="chkChecked(1)" style="color:green"></i></p>
              <p class="contact"><label for="review">Prior :</label> <%=tcr %></p>
              
              
              <br/>
              <br/>
              <br/>
              <br/>
            </td>
            </tr>
            <%} %>

</table>
</div>
                    			
                    			
                    			
                    			
                    			<%
                    		}
                        %> 
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                      
 --%>
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
                            <li><a href="register.html">Regiter</a>
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
 ___________________   <script src="js/rating.js"></script>______________________________________ -->
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
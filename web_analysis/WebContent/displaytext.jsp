<%@page import="codes.GetSetText"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*" %>
<%@page import="codes.DBConnection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="ass1/css/bootstrap.min.css" />
<link rel="stylesheet" href="ass1/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="ass1/css/fullcalendar.css" />
<link rel="stylesheet" href="ass1/css/matrix-style.css" />
<link rel="stylesheet" href="ass1/css/matrix-media.css" />
<link href="ass1/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="ass1/css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li id="profile-messages" ><a title="" href="#" data-target="#profile-messages" ><i class="icon icon-user"></i>  <span class="text">Welcome Admin</span><b class="caret"></b></a>
     
    </li>
    <li class=""><a title="" href="index.jsp"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->
<div id="header">
  <h1><a href="#">Admin</a></h1>
</div>
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li class="active"><a href="adminindex.jsp"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
    <li> <a href="addproduct.jsp"><i class="icon icon-signal"></i> <span>Add New Products</span></a> </li>
    <li> <a href="viewallproducts.jsp"><i class="icon icon-signal"></i> <span>View All Products</span></a> </li>
    <li><a href="sortedreviews.jsp"><i class="icon icon-th"></i> <span>Sorted Reviews</span></a></li>
     <li><a href="setdiscount.jsp"><i class="icon icon-th"></i> <span>Set Discount</span></a></li>
     <li><a href="setoffers.jsp"><i class="icon icon-th"></i> <span>Set Offers</span></a></li>
     <li><a href="invoicereports.jsp"><i class="icon icon-th"></i> <span>Invoice Details</span></a></li>
     <li><a href="revenue.jsp"><i class="icon icon-th"></i> <span>Revenue</span></a></li>
  </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->
<div class="container-fluid">


    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>Statistics of NB</h5>
          </div>
          <%
          Connection con=DBConnection.getDBConnection();
try{
	String prodid = "";
	int ram_counter = 0;
	int camera_counter = 0;
	int memory_counter = 0;
	int battery_counter = 0;
	int speed_counter = 0;
	String maxcount = "";
	List<String> pids = new ArrayList<String>();
	List<String> ptitles = new ArrayList<String>();
PreparedStatement psr = con.prepareStatement("SELECT reviews.productId, COUNT(reviews.productId) as cnt from reviews WHERE reviews.nbprior = 'bad' GROUP BY reviews.productId ORDER BY COUNT(reviews.productId)");
ResultSet rsr = psr.executeQuery();
while(rsr.next())
{
	prodid = rsr.getString("productId");	
	int countonr = rsr.getInt("cnt");
	if(countonr >= 2)
	{
		PreparedStatement psp = con.prepareStatement("SELECT reviews.Review FROM reviews WHERE reviews.productId = '" + prodid + "' AND reviews.nbprior = 'bad'");
		ResultSet rsp = psp.executeQuery();
		while(rsp.next())
		{
			if(rsp.getString("Review").contains("ram"))
			{
				ram_counter++;
			}
			else
				if(rsp.getString("Review").contains("camera"))
				{
					camera_counter++;
				}
				else
					if(rsp.getString("Review").contains("memory"))
					{
						memory_counter++;
					}
					else
						if(rsp.getString("Review").contains("speed"))
						{
							speed_counter++;
						}
						else
							if(rsp.getString("Review").contains("battery"))
							{
								battery_counter++;
							}
			
		}
		
		if((ram_counter > camera_counter) && (ram_counter > memory_counter) && (ram_counter > speed_counter) && (ram_counter > battery_counter))
		{
			maxcount = "ram";
		}
		else
			if((camera_counter > ram_counter) && (camera_counter > memory_counter) && (camera_counter > speed_counter) && (camera_counter > battery_counter))
			{
				maxcount = "camera";
			}
			else
				if((memory_counter > ram_counter) && (memory_counter > camera_counter) && (memory_counter > speed_counter) && (memory_counter > battery_counter))
				{
					maxcount = "memory";
				}
				else
					if((speed_counter > ram_counter) && (speed_counter > camera_counter) && (speed_counter > memory_counter) && (speed_counter > battery_counter))
					{
						maxcount = "speed";
					}
					else
						if((battery_counter > ram_counter) && (battery_counter > camera_counter) && (battery_counter > memory_counter) && (battery_counter > speed_counter))
						{
							maxcount = "battery";
						}
		
		PreparedStatement ps = con.prepareStatement("SELECT product.productId, product.title FROM product WHERE product.productId = '" + prodid + "'");
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			pids.add(""+rs.getString("productId"));
			ptitles.add(""+rs.getString("title"));
		}
		
	}
	
	
}

List<String> sentences = new ArrayList<String>();
	
for(int i = 0; i <  pids.size(); i++)
{
	sentences.add("Customers having issues of " + maxcount + " for the product : " + pids.get(i) + " - " + ptitles.get(i) + " Please improve " + maxcount + " of this product");
}

%>
<div>
<%
for(int i = 0; i <  pids.size(); i++)
{
%>
<h5 style="color: purple;"><%=sentences.get(i) %></h5><br>
<%
}
}
catch(Exception e){
	System.out.print(e);
}
%>
          
          
          
          <div class="widget-content nopadding">
           <form action="loadCsv2.jsp" method="post" class="form-horizontal" enctype="multipart/form-data">
            <div><label style="white-space : pre;"><%=GetSetText.nbdiplaytxt %></label></div>
            <div class="form-actions">
              <button type="submit" class="btn btn-success">Back</button>
            </div>
            </form>
          </div>
          </div>
          </div>
          </div>
          </div>
           
      </div>

<!--end-main-container-part-->



<script src="ass1/js/excanvas.min.js"></script> 
<script src="ass1/js/jquery.min.js"></script> 
<script src="ass1/js/jquery.ui.custom.js"></script> 
<script src="ass1/js/bootstrap.min.js"></script> 
<script src="ass1/js/jquery.flot.min.js"></script> 
<script src="ass1/js/jquery.flot.resize.min.js"></script> 
<script src="ass1/js/jquery.peity.min.js"></script> 
<script src="ass1/js/fullcalendar.min.js"></script> 
<script src="ass1/js/matrix.js"></script> 
<script src="ass1/js/matrix.dashboard.js"></script> 
<script src="ass1/js/jquery.gritter.min.js"></script> 
<script src="ass1/js/matrix.interface.js"></script> 
<script src="ass1/js/matrix.chat.js"></script> 
<script src="ass1/js/jquery.validate.js"></script> 
<script src="ass1/js/matrix.form_validation.js"></script> 
<script src="ass1/js/jquery.wizard.js"></script> 
<script src="ass1/js/jquery.uniform.js"></script> 
<script src="ass1/js/select2.min.js"></script> 
<script src="ass1/js/matrix.popover.js"></script> 
<script src="ass1/js/jquery.dataTables.min.js"></script> 
<script src="ass1/js/matrix.tables.js"></script> 

<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

      // if url is empty, skip the menu dividers and reset the menu selection to default
      if (newURL != "") {
      
          // if url is "-", it is this page -- reset the menu:
          if (newURL == "-" ) {
              resetMenu();            
          } 
          // else, send page to designated URL            
          else {  
            document.location.href = newURL;
          }
      }
  }

// resets the menu selection upon entry to this page:
function resetMenu() {
   document.gomenu.selector.selectedIndex = 2;
}
</script>
</body>
</html>
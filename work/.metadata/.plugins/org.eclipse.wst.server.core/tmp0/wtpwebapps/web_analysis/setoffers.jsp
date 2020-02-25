<%@page import="java.sql.ResultSet"%>
<%@page import="codes.DBConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
<%
Connection con = DBConnection.getDBConnection();
%>
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
    <li><a href="adminindex.jsp"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
     <li> <a href="addproduct.jsp"><i class="icon icon-signal"></i> <span>Add New Products</span></a> </li>
    <li> <a href="viewallproducts.jsp"><i class="icon icon-signal"></i> <span>View All Products</span></a> </li>
    <li><a href="sortedreviews.jsp"><i class="icon icon-th"></i> <span>Sorted Reviews</span></a></li>
     <li><a href="setdiscount.jsp"><i class="icon icon-th"></i> <span>Set Discount</span></a></li>
     <li class="active"><a href="setoffers.jsp"><i class="icon icon-th"></i> <span>Set Offers</span></a></li>
     <li><a href="invoicereports.jsp"><i class="icon icon-th"></i> <span>Invoice Details</span></a></li>
     <li><a href="revenue.jsp"><i class="icon icon-th"></i> <span>Revenue</span></a></li>
     <li><a href="call_chart.jsp"><i class="icon icon-th"></i> <span>Display Chart</span></a></li>
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
            <h5>Add New Offer</h5>
          </div>
          <div class="widget-content nopadding">
           <form action="SetOffers" method="post" class="form-horizontal">
        <div class="control-group">
              <label class="control-label">Offer :</label>
              <div class="controls">
                <input type="text"  required class="span11" placeholder="Offer Name" name="offer"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Free Product :</label>
              <div class="controls">
             
               <select name="offers">
                <%
                PreparedStatement ps3 = con.prepareStatement("select title from product");
                ResultSet rs3 = ps3.executeQuery();
                while(rs3.next())
                {
                %>
                  <option value="<%=rs3.getString("title")%>"><%=rs3.getString("title") %></option>
                  <%} %>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">From Date :</label>
              <div class="controls">
                <input type="date"  required class="span11" placeholder="From Date" name="fdate"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">To Date :</label>
              <div class="controls">
                <input type="date"  required class="span11" placeholder="To Date" name="tdate"/>
              </div>
            </div>
            
            
            <div class="form-actions">
              <button type="submit" class="btn btn-success">Save</button>
              <button type="reset" class="btn btn-reset">Reset</button>
            </div>
            </form>
          </div>
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>Set offer to product</h5>
          </div>
          <div class="widget-content nopadding">
           <form action="SetOffer" method="post" class="form-horizontal">
        	<div class="control-group">
              <label class="control-label">Offer:</label>
              <div class="controls">
                <select name="offers">
                <%
                PreparedStatement ps = con.prepareStatement("select offer from offers");
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                %>
                  <option><%=rs.getString("offer") %></option>
                  <%} %>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Product ID:</label>
              <div class="controls">
                <select name="products">
                <%
                PreparedStatement ps1 = con.prepareStatement("select productId from product");
                ResultSet rs1 = ps1.executeQuery();
                while(rs1.next())
                {
                %>
                  <option><%=rs1.getString("productId") %></option>
                  <%} %>
                </select>
              </div>
            </div>
            <div class="form-actions">
              <button type="submit" class="btn btn-success">Save</button>
              <button type="reset" class="btn btn-reset">Reset</button>
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
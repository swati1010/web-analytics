<%@page import="codes.GetSetText"%>
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
            <h5>Suggestion For product</h5>
          </div>
          <div class="widget-content nopadding">          
           <%
           Connection con = DBConnection.getDBConnection();
           try{
           	String mb[]={"Please Improve ram","improve the camera quality","memory space is low improve the memory storage","improve battery quality"};
           	String sp[]={"improve the shape","improve the audio performance","improve the sound quality speaker","improve battery quality"};
           	String hp[]={"improve the shape","improve the audio performance","improve the sound quality of speaker","Improve the wireless distance range"};
           	String pt[]={"improve quality of image print","improve the cartridge of the printer","improve the ink quality"};
           	%>
           	<center>
           	           	<h3>Product suggestions</h3>
           	      <table class="table table-bordered table-striped" >
           	 <thead>
           	<tr>
				
           		<th>Product-Name</th>
           		<th>suggestions</th>
           		
           	</tr>
           	</thead>
           	<tbody>
           	<%
           	boolean trs=false;
           	int cou=0;
           	int p_type=0;
           	int crm=0;
           	int ccm=0,csp=0,cbty=0;
           	int ccm2=0,csp2=0,cbty2=0,crm2=0;
           	int ccm3=0,csp3=0,cbty3=0,crm3=0;
           	int ccm4=0,csp4=0,cbty4=0,crm4=0;
           	int ccm5=0,csp5=0,cbty5=0,crm5=0;

           	String pid="";
           	String name="";
           	PreparedStatement ps2=con.prepareStatement("select product.title,product.p_type,reviews.review, reviews.productid from reviews,product where nbprior='bad' and reviews.productId = product.productId ");
           	ResultSet rs2=ps2.executeQuery();
           	while(rs2.next()){
           		pid=rs2.getString("productid");	
           		
           	p_type=rs2.getInt("p_type");
           	
           			String mobile = rs2.getString("review");
           			
           			 //mobile
           			    
           		 if((mobile.contains("ram"))&&pid.equals(pid)&&p_type==1){		 
           			 crm++;	
           			 if(crm==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=mb[0] %></label></td>
           				
           			</tr>
           				<%
           			 }
           			 
           		 }
           		 if(mobile.contains("camera")&&pid.equals(pid)&&p_type==1){
           			 ccm++;
           			if(ccm==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=mb[1] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 if(mobile.contains("storage")&&pid.equals(pid)&&p_type==1){
           			 csp++;
           			if(csp==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=mb[2] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 if(mobile.contains("battery")&&pid.equals(pid)&&p_type==1){
           			 cbty++;
           			if(cbty==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=mb[3] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 
           		 	//heaadphone2
           		 System.out.print(p_type);
           		 if((mobile.contains("shape"))&&pid.equals(pid)&&p_type==2){		 
           			 crm2++;	
           			if(crm2==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=hp[0] %></label></td>
           				
           			</tr>
           				<%
           			 }
           			 
           			 
           		 }
           		 if(mobile.contains("audio")&&pid.equals(pid)&&p_type==2){
           			 ccm2++;
           			 if(ccm2==2){
           				%>
                   		<tr>
                   		<td><label><%=rs2.getString("title") %></label></td>
                   		<td><label><%=hp[1] %></label></td>
                   	</tr>

                   		<%
           			 }
           		 }
           		 if(mobile.contains("speaker")&&pid.equals(pid)&&p_type==2){
           			 csp2++;
           			if(csp2==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=hp[2] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 if(mobile.contains("range")&&pid.equals(pid)&&p_type==2){
           			 cbty2++;
           			if(cbty2==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=hp[3] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 //speaker
           		 
           		 if((mobile.contains("shape"))&&pid.equals(pid)&&p_type==3){		 
           			 crm3++;	
           			if(crm3==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=sp[0] %></label></td>
           				
           			</tr>
           				<%
           			 }
           			 
           		 }
           		 if(mobile.contains("audio")&&pid.equals(pid)&&p_type==3){
           			 ccm3++;
           			if(ccm3==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=sp[1] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 if(mobile.contains("speaker")&&pid.equals(pid)&&p_type==3){
           			 csp3++;
           			if(csp3==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=sp[2] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 if(mobile.contains("battery")&&pid.equals(pid)&&p_type==3){
           			 cbty3++;
           			if(cbty3==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=sp[3] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 //laptop
           		 
           		 if((mobile.contains("ram"))&&pid.equals(pid)&&p_type==4){		 
           			 crm4++;	
           			if(crm4==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=mb[0] %></label></td>
           				
           			</tr>
           				<%
           			 }
           			 
           		 }
           		 if(mobile.contains("camera")&&pid.equals(pid)&&p_type==4){
           			 ccm4++;
           			if(ccm4==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=mb[1] %></label></td>
           				
           			</tr>
           				<%
           			 }
           			 
           		 }
           		 if(mobile.contains("storage")&&pid.equals(pid)&&p_type==4){
           			 csp4++;
           			if(csp4==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=mb[2] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 if(mobile.contains("battery")&&pid.equals(pid)&&p_type==4){
           			 cbty4++;
           			if(cbty4==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=mb[3] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 //printer
           		 if((mobile.contains("image"))&&pid.equals(pid)&&p_type==5){		 
           			 crm5++;	
           			if(crm5==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=pt[0] %></label></td>
           				
           			</tr>
           				<%
           			 }
           			 
           			 
           		 }
           		 if(mobile.contains("cartridge")&&pid.equals(pid)&&p_type==5){
           			 ccm5++;
           			if(ccm5==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=pt[1] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 if(mobile.contains("ink")&&pid.equals(pid)&&p_type==5){
           			 csp5++;
           			if(csp5==3){
           				%>
           				<tr>
           				<td><label><%=rs2.getString("title") %></label></td>
           				<td><label><%=pt[2] %></label></td>
           				
           			</tr>
           				<%
           			 }
           		 }
           		 if(mobile.contains("battery")&&pid.equals(pid)&&p_type==5){
           			 cbty5++;
           		 }
           		
           		
           		 
           		 
           	} 
           	}
           	catch(Exception e){
           		out.print(e);
           	}
           	%>
           
          
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
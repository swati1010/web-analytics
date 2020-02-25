
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*" %>
<%@page import="codes.DBConnection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="js/jquery-1.4.2.min.js"></script> 
<!-- <script type="text/javascript">
     var auto = setInterval(    function ()
     {
          $('#score').load('reload-window.jsp').fadeIn("slow");
     }, 15000); // refresh every 5000 milliseconds
</script> -->
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
<style type="text/css">
.bar{
margin-left: 4em;
    font-size: 20px;
    color: #27a9e3;
}
th{
    font-size: 20px !important;
}

</style>
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

<div id="score" width="100%" align="center"></div>
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>Upload Product Data From CSV File</h5>
          </div>
          <div class="widget-content nopadding">
          
          
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
<%-- <h5 style="color: purple;"><%=sentences.get(i) %></h5><br>
 --%><%
}
%>
</div>
<%

	PreparedStatement ps=con.prepareStatement("SELECT  date, sum( counts)as ab FROM counts GROUP BY date");
	ResultSet r = ps.executeQuery();
	


%>

<%

%>
<table class="table table-bordered table-striped" border="1">
<br><br>
<h2><center>Cancel Items or Orders</center></h2>
              <thead>
                <tr>
                  <th>Product Name</th>
                  <th>Reasons</th>
                  
                </tr>
              </thead>
              <tbody>
             
             

<%
PreparedStatement psc=con.prepareStatement("select * from invoice where status=0");
ResultSet rsc=psc.executeQuery();
while(rsc.next()){
	%>
	 <tr>
                  <td><%=rsc.getString("p_name") %></td>
                  <td><%=rsc.getString("cancel_product") %></td>
                  
                </tr>
	
	<%

}

%>
<!-- </tbody></table>
<table class="table table-bordered table-striped" border="1">
<br><br>
<h2>Offers for location</h2>
              <thead>
                <tr>
                  <th>Name</th>
                  <th>offer</th>
                  
                </tr>
              </thead>
              <tbody> -->


<%
/* PreparedStatement psl=con.prepareStatement("SELECT location,COUNT(location) as ls FROM user GROUP by location");
		ResultSet rsl=psl.executeQuery();
		int lcount=0;
		while(rsl.next()){
			lcount=rsl.getInt("ls");
			if(lcount<4) { */
				%>
				 <%-- <tr>
			                  <td><%=rsl.getString("location") %></td>
			                  <td><%=rsl.getString("ls") %></td>
			                  
			                </tr> --%>
			               
				
				<%
				
			/* } */
			


/* } */
				//date		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	      java.util.Date date=new java.util.Date();  
	      String d=dateFormat.format(date);
	      
	      //time
	      SimpleDateFormat time = new SimpleDateFormat("hh");
	      java.util.Date time1 =new java.util.Date();  
	      String t=time.format(time1);	      
	      int tt=Integer.parseInt(t);
	      
	      
PreparedStatement pss1=con.prepareStatement("SELECT  date, sum(counts)as ab FROM counts GROUP BY date");
ResultSet rss1=pss1.executeQuery();
String date1="";
int sum=0;
while(rss1.next()){
	sum=rss1.getInt("ab");
	
	date1=rss1.getString("date");
	if(date1.equals(d)&&sum>=2&&tt>=6){
		System.out.print("hello  "+tt);
	}
	
}		
}
catch(Exception e){
	out.print(e);
}



%>

 </tbody>
              </table>

<%-- <table class="table table-bordered table-striped">
<h1>More than 13 visits on website</h1>
<tr>
	<th>Date</th>
	<th>Hits</th>
	<th>happy</th>
</tr>
<%

while(r.next()){
	 String category = r.getString("date");
	   int hits = r.getInt("ab");
	   if(hits>=13){	
		%>
		<tr>
		<td><label><%=r.getString("date") %></label></td>
		<td><label><%=hits%></label></td>
		<td><label>&#9787;</label></td>
	</tr>
		<%
}
}
}
catch(Exception e){
	out.print(e);
}


%>
 --%>


  </table>  </table></center>      
         <%--  <center><table border="1">
<tr>
	<td>Count</td>
	<td>date</td>
</tr>
        <%
        Connection con=DBConnection.getDBConnection();
        PreparedStatement ps=con.prepareStatement("select * from counts");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
        	int counts=rs.getInt("counts");
        	String date=rs.getString("date");
        	%>
        	<tr>
	<td><%=counts %></td>
	<td><%=date %></td>
</tr>
        	
        	<%
        	
        	
        }
        
        
        
        %>  
       </table></center>  --%>
           <form action="loadCsv.jsp" method="post" class="form-horizontal" enctype="multipart/form-data">
         <!--  <div class="control-group">
              <div class="controls">
                <input type="file" id="file" name="file"/>
                
              </div>
            </div> -->
            
            <div class="form-actions">
              <button type="submit" class="btn btn-success">Upload Data</button>
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
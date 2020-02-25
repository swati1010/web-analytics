<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
     <%@ page import="java.text.*" %>
     <%@ page import="java.util.*" %>
     <%@ page import="java.io.*" %>
      <%@ page import="weka.core.*" %>
      <%@ page import="weka.classifiers.*" %>
      <%@ page import="weka.filters.unsupervised.attribute.StringToWordVector" %>
      <%@ page import="codes.*" %>
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

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Customer Analysis</a></h1>
</div>
<!--close-Header-part--> 
<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li id="profile-messages" ><a title="" href="#" data-target="#profile-messages" ><i class="icon icon-user"></i>  <span class="text">Welcome Admin</span><b class="caret"></b></a>
     
    </li>
    <li class=""><a title="" href="index.jsp"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->

<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li><a href="adminindex.jsp"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
    <li> <a href="addproduct.jsp"><i class="icon icon-signal"></i> <span>Add New Products</span></a> </li>
    <li> <a href="viewallproducts.jsp"><i class="icon icon-signal"></i> <span>View All Products</span></a> </li>
    <li class="active"><a href="#"><i class="icon icon-th"></i> <span>Sorted Reviews</span></a></li>
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
    <div id="breadcrumb"> <a href="adminindex.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a><a href="#" class="current">Sorted Reviews</a></div>
  </div>
<!--End-breadcrumbs-->

  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>Products with reviews</h5>
            <%
            
            Connection con = DBConnection.getDBConnection();
        		PreparedStatement ps = con.prepareStatement("SELECT reviews.Review, reviews.Rating, reviews.prior, product.title FROM reviews, product WHERE reviews.productId = product.productId");
        		ResultSet rs = ps.executeQuery();
        		rs.last();
        		String[] testText = new String[rs.getRow()];
        		rs.beforeFirst();
        		int index = 0;
        		while(rs.next())
        		{
        			testText[index++] = rs.getString("Review");
        			
        		}
        		TextClassifier.thisClassString = "weka.classifiers.bayes.NaiveBayes";
                String fileName = "E:\\swati_pro\\web_analysis\\previews.csv";
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
    	                
    	                inputText[ii] = attributes[0];
    	                inputClasses[ii] = attributes[0];
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
    	            for (int i = 0; i < testText.length; i++) {
    	                thisTextAttribute.addStringValue(testText[i]);
    	            }

    	            //
    	            // create the attribute information
    	            //
    	            FastVector thisAttributeInfo = new FastVector(2);
    	            thisAttributeInfo.addElement(thisTextAttribute);
    	            thisAttributeInfo.addElement(thisClassAttribute);


    	            TextClassifier classifier = new TextClassifier(inputText, inputClasses, thisAttributeInfo, thisTextAttribute, thisClassAttribute, TextClassifier.thisClassString);

    	            System.out.println("DATA SET:\n");
    	            System.out.println(classifier.classify(TextClassifier.thisClassString));
    	            System.out.println("NEW CASES:\n");
    	            System.out.println(classifier.classifyNewCases(testText));
    	            
    	            String tcr = TextClassifier.caseresults;
    	            
    	            tcr = tcr.substring(0, tcr.length()-1);
    	            System.out.println(""+tcr);
    	            String results[] = tcr.split(",");
    	            TextClassifier.caseresults = "";
           // SELECT reviews.Review, reviews.Rating, reviews.prior, product.title FROM reviews, product WHERE reviews.productId = product.productId
            %>
            
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>Sr. No.</th>
                  <th>Product Name</th>
                  <th>Review</th>
                  <th>Prior</th>
                </tr>
              </thead>
              <tbody>
              <%
              int r = 1, i = 0;
              	PreparedStatement psr = con.prepareStatement("SELECT reviews.ID, reviews.Review, reviews.Rating, reviews.prior, product.title, reviews.productId FROM reviews, product WHERE reviews.productId = product.productId");
              	ResultSet rsr = psr.executeQuery();
              	while(rsr.next())
              	{
              		
              
              %>
                <tr class="odd gradeX">
                  <td><%=r++ %></td>
                  <td><%=rsr.getString("title") %></td>
                  <td><%=rsr.getString("Review") %></td>
                  
                  <%
                  	if((results[i].equals("bad") && Integer.parseInt(rsr.getString("Rating")) < 3) || (results[i].equals("good") && Integer.parseInt(rsr.getString("Rating")) < 3))
                  	{
                  %>
                  <td>bad</td>
                  <%}
                  else
                  {%>
                  <td>good</td>
                  <%} %>
                </tr>
                <%
                PreparedStatement ps1 = con.prepareStatement("UPDATE reviews SET prior='" + results[i] + "' WHERE productId = '" + rsr.getString("productId") + "' and ID = "+rsr.getInt("ID"));
                ps1.executeUpdate();
                i++;
                }
                %>
              </tbody>
            </table>
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
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M18
 * Generated at: 2017-04-20 09:44:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.sql.*;
import codes.DBConnection;

public final class Suggestion_005fdisp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("codes.DBConnection");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<script src=\"js/jquery-1.4.2.min.js\"></script> \r\n");
      out.write("<!-- <script type=\"text/javascript\">\r\n");
      out.write("     var auto = setInterval(    function ()\r\n");
      out.write("     {\r\n");
      out.write("          $('#score').load('reload-window.jsp').fadeIn(\"slow\");\r\n");
      out.write("     }, 15000); // refresh every 5000 milliseconds\r\n");
      out.write("</script> -->\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Admin</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"ass1/css/bootstrap.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"ass1/css/bootstrap-responsive.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"ass1/css/fullcalendar.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"ass1/css/matrix-style.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"ass1/css/matrix-media.css\" />\r\n");
      out.write("<link href=\"ass1/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"ass1/css/jquery.gritter.css\" />\r\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".bar{\r\n");
      out.write("margin-left: 4em;\r\n");
      out.write("    font-size: 20px;\r\n");
      out.write("    color: #27a9e3;\r\n");
      out.write("}\r\n");
      out.write("th{\r\n");
      out.write("    font-size: 20px !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!--top-Header-menu-->\r\n");
      out.write("<div id=\"user-nav\" class=\"navbar navbar-inverse\">\r\n");
      out.write("  <ul class=\"nav\">\r\n");
      out.write("    <li id=\"profile-messages\" ><a title=\"\" href=\"#\" data-target=\"#profile-messages\" ><i class=\"icon icon-user\"></i>  <span class=\"text\">Welcome Admin</span><b class=\"caret\"></b></a>\r\n");
      out.write("     \r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"\"><a title=\"\" href=\"index.jsp\"><i class=\"icon icon-share-alt\"></i> <span class=\"text\">Logout</span></a></li>\r\n");
      out.write("  </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!--close-top-Header-menu-->\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("  <h1><a href=\"#\">Admin</a></h1>\r\n");
      out.write("</div>\r\n");
      out.write("<!--sidebar-menu-->\r\n");
      out.write("<div id=\"sidebar\"><a href=\"#\" class=\"visible-phone\"><i class=\"icon icon-home\"></i> Dashboard</a>\r\n");
      out.write("  <ul>\r\n");
      out.write("  <li class=\"active\"><a href=\"adminindex.jsp\"><i class=\"icon icon-home\"></i> <span>Dashboard</span></a> </li>\r\n");
      out.write("    <li> <a href=\"addproduct.jsp\"><i class=\"icon icon-signal\"></i> <span>Add New Products</span></a> </li>\r\n");
      out.write("    <li> <a href=\"viewallproducts.jsp\"><i class=\"icon icon-signal\"></i> <span>View All Products</span></a> </li>\r\n");
      out.write("    <li><a href=\"sortedreviews.jsp\"><i class=\"icon icon-th\"></i> <span>Sorted Reviews</span></a></li>\r\n");
      out.write("     <li><a href=\"setdiscount.jsp\"><i class=\"icon icon-th\"></i> <span>Set Discount</span></a></li>\r\n");
      out.write("     <li><a href=\"setoffers.jsp\"><i class=\"icon icon-th\"></i> <span>Set Offers</span></a></li>\r\n");
      out.write("     <li><a href=\"invoicereports.jsp\"><i class=\"icon icon-th\"></i> <span>Invoice Details</span></a></li>\r\n");
      out.write("     <li><a href=\"revenue.jsp\"><i class=\"icon icon-th\"></i> <span>Revenue</span></a></li>\r\n");
      out.write("     <li><a href=\"call_chart.jsp\"><i class=\"icon icon-th\"></i> <span>Display Chart</span></a></li>\r\n");
      out.write("  </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!--sidebar-menu-->\r\n");
      out.write("\r\n");
      out.write("<!--main-container-part-->\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("<!--breadcrumbs-->\r\n");
      out.write("  <div id=\"content-header\">\r\n");
      out.write("    <div id=\"breadcrumb\"> <a href=\"index.html\" title=\"Go to Home\" class=\"tip-bottom\"><i class=\"icon-home\"></i> Home</a></div>\r\n");
      out.write("  </div>\r\n");
      out.write("<!--End-breadcrumbs-->\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("<body>\r\n");
      out.write(" ");

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


      out.write("\r\n");
      out.write("<div>\r\n");

for(int i = 0; i <  pids.size(); i++)
{

      out.write("\r\n");
      out.write("<h5 style=\"color: purple;\">");
      out.print(sentences.get(i) );
      out.write("</h5><br>\r\n");

}
}
catch(Exception e){
	System.out.print(e);
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
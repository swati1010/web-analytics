/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M18
 * Generated at: 2017-04-21 07:02:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import weka.core.Attribute;
import weka.core.FastVector;
import java.util.Arrays;
import java.util.HashSet;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.sql.*;
import codes.*;
import java.text.SimpleDateFormat;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 static int hitsCount=0; 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("codes");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.HashSet");
    _jspx_imports_classes.add("java.util.Arrays");
    _jspx_imports_classes.add("weka.core.FastVector");
    _jspx_imports_classes.add("java.nio.file.Files");
    _jspx_imports_classes.add("java.nio.file.Paths");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.io.BufferedReader");
    _jspx_imports_classes.add("weka.core.Attribute");
    _jspx_imports_classes.add("java.nio.file.Path");
    _jspx_imports_classes.add("java.nio.charset.StandardCharsets");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("       <!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"robots\" content=\"all,follow\">\r\n");
      out.write("    <meta name=\"googlebot\" content=\"index,follow,snippet,archive\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"Obaju e-commerce template\">\r\n");
      out.write("    <meta name=\"author\" content=\"Ondrej Svestka | ondrejsvestka.cz\">\r\n");
      out.write("    <meta name=\"keywords\" content=\"\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/rating.css\">\r\n");
      out.write("    <title>\r\n");
      out.write("          Electric Smiling\r\n");
      out.write("    </title>\r\n");
      out.write("\r\n");
      out.write("    <meta name=\"keywords\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("    <!-- styles -->\r\n");
      out.write("    <link href=\"css/font-awesome.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/animate.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/owl.carousel.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/owl.theme.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- theme stylesheet -->\r\n");
      out.write("    <link href=\"css/style.default.css\" rel=\"stylesheet\" id=\"theme-stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- your stylesheet with modifications -->\r\n");
      out.write("    <link href=\"css/custom.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <script src=\"js/respond.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"favicon.png\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"amount\" value=\"2.5\">\r\n");
      out.write("\t\r\n");
      out.write("<p id=\"abc\"><span class=\"stars\"><span style=\"width: 40.48px;\"></span></span></p>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

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


		
  
    
	
	
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- *** TOPBAR ***\r\n");
      out.write(" _________________________________________________________ -->\r\n");
      out.write("    <div id=\"top\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"col-md-6 offer\" data-animate=\"fadeInDown\">\r\n");
      out.write("<!--                 <a href=\"#\" class=\"btn btn-success btn-sm\" data-animate-hover=\"shake\">Offer of the day</a>  <a href=\"#\">Get flat 35% off on orders over $50!</a>\r\n");
      out.write(" -->            </div>\r\n");
      out.write("            <div class=\"col-md-6\" data-animate=\"fadeInDown\">\r\n");
      out.write("                <ul class=\"menu\">\r\n");
      out.write("                \r\n");
      out.write("                ");
if(userid>=1){
                	
                	
                	
      out.write("\r\n");
      out.write("                \t<li ><a  href=\"#\"><i class=\"fa fa-user\"></i>");
      out.print(uname );
      out.write(" </a>\r\n");
      out.write("                \t<li ><a  href=\"logout.jsp\"><i class=\"fa fa-user\"></i>Logout </a>\r\n");
      out.write("                \t");

                }
                else{
                	
      out.write("\r\n");
      out.write("                \t<li><a href=\"#\" data-toggle=\"modal\" data-target=\"#login-modal\">Login</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li><a href=\"register.html\">Register</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                \t");

                	
                }
                
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    <li><a href=\"contact.jsp\">Contact</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                   \r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal fade\" id=\"login-modal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"Login\" aria-hidden=\"true\">\r\n");
      out.write("            <div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("                        <h4 class=\"modal-title\" id=\"Login\">Customer login</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <form action=\"Login\" method=\"post\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <input type=\"text\" name=\"username\" class=\"form-control\" id=\"email-modal\" placeholder=\"emial\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <input type=\"password\" name=\"password\" class=\"form-control\" id=\"password-modal\" placeholder=\"password\">\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <p class=\"text-center\">\r\n");
      out.write("                                <button class=\"btn btn-primary\"><i class=\"fa fa-sign-in\"></i> Log in</button>\r\n");
      out.write("                            </p>\r\n");
      out.write("\r\n");
      out.write("                        </form>\r\n");
      out.write("\r\n");
      out.write("                        <p class=\"text-center text-muted\">Not registered yet?</p>\r\n");
      out.write("                        <p class=\"text-center text-muted\"><a href=\"register.html\"><strong>Register now</strong></a>! It is easy and done in 1&nbsp;minute and gives you access to special discounts and much more!</p>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- *** TOP BAR END *** -->\r\n");
      out.write("\r\n");
      out.write("    <!-- *** NAVBAR ***\r\n");
      out.write(" _________________________________________________________ -->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"navbar navbar-default yamm\" role=\"navigation\" id=\"navbar\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"navbar-header\">\r\n");
      out.write("\r\n");
      out.write("                <a class=\"navbar-brand home\" href=\"index.html\" data-animate-hover=\"bounce\">\r\n");
      out.write("                     <img src=\"img/nameofwebsite.jpg\" style=\"width: 126px;height: 58px;\" alt=\"Obaju logo\" class=\"hidden-xs\">\r\n");
      out.write("                    <img src=\"img/logo-small.png\" alt=\"Obaju logo\" class=\"visible-xs\"><span class=\"sr-only\">Obaju - go to homepage</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"navbar-buttons\">\r\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navigation\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                        <i class=\"fa fa-align-justify\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#search\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle search</span>\r\n");
      out.write("                        <i class=\"fa fa-search\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <a class=\"btn btn-default navbar-toggle\" href=\"basket.html\">\r\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i>  <span class=\"hidden-xs\">3 items in cart</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--/.navbar-header -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"navbar-collapse collapse\" id=\"navigation\">\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"nav navbar-nav navbar-left\">\r\n");
      out.write("                    <li class=\"active\"><a href=\"index.jsp\">Home</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=1&brand=mobile\">Mobile</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=4&brand=Laptop\">Laptop</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=2&brand=Headphone\">Headphone</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=3&brand=Speaker\">Speaker</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=5&brand=Printer\">Printer</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                       <li ><a href=\"your_account.jsp\">Your Account</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                  \r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--/.nav-collapse -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"navbar-buttons\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"navbar-collapse collapse right\" id=\"basket-overview\">\r\n");
      out.write("                 ");

                    	String ucount = "";
                    String totalsum = "";
                    	PreparedStatement pscart = con.prepareStatement("SELECT COUNT(userid) AS usercount, SUM(total) AS totalsum FROM cart WHERE userid = " + userid + " GROUP BY userid");
                    	ResultSet rscart = pscart.executeQuery();
                    	if(rscart.next())
                    	{
                    		ucount = rscart.getInt("usercount")+"";
                    		totalsum = rscart.getInt("totalsum")+"";
                    	}
                    
      out.write("\r\n");
      out.write("                    <a href=\"basket.jsp?userid=");
      out.print(userid );
      out.write("\" class=\"btn btn-primary navbar-btn\"><i class=\"fa fa-shopping-cart\"></i><span class=\"hidden-sm\">");
      out.print(ucount );
      out.write(" items in cart</span></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--/.nav-collapse -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"navbar-collapse collapse right\" id=\"search-not-mobile\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn navbar-btn btn-primary\" data-toggle=\"collapse\" data-target=\"#search\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle search</span>\r\n");
      out.write("                        <i class=\"fa fa-search\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"collapse clearfix\" id=\"search\">\r\n");
      out.write("\r\n");
      out.write("                <form class=\"navbar-form\" role=\"search\">\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\r\n");
      out.write("                        <span class=\"input-group-btn\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-primary\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("\r\n");
      out.write("\t\t    </span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--/.nav-collapse -->\r\n");
      out.write("            <!--/.nav-collapse -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.container -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /#navbar -->\r\n");
      out.write("\r\n");
      out.write("    <!-- *** NAVBAR END *** -->\r\n");
      out.write("\r\n");
      out.write("    <div id=\"all\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"content\">\r\n");
      out.write("            <div class=\"container\">\r\n");
 String brand=request.getParameter("brand"); 
      out.write("\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <ul class=\"breadcrumb\">\r\n");
      out.write("                        <li><a href=\"#\">Home</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"#\">");
      out.print(brand );
      out.write("</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        \r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-3\">\r\n");
      out.write("                    <!-- *** MENUS AND FILTERS ***\r\n");
      out.write(" _________________________________________________________ -->\r\n");
      out.write("                    <div class=\"panel panel-default sidebar-menu\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"panel-heading\">\r\n");
      out.write("                            <h3 class=\"panel-title\">Categories</h3>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                          <div class=\"panel-body\">\r\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked category-menu\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"category.html\">Electronic <span class=\"badge pull-right\"></span></a>\r\n");
      out.write("                                    <ul>\r\n");
      out.write("                                        <li ><a href=\"shop.jsp?p_type=1&brand=mobile\">Mobile</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=4&brand=Laptop\">Laptop</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=2&brand=Headphone\">Headphone</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=3&brand=Speaker\">Speaker</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=5&brand=Printer\">Printer</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                \r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                   \r\n");
      out.write("                    <!-- *** MENUS AND FILTERS END *** -->\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"banner\">\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                          \r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-9\">\r\n");

String prodId =request.getParameter("prodId");
PreparedStatement psp = con.prepareStatement("select * from product where productId = '" + prodId + "'");
ResultSet rs=psp.executeQuery();
if(rs.next()){
	
	
	



      out.write("\r\n");
      out.write("                    <div class=\"row\" id=\"productMain\">\r\n");
      out.write("                        <div class=\"col-sm-6\">\r\n");
      out.write("                            <div id=\"mainImage\">\r\n");
      out.write("                                <img src=\"");
      out.print(rs.getString("imageUrlStr") );
      out.write("\" alt=\"\" class=\"img-responsive\">\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"ribbon sale\">\r\n");
      out.write("                                <div class=\"theribbon\">SALE</div>\r\n");
      out.write("                                <div class=\"ribbon-background\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- /.ribbon -->\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"ribbon new\">\r\n");
      out.write("                                <div class=\"theribbon\">NEW</div>\r\n");
      out.write("                                <div class=\"ribbon-background\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- /.ribbon -->\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-sm-6\">\r\n");
      out.write("                            <div class=\"box\">\r\n");
      out.write("                                <h1 class=\"text-center\">");
      out.print(rs.getString("title") );
      out.write("</h1>\r\n");
      out.write("                                <p class=\"goToDescription\">");
      out.print(rs.getString("description") );
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <p class=\"price\">&#8377;");
      out.print(rs.getString("price") );
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                                <p class=\"text-center buttons\">\r\n");
      out.write("                                    <a href=\"addtocart.jsp?prodId=");
      out.print(rs.getString("productId"));
      out.write("&userid=");
      out.print(userid );
      out.write("&cname=");
      out.print(uname );
      out.write("&email=");
      out.print(email );
      out.write("&p_type=");
      out.print(rs.getString("p_type")  );
      out.write("&brand=");
      out.print(brand );
      out.write("&price=");
      out.print(rs.getString("price") );
      out.write("&qty=1&shipping=0\" class=\"btn btn-primary\"><i class=\"fa fa-shopping-cart\"></i> Add to cart</a> \r\n");
      out.write("                                </p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"box\" id=\"details\">\r\n");
      out.write("                        <h1>Review</h1>\r\n");
      out.write("\r\n");
      out.write("                       \r\n");
      out.write("\r\n");
      out.write("                        <hr>\r\n");
      out.write("\r\n");
      out.write("                        <form action=\"UserReview\" method=\"post\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"name\">Name</label>\r\n");
      out.write("                                <input type=\"text\" required=\"required\" class=\"form-control\" id=\"name\" name=\"name\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"email\">Email</label>\r\n");
      out.write("                                <input type=\"text\" required=\"required\" value=\"");
      out.print(email );
      out.write("\" name=\"email\" class=\"form-control\" id=\"email\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"password\">Review</label>\r\n");
      out.write("                                <textarea required=\"required\" name=\"review\" id=\"\" width=\"300px\" cols=\"30\" rows=\"4\" class=\"form-control\"  ></textarea>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <p>Please rate this item:</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"rating-wrap-post\">\r\n");
      out.write("                                                            <span class=\"star-cb-group\">\r\n");
      out.write("      <input type=\"radio\" required=\"required\" id=\"rating-5\" name=\"rating\" value=\"5\" required=\"required\"/><label for=\"rating-5\">5</label>\r\n");
      out.write("      <input type=\"radio\" id=\"rating-4\" name=\"rating\" value=\"4\"  required=\"required\" /><label for=\"rating-4\">4</label>\r\n");
      out.write("      <input type=\"radio\" id=\"rating-3\" name=\"rating\" value=\"3\" required=\"required\" /><label for=\"rating-3\">3</label>\r\n");
      out.write("      <input type=\"radio\" id=\"rating-2\" name=\"rating\" value=\"2\" required=\"required\"/><label for=\"rating-2\">2</label>\r\n");
      out.write("      <input type=\"radio\" id=\"rating-1\" name=\"rating\" value=\"1\"required=\"required\" /><label for=\"rating-1\">1</label>\r\n");
      out.write("     \r\n");
      out.write("    </span>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                       <input type=\"hidden\" value=\"");
      out.print(prodId );
      out.write("\" name=\"hide\"/>\r\n");
      out.write("                                                       <input type=\"hidden\" value=\"");
      out.print(brand );
      out.write("\" name=\"brand\"/>\r\n");
      out.write("                            \r\n");
      out.write("                            <div cl\tass=\"text-center\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fa fa-user-md\"></i>Submit</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("\r\n");
      out.write("                           \r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                   \r\n");
      out.write("                        </div></div>\r\n");
      out.write("                        <center>\r\n");
      out.write("                       <h1> Top Customer Reviews</h1>\r\n");
      out.write("                       <table>\r\n");
      out.write("                       \r\n");
      out.write("                        ");

                        PreparedStatement pss=con.prepareStatement("select * from reviews where productid='"+prodId+"'");
    		  		ResultSet rss=pss.executeQuery();
    		  while(rss.next()){
    			  
      out.write("\r\n");
      out.write("    \t\t\t  <tr><td>");
      out.print(rss.getString("name") );
      out.write(":</td>\r\n");
      out.write("    \t\t\t  \r\n");
      out.write("    \t\t\t  <td>");
      out.print(rss.getString(3) );
      out.write("</td>\r\n");
      out.write("    \t\t\t  </tr>\r\n");
      out.write("    \t\t\t  \r\n");
      out.write("    \t\t\t  <tr>\r\n");
      out.write("    \t\t\t  \r\n");
      out.write("    \t\t\t  <td colspan=\"2\">");
      out.print(rss.getString(4) );
      out.write("<span style=\"font-size:165%;color:#ffb400;;\">&starf;</span></td>\r\n");
      out.write("    \t\t\t  </tr>\r\n");
      out.write("    \t\t\t  \r\n");
      out.write("    \t\t\t  \r\n");
      out.write("    \t\t\t  ");

    			  
    			  
    		  }
                        
                        
                        
      out.write("\r\n");
      out.write("                        </table>\r\n");
      out.write("                  </center>      \r\n");
      out.write("                \r\n");
      out.write("                        \r\n");
      out.write("        <!-- /#content -->\r\n");
      out.write("\r\n");
      out.write("        <!-- *** FOOTER ***\r\n");
      out.write(" _________________________________________________________ -->\r\n");
      out.write("        <div id=\"footer\" data-animate=\"fadeInUp\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-3 col-sm-6\">\r\n");
      out.write("                       \r\n");
      out.write("\r\n");
      out.write("                      \r\n");
      out.write("\t\r\n");
      out.write("                       \r\n");
      out.write("\r\n");
      out.write("                        <h4>User section</h4>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                        <ul>\r\n");
      out.write("                        ");

				if(userid>=1){
					
					 
      out.write("\r\n");
      out.write("\t\t\t\t\t <li ><a  href=\"logout.jsp\"><i class=\"fa fa-user\"></i>Logout </a>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t ");

				}
				else{
					
					
      out.write("\r\n");
      out.write("\t\t\t\t\t  <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#login-modal\">Login</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li><a href=\"register.html\">Regiter</a>\r\n");
      out.write("                            </li> \r\n");
      out.write("\t\t\t\t\t");

				}
				
				
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                           \r\n");
      out.write("                        </ul>\r\n");
      out.write("\r\n");
      out.write("                        <hr class=\"hidden-md hidden-lg hidden-sm\">\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.col-md-3 -->\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-md-3 col-sm-6\">\r\n");
      out.write("\r\n");
      out.write("                        <h4>Top categories</h4>\r\n");
      out.write("\r\n");
      out.write("                        <h5>Electronic</h5>\r\n");
      out.write("\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li ><a href=\"shop.jsp?p_type=1&brand=mobile\">Mobile</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=4&brand=Laptop\">Laptop</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=2&brand=Headphone\">Headphone</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=3&brand=Speaker\">Speaker</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li ><a href=\"shop.jsp?p_type=5&brand=Printer\">Printer</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("\r\n");
      out.write("                        <hr class=\"hidden-md hidden-lg\">\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.col-md-3 -->\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-md-3 col-sm-6\">\r\n");
      out.write("\r\n");
      out.write("                       \r\n");
      out.write("\r\n");
      out.write("                        <a href=\"contact.jsp\">Go to contact page</a>\r\n");
      out.write("\r\n");
      out.write("                        <hr class=\"hidden-md hidden-lg\">\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.col-md-3 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <!-- /.col-md-3 -->\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.container -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /#footer -->\r\n");
      out.write("\r\n");
      out.write("        <!-- *** FOOTER END *** -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- *** COPYRIGHT ***\r\n");
      out.write(" _________________________________________________________ -->\r\n");
      out.write("        \r\n");
      out.write("        <!-- *** COPYRIGHT END *** -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /#all -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <!-- *** SCRIPTS TO INCLUDE ***\r\n");
      out.write(" ___________________   <script src=\"js/rating.js\"></script>______________________________________ -->\r\n");
      out.write("    <script src=\"js/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery.cookie.js\"></script>\r\n");
      out.write("    <script src=\"js/waypoints.min.js\"></script>\r\n");
      out.write("    <script src=\"js/modernizr.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap-hover-dropdown.js\"></script>\r\n");
      out.write("    <script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script src=\"js/front.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
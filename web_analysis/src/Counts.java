

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.text.SimpleDateFormat;

import codes.DBConnection;

/**
 * Servlet implementation class Counts
 */
@WebServlet("/Counts")
public class Counts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int hitCount; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() 
    { 
       // Reset hit counter.
       hitCount = 0;
    } 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	      // This method executes whenever the servlet is hit 
	      // increment hitCount 
	      hitCount++; 
	      PrintWriter out = response.getWriter();
	      String title = "Total Number of Hits";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n" +
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<h2 align=\"center\">" + hitCount + "</h2>\n" +
	        "</body></html>");
	      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	      java.util.Date date=new java.util.Date();  
	      String d=dateFormat.format(date);
	      System.out.println(d); //2013/10/15 16:16:39
	      try{
	    	  Connection con=DBConnection.getDBConnection();
	      if(hitCount==1){
	    	 
	    	 
	    	  PreparedStatement ps=con.prepareStatement("insert into counts(counts,date)values(?,?)");
	    	  ps.setInt(1, hitCount);
	    	  ps.setString(2,d);
	    	  int i=ps.executeUpdate();
	    	  
	      }
	      else{
	    	  PreparedStatement ps1=con.prepareStatement("update counts set counts='"+hitCount+"' where date=?");
	    	  ps1.setString(1,d);
	    	  int j=ps1.executeUpdate();
	    	  
	      }
	      }
	      catch (Exception e) {
	    	  System.out.println(e);
			// TODO: handle exception
		}
	      request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

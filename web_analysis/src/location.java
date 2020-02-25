

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import codes.DBConnection;

/**
 * Servlet implementation class location
 */
@WebServlet("/location")
public class location extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public location() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			 
			}
			catch (ClassNotFoundException e) {
			//  System.out.println(e.toString());
			}
			
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 
		 
		
		
		 
		 
		 
		 
		 OutputStream out = response.getOutputStream(); 
		 try{
			Connection connect=DBConnection.getDBConnection();
		    	     
		    	      Statement statement = connect.createStatement( );
		    	    
		    	      ResultSet resultSet = statement.executeQuery("SELECT location, count(location) FROM user GROUP BY location");
		    	      DefaultPieDataset dataset = new DefaultPieDataset();
		    	      while(resultSet.next()) 
		    	      {
		    	         dataset.setValue( 
		    	         resultSet.getString("location"),
		    	         Double.parseDouble( resultSet.getString(2)));
		    	      }
		    	      JFreeChart chart = ChartFactory.createPieChart(
		    	         "Location",  // chart title           
		    	         dataset,         // data           
		    	         true,            // include legend          
		    	         true,           
		    	         false);
		    	      PiePlot plot = (PiePlot) chart.getPlot();
		    	      PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
		  	                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		  	            plot.setLabelGenerator(gen);
		    	      int width = 660;  
		    	      int height = 470; 
		    	      response.setContentType("image/png"); 
		  		    ChartUtilities.writeChartAsJPEG(out, chart,width,height);
		  		   
	   }catch(Exception e){
		  
	   }
         finally {
     out.close();
  }
		
	}
}
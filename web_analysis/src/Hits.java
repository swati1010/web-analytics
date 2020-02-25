

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
 * Servlet implementation class Hits
 */
@WebServlet("/Hits")
public class Hits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hits() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  
			}
			catch (ClassNotFoundException e) {
			  //System.out.println(e.toString());
			}
			
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String url = request.getRequestURL().toString();
		System.out.println(url);
		
		
		 OutputStream out = response.getOutputStream(); 
		 try{
			Connection connect=DBConnection.getDBConnection();
		    	     
		    	      Statement statement = connect.createStatement( );
		    	    
		    	      ResultSet resultSet = statement.executeQuery("Select url, sum(hits) as Count from clicks GROUP BY url");
		    	      DefaultPieDataset dataset = new DefaultPieDataset();
		    	      while(resultSet.next()) 
		    	      {
		    	         dataset.setValue( 
		    	         resultSet.getString("url"),
		    	         Double.parseDouble( resultSet.getString(2)));
		    	      }
		    	      JFreeChart chart = ChartFactory.createPieChart(
		    	    		  
		    	         "Number of hits",  // chart title           
		    	         dataset,         // data           
		    	         true,            // include legend          
		    	         true,           
		    	         false);
		    	      PiePlot plot = (PiePlot) chart.getPlot();
		    	      PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
		  	                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		  	            plot.setLabelGenerator(gen);

		    	      int width = 800;  
		    	      int height = 700; 
		    	      response.setContentType("image/png"); 
		  		    ChartUtilities.writeChartAsJPEG(out, chart,width,height);
		  		   
	   }catch(Exception e){
		  
	   }
        finally {
    out.close();
 }
	}
		
		
		/* OutputStream out = response.getOutputStream(); 
		 try{
		 Connection conn=DBConnection.getDBConnection();
		  DefaultCategoryDataset bar = new DefaultCategoryDataset();
		  PreparedStatement ps=conn.prepareStatement("Select url, sum(hits) as Count from clicks GROUP BY url");
		   ResultSet r = ps.executeQuery();
		   while (r.next()) 
		   {
		   String category = r.getString("url");
		   int hits = r.getInt("Count");
		   bar.addValue(hits,"No. of Hits",category);
		    }
           JFreeChart BarChartObject=ChartFactory.createBarChart("No.Of Hits","Urls","No. Of Hits",bar,PlotOrientation.VERTICAL,true,true,false);

		    response.setContentType("image/png"); 
		    ChartUtilities.writeChartAsPNG(out, BarChartObject, 2500, 900);
		   
				
			 }catch (Exception e) {
		           System.out.println(e);
		            }
		         finally {
		     out.close();
		  }*/
		
	

}


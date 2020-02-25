

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import codes.DBConnection;

/**
 * Servlet implementation class Number_of_hits
 */
@WebServlet("/Number_of_hits")
public class Number_of_hits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Number_of_hits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* OutputStream out = response.getOutputStream(); 
		 try{
			Connection connect=DBConnection.getDBConnection();
		    	     
		    	      Statement statement = connect.createStatement( );
		    	    
		    	      ResultSet resultSet = statement.executeQuery("SELECT  date, count( date) FROM counts GROUP BY date");
		    	      DefaultPieDataset dataset = new DefaultPieDataset();
		    	      while(resultSet.next()) 
		    	      {
		    	         dataset.setValue( 
		    	         resultSet.getString("date"),
		    	         Double.parseDouble( resultSet.getString(2)));
		    	      }
		    	      JFreeChart chart = ChartFactory.createPieChart(
		    	         "Location",  // chart title           
		    	         dataset,         // data           
		    	         true,            // include legend          
		    	         true,           
		    	         false);

		    	      int width = 660;  Width of the image 
		    	      int height = 470;  Height of the image  
		    	      response.setContentType("image/png"); 
		  		    ChartUtilities.writeChartAsJPEG(out, chart,width,height);
		  		   
	   }catch(Exception e){
		  
	   }
         finally {
     out.close();
  }
		
	}
}*/
		
		
		
		 OutputStream out = response.getOutputStream(); 
		 try{
		 Connection conn=DBConnection.getDBConnection();
		  DefaultCategoryDataset bar = new DefaultCategoryDataset();
		  PreparedStatement ps=conn.prepareStatement("SELECT  date, sum( counts)as ab FROM counts GROUP BY date");
		   ResultSet r = ps.executeQuery();
		   while (r.next()) 
		   {
		   String category = r.getString("date");
		   int hits = r.getInt("ab");
		   bar.addValue(hits,"Visit on webside",category);
		    }
           JFreeChart BarChartObject=ChartFactory.createBarChart("Visit on webside","date","Visit on webside",bar,PlotOrientation.VERTICAL,true,true,false);

		    response.setContentType("image/png"); 
		    ChartUtilities.writeChartAsPNG(out, BarChartObject,1600, 550);
		   
				
			 }catch (Exception e) {
		           System.out.println(e);
		            }
		         finally {
		     out.close();
		  }
		
	}

}

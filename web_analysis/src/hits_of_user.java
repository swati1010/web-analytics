

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

import codes.DBConnection;

/**
 * Servlet implementation class hits_of_user
 */
@WebServlet("/hits_of_user")
public class hits_of_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hits_of_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			   if(hits>=13){		  
		   bar.addValue(hits,"No. of Hits",category);
		    }
		   }
          JFreeChart BarChartObject=ChartFactory.createBarChart("No.Of Hits","date","No. Of Hits",bar,PlotOrientation.VERTICAL,true,true,false);

		    response.setContentType("image/png"); 
		    ChartUtilities.writeChartAsPNG(out, BarChartObject, 1200, 550);
		   
				
			 }catch (Exception e) {
		           System.out.println(e);
		            }
		         finally {
		     out.close();
		  }
		
	}
}
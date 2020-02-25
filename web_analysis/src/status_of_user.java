

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
 * Servlet implementation class status_of_user
 */
@WebServlet("/status_of_user")
public class status_of_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public status_of_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 OutputStream out = response.getOutputStream(); 
		 try{
		 Connection conn=DBConnection.getDBConnection();
		  DefaultCategoryDataset bar = new DefaultCategoryDataset();
		  PreparedStatement ps=conn.prepareStatement("SELECT start_time, count(start_time)as ab FROM user where status=1");
		   ResultSet r = ps.executeQuery();
		   while (r.next()) 
		   {
		   String category = r.getString("start_time");
		   int hits = r.getInt("ab");
		   bar.addValue(hits,"status of users",category);
		    }
           JFreeChart BarChartObject=ChartFactory.createBarChart("status of users","date","nunber of users",bar,PlotOrientation.VERTICAL,true,true,false);

		    response.setContentType("image/png"); 
		    ChartUtilities.writeChartAsPNG(out, BarChartObject, 700, 550);
		   
				
			 }catch (Exception e) {
		           System.out.println(e);
		            }
		         finally {
		     out.close();
		  }
		
	}

}

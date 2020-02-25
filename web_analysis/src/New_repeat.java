

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
 * Servlet implementation class New_repeat
 */
@WebServlet("/New_repeat")
public class New_repeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_repeat() {
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
		  PreparedStatement ps=conn.prepareStatement("select user_identity, count(user_identity) as user from user group by user_identity");
		   ResultSet r = ps.executeQuery();
		   while (r.next()) 
		   {
		   String category = r.getString("user_identity");
		   int hits = r.getInt("user");
		   bar.addValue(hits,"status of users",category);
		    }
           JFreeChart BarChartObject=ChartFactory.createBarChart("status of users","","nunber of users",bar,PlotOrientation.VERTICAL,true,true,false);

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

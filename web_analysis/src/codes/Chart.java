package codes;
import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
public class Chart {
	Connection connect=DBConnection.getDBConnection();
	public  void hits(){
		try{
	
  	   Statement statement=connect.createStatement();
		 ResultSet resultSet = statement.executeQuery("Select url, sum(hits) as Count from clicks GROUP BY url");
	     DefaultPieDataset dataset = new DefaultPieDataset();
	     while(resultSet.next()) 
	     {
	        dataset.setValue( 
	        resultSet.getString("url"),
	        Double.parseDouble( resultSet.getString("Count")));
	     }
	     JFreeChart chart = ChartFactory.createPieChart
	   		  ("Hits ", dataset, true, true, false);
	    PiePlot plot = (PiePlot) chart.getPlot();
		   	     PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
		 	               "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		 	           plot.setLabelGenerator(gen);
		  
		 	          final ChartRenderingInfo info = new 
		 	        		  ChartRenderingInfo(new StandardEntityCollection());

		 	        		  final File file1 = new File("E:\\swati_pro\\web_analysis\\WebContent\\Chart\\hits.png");
		 	        		  ChartUtilities.saveChartAsPNG(
		 	        		   file1, chart,600,600, info);

	}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}
	public void location(){
		try{
			Statement statement=connect.createStatement();
			 ResultSet resultSet = statement.executeQuery("SELECT location, count(location) FROM user GROUP BY location");
		     DefaultPieDataset dataset = new DefaultPieDataset();
		     while(resultSet.next()) 
		     {
		        dataset.setValue( 
		        resultSet.getString("location"),
		        Double.parseDouble( resultSet.getString(2)));
		     }
		     JFreeChart chart = ChartFactory.createPieChart
		   		  ("location ", dataset, true, true, false);
		    PiePlot plot = (PiePlot) chart.getPlot();
			   	     PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
			 	               "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
			 	           plot.setLabelGenerator(gen);
			  
			 	          final ChartRenderingInfo info = new 
			 	        		  ChartRenderingInfo(new StandardEntityCollection());

			 	        		  final File file1 = new File("E:\\swati_pro\\web_analysis\\WebContent\\Chart\\location.png");
			 	        		  ChartUtilities.saveChartAsPNG(
			 	        		   file1, chart,400, 300, info);


		     

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void newRepeat(){
		try{
			DefaultCategoryDataset bar = new DefaultCategoryDataset();
			  PreparedStatement ps=connect.prepareStatement("select user_identity, count(user_identity) as user from user group by user_identity");
			   ResultSet r = ps.executeQuery();
			   while (r.next()) 
			   {
			   String category = r.getString("user_identity");
			   int hits = r.getInt("user");
			   bar.addValue(hits,"status of users",category);
			    }
		      JFreeChart BarChartObject=ChartFactory.createBarChart("status of users","","nunber of users",bar,PlotOrientation.VERTICAL,true,true,false);
		      final ChartRenderingInfo info2 = new 
		    		  ChartRenderingInfo(new StandardEntityCollection());

		    		  final File file2 = new File("E:\\swati_pro\\web_analysis\\WebContent\\Chart\\New_repeat.png");
		    		  ChartUtilities.saveChartAsPNG(
		    		   file2, BarChartObject,400, 350, info2);

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void statusOfUser(){
		try{
			DefaultCategoryDataset bar = new DefaultCategoryDataset();
			  PreparedStatement ps=connect.prepareStatement("SELECT start_time, count(start_time)as ab FROM user where status=1");
			   ResultSet r = ps.executeQuery();
			   while (r.next()) 
			   {
			   String category = r.getString("start_time");
			   int hits = r.getInt("ab");
			   bar.addValue(hits,"status of users",category);
			    }
		      JFreeChart BarChartObject=ChartFactory.createBarChart("status of users","","nunber of users",bar,PlotOrientation.VERTICAL,true,true,false);
		      final ChartRenderingInfo info2 = new 
		    		  ChartRenderingInfo(new StandardEntityCollection());

		    		  final File file2 = new File("E:\\swati_pro\\web_analysis\\WebContent\\Chart\\active_user.png");
		    		  ChartUtilities.saveChartAsPNG(
		    		   file2, BarChartObject, 600, 400, info2);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void visitOnWebsite(){
		try{
			DefaultCategoryDataset bar = new DefaultCategoryDataset();
			  PreparedStatement ps=connect.prepareStatement("SELECT  date, sum( counts)as ab FROM counts GROUP BY date");
			   ResultSet r = ps.executeQuery();
			   while (r.next()) 
			   {
			   String category = r.getString("date");
			   int hits = r.getInt("ab");
			   bar.addValue(hits,"Visit on website",category);
			    }
		      JFreeChart BarChartObject=ChartFactory.createBarChart("Visit on website","","Date",bar,PlotOrientation.VERTICAL,true,true,false);
		      final ChartRenderingInfo info2 = new 
		    		  ChartRenderingInfo(new StandardEntityCollection());

		    		  final File file2 = new File("E:\\swati_pro\\web_analysis\\WebContent\\Chart\\visit_On_Website.png");
		    		  ChartUtilities.saveChartAsPNG(
		    		   file2, BarChartObject,900,600, info2);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		Chart obj=new Chart();
		obj.hits();
		
			}
	
}

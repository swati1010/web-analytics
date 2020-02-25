

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.CsvParameters;

/**
 * Servlet implementation class CsvPreprocess
 */
@WebServlet("/CsvPreprocess")
public class CsvPreprocess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsvPreprocess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			List list = new ArrayList();
			String fileName = "E:\\swati_pro\\web_analysis\\reviews1.csv";
			Path pathToFile = Paths.get(fileName);
			BufferedReader br = Files.newBufferedReader(pathToFile,
	                StandardCharsets.UTF_8); 

	            // read the first line from the text file
	            String line = br.readLine();

	            // loop until all lines are read
	            while (line != null) {

	                // use string.split to load a string array with the values from
	                // each line of
	                // the file, using a comma as the delimiter
	                String[] attributes = line.split(",");
	                boolean b = false;
	                
	                
	                
	                if(attributes.length == 3)
                	{
	                	Pattern pt = Pattern.compile("[^a-zA-Z0-9 ]");
		                Matcher match= pt.matcher(attributes[1]);
		                while(match.find())
		                {
		                    String s= match.group();
		                    attributes[1]=attributes[1].replaceAll("\\"+s, "");
		                }
                	}
	                else
	                {
	                	Pattern pt = Pattern.compile("[^a-zA-Z0-9 ]");
		                Matcher match= pt.matcher(attributes[0]);
		                while(match.find())
		                {
		                    String s= match.group();
		                    attributes[0]=attributes[0].replaceAll("\\"+s, "");
		                }
	                }
	               
	                	if(attributes.length == 3)
	                	{
	                		list.add(attributes[0]+","+attributes[1]+","+attributes[2]);
	                	}
	                	else
	                	{
		                	list.add(" ,"+attributes[0]+","+attributes[0]);
	                	}
	                
	                // adding book into ArrayList
	                // read next line before looping
	                // if end of file reached, line would be null
	                line = br.readLine();
	            }
	          //Delimiter used in CSV file
	           
	            	     final String COMMA_DELIMITER = ",";
	            	     final String NEW_LINE_SEPARATOR = "\n";
	            	     final String FILE_HEADER = "Ratings,Reviews,Class";
	            
	            FileWriter fileWriter = null;
	            String fileName1 = "E:\\swati_pro\\web_analysis\\previews.csv";
	            fileWriter = new FileWriter(fileName1);
	           // fileWriter.append(FILE_HEADER.toString());
	            

	            for(int i = 0; i < list.size(); i++)
	            {
	            	fileWriter.append(list.get(i).toString());
	            	fileWriter.append(NEW_LINE_SEPARATOR);
	            }
	            
	            fileWriter.close();
	            response.sendRedirect("loadCsv2.jsp");
	            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

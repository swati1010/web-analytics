

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import codes.ReadCsv;


/**
 * Servlet implementation class LoadCsvFile
 */
@WebServlet("/LoadCsvFile")
public class LoadCsvFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String filename = "";   
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCsvFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			new ReadCsv();
			PrintWriter out = response.getWriter();  
			out.println("Uploaded Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("adminindex.jsp");  
			rd.forward(request, response);
			//CSVLoader loader = new CSVLoader(DBConnection.getDBConnection());
			
			//loader.loadCSV("D:/JSPWS/Analysis/storage.csv", "product", false);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}

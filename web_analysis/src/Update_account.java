

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.DBConnection;
import codes.UserCredentials;

/**
 * Servlet implementation class Update_account
 */
@WebServlet("/Update_account")
public class Update_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
int uid=UserCredentials.getUserid();
		
		String bnk_name=request.getParameter("bnk_name");
		String name=request.getParameter("name");
		String ac=request.getParameter("ac");
		String ifsc=request.getParameter("ifsc");
		
		Connection con=DBConnection.getDBConnection();
		try{
			PreparedStatement ps=con.prepareStatement("update bank_detail set bank_name=?,name=?,account_name=?,ifsc=? where uid='"+uid+"'");
			
			ps.setString(1,bnk_name);
			ps.setString(2,name);
			ps.setString(3,ac);
			ps.setString(4,ifsc);
			int i=ps.executeUpdate();
			if(i!=0){
				out.println("<script type=\"text/javascript\">alert('update successfully completed')</script>");		
				request.getRequestDispatcher("your_account.jsp").include(request,response);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}



		
	}



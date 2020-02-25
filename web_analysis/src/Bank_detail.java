

import java.io.IOException;
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
 * Servlet implementation class Bank_detail
 */
@WebServlet("/Bank_detail")
public class Bank_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int uid=UserCredentials.getUserid();
		int id=Integer.parseInt(request.getParameter("id"));
		String bnk_name=request.getParameter("bnk_name");
		String name=request.getParameter("name");
		String ac=request.getParameter("ac");
		String ifsc=request.getParameter("ifsc");
		
		Connection con=DBConnection.getDBConnection();
		try{
			PreparedStatement ps=con.prepareStatement("insert into bank_detail(uid,bank_name,name,account_name,ifsc)values(?,?,?,?,?)");
			ps.setInt(1,uid);
			ps.setString(2,bnk_name);
			ps.setString(3,name);
			ps.setString(4,ac);
			ps.setString(5,ifsc);
			int i=ps.executeUpdate();
			System.out.println(id);
			if(i!=0){
				 request.getRequestDispatcher("Cancel_product?id="+id).forward(request,response);
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}

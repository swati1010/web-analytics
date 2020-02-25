

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codes.DBConnection;
import codes.GetSetIds;
import codes.UserCredentials;

/**
 * Servlet implementation class UpdateReview
 */
@WebServlet("/UpdateReview")
public class UpdateReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReview() {
        super();
        // TODO Auto-generated constructor stub
        

    }
    static int hitsCount=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p_type=Integer.parseInt(request.getParameter("p_type"));
		System.out.println(p_type);
		PrintWriter out=response.getWriter();
		Connection con = DBConnection.getDBConnection();

		
		
		
		String url = request.getRequestURL().toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date=new java.util.Date();  
		String d=dateFormat.format(date);


		try{
			


		if (hitsCount == 0) 
		{
			hitsCount++;
		PreparedStatement ps=con.prepareStatement("insert into  clicks(url,hits,date) values(?,?,?)");
				    ps.setString(1,url);
				    ps.setInt(2,hitsCount);
				   
				    ps.setString(3,d);	
				    int i=ps.executeUpdate();

		}
		else
		{

		hitsCount++;

		PreparedStatement ps3=con.prepareStatement("update clicks set hits='"+hitsCount+"' where date='"+d+"' and url='"+url+"'");
			  
			  
			  int j=ps3.executeUpdate();


		}
		}
		catch(Exception e){
			System.out.print(e);
		}

		
		
		try {
			HttpSession session=request.getSession();
			
			String pid1=(String)session.getAttribute("pid");
				session.setAttribute("pid",pid1);
				String qty=(String)session.getAttribute("qty");
				session.setAttribute("qty",qty);
				String shi=(String)session.getAttribute("shi");
				session.setAttribute("shi",shi);
				String blk=(String)session.getAttribute("blk");
				session.setAttribute("blk",blk);
			int uid=UserCredentials.getUserid();
			String pid = request.getParameter("hide");
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String rv = request.getParameter("review");
			String rating=request.getParameter("rating");
			
			int rid = GetSetIds.getReviewid();
			PreparedStatement ps = con.prepareStatement("update reviews set Review='"+rv+"', Rating='"+rating+"', productId='"+pid+"', name='"+name+"', email='"+email+"'where uid='"+uid+"'");
			int res = ps.executeUpdate();
			if(res>0)
			{
				System.out.println("success");
				RequestDispatcher rd=request.getRequestDispatcher("addtocart.jsp?p_type="+p_type);  
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}


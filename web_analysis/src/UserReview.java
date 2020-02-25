

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class UserReview
 */
@WebServlet("/UserReview")
public class UserReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReview() {
        super();
        // TODO Auto-generated constructor stub
    }
    static int hitsCount=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
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
			
			int uid=UserCredentials.getUserid();
			String pid = request.getParameter("hide");
			String brand = request.getParameter("brand");
			
			String name = request.getParameter("name");
			System.out.println(name);
			String email = request.getParameter("email");
			String rv = request.getParameter("review");
			String rating=request.getParameter("rating");
			
			int rid = GetSetIds.getReviewid();
			
			PreparedStatement ps1=con.prepareStatement("select * from reviews where uid='"+uid+"' and productId='"+pid+"'");
			ResultSet rs=ps1.executeQuery();
			if(rs.next()){
				
				PreparedStatement ps = con.prepareStatement("update reviews set Review='"+rv+"', Rating='"+rating+"', name='"+name+"', email='"+email+"' where  uid='"+uid+"' and productId='"+pid+"'");
				int i=ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("detail.jsp?prodId="+pid+"&brand="+brand);  
				rd.forward(request, response);
			}
			
			else{
			PreparedStatement ps = con.prepareStatement("insert into reviews(ID,uid,Review, Rating, productId, name, email) values(" + rid + ",'"+uid+"', '" + rv + "', '" + rating + "', '" + pid + "', '" + name + "', '" + email + "')");
			int res = ps.executeUpdate();
			if(res>0)
			{
				System.out.println("success");
/*				"reviews.jsp?prodId=<%=rs.getString("productId")%>&userid=<%=userid %>&cname=<%=uname %>&email=<%=email %>&qty=1&shipping=0&backlink=shop.jsp"
*/				RequestDispatcher rd=request.getRequestDispatcher("detail.jsp?prodId="+pid+"&brand="+brand);  
				rd.forward(request, response);
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}

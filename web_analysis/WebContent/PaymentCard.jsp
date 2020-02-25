
<%@page import="codes.DBConnection"%>
<%@page import="codes.UserCredentials"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>    

  
 <%@page import ="java.io.File" %>   
   <%@page import ="java.io.FileOutputStream" %>
    <%@page import= "java.io.OutputStream" %>
     <%@page import ="com.itextpdf.text.BaseColor" %>
      <%@page import ="com.itextpdf.text.pdf.PdfWriter" %>
       <%@page import= "com.itextpdf.text.Document" %>
        <%@page import= "com.itextpdf.text.Image"      %>
         <%@page import ="com.itextpdf.text.List"     %>
          <%@page import= "com.itextpdf.text.ListItem"   %>
          
<%@page import= "com.itextpdf.text.Paragraph" %>
<%@page import= "com.itextpdf.text.pdf.PdfPCell" %>

<%@page import= "com.itextpdf.text.pdf.PdfPTable" %>
<%@page import= "com.itextpdf.text.pdf.PdfWriter" %>
<%@page import= "com.itextpdf.text.Chunk" %>
<%@page import= "java.util.Date" %>
<%@page import= "com.itextpdf.text.Element" %>


   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%


String uname=UserCredentials.getUsername();
String email=UserCredentials.getEmailId();
int uid=UserCredentials.getUserid();
Connection con=DBConnection.getDBConnection();
String total="0";
String uname1="",add="";
 try{
	  
	 
	PreparedStatement ps=con.prepareStatement("SELECT sum(total) as total_sum FROM cart WHERE userid ='"+uid+"' GROUP BY userid");
	
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		total=rs.getString("total_sum")+"";
		
	}
	PreparedStatement ps2=con.prepareStatement("select name,address from user_detail where userid='"+uid+"'");
	ResultSet rs2=ps2.executeQuery();
if(rs.next()){
	
	uname1=rs2.getString("name");
	add=rs2.getString("address");
}
	
	
} 
catch(Exception e){
	out.print(e);
}

	String name="bandhu";
	OutputStream file = new FileOutputStream(new File("D:\\Generate_Invoice_Bill\\"+uid+".pdf"));
	Document document = new Document();
	PdfWriter.getInstance(document, file);

	//Inserting Image in PDF
	    Image image = Image.getInstance ("C:\\Users\\Swati\\Desktop\\project stuff\\nameofwebsite.jpg");
	    image.scaleAbsolute(120f, 60f);//image width,height	

	//Inserting Table in PDF
	     document.open();
			        document.add(new Paragraph("With 3 columns:"));
			        PdfPTable table = new PdfPTable(3);
			        table.setSpacingBefore(5);
			        table.setWidths(new int[]{1, 1, 8});
			       
			        document.add(new Paragraph("With 2 columns:"));
			        table = new PdfPTable(6);
			       
			        table.setWidthPercentage(100);
			      
			        table.addCell("Product-Title");
			 	      table.addCell("MRP");
			 	      table.addCell("QTY");
			 	     table.addCell("DIS");
			 	    table.addCell("TAX");
			 	    table.addCell("Total");
			 	   String name1="",price="",qty1="",dis="",price1="";
			 		int mrp=0,qty=0,gd=0,mrp1=0;
	
    PreparedStatement ps = con.prepareStatement("SELECT cart.qty,cart.subtotal,product.price, cart.total, cart.shippingcharges, cart.productid, product.title,product.discount FROM cart,product WHERE cart.productid = product.productId and cart.userid = " +uid+ "");

	System.out.print("hallo");

    ResultSet rs = ps.executeQuery();
    while(rs.next())
    {                                
	name1=rs.getString("title");
	System.out.print("hallo"+name1);
	qty=rs.getInt("qty");
	qty1=Integer.toString(qty);
	mrp=rs.getInt("price");
	price=Integer.toString(mrp);
	mrp1=rs.getInt("total");
	price1=Integer.toString(mrp1);
	dis=rs.getString("discount");
	
	
	 table.addCell(name1);
	 table.addCell(price);
      table.addCell(qty1);
     table.addCell(dis);
    table.addCell("-");
    table.addCell(price1);
    
    String sql = "insert into invoice(unique_id,cid,p_name,date,total_amt,grand_total,name,email,qty,status) values (UUID(),?,'"+name1+"',now(),'"+price+"','"+price1+"',?,?,'"+qty+"',1)";
	  
	 PreparedStatement ps1=con.prepareStatement(sql);
	 ps1.setInt(1,uid);
	
	 
	 ps1.setString(2,uname);
	 ps1.setString(3,email);
	    
		int i=ps1.executeUpdate();
		if(i!=0){
			 PreparedStatement psd=con.prepareStatement("delete from cart where userid='"+uid+"'");
			 int qw=psd.executeUpdate();
		
    }
    }
    

    
    
   /*  PreparedStatement ps1=con.prepareStatement("insert into invoice (unique_id,cid,p_id,date,total_amt,grand_total,name,eamil)values(UUID(),'"+uid+"','"+p_id+"',now()");
    
	int i=ps1.executeUpdate();
	if(i!=0){
		out.print("Success");
	}  */
    

		 	    
		 	  
		 	      
		        table.getDefaultCell().setColspan(5);
		        table.addCell("Grand-Total");
		        table.addCell(total);
		       
		        document.add(table);
		        
		 	      
		 	      
		 	      
		 //Inserting List in PDF
		 	      List list=new List(true,30);
		          /* list.add(new ListItem("Java4s"));
		 	      list.add(new ListItem("Php4s"));
		 	      list.add(new ListItem("Some Thing..."));	 */	

		 //Text formating in PDF
		       Chunk chunk=new Chunk("Thank you for shopping with us");
		 		chunk.setUnderline(+1f,-2f);//1st co-ordinate is for line width,2nd is space between
		 		/* Chunk chunk1=new Chunk("Php4s.com"); */
		 		/* chunk1.setUnderline(+4f,-8f);
		 		chunk1.setBackground(new BaseColor (17, 46, 193));       */

		 //Now Insert Every Thing Into PDF Document
		     document.open();//PDF document opened........			       

		 		document.add(image);

		 		document.add(Chunk.NEWLINE);   //Something like in HTML :-)
			document.add(new Paragraph("Name:"+uname));
		       document.add(new Paragraph("Address:"+add));
		       document.add(new Paragraph("Stay MAlad(East)"));
		       document.add(new Paragraph("Date:"+new Date().toString()));	

		 		document.add(table);

		 		document.add(chunk);
		 		/* document.add(chunk1); */

		 		document.add(Chunk.NEWLINE);   //Something like in HTML :-)							    

		 			document.newPage();            //Opened new page
		 		document.add(list);            //In the new page we are going to add list

		     document.close();

		             file.close();

		 System.out.println("Pdf created successfully.."); 
		 
		response.sendRedirect("Send_Invoice");
%>





</body>
</html>
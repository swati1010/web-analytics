

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

import codes.DBConnection;
import codes.EmailUtility;
import codes.UserCredentials;

/**
 * Servlet implementation class Send_Invoice
 */
@WebServlet("/Send_Invoice")
public class Send_Invoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
	 public static void sendEmailWithAttachments(String host, String port,
	            final String userName, final String password, String toAddress,
	            String subject, String message, String[] attachFiles)
	            throws AddressException, MessagingException {
	        // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.user", userName);
	        properties.put("mail.password", password);
	 
	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        Session session = Session.getInstance(properties, auth);
	 
	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);
	 
	        msg.setFrom(new InternetAddress(userName));
	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	 
	        // creates message part
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent(message, "text/html");
	 
	        // creates multi-part
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	 
	        // adds attachments
	        if (attachFiles != null && attachFiles.length > 0) {
	            for (String filePath : attachFiles) {
	                MimeBodyPart attachPart = new MimeBodyPart();
	 
	                try {
	                    attachPart.attachFile(filePath);
	                } catch (IOException ex) {
	                    System.out.println(ex);
	                }
	 
	                multipart.addBodyPart(attachPart);
	            }
	        }
	 
	        // sets the multi-part as e-mail's content
	        msg.setContent(multipart);
	 
	        // sends the e-mail
	        Transport.send(msg);
	 
	    }
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Send_Invoice() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    	 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "analysis.customer@gmail.com";
        String password = "analysis123";
        
        
        // message info
        
        String subject = "Your Invoice bill ";
        String message = "Invoice bill ";
		
        
		
		try{
			
		
			int uid=UserCredentials.getUserid();
			String[] attachFiles = new String[1];
	        attachFiles[0] = "D:\\Generate_Invoice_Bill\\"+uid+".pdf";
			PreparedStatement pse = con.prepareStatement("SELECT email from user_detail where userid ='"+uid+"'");
			ResultSet rse = pse.executeQuery();
			
			 String mailTo="";
			if(rse.next())
			{
				mailTo = rse.getString("Email");
			}
			sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
	                subject, message, attachFiles);
	            System.out.println("Email sent.");
	            out.println("<script type=\"text/javascript\">alert('Thank you for shopping')</script>");	
	            request.getRequestDispatcher("index.jsp").include(request,response);
		}
		
		catch (Exception e) {
			System.out.println(e);
		}

		
		 
	 
	        // attachments
	        
	       
	 
	       
	    }
	}
		
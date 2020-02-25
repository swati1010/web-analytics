

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codes.DBConnection;
import codes.GetSetText;
import codes.TextClassifier;
import weka.core.Attribute;
import weka.core.FastVector;

/**
 * Servlet implementation class ApplyNB
 */
@WebServlet("/ApplyNB")
public class ApplyNB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBConnection.getDBConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyNB() {
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
			//new NaiveBayes();
			PreparedStatement ps = con.prepareStatement("SELECT reviews.Review, reviews.Rating, reviews.prior, product.title FROM reviews, product WHERE reviews.productId = product.productId");
     		ResultSet rs = ps.executeQuery();
     		rs.last();
     		String[] testText = new String[rs.getRow()];
     		rs.beforeFirst();
     		int index = 0;
     		while(rs.next())
     		{
     			testText[index++] = rs.getString("Review");
     			
     		}
          TextClassifier.thisClassString = "weka.classifiers.bayes.NaiveBayes";
          //String thisClassString = "weka.classifiers.lazy.IBk";

         /* if (args.length > 0) {
             thisClassString = args[0];
         } */ 

          
          
          String fileName = "E:\\swati_pro\\web_analysis\\previews.csv";
			Path pathToFile = Paths.get(fileName);
			BufferedReader br = Files.newBufferedReader(pathToFile,
	                StandardCharsets.UTF_8); 
			String[] inputText = new String[162];
			String[] inputClasses = new String[162];
	            // read the first line from the text file
	            String line = br.readLine();
	            line = br.readLine();
	            // loop until all lines are read
	            int ii = 0;
	            while (line != null) {
	                // use string.split to load a string array with the values from
	                // each line of
	                // the file, using a comma as the delimiter
	                String[] attributes = line.split(",");
	                
	                inputText[ii] = attributes[1];
	                inputClasses[ii] = attributes[2];
	                line = br.readLine();
	                ii++;
	            }
          
          
         /* inputText =  {"Good product..", "Product is very good", "product is not good", "Bad product", "worst experience",
         		"nice quality of hardware", "poor performance", "Product is good, but sound quality is poor", "I am satisfied with this product",
         		"I am not satisfied with this product", "Product is satisfacotry", " awesome product", "product is not satisfactory",
					"better than my previous product", "Best product ever", "Good enough", "product hs some issues", "Not working",
					"Disappointed with this product", "Simply good", "I am so greatful for thius product", "I like it, Really!!!",
					"I love it!!!", "Low quality product", "Not happy with this product", "I hate this product", "Excellent product, and great sound",
					"The best I have found so far", "Brilliant Product", "Very bad quality", "Having software issues", "Having hardware issues", 
					"I love this product but speed is low"};*/

         
         /*String[] inputClasses = {"good", "good", "bad", "bad", "bad", "good", "bad", "bad", "good", "bad", "good", "good", "bad", "good",
         		"good", "good", "bad", "bad", "bad", "good", "good", "good", "good", "bad", "bad", "bad", "good", "good", "good", "bad",
         		"bad", "bad", "bad"};*/
         
         if (inputText.length != inputClasses.length) {
             System.err.println("The length of text and classes must be the same!");
             System.exit(1);
         }

         // calculate the classValues
         HashSet classSet = new HashSet(Arrays.asList(inputClasses));
        classSet.add("neutral");
         String[] classValues = (String[])classSet.toArray(new String[0]);

         //
         // create class attribute
         //
         FastVector classAttributeVector = new FastVector();
         for (int i = 0; i < classValues.length; i++) {
             classAttributeVector.addElement(classValues[i]);
         }
         Attribute thisClassAttribute = new Attribute("class", classAttributeVector);

         //
         // create text attribute
         //
         FastVector inputTextVector = null;  // null -> String type
         Attribute thisTextAttribute = new Attribute("text", inputTextVector);
         for (int i = 0; i < inputText.length; i++) {
             thisTextAttribute.addStringValue(inputText[i]);
         }
         
         // add test cases (to be inserted into instances)
         // just a singular test string
         /*
         String newTextString = newTestTextField.getText();
         String[] newTextArray = new String[1];
         newTextArray[0] = newTextString;
         if (!"".equals(newTextString)) {
             thisTextAttribute.addStringValue(newTextString);
         }
         */

         // add the text of test cases
         for (int i = 0; i < testText.length; i++) {
             thisTextAttribute.addStringValue(testText[i]);
         }

         //
         // create the attribute information
         //
         FastVector thisAttributeInfo = new FastVector(2);
         thisAttributeInfo.addElement(thisTextAttribute);
         thisAttributeInfo.addElement(thisClassAttribute);


         TextClassifier classifier = new TextClassifier(inputText, inputClasses, thisAttributeInfo, thisTextAttribute, thisClassAttribute, TextClassifier.thisClassString);

         
         
         GetSetText.nbdiplaytxt.append("\nDATA SET:\n"+classifier.classify(TextClassifier.thisClassString)+"\n");
         GetSetText.nbdiplaytxt.append("\nNEW CASES:\n"+classifier.classifyNewCases(testText)+"\n");
         
         /*System.out.println("DATA SET:\n");
         System.out.println(classifier.classify(TextClassifier.thisClassString));

         System.out.println("NEW CASES:\n");
         System.out.println(classifier.classifyNewCases(testText));*/
         
         String tcr = TextClassifier.caseresults;
         
         tcr = tcr.substring(0, tcr.length()-1);
        // System.out.println(""+tcr);
         String results[] = tcr.split(",");
         TextClassifier.caseresults = "";
         
         int r = 1, i = 0;
       	PreparedStatement psr = con.prepareStatement("SELECT reviews.ID, reviews.Review, reviews.Rating, reviews.prior, product.title, reviews.productId FROM reviews, product WHERE reviews.productId = product.productId");
       	ResultSet rsr = psr.executeQuery();
       	while(rsr.next())
       	{	
       		PreparedStatement ps1 = con.prepareStatement("UPDATE reviews SET nbprior='" + results[i] + "' WHERE productId = '" + rsr.getString("productId") + "' and ID = "+rsr.getInt("ID"));
            ps1.executeUpdate();
            i++;
         
       	}
       	//request.setAttribute("displaytxt", displaytxt);
		RequestDispatcher rd = request.getRequestDispatcher("/displaytext.jsp");
        rd.forward(request, response);
			//response.sendRedirect("loadCsv2.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

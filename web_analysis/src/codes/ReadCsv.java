package codes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReadCsv {

	public ReadCsv() {
		// TODO Auto-generated constructor stub
		Connection con = DBConnection.getDBConnection();
		String sql = " INSERT INTO product(productId, title, description, imageUrlStr, mrp, price, productUrl, categories, productBrand, inStock, codAvailable, discount, color) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ";


		try { 
		        BufferedReader bReader = new BufferedReader(new FileReader("D:\\JSPWS\\Analysis\\storage.csv"));
		        String line = ""; 
		        try {
					while ((line = bReader.readLine()) != null) {
					    try {

					        if (line != null) 
					        {
					            String[] array = line.split(",");
					           /* for(String result:array)
					            {
					                System.out.println(result);
					            }*/
 //Create preparedStatement here and set them and excute them
					        PreparedStatement ps = con.prepareStatement(sql);
					         ps.setString(1,array[0]);
					         ps.setString(2,array[1]);
					         ps.setString(3,array[2]);
					         ps.setString(4,array[3]);
					         ps.setString(5,array[4]);
					         ps.setString(6,array[5]);
					         ps.setString(7,array[6]);
					         ps.setString(8,array[7]);
					         ps.setString(9,array[8]);
					         ps.setString(10,array[9]);
					         ps.setString(11,array[10]);
					         ps.setString(12,array[11]);
					         ps.setString(13,array[12]);
					         ps.executeUpdate();
					         ps. close();
   //Assuming that your line from file after split will folllow that sequence

					            }
					        //} 
					    } catch (Exception ex) {
					        ex.printStackTrace();
					    }
					    finally
					    {
					       if (bReader == null) 
					        {
					            try {
									bReader.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					        }
					    }
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } catch (FileNotFoundException ex) {
		        ex.printStackTrace();
		    }
	}

}

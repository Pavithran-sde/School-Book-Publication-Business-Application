import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class reduce_stock {

	reduce_stock(Integer STOCK1,Integer BOOK_QTY,String book_id )
	{
		
		try {
		 STOCK1-=BOOK_QTY;
    	 System.out.println("THE REMAINING STOCK = "+ STOCK1);
    	  //reduce stock
		    Class.forName("com.mysql.jdbc.Driver");
			Connection con3=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
	    
	      // create the java mysql update preparedstatement
	      String query3 = "update book_details set quantity= ? where book_id = ?";
	      PreparedStatement preparedStmt3 = con3.prepareStatement(query3);
	     
	     //edit 

	  
	       preparedStmt3.setInt(1,STOCK1);
	       preparedStmt3.setString (2, book_id);
	     
		 				     
	      // execute the java prepared statement
	      preparedStmt3.executeUpdate();
	     
	      con3.close();

}catch(Exception ex)
{System.out.println(" ");
System.err.println("exception IN UPDATING THE REMAINING STOCK:");
System.err.println(ex.getMessage());
}
	}
	
	
}

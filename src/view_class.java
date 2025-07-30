import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class view_class {
	
	
	
	
	public static void  main(String[] args) throws SQLException
	{}
	
	public boolean add_school(String s_id)
	{
		boolean conti = true;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM school_details where s_id='"+s_id+"'";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      if (rs.next())
		      {
		    	  conti = false;
		      }
			      st.close();
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
		
		return conti;
	}
	
	public boolean add_employee(String e_id)
	{
		boolean conti = true;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM emp_details_dbms where e_id='"+e_id+"'";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      if (rs.next())
		      {
		    	  conti = false;
		      }
			      st.close();
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
		
		return conti;
	}
	public boolean add_order(String o_id)
	{
		boolean conti = true;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "select o_id from order_detail where order_id='"+o_id+"'";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      if (rs.next())
		      {
		    	  conti = false;
		      }
			      st.close();
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
		
		return conti;
	}
	public boolean add_warehouse(String w_id)
	{
		boolean conti = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM ware_house where w_id='"+w_id+"'";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      if (rs.next())
		      {
		    	  conti = true;
		      }
			      st.close();
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
		
		return conti;
	}
	public boolean add_books(String b_id,String w_id )
	{
		boolean conti1 = false;
		boolean conti2 = true;
		
		conti2 = add_warehouse(w_id);
		
		if(conti2) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM book_details where book_id='"+b_id+"'";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      if (rs.next())
		      {
		    	  conti1 = true;
		    	  
		      }
			      st.close();
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
	
		
		}
		else {JOptionPane.showMessageDialog(null, "WAREHOUSE ID DOESN'T EXIST","INFO",JOptionPane.INFORMATION_MESSAGE,null);}

		return conti1;
	
	}
}

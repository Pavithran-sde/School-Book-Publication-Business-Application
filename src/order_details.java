import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class order_details {
	
	int Price, Stock, Total;
	String BookName;
	
	public static void main(String[] arg) throws Exception
	{
		order_details od = new order_details();
		
		/*System.out.println("");
		System.out.println("Order Present : ");
		od.check_order_present("wmche27");
		
		System.out.println("");
		System.out.println("Add Order  : ");
		od.add_order_detail("wmche27", "wmche", "no");
		
		System.out.println("");
		System.out.println("Book search : ");
		od.book_details("eg1");
		
		System.out.println("");
		System.out.println("Add Order book : ");
		od.add_order_books("wmche27", "wmche", "eg1", 3, "", 120);
		
		
		System.out.println("");
		System.out.println("Total : ");
		od.cal_total("wmche27");
		
		System.out.println("");
		System.out.println("Add Total : ");
		od.add_order_total("wmche27");*/
		
		
		
	}
	
	// check the order status whether already present or not
	
	boolean check_order_present(String o_id)
	{
		boolean conti = true;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "select order_id from order_detail where order_id='"+o_id+"'";

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
	    System.out.println("the school details is"+ conti);
		return conti;
	}
	
	
	// Add the details to order details o_id, s_id, order_status = no
	
	
	public boolean add_order_detail(String o_id, String s_id, String status)
	{
		boolean proceed , od_proceed = false;
		proceed = check_order_present(o_id);
		
		if(proceed)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			    Connection con1=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			     // the insert statement
		         String query1 = " insert into order_detail (order_id,s_id,order_status)"
		        + " values (?, ?, ?)";

		      // create the  insert prepared statement
		      PreparedStatement preparedStmt1 = con1.prepareStatement(query1);
		      preparedStmt1.setString (1, o_id);
		      preparedStmt1.setString (2, s_id);
		      preparedStmt1.setString (3, status);
		      preparedStmt1.execute();
		      con1.close(); 
		      od_proceed = true;
			}
			catch(Exception ex)
			{
			System.out.println("1");
		    System.err.println("exception:");
		    System.err.println(ex.getMessage());
			}	
			 System.out.println("the order details is"+ od_proceed);
			return od_proceed;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Order Id already present","WARNING",JOptionPane.WARNING_MESSAGE,null);
			return od_proceed;
		}
		
	}
	
	// update order_details
	
	public boolean update_order_details(String o_id, String status)
	{
		boolean uod_details = false;
		try {
			System.out.println("update the order detais as Yes");
		     Class.forName("com.mysql.jdbc.Driver");
				Connection con5=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				 // the insert statement
			      String query5 = "update order_detail set order_status= ? where order_id = ?";
			      // create the  insert prepared statement
			      PreparedStatement preparedStmt5 = con5.prepareStatement(query5);
			     
			     System.out.println("order=" +o_id);
			 
			      preparedStmt5.setString (1, status);
			      preparedStmt5.setString (2, o_id);
			      preparedStmt5.execute();
			      con5.close(); 
		          uod_details = true;
			               }catch(Exception e1)
				{System.out.println("6");
					System.err.println("exception:");
					System.err.println(e1.getMessage());
				}
		 System.out.println("the order details are updated  "+ uod_details);
		return uod_details;
	}
	
	
	// adding books along with order id
	
	// 1. retrive book details 
	
	  public boolean book_details(String b_id)
	  {
		  String bid;
		  int stock,price;
		  boolean bd_proceed = false ;
		  
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
				         bid= rs.getString("book_id");
				         BookName= rs.getString("book_name");
				         stock = rs.getInt("quantity");
				         price = rs.getInt("price");   
				         Stock = stock;
				         Price = price;
				         bd_proceed = true;
				        }
				      else{
				    	  JOptionPane.showMessageDialog(null, "Invalid Book Id","Warning",JOptionPane.ERROR_MESSAGE,null);	
				    	  bd_proceed = true;
				        }
				      st.close();
				      
	            }catch(Exception e1)
				{
					System.err.println("exception:");
					System.err.println(e1.getMessage());
				}
			 System.out.println("the book details are retrieved "+ bd_proceed);
			return bd_proceed;
			}
	  
	  // 2. insert details into order_books and also check the order status
	  
	  public boolean add_order_books(String o_id,String s_id,String b_id,int qty, String available, int eprice)
	  {
		  String status;
		  int total;
		  boolean proceed, ob_proceed=false, uod;
		  
		       proceed = book_details(b_id);
		  
		  if(proceed)
		  {
			  if(Stock >= qty)
			  {
				  try { 
			            Class.forName("com.mysql.jdbc.Driver");
			            Connection con2=DriverManager.getConnection(  
			                                           	"jdbc:mysql://localhost:3306/my_business","root","");  

			                        // the insert statement
			                     String query2 = " insert into order_book (o_id,s_id,b_id,b_name,qty,total,available,price)"
			                             + " values (? ,?, ?, ?, ?,?, ?, ?)";
			                         // create the  insert prepared statement
			                    PreparedStatement preparedStmt2 = con2.prepareStatement(query2);
			                     
			                    if(eprice > 0)
			                    {
			                        total = qty * eprice;
			                    }else { total = qty * Price;}
			                    
									preparedStmt2.setString (1,o_id);
									preparedStmt2.setString (2, s_id);
									preparedStmt2.setString (3,b_id);
									preparedStmt2.setString (4, BookName);
									preparedStmt2.setInt (5, qty);
									preparedStmt2.setInt (6, total);
									preparedStmt2.setString (7,"yes" );
									preparedStmt2.setInt (8,eprice);
									
									preparedStmt2.execute();
									con2.close();
									
		// update order details
									status = "yes";
									uod = update_order_details(o_id, status);
									System.out.println("the order books entered  "+ uod+ "with status  "+status);
									
									if(uod) {
									 new reduce_stock(Stock,qty,b_id);
									 
									}
									else 
									{
										JOptionPane.showMessageDialog(null, "Update order status error in update_order_details","Warning",JOptionPane.ERROR_MESSAGE,null);	
									}
									
				  }catch(Exception ex) {
					  System.err.println("exception:");
						System.err.println(ex.getMessage());	  
				  }
			  }
			  else {
				  // update the available status to no as stock < qty
				  
				  try { 
			            Class.forName("com.mysql.jdbc.Driver");
			            Connection con2=DriverManager.getConnection(  
			                                           	"jdbc:mysql://localhost:3306/my_business","root","");  

			                        // the insert statement
			                     String query2 = " insert into order_book (o_id,s_id,b_id,b_name,qty,total,available,price)"
			                             + " values (? ,?, ?, ?, ?,?, ?, ?)";
			                         // create the  insert prepared statement
			                    PreparedStatement preparedStmt2 = con2.prepareStatement(query2);
			                     
			                    if(eprice > 0)
			                    {
			                        total = qty * eprice;
			                    }else { total = qty * Price;}
			                    
									preparedStmt2.setString (1,o_id);
									preparedStmt2.setString (2, s_id);
									preparedStmt2.setString (3,b_id);
									preparedStmt2.setString (4, BookName);
									preparedStmt2.setInt (5, qty);
									preparedStmt2.setInt (6, total);
									preparedStmt2.setString (7,"no" );
									preparedStmt2.setInt (8,eprice);
									
									preparedStmt2.execute();
									con2.close();
									
									status = "no";
									uod = update_order_details(o_id, status);
									System.out.println("the order books entered  "+ uod+ "with status  "+status);
				  }catch(Exception ex) {
					  System.err.println("exception:");
						System.err.println(ex.getMessage());	  
				  }
				  
			  }
			  
			  }

		  
		  
		  return ob_proceed;
	  }
	  
	  
	  // CALCULATE TOTAL FROM THE ORDER BOOKS
	  
	  public boolean cal_total(String o_id)
	  {
		  int price;
		  Total = 0;
		   boolean conti = false;
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				// our SQL SELECT query. 
			      // if you only need a few columns, specify them by name instead of using "*"
			      String query = "select total from order_book where o_id='"+o_id+"'";

			      // create the java statement
			      Statement st = con.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs = st.executeQuery(query);
			      
			      // iterate through the java resultset
			      while (rs.next())
			      {
			    	  price = rs.getInt("total");
			    	  Total += price;
			    	  conti = true;
			      }
				      st.close();
			}catch(Exception ex)
			{
				System.err.println("exception:");
				System.err.println(ex.getMessage());
			}
		  
		  System.out.println("The final total of order id= "+o_id+" is "+ Total); 
		  return conti;
		  
	  }
	  
	  // add to order total 
	  
	  public boolean add_order_total(String o_id)
	  {
		  boolean conti= false;
		  try {
				System.out.println("");
				System.out.println("inserting into order_total");
				Class.forName("com.mysql.jdbc.Driver");
				Connection con6=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				 // the insert statement
			      String query6 = " insert into order_tot (o_id,tot)"
			        + " values (?, ?)";

			      // create the  insert prepared statement
			      PreparedStatement preparedStmt6 = con6.prepareStatement(query6);
			      preparedStmt6.setString (1, o_id);
			      preparedStmt6.setInt (2, Total);
			      preparedStmt6.execute();
			      conti = true;
			      con6.close(); 
			 
			   System.out.println("Add order total : "+ conti);
			}
			catch(Exception ex)
			{
				conti = false;
				System.out.println("exception in 1st total");
				System.out.println(ex);
			}

	  return conti;
	  }
	
}


	
	

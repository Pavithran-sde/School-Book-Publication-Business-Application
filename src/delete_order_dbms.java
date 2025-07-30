//import statement
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
public class  delete_order_dbms  implements ActionListener {
	//variables
	static String id1,id2;
	static String name;
	static String id,m_id;
	String ID;
	static int ph_no;
	Integer PH,ST;
	String ID1,ID2;
	// frame
			JFrame frame=new JFrame("DELETE ORDER DETAILS");
			JPanel panel =new JPanel();
			//button
			JButton delete= new JButton("DELETE");
			JButton back= new JButton("BACK");
			JButton search= new JButton("SEARCH");
			
			/*ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\order.jpg");
			JLabel l1= new JLabel(i,JLabel.CENTER);*/
	
			//label
			JLabel title=new JLabel("DELETE ORDER DETAILS");
		
			JLabel ordid=new JLabel("ORDER ID");
			JLabel school_id=new JLabel("SCHOOL ID");
			//table
			JTable tabel=new JTable();
			//scroll pane
			JScrollPane pane=new JScrollPane(tabel);
			
			//text field
			 JTextField o_id=new JTextField();
			 JTextField s_id=new JTextField();
			 delete_order_dbms() throws SQLException
			{
				 //frame and panel settings
				frame.setSize(640,640);
				frame.setVisible(true);
			panel.setLayout(null);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//set bounds label
		title.setBounds(100,30,250,50);
	 ordid.setBounds(75,100, 100, 30);
		school_id.setBounds(75,150, 100, 30);
		
		//set bounds table
		tabel.setBounds(100,150,300,300);
		
		//set bounds text fields
		o_id.setBounds(180, 100, 100, 30);
		s_id.setBounds(180, 150, 100, 30);
		
		
		//set bounds to buttons
		search.setBounds(450,150,120,30);
		delete.setBounds(450,200,120,30);
		back.setBounds(450,450,120,30);
			/* l1.setBounds(0,0,640,640);
				panel.add(l1);*/
			//add components to panel
			panel.add(title);
			panel.add(delete);
			panel.add(back);
			panel.add(search);
			
			panel.add(ordid);
			//panel.add(school_id);
			panel.add(o_id);
			//panel.add(s_id);
			panel.add(pane);
		//add panel to frame
			frame.add(panel);
			delete.addActionListener(this);
			back.addActionListener(this);
			search.addActionListener(this);
			}
			public static void main(String[] args) throws SQLException {
				 delete_order_dbms v=new  delete_order_dbms();

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==delete)
				{
		JOptionPane.showMessageDialog(null, "DO YOU REALLY WANT TO EDIT THIS DETAIL","ALERT",JOptionPane.WARNING_MESSAGE,null);
					try {
						Class.forName("com.mysql.jdbc.Driver");
						  Connection con2=DriverManager.getConnection(  
									"jdbc:mysql://localhost:3306/my_business","root","");  
							 String query2 = "delete from order_book where s_id = ?";
						      PreparedStatement preparedStmt2 = con2.prepareStatement(query2);
						      id2=s_id.getText();
						     
						      // execute the prepared statement
						  preparedStmt2.setString(1, id2);
							      preparedStmt2.execute();
						
							    	Class.forName("com.mysql.jdbc.Driver");
									Connection con3=DriverManager.getConnection(  
											"jdbc:mysql://localhost:3306/my_business","root","");  
									 String query3 = "delete from pack_Db where o_id = ?";
								      PreparedStatement preparedStmt3 = con3.prepareStatement(query3);
								     id1=o_id.getText();
								      preparedStmt3.setString(1, id1);
								      // execute the prepared statement
								      preparedStmt3.execute();
								      
							      Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/my_business","root","");  
					 String query = "delete from order_detail where order_id = ?";
				      PreparedStatement preparedStmt = con.prepareStatement(query);
				     id1=o_id.getText();
				      preparedStmt.setString(1, id1);
				      // execute the prepared statement
				      preparedStmt.execute();
				      /////total
				      Class.forName("com.mysql.jdbc.Driver");
						Connection conq=DriverManager.getConnection(  
								"jdbc:mysql://localhost:3306/my_business","root","");  
						 String queryq = "delete from order_tot where o_id = ?";
					      PreparedStatement preparedStmtq = conq.prepareStatement(queryq);
					     id1=o_id.getText();
					      preparedStmtq.setString(1, id1);
					      // execute the prepared statement
					      preparedStmtq.execute();
				    
				
						    JOptionPane.showMessageDialog(null, "SUCCESSFULLY DELETED","INFO",JOptionPane.INFORMATION_MESSAGE,null);
				   	}
					catch(Exception e1)
					{
						System.out.println(e1);
					}
				}
				else if(e.getSource()==search)
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection(  
								"jdbc:mysql://localhost:3306/my_business","root","");  
						// our SQL SELECT query. 
					      // if you only need a few columns, specify them by name instead of using "*"
					      String query = "select s_id from order_detail where order_id='"+o_id.getText()+"'";

					      // create the java statement
					      Statement st = con.createStatement();
					      
					      // execute the query, and get a java resultset
					      ResultSet rs = st.executeQuery(query);
					      
					      // iterate through the java resultset
					      while (rs.next())
					      {
					    id= rs.getString("s_id");
					  m_id=id;
					      }
				      System.out.println(m_id);
				       new v_o(m_id,o_id.getText());
					      st.close();
					     	}
						catch(Exception ex)
						{
						
				System.err.println("exception:");
				System.err.println(ex.getMessage());
						}	
				}
				else if(e.getSource()==back)
				{
					new order_first_dbms();
					frame.dispose();
				}
				
				
}
}
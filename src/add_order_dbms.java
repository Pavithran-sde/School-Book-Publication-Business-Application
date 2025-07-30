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
public class add_order_dbms  implements ActionListener {
	//variables
	
	 int book_count=0,i=1;
	
	// frame
			JFrame frame=new JFrame("ADD ORDER DETAILS");
			JPanel panel =new JPanel();
			//button
			JButton add= new JButton("ADD ORDER ID");
			JButton add_books= new JButton("ADD BOOKS");
			
			JButton status= new JButton("CHECK STATUS");
			JButton back= new JButton("BACK");
			
			
			
			//label
			JLabel title=new JLabel("ADD ORDER DETAILS");
			JLabel ordid=new JLabel("ORDER ID");
			JLabel school_id=new JLabel("SCHOOL ID");
			JLabel book_id=new JLabel("BOOK ID");
			JLabel qty=new JLabel("BOOK QUANTITY");
			JLabel cost=new JLabel("PRICE OF BOOK");
			
			
			//table
			JTable tabel=new JTable();
			//scroll pane
			JScrollPane pane=new JScrollPane(tabel);
			
			//text field
			 JTextField o_id=new JTextField();
			 JTextField s_id=new JTextField();
			 JTextField b_id=new JTextField();
			 JTextField q=new JTextField();
			 JTextField c=new JTextField();
			 
			 add_order_dbms() throws SQLException
			{
				 //frame and panel settings
				frame.setSize(640,640);
				frame.setVisible(true);
			panel.setLayout(null);
			
			//set bounds label
		title.setBounds(100,30,250,50);
	    ordid.setBounds(75,100, 100, 30);
		school_id.setBounds(75,150, 100, 30);
		book_id.setBounds(75,200, 100, 30);
		cost.setBounds(75,250, 100, 30);
		qty.setBounds(65,300, 110, 30);
		
		//set bounds table
		tabel.setBounds(100,150,300,300);
		
		//set bounds text fields
		o_id.setBounds(180, 100, 100, 30);
		s_id.setBounds(180, 150, 100, 30);
		b_id.setBounds(180, 200, 100, 30);
		c.setBounds(180, 250, 100, 30);
		q.setBounds(180, 300, 100, 30);
		
		
		//set bounds to buttons
		add.setBounds(450,150,150,30);
		add_books.setBounds(450,200,150,30);
		status.setBounds(450,250,150,30);
		back.setBounds(450,300,150,30);
		
		 /*l1.setBounds(0,0,640,640);
			panel.add(l1);*/
			//add components to panel
			panel.add(title);
			panel.add(add);
			panel.add(add_books);
			panel.add(back);	
			panel.add(status);		
			panel.add(book_id);	
			panel.add(cost);
			panel.add(c);			
			panel.add(qty);
			panel.add(b_id);
			panel.add(q);
			
			
			panel.add(ordid);
			panel.add(school_id);
			panel.add(o_id);
			panel.add(s_id);
			panel.add(pane);
		//add panel to frame
			frame.add(panel);
			add.addActionListener(this);
			add_books.addActionListener(this);
			status.addActionListener(this);
	      	back.addActionListener(this);
			
			
		
		
			}
			public static void main(String[] args) throws SQLException {
				 add_order_dbms v=new add_order_dbms();

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean proceed = true;
				order_details od = new order_details();
				String orderid, schoolid;
				int qty, p;
                
				if(e.getSource()==add)
				{
                	//order details
                	if(!o_id.getText().equals("")) {      
                	try {
						//insert into order details
				    
				    orderid  = o_id.getText();
				    schoolid=  s_id.getText();  
				    proceed = od.add_order_detail(orderid, schoolid, "no"); 
				      o_id.setEditable(false);
					  s_id.setEditable(false);
					}
					catch(Exception ex)
					{
					System.out.println("1");
				    System.err.println("exception:");
				    System.err.println(ex.getMessage());
					}		
			}
                	
				else 
				{
					JOptionPane.showMessageDialog(null, "ENTER CREDENTIALS","WARNING",JOptionPane.WARNING_MESSAGE,null);
					o_id.setText(null);}
				}

			
// add books
                
				else if(e.getSource()==add_books)
				{
				if(proceed) {
					
				
					{
		
					try {
				 
						proceed = od.book_details(b_id.getText());
				
						if(proceed) {}			
						else {
							//JOptionPane.showMessageDialog(null, "BOOK ID DOES NOT EXIST","WARNING",JOptionPane.WARNING_MESSAGE,null);
							o_id.setText(null);
		    	  
						}
					}catch(Exception e1)
					{System.out.println("2");
					System.err.println("exception:");
					System.err.println(e1.getMessage());
					}
			
			
			     try {
			       	 
			       orderid  = o_id.getText();
				   schoolid=  s_id.getText(); 
			 	   p=Integer.parseInt(c.getText());               
                   o_id.getText();
			       b_id.getText();
			       String ststus = "yes" ;
			       qty = Integer.parseInt( q.getText());  
			       
			      proceed = od.add_order_books(orderid, schoolid, b_id.getText(), qty , "",  p);

	              b_id.setText(null); 
			      q.setText(null);
			      c.setText(null);
			     }
			     catch(Exception ex) {
			      
			    	 System.err.println("exception:");
						System.err.println(ex.getMessage());
			     }
		
			
			
			
			
				try {
					proceed = od.cal_total(o_id.getText());
				    
					if(proceed) { 
						
						proceed = od.add_order_total(o_id.getText());
					}else 
					{
						JOptionPane.showMessageDialog(null, "Calculation Error","WARNING",JOptionPane.WARNING_MESSAGE,null);
					}
				}
				catch(Exception ex)
				{
					System.out.println("exception in 1st total");
					System.out.println(ex);
				}
			}
			}
			
			}		
else if(e.getSource()==status)
					{
			          
					}
else if(e.getSource()==back)
{
new order_first_dbms();
frame.dispose();
}

                
			
}
}




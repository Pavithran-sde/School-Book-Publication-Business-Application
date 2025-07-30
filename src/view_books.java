
import javax.swing.JOptionPane;
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
public class view_books implements ActionListener {
	//variables
	static int id;
	static String name;
	static String a,w;
	static String b;
	
	static int ph_no,pri;
	static int sto;
	Integer ID,PH,ST,P;
	//TABLE
	JTable tabel=new JTable();
	
	JScrollPane pane=new JScrollPane(tabel);
	//frame and panel
	JFrame frame=new JFrame("VIEW BOOKS");
   JPanel panel=new JPanel();
   //JLabel
   JLabel ware_id=new JLabel("WAREHOUSE ID");
   JLabel book_id=new JLabel("BOOK ID");
   JLabel book_name=new JLabel("BOOK NAME");
   JLabel qty=new JLabel("BOOK QUANTITY");
   JLabel price=new JLabel("BOOK PRICE");
   
   //JTEXTFIELDS
   JTextField w_id=new JTextField();
   JTextField b_id=new JTextField();
   JTextField b_name=new JTextField();
   JTextField b_qty=new JTextField();
   JTextField b_pri=new JTextField();
   
   // background
   /*ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\book.jpg");
   JLabel l1= new JLabel(i,JLabel.CENTER);*/
  
   //button
   JButton  view=new JButton("VIEW BOOK");
   view_books()
   {
	   //setting frame and panel
	   frame.setSize(640,640);
	   frame.setVisible(true);
panel.setLayout(null);
//set bounds for
//set bounds Label
ware_id.setBounds(75,100,150,30);

book_id.setBounds(75,150,150,30);
book_name.setBounds(75,200,150,30);
qty.setBounds(75,250,150,30);
price.setBounds(75,300,150,30);

//set bounds textfield
w_id.setBounds(260,100,150,30);

b_id.setBounds(260,150,150,30);
b_name.setBounds(260,200,150,30);
b_name.setEditable(false);
b_qty.setBounds(260,250,150,30);
b_qty.setEditable(false);
b_pri.setBounds(260,300,150,30);
b_pri.setEditable(false);
//l1.setBounds(0,0,640,640);

//set bounds buttons
view.setBounds(450,150,150,30);
//add components to panel
	//panel.add(l1);
panel.add(view);
panel.add(book_id);
panel.add(ware_id);
panel.add(w_id);

panel.add(book_name);
panel.add(qty);
panel.add(b_id);
panel.add(b_name);
panel.add(b_qty);
panel.add(price);
panel.add(b_pri);

//add panel to frame
frame.add(panel);
view.addActionListener(this);
   }
	
   public static void main(String[] args){
	   view_books v=new view_books();
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==view)
		{
	        if(!w_id.getText().equals("") || !b_id.getText().equals("") || (!w_id.getText().equals("") && !b_id.getText().equals("")))
	        { 
	        	boolean proceed = true;
				try {
					view_class vc = new view_class();
					proceed  = vc.add_books(b_id.getText(), w_id.getText());
						
				}
				catch(Exception ex) {}
				
				if(proceed) {
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/my_business","root","");  
					// our SQL SELECT query. 
				      // if you only need a few columns, specify them by name instead of using "*"
				      String query = "SELECT * FROM book_details where book_id='"+b_id.getText()+"'";

				      // create the java statement
				      Statement st = con.createStatement();
				      
				      // execute the query, and get a java resultset
				      ResultSet rs = st.executeQuery(query);
				      
				      
					// iterate through the java resultset
				      if (rs.next())
				      {
				    	  w= rs.getString("w_id");
					          
				         a= rs.getString("book_id");
				         name= rs.getString("book_name");
				        sto = rs.getInt("quantity");
				        pri = rs.getInt("price");
				        P=pri;
				         ST=sto;
				         w_id.setText(w);
					      b_id.setText(a);
					      b_name.setText(name);
					      b_qty.setText(ST.toString());
					      b_pri.setText(P.toString());
				        
				        }
				      else{
				    	  JOptionPane.showMessageDialog(null, "Invalid Book Id ","Warning",JOptionPane.ERROR_MESSAGE,null);
				    	
				    	  w_id.setText(null);
					      b_id.setText(null);
					      b_name.setText(null);
					      b_qty.setText(null);
					      b_pri.setText(null);
				        	
				        }
				      st.close();
	               }catch(Exception e1)
				{
					System.err.println("exception:");
					System.err.println(e1.getMessage());
				}
			}
				else{
			    	  
			    	  w_id.setText(null);
				      b_id.setText(null);
				      b_name.setText(null);
				      b_qty.setText(null);
				      b_pri.setText(null);
			        	
			        }
				
	        
			  
			
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Enter Credentials","Warning",JOptionPane.ERROR_MESSAGE,null);
			w_id.setText(null);
	      	b_id.setText(null);
		}
		}
	}
	}


		
	



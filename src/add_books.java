import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
public class add_books implements ActionListener {
	//variables
	static int sid,total;
	static String name;
	static int ph_no;
	static int stock;
	
	//frame and panel
	JFrame frame=new JFrame("ADD BOOKS");
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
   
   //background
   //ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\book.jpg");
   //JLabel l1= new JLabel(i,JLabel.CENTER);

   
   //button
   JButton add=new JButton("ADD BOOK");
   JButton back=new JButton("BACK");
   
   add_books()
   {//setting frame and panel
	   frame.setSize(640,640);
	   frame.setVisible(true);
panel.setLayout(null);
//set bounds Label
ware_id.setBounds(75,100,150,30);
book_id.setBounds(75,150,150,30);
book_name.setBounds(75,200,150,30);
qty.setBounds(75,250,150,30);
price.setBounds(75, 300, 150, 30);
//set bounds textfield
w_id.setBounds(260,100,150,30);
b_id.setBounds(260,150,150,30);
b_name.setBounds(260,200,150,30);
b_qty.setBounds(260,250,150,30);
b_pri.setBounds(260,300,150,30);

//set bounds buttons
add.setBounds(450,150,150,30);
//l1.setBounds(0,0,640,640);

//add components to panel
//panel.add(l1);
panel.add(add);
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
add.addActionListener(this);
   }
	
   public static void main(String[] args){
		add_books v=new  add_books();
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add)
		{
		
			if(!b_id.getText().equals("") || !w_id.getText().equals("")  || (!b_id.getText().equals("") &&  !w_id.getText().equals("")) || b_name.getText().equals("") || b_qty.getText().equals("") || b_pri.getText().equals("")) {
				boolean proceed = true;
				try {
					view_class vc = new view_class();
					proceed  = vc.add_books(b_id.getText(), w_id.getText());
						
				}
				catch(Exception ex) {}
				
				if(!proceed) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				 // the insert statement
			      String query = " insert into book_details (book_id,book_name,quantity,price,w_id)"
			        + " values (?, ?, ?, ?, ?)";

			      // create the  insert prepared statement
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			  stock=Integer.parseInt(b_qty.getText());
			  total= Integer.parseInt(b_pri.getText());
			      preparedStmt.setString (1,b_id.getText());
			      preparedStmt.setString (2, b_name.getText());
			      preparedStmt.setInt (3, stock);
			      preparedStmt.setInt (4, total);
			      preparedStmt.setString (5,w_id.getText());  
			      preparedStmt.execute();
			      con.close();
			      JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED","INFO",JOptionPane.INFORMATION_MESSAGE,null);
			      frame.dispose();
			      }
				catch(Exception ex)
				{
				
			System.err.println("exception:");
			System.err.println(ex.getMessage());
				}
		}
			else {
				
				JOptionPane.showMessageDialog(null, "BOOK ID ALREADY EXIST","WARNING",JOptionPane.WARNING_MESSAGE,null);
				b_id.setText(null);
				w_id.setText(null);
				b_name.setText(null);
				b_qty.setText(null);
				b_pri.setText(null);				
			}
		}
			else 
			{
				JOptionPane.showMessageDialog(null, "ENTER CREDENTIALS","WARNING",JOptionPane.WARNING_MESSAGE,null);
				b_id.setText(null);	
			}
		}
		
	}

}

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
import java.util.Vector;

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

import com.mysql.jdbc.ResultSetMetaData;

import net.proteanit.sql.DbUtils;
public class  view_order_dbms  implements ActionListener {
	static String id,m_id,O_ID;
	String ID;
			// frame
			JFrame frame=new JFrame("VIEW ORDER DETAILS");
			JPanel panel =new JPanel();
			//button
			JButton view= new JButton("VIEW");
			//JButton save= new JButton("SAVE");
			JButton back= new JButton("BACK");
			
			
			//label
			JLabel title=new JLabel("VIEW ORDER DETAILS");

			JLabel ordid=new JLabel("ORDER ID");
			//JLabel school_id=new JLabel("SCHOOL ID");
			//table
			JTable tabel=new JTable();
			//scroll pane
			JScrollPane pane=new JScrollPane(tabel);
			/*ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\order.jpg");
			JLabel l1= new JLabel(i,JLabel.CENTER);*/
	
			
			//text field
			 JTextField o_id=new JTextField();
		//	 JTextField o_name=new JTextField();
			 view_order_dbms() throws SQLException
			{
				 //frame and panel settings
				frame.setSize(640,640);
				frame.setVisible(true);
			panel.setLayout(null);
			
			//set bounds label
		title.setBounds(100,30,250,50);
	    ordid.setBounds(75,100, 100, 30);
		//school_id.setBounds(280,100, 100, 30);
		
		//set bounds table
		tabel.setBounds(100,150,300,300);
		
		//set bounds text fields
		o_id.setBounds(175, 100, 100, 30);
		
		//set bounds to buttons
		view.setBounds(450,150,100,30);
		//save.setBounds(450,200,100,30);
			back.setBounds(450,450,150,30);
			//add components to panel
			/* l1.setBounds(0,0,640,640);
				panel.add(l1);*/
			panel.add(title);
			panel.add(view);
			//panel.add(save);
			//panel.add(back);
			
			panel.add(ordid);
			//panel.add(school_id);
			panel.add(o_id);
			//panel.add(s_id);
			panel.add(pane);
		//add panel to frame
			frame.add(panel);
			view.addActionListener(this);
			}
			public static void main(String[] args) throws SQLException {
				view_order_dbms v=new  view_order_dbms();

			}

		@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					if(e.getSource()==view) {
						if(!o_id.getText().equals("")) {
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
						      if (rs.next())
						      {
						    id= rs.getString("s_id");
						  m_id=id;
						  System.out.println(m_id);
					      O_ID=o_id.getText();
					       new v_o(m_id,O_ID);
						      st.close();
						      }else
						      {
						    	  JOptionPane.showMessageDialog(null, "Invalid Order Id","Warning",JOptionPane.ERROR_MESSAGE,null);
						    	  o_id.setText(null);
						      }
						      
					      
						     	}
							catch(Exception ex)
							{
							
					System.err.println("exception:");
					System.err.println(ex.getMessage());
							}
				
					
							
			}
					else
					{
						JOptionPane.showMessageDialog(null, "Enter Credentials","Warning",JOptionPane.ERROR_MESSAGE,null);
						o_id.setText(null);
				      	
					}
					}
		}
}

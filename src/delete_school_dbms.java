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
public class delete_school_dbms  implements ActionListener{
	//variables
			
			static String name,id;
			static String ph_no;
			static String address;
			static String emailid;
			static int pin;
			
			Integer ID,PH,PIN;
			
	// frame
			JFrame frame=new JFrame(" DELETE SCHOOL DETAILS");
			JPanel panel =new JPanel();
			//button
			JButton delete= new JButton("DELETE");
			JButton search= new JButton("SEARCH");
			JButton back= new JButton("BACK");
			
			/*ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\school.jpg");
			JLabel l1= new JLabel(i,JLabel.CENTER);*/
			
			//label
			JLabel title=new JLabel("SCHOOL DETAILS");

			JLabel schoolid=new JLabel("SCHOOL ID");
			JLabel school_name=new JLabel("SCHOOL NAME");
			JLabel school_ph_no=new JLabel("SCHOOL PH.NO");
			JLabel school_address=new JLabel("SCHOOL ADDRESS");
			JLabel school_email=new JLabel("SCHOOL EMAIL");
			JLabel school_pin=new JLabel("SCHOOL PINCODE");
			
			//table
			JTable tabel=new JTable();
			//scroll pane
			JScrollPane pane=new JScrollPane(tabel);
			
			//text field
			 JTextField s_id=new JTextField();
			 JTextField s_name=new JTextField();
			 JTextField s_ph_no=new JTextField();
			 JTextField s_address=new JTextField();
			 JTextField s_email=new JTextField();
			 JTextField s_pin=new JTextField();
			 
			 delete_school_dbms() throws SQLException
			{
				 //frame and panel settings
				frame.setSize(640,640);
				frame.setVisible(true);
			    panel.setLayout(null);
			
			//set bounds label
			title.setBounds(100,30,250,50);
			schoolid.setBounds(75,100, 150, 30);
			school_name.setBounds(75,140, 150, 30);
			school_ph_no.setBounds(75,180, 150, 30);
			school_address.setBounds(75,220, 150, 30);
			school_email.setBounds(75,300, 150, 30);
			school_pin.setBounds(75,260, 150, 30);
			
		//set bounds table
		tabel.setBounds(100,150,300,300);
		
		//set bounds text fields
		s_id.setBounds(250, 100, 150, 30);
		s_name.setBounds(250,140,150,30);
		s_ph_no.setBounds(250, 180, 150, 30);
		s_address.setBounds(250, 220, 150, 30);
		s_email.setBounds(250, 300, 200, 30);
		s_pin.setBounds(250, 260, 150, 30);
			
		//set bounds to buttons
		delete.setBounds(480,200,100,30);
		search.setBounds(480,150,100,30);
		back.setBounds(480,450,100,30);
		
		/* l1.setBounds(0,0,640,640);
			panel.add(l1);*/
		
		
			//add components to panel
			panel.add(title);
			panel.add(delete);
			panel.add(search);
			panel.add(school_pin);
			panel.add(s_pin);
			panel.add(back);
			
			
			panel.add(schoolid);
			panel.add(school_name);
			panel.add(school_ph_no);
			panel.add(school_address);
			panel.add(school_email);
			
			panel.add(s_name);
			panel.add(s_id);
			panel.add(s_address);
			panel.add(s_ph_no);
			panel.add(s_email);
			panel.add(pane);
		//add panel to frame
			frame.add(panel);
			delete.addActionListener(this);
			search.addActionListener(this);
			back.addActionListener(this);
			
		
		
			}
			public static void main(String[] args) throws SQLException {
				 delete_school_dbms v=new  delete_school_dbms();

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==delete)
				{ 
					try {
					
					JOptionPane.showMessageDialog(null, "DO YOU REALLY WANT TO DELET THE RECORD","INFO",JOptionPane.WARNING_MESSAGE,null);
					Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				 String query = "delete from school_details where s_id = ?";
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setString(1, s_id.getText());

			      // execute the preparedstatement
			      preparedStmt.execute();
			      
			      con.close();
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
				      String query = "SELECT * FROM school_details where s_id='"+s_id.getText()+"'";

				      // create the java statement
				      Statement st = con.createStatement();
				      
				      // execute the query, and get a java resultset
				      ResultSet rs = st.executeQuery(query);
				      
				      // iterate through the java resultset
				      while (rs.next())
				      {
				         id = rs.getString("s_id");
				         name= rs.getString("s_name");
				         ph_no= rs.getString("s_ph_no");
				        
				         address= rs.getString("address");
				         pin= rs.getInt("pincode");
				         PIN=pin;
				         emailid= rs.getString("email");
				        
				        }
				      s_id.setText(id);
				      s_name.setText(name);
				      s_ph_no.setText(ph_no);
				      s_address.setText(address);
				      s_pin.setText(PIN.toString());
				      s_email.setText(emailid);
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
					//new s1_dbms();
					frame.dispose();
					
				}
			}
}
		

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

public class view_school_dbms implements ActionListener{
	//variables
	
	static String name,id;
	static String ph_no,ph_no1,ph_no2;
	static String address,address1,address2,address3;
	static String emailid;
	static int pin;
	Integer ID,PH,PIN;
	
	// frame
		JFrame frame=new JFrame(" VIEW SCHOOL DETAILS");
		JPanel panel =new JPanel();
		//button
		JButton view= new JButton("VIEW");
		
		
		//label
		JLabel title=new JLabel("SCHOOL DETAILS");

		JLabel schoolid=new JLabel("SCHOOL ID");
		JLabel school_name=new JLabel("SCHOOL NAME");
		JLabel school_ph_no1=new JLabel("SCHOOL PH.NO 1");
		JLabel school_ph_no2=new JLabel("SCHOOL PH.NO 2");
		JLabel school_ph_no=new JLabel("SCHOOL PH.NO 3");
		JLabel school_address=new JLabel("SCHOOL ADDRESS 1");
		JLabel school_address1=new JLabel("SCHOOL ADDRESS 2");
		JLabel school_address2=new JLabel("SCHOOL ADDRESS 3");
		JLabel school_address3=new JLabel("SCHOOL ADDRESS 4");
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
		 JTextField s_ph_no1=new JTextField();
		 JTextField s_ph_no2=new JTextField();
		 JTextField s_address=new JTextField();
		 JTextField s_address1=new JTextField();
		 JTextField s_address2=new JTextField();
		 JTextField s_address3=new JTextField();
		 JTextField s_email=new JTextField();
		 JTextField s_pin=new JTextField();
		/* ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\school.jpg");
		 JLabel l1= new JLabel(i,JLabel.CENTER);*/
		 
		 view_school_dbms() throws SQLException
		{
			 //frame and panel settings
			frame.setSize(640,640);
			frame.setVisible(true);
		panel.setLayout(null);
		
		//set bounds label
		  title.setBounds(200,50,450,30);
	        title.setFont(new Font("",Font.BOLD,20));
	schoolid.setBounds(75,100, 150, 30);
	school_name.setBounds(75,140, 150, 30);
	school_address.setBounds(75,180, 150, 30);
	school_address1.setBounds(75,220, 150, 30);
	school_address2.setBounds(75,260, 150, 30);
	school_address3.setBounds(75,300, 150, 30);
	school_ph_no.setBounds(75,340, 150, 30);
	school_ph_no1.setBounds(75,380, 150, 30);
	school_ph_no2.setBounds(75,420, 150, 30);
	school_email.setBounds(75,500, 150, 30);
	school_pin.setBounds(75,460, 150, 30);
	
	
	//set bounds table
	tabel.setBounds(100,150,300,300);
	
	//set bounds text fields
	s_id.setBounds(250, 100, 150, 30);
	s_name.setBounds(250,140,150,30);
	s_address.setBounds(250, 180, 150, 30);
	s_address1.setBounds(250, 220, 150, 30);
	s_address2.setBounds(250, 260, 150, 30);
	s_address3.setBounds(250, 300, 150, 30);
	s_ph_no.setBounds(250, 340, 150, 30);
	s_ph_no1.setBounds(250, 380, 150, 30);
	s_ph_no2.setBounds(250, 420, 150, 30);
	s_email.setBounds(250, 500, 200, 30);
	s_pin.setBounds(250,460, 150, 30);
		
	//set bounds to buttons
	view.setBounds(450,150,100,30);
	/* l1.setBounds(0,0,640,640);
	 	panel.add(l1);
	 */
		//add components to panel
		panel.add(title);
		panel.add(view);
		panel.add(schoolid);
		panel.add(school_name);
		panel.add(school_ph_no);
		panel.add(school_ph_no1);
		panel.add(school_ph_no2);
		panel.add(school_address);
		panel.add(school_address1);
		panel.add(school_address2);
		panel.add(school_address3);
		panel.add(school_email);
		panel.add(s_name);
		panel.add(s_id);
		panel.add(s_address);
		panel.add(s_address1);
		panel.add(s_address2);
		panel.add(s_address3);
		panel.add(s_ph_no);
		panel.add(s_ph_no1);
		panel.add(s_ph_no2);
		
		panel.add(s_email);
		panel.add(school_pin);
		panel.add(s_pin);
		panel.add(pane);
	//add panel to frame
		frame.add(panel);
		view.addActionListener(this);
		
	
		}
		public static void main(String[] args) throws SQLException {
			 view_school_dbms v=new  view_school_dbms();

		}

		@Override
		public void actionPerformed(ActionEvent e)  {
			if(e.getSource()==view)
			{
				if(!s_id.getText().equals("")) {
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
				      if (rs.next())
				      {
				         id = rs.getString("s_id");
				         
				         name= rs.getString("s_name");
				         ph_no= rs.getString("s_ph_no");
				         ph_no1= rs.getString("ph1");
				         ph_no2= rs.getString("ph2");
				         address= rs.getString("address");
				         address1= rs.getString("add1");
				         address2= rs.getString("add2");
				         address3= rs.getString("add3");
				         pin= rs.getInt("pincode");
				         PIN=pin;
				         emailid= rs.getString("email");
				        
				         s_id.setText(id);
					      s_name.setText(name);
					      s_ph_no.setText(ph_no);
					      s_ph_no1.setText(ph_no1);
					      s_ph_no2.setText(ph_no2);
					      
					      s_address.setText(address);
					      s_address1.setText(address1);
					      s_address2.setText(address2);
					      s_address3.setText(address3);
					      
					      s_pin.setText(PIN.toString());
					      s_email.setText(emailid);
					      st.close();
				        }
				      else {
				    	  
				    	  JOptionPane.showMessageDialog(null, "Invalid School Id","Warning",JOptionPane.ERROR_MESSAGE,null);
				    	  s_id.setText(null);
					      s_name.setText(null);
					      s_ph_no.setText(null);
					      s_ph_no1.setText(null);
					      s_ph_no2.setText(null);
					      
					      s_address.setText(null);
					      s_address1.setText(null);
					      s_address2.setText(null);
					      s_address3.setText(null);
					      
					      s_pin.setText(null);
					      s_email.setText(null);
				      }
				     
				      
				}
					catch(Exception ex)
					{
					
			System.err.println("exception:");
			System.err.println(ex.getMessage());
					}
				}

				else {
					
					JOptionPane.showMessageDialog(null, "Enter Credentials","Warning",JOptionPane.ERROR_MESSAGE,null);
					s_id.setText(null);
				  
				}
			}
			
			}
}

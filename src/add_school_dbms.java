//import statement
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
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
public class add_school_dbms extends view_class implements ActionListener  {
	//variables

	static int pin;

	
	
	// frame
			JFrame frame=new JFrame("ADD SCHOOL DETAILS");
			JPanel panel =new JPanel();
			//button
			JButton add= new JButton("ADD");
			//JButton save= new JButton("SAVE");
			
			
			//label
			JLabel title=new JLabel("SCHOOL DETAILS");

			JLabel schoolid=new JLabel("SCHOOL ID");
			JLabel school_name=new JLabel("SCHOOL NAME");
			JLabel school_ph_no=new JLabel("SCHOOL PH.NO");
			JLabel school_ph_no1=new JLabel("SCHOOL PH.NO");
			JLabel school_ph_no2=new JLabel("SCHOOL PH.NO");
			
			JLabel school_address=new JLabel("SCHOOL ADDRESS 1");
			JLabel school_address1=new JLabel("SCHOOL ADDRESS 2");
			JLabel school_address2=new JLabel("SCHOOL ADDRESS 3");
			JLabel school_address3=new JLabel("SCHOOL ADDRESS 4");
			JLabel school_email=new JLabel("SCHOOL EMAIL");
			JLabel school_pin=new JLabel("SCHOOL PINCODE");
		/*	ImageIcon i1=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\school.jpg");
			JLabel l1= new JLabel(i1,JLabel.CENTER);*/
		
			
			
			//table
			JTable tabel=new JTable();
			//scroll pane
			JScrollPane pane=new JScrollPane(tabel);
			
			//text field
			 JTextField s_id=new JTextField();
			 JTextField s_name=new JTextField();
			 JTextField s_ph_no=new JTextField();
			 JTextField s_ph_no1=new JTextField("");
			 JTextField s_ph_no2=new JTextField("");
			 
			 JTextField s_address1=new JTextField();
			 JTextField s_address2=new JTextField();
			 JTextField s_address3=new JTextField();
			 JTextField s_address=new JTextField();
			 
			 JTextField s_email=new JTextField();
			 JTextField s_pin=new JTextField();
			 
			add_school_dbms() throws SQLException
			{
				 int count[]=new int[10];
				 //frame and panel settings
				frame.setSize(640,640);
				frame.setVisible(true);
			panel.setLayout(null);
			
			//set bounds label
			 title.setBounds(200,50,450,30);
		        title.setFont(new Font("",Font.BOLD,20));
		schoolid.setBounds(75,100, 150, 30);
		school_name.setBounds(75,140, 150, 30);
		school_ph_no.setBounds(75,180, 150, 30);
		school_ph_no1.setBounds(75,220, 150, 30);
		school_ph_no2.setBounds(75,260, 150, 30);
		
		school_address.setBounds(75,300, 150, 30);
		school_address1.setBounds(75,340, 150, 30);
		school_address2.setBounds(75,380, 150, 30);
		school_address3.setBounds(75,420, 150, 30);
		school_pin.setBounds(75,460, 150, 30);
		school_email.setBounds(75,500, 150, 30);
		
		
		//set bounds table
		tabel.setBounds(100,150,300,300);
		
		//set bounds text fields
		s_id.setBounds(250, 100, 150, 30);
		s_name.setBounds(250,140,150,30);
		s_ph_no.setBounds(250, 180, 150, 30);
		s_ph_no1.setBounds(250, 220, 150, 30);
		s_ph_no2.setBounds(250, 260, 150, 30);
		
		s_address.setBounds(250, 300, 150, 30);
		s_address1.setBounds(250, 340, 150, 30);
		s_address2.setBounds(250, 380, 150, 30);
		s_address3.setBounds(250, 420, 150, 30);
		s_pin.setBounds(250, 460, 200, 30);
		s_email.setBounds(250, 500, 200, 30);
		
	
		//set bounds to buttons
		add.setBounds(450,150,100,30);
		//save.setBounds(450,200,100,30);
			
			/* l1.setBounds(0,0,640,640);
				panel.add(l1);*/
			//add components to panel
			panel.add(title);
			panel.add(add);
		//	panel.add(save);
			
			
			
			
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
			panel.add(school_pin);
			panel.add(s_pin);
			
			
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
			
			panel.add(pane);
		//add panel to frame
			frame.add(panel);
			add.addActionListener(this);
		//	save.addActionListener(this);
		
			
			
			
		
			 }
			
			
			public static void main(String[] args) throws SQLException {
				 add_school_dbms v=new add_school_dbms();

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==add)
				{
					if(!s_id.getText().equals("")) {
					boolean proceed = true;
					try {
						view_class vc = new view_class();
						proceed  = vc.add_school(s_id.getText());
							
					}
					catch(Exception ex) {}
					
					if(proceed) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection(  
								"jdbc:mysql://localhost:3306/my_business","root","");  
						 // the insert statement
					      String query = " insert into school_details (s_id,s_name,s_ph_no,address,pincode,email,add1,add2,add3,ph1,ph2)"
					        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

					      // create the  insert prepared statement
					      PreparedStatement preparedStmt = con.prepareStatement(query);
					      pin=Integer.parseInt(s_pin.getText());
					      preparedStmt.setString (1, s_id.getText());
					      preparedStmt.setString (2, s_name.getText());
					      preparedStmt.setString (3, s_ph_no.getText());
					      preparedStmt.setString (4, s_address.getText());
					      preparedStmt.setInt (5, pin);
					      preparedStmt.setString (6, s_email.getText());
					      preparedStmt.setString (7, s_address1.getText());
					      preparedStmt.setString (8, s_address2.getText());
					      preparedStmt.setString (9, s_address3.getText());
					      preparedStmt.setString (10, s_ph_no1.getText());
					      preparedStmt.setString (11, s_ph_no2.getText());
					      
					      preparedStmt.execute();
					      con.close();
					      JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED","INFO",JOptionPane.INFORMATION_MESSAGE,null);
					      }
						catch(Exception ex)
						{
						
					System.err.println("exception:");
					System.err.println(ex.getMessage());
						}
				  
						}
					else
						{
						JOptionPane.showMessageDialog(null, "SCHOOL ID ALREADY EXIST","WARNING",JOptionPane.WARNING_MESSAGE,null);
						s_id.setText(null);
				
						}
				}else 
				{
					JOptionPane.showMessageDialog(null, "ENTER CREDENTIALS","WARNING",JOptionPane.WARNING_MESSAGE,null);
					s_id.setText(null);
					
				}
				
					}
			}

}


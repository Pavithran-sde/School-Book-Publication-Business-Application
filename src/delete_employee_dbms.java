

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

public class delete_employee_dbms  implements ActionListener{
	//variables
	static int id;
	static String name;
	static int ph_no;
	static int age;
	static int sal;
	
	static String gender;
	static String address;
	static String emailid;
	static int pin;
	Integer ID,PH,PIN,SAL,AGE;
	// frame
		JFrame frame=new JFrame("DELETE EMPLOYEE DETAILS");
		JPanel panel =new JPanel();
		//button
		JButton delete= new JButton("DELETE");
		JButton search= new JButton("SEARCH");
		
	
		
		//label
		JLabel title=new JLabel("EMPLOYEE DETAILS");

		JLabel 	empid=new JLabel("EMPLOYEE ID");
		JLabel emp_name=new JLabel("EMPLOYEE NAME");
		JLabel emp_ph_no=new JLabel("EMPLOYEE PH.NO");
		JLabel emp_address=new JLabel("EMPLOYEE ADDRESS");
		JLabel emp_age=new JLabel("EMPLOYEE AGE");
		JLabel emp_gender=new JLabel("EMPLOYEE GENDER");
		JLabel emp_salary=new JLabel("EMPLOYEE SALARY");
		
		
		//table
		JTable tabel=new JTable();
		//scroll pane
		JScrollPane pane=new JScrollPane(tabel);
		
		//text field
		 JTextField e_id=new JTextField();
		 JTextField e_name=new JTextField();
		 JTextField e_ph_no=new JTextField();
		 JTextField e_address=new JTextField();
		 JTextField e_age=new JTextField();
		 JTextField e_gender=new JTextField();
		 JTextField e_salary=new JTextField();
		 
		 delete_employee_dbms() throws SQLException
		{
			 //frame and panel settings
			frame.setSize(640,640);
			frame.setVisible(true);
		panel.setLayout(null);
		
		//set bounds label
	title.setBounds(100,30,250,50);
	empid.setBounds(75,100, 150, 30);
	emp_name.setBounds(75,140, 150, 30);
	emp_ph_no.setBounds(75,180, 150, 30);
	emp_address.setBounds(75,220, 150, 30);
	emp_age.setBounds(75,260, 150, 30);
	emp_gender.setBounds(75,300, 150, 30);
	emp_salary.setBounds(75,340, 150, 30);
	
	
	//set bounds table
	tabel.setBounds(100,150,300,300);
	
	//set bounds text fields
	e_id.setBounds(250, 100, 150, 30);
	e_name.setBounds(250,140,150,30);
	e_ph_no.setBounds(250, 180, 150, 30);
	e_address.setBounds(250, 220, 150, 30);
	e_age.setBounds(250, 260, 150, 30);
	e_gender.setBounds(250, 300, 150, 30);
	e_salary.setBounds(250, 340, 150, 30);
		
	//set bounds to buttons
	delete.setBounds(450,200,100,30);
	search.setBounds(450,150,100,30);
	 

		
		//add components to panel
		panel.add(title);
		panel.add(delete);
		panel.add(search);
		
		panel.add(empid);
		panel.add(emp_name);
		panel.add(emp_ph_no);
		panel.add(emp_address);
		panel.add(emp_age);
		panel.add(emp_gender);
		panel.add(emp_salary);
		
		panel.add(e_name);
		panel.add(e_id);
		panel.add(e_address);
		panel.add(e_ph_no);
		panel.add(e_age);
		panel.add(e_gender);
		panel.add(e_salary);

		panel.add(pane);
	//add panel to frame
		frame.add(panel);
		delete.addActionListener(this);
		search.addActionListener(this);
		
	
	
		}
		public static void main(String[] args) throws SQLException {
			delete_employee_dbms v=new  delete_employee_dbms();

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==delete)
			{
				JOptionPane.showMessageDialog(null, "DO YOU REALLY WANT TO EDIT THIS DETAIL","ALERT",JOptionPane.WARNING_MESSAGE,null);
			
try {
					
					
					Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				 String query = "delete from emp_details_dbms where e_id = ?";
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      id=Integer.parseInt(e_id.getText());
			      ID=id;
			      preparedStmt.setInt(1, id);

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
				      String query = "SELECT * FROM emp_details_dbms where e_id='"+e_id.getText()+"'";

				      // create the java statement
				      Statement st = con.createStatement();
				      
				      // execute the query, and get a java resultset
				      ResultSet rs = st.executeQuery(query);
				      
				      // iterate through the java resultset
				      while (rs.next())
				      {
				         id = rs.getInt("e_id");
				         ID=id;
				         name= rs.getString("e_name");
				         age= rs.getInt("e_age");
				         AGE=age;
				         gender= rs.getString("e_gender");
				         ph_no= rs.getInt("e_phno");
				         PH=ph_no;
				         address= rs.getString("e_address");
				         sal= rs.getInt("e_salary");
				         SAL=sal;
				         
				        
				        }
				      	e_id.setText(ID.toString());
				      e_name.setText(name);
				      e_age.setText(AGE.toString());
				      e_gender.setText(gender);
				      e_ph_no.setText(PH.toString());
				      e_address.setText(address);
				      e_salary.setText(SAL.toString());
				     
				      st.close();
				      
				}
					catch(Exception ex)
					{
					
			System.err.println("exception:");
			System.err.println(ex.getMessage());
					}
				
			}



			
		}
		}






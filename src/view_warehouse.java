
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
public class view_warehouse implements ActionListener {
	//variables
	static int id;
	static String add1,add2,add3,add4;
	
	
	static String ph_no,ph_no1,ph_no2,email;
	static int sto;
	Integer ID,PH,ST;
	//TABLE
	JTable tabel=new JTable();
	
	JScrollPane pane=new JScrollPane(tabel);
	//frame and panel
	JFrame frame=new JFrame("VIEW WAREHOUSE");
   JPanel panel=new JPanel();
 //JLabel
   JLabel wa_id=new JLabel("WAREHOUSE ID");
   JLabel wa_phno=new JLabel("LANDLINE NO");
   JLabel wa_phno1=new JLabel("WAREHOUSE PHNO");
   JLabel wa_phno2=new JLabel("WAREHOUSE PHNO");
  
   
   JLabel wa_loc=new JLabel("WAREHOUSE ADDRESS 1");
   JLabel wa_loc1=new JLabel(" ADDRESS 2");
   JLabel wa_loc2=new JLabel(" ADDRESS 3");
   JLabel wa_loc3=new JLabel(" ADDRESS 4");
   JLabel gst=new JLabel("GSTIN NO");
   JLabel wa_email=new JLabel("WAREHOUSE EMAIL");
   
  /* ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\warehouse.jpg");
   JLabel l1= new JLabel(i,JLabel.CENTER);*/
   
   //JTEXTFIELDS
   JTextField w_id=new JTextField();
   JTextField w_loc=new JTextField();
   JTextField w_loc1=new JTextField("");
   JTextField w_loc2=new JTextField("");
   JTextField w_loc3=new JTextField("");
   JTextField w_email=new JTextField("");
   JTextField w_phno=new JTextField("");
   JTextField w_phno1=new JTextField("");
   JTextField w_phno2=new JTextField("");

   //button
   JButton  view=new JButton("VIEW WAREHOUSE");
   
   view_warehouse()
   {
	   //setting frame and panel
	   frame.setSize(640,640);
	   frame.setVisible(true);
panel.setLayout(null);
//set bounds for
//set bounds Label
wa_id.setBounds(75,100,150,30);
wa_loc.setBounds(75,150,150,30);
wa_loc1.setBounds(75,200,150,30);
wa_loc2.setBounds(75,250,150,30);
wa_loc3.setBounds(75,300,150,30);
wa_phno.setBounds(75,350,150,30);
wa_phno1.setBounds(75,400,150,30);
wa_phno2.setBounds(75,450,150,30);
wa_email.setBounds(75,500,150,30);

//set bounds textfield
w_id.setBounds(260,100,150,30);
w_loc.setBounds(260,150,150,30);
w_loc1.setBounds(260,200,150,30);
w_loc2.setBounds(260,250,150,30);
w_loc3.setBounds(260,300,150,30);
w_loc.setEditable(false);
w_loc1.setEditable(false);
w_loc2.setEditable(false);
w_loc3.setEditable(false);
w_phno.setBounds(260,350,150,30);
w_phno1.setBounds(260,400,150,30);
w_phno2.setBounds(260,450,150,30);
w_phno1.setEditable(false);
w_phno2.setEditable(false);

w_phno.setEditable(false);
w_email.setBounds(260,500,150,30);
w_email.setEditable(false);

//set bounds buttons
view.setBounds(450,150,150,30);
/*l1.setBounds(0,0,640,640);
	panel.add(l1);*/

//add components to panel
panel.add(view);
panel.add(wa_id);
panel.add(wa_loc);
panel.add(wa_loc1);
panel.add(wa_loc2);
panel.add(wa_loc3);


panel.add(wa_phno);
panel.add(wa_phno1);
panel.add(wa_phno2);

panel.add(wa_email);

panel.add(w_id);
panel.add(w_loc);
panel.add(w_loc1);
panel.add(w_loc2);

panel.add(w_loc3);


panel.add(w_phno);
panel.add(w_phno1);
panel.add(w_phno2);

panel.add(w_email);

//add panel to frame
frame.add(panel);
view.addActionListener(this);
   }
	
   public static void main(String[] args){
	   view_warehouse v=new view_warehouse();
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==view)
		{
			if(!w_id.getText().equals("")) {

try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				// our SQL SELECT query. 
			      // if you only need a few columns, specify them by name instead of using "*"
			      String query = "SELECT * FROM ware_house where w_id='"+w_id.getText()+"'";

			      // create the java statement
			      Statement st = con.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs = st.executeQuery(query);
			      
			      // iterate through the java resultset
			      if (rs.next())
			      {
			         id= rs.getInt("w_id");
			         ID=id;
			         add1= rs.getString("w_location");
			         add2= rs.getString("w_location1");
			         add3= rs.getString("w_location2");
			         add4= rs.getString("w_location3");
			         
			         email= rs.getString("w_email");
			         ph_no = rs.getString("w_phno");
			         ph_no1 = rs.getString("w_phno1");
			         ph_no2 = rs.getString("w_phno2");
			         
			     	w_id.setText(ID.toString());
				      w_loc.setText(add1);
				      w_loc1.setText(add2);
				      w_loc2.setText(add3);
				      w_loc3.setText(add4);
				      w_phno.setText(ph_no);
				      w_phno1.setText(ph_no1);
				      w_phno2.setText(ph_no2);
				      w_email.setText(email);
				      st.close();
			        
			        }
			      else {
			    	  
			    	  JOptionPane.showMessageDialog(null, "Invalid Warehouse Id","Warning",JOptionPane.ERROR_MESSAGE,null);
			    	  w_id.setText(null);
				      w_loc.setText(null);
				      w_loc1.setText(null);
				      w_loc2.setText(null);
				      w_loc3.setText(null);
				      w_phno.setText(null);
				      w_phno1.setText(null);
				      w_phno2.setText(null);
				      w_email.setText(null);
			      }
			      
			     
}catch(Exception e1)
			{
				System.err.println("exception:");
				System.err.println(e1.getMessage());
			}

			}
			else {
				
				JOptionPane.showMessageDialog(null, "Enter Credentials","Warning",JOptionPane.ERROR_MESSAGE,null);
				w_id.setText(null);
			}
		}
		}
	}


		
	




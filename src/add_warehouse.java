import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class add_warehouse implements ActionListener {
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
		JFrame frame=new JFrame("ADD WAREHOUSE");
	   JPanel panel=new JPanel();
	 //JLabel
	   JLabel wa_id=new JLabel("WAREHOUSE ID");
	   JLabel wa_phno=new JLabel("LANDLINE NO");
	   JLabel wa_phno1=new JLabel("WAREHOUSE PHNO");
	   JLabel wa_phno2=new JLabel("WAREHOUSE PHNO");
	  
	   
	   JLabel wa_loc=new JLabel("WAREHOUSE ADDRESS 1");
	   JLabel wa_loc1=new JLabel(" ADDRESS 2");
	   JLabel wa_loc2=new JLabel(" ADDRESS 3");
	   JLabel wa_loc3=new JLabel(" PINCODE");
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
	   JButton  add=new JButton("ADD WAREHOUSE");
	   
	   add_warehouse()
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
	//w_loc.setEditable(false);
	//w_loc1.setEditable(false);
	//w_loc2.setEditable(false);
	//w_loc3.setEditable(false);
	w_phno.setBounds(260,350,150,30);
	w_phno1.setBounds(260,400,150,30);
	w_phno2.setBounds(260,450,150,30);
	//w_phno1.setEditable(false);
	//w_phno2.setEditable(false);

	//w_phno.setEditable(false);
	w_email.setBounds(260,500,150,30);
	//w_email.setEditable(false);

	//set bounds buttons
	add.setBounds(450,150,150,30);
	/*l1.setBounds(0,0,640,640);
		panel.add(l1);*/

	//add components to panel
	panel.add(add);
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
	add.addActionListener(this);
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add_warehouse a=new add_warehouse();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add)
		{
			if(!w_id.getText().equals("")) {
				boolean proceed = true;
				try {
					view_class vc = new view_class();
					proceed  = vc.add_warehouse(w_id.getText());
						
				}
				catch(Exception ex) {}
				
				if(proceed) {
		
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/my_business","root","");  
	 // the insert statement
      String query = " insert into ware_house (w_phno,w_location,w_email,w_id,w_phno1,w_phno2,w_location1,w_location2,w_location3)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

      // create the  insert prepared statement
      PreparedStatement preparedStmt = con.prepareStatement(query);
      
      preparedStmt.setString (1,  w_phno.getText());
      preparedStmt.setString (2, w_loc.getText());
      preparedStmt.setString (3, w_email.getText());
      preparedStmt.setString (4,w_id.getText());
     preparedStmt.setString (5,  w_phno1.getText());
      preparedStmt.setString (6,  w_phno2.getText());
      preparedStmt.setString (7, w_loc1.getText());
      preparedStmt.setString (8, w_loc2.getText());
      preparedStmt.setString (9, w_loc3.getText());
      
      preparedStmt.execute();
      con.close();
      JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED","INFO",JOptionPane.INFORMATION_MESSAGE,null);
			     
}catch(Exception e1)
			{
				System.err.println("exception:");
				System.err.println(e1.getMessage());
			}

			}
				else {
					
					JOptionPane.showMessageDialog(null, "WAREHOUSE ID ALREADY EXIST","WARNING",JOptionPane.WARNING_MESSAGE,null);
					w_id.setText(null);
				
					
				}
			}
				else 
				{
					JOptionPane.showMessageDialog(null, "ENTER CREDENTIALS","WARNING",JOptionPane.WARNING_MESSAGE,null);
					w_id.setText(null);
					
					
				}
				
			
		}
}
}


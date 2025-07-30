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
import javax.swing.JTextField;
public class pack_dbms implements ActionListener{
	static String id1,id2,vmot,vs;
	static int qty,nb,pc;
	Integer NB,PC;
	//variables
	static int quantity;
	static int m,tot=0;
	//variables
	static int id;
	static String name;
	static String x;
	static String b;
	
	static int ph_no;
	static int sto;
	Integer PH,ST;
	String VS,a;
	
	static String school;
	
	
	Integer ID,QTY,NO;
	//JFrame and JPanel
		JFrame frame= new JFrame("PACKING");
		JPanel panel=new JPanel();

		//JButton
		JButton pack=new JButton("PACK BOOKS");
		
		
		
		//label
		JLabel pack_id=new JLabel("PACKING ID");
		JLabel order_id=new JLabel("ORDER ID");
		JLabel school_id=new JLabel("SCHOOL ID");
		JLabel nob=new JLabel("NO OF BUNDELS");
		JLabel pack_charge=new JLabel("PACKING CHARGE");
		JLabel mode_of_trans=new JLabel("MODE OF TRANSPORT");
		JLabel status=new JLabel("ORDER STATUS");
		JLabel lrd=new JLabel("L R DATE");
		JLabel lrn=new JLabel("L R NO ");
		JLabel dest=new JLabel("DESTINATION");
		
		//TEXT FIELD
		JTextField p_id=new JTextField();
		JTextField o_id=new JTextField();
		JTextField s_id=new JTextField();
		JTextField nobt=new JTextField();
		JTextField p_charge=new JTextField();
		JTextField mot=new JTextField();
		JTextField s=new JTextField();
		JTextField lrdate=new JTextField();
		JTextField lrno=new JTextField();
		JTextField destination=new JTextField();
		
		
		/*ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\package.jpg");
		JLabel l1= new JLabel(i,JLabel.CENTER);*/
	
		
		pack_dbms()
		{
			//setting frame and panel
		frame.setSize(640,640);
		frame.setVisible(true);
		panel.setLayout(null);
		
		//SET BOUNDS buttons
	     pack.setBounds(450,450,150,30);
	     
	     
	     //setBounds Jlabel
	     pack_id.setBounds(15, 100, 175, 30);
	     lrd.setBounds(300, 100, 150, 30);
	     lrn.setBounds(300, 150, 150, 30);
	     dest.setBounds(300, 200, 150, 30);
	     
	     order_id.setBounds(15, 150, 150, 30);
	     school_id.setBounds(15, 200, 150, 30);
	     nob.setBounds(15, 250, 150, 30);
	     pack_charge.setBounds(15, 300, 175, 30);
	     mode_of_trans.setBounds(15, 350, 175, 30);
	     status.setBounds(15, 400, 175, 30);
	     
	      //text fields setbounds
	     p_id.setBounds(175,100,100,30);
	     o_id.setBounds(175,150,100,30);
	     s_id.setBounds(175,200,100,30);
	     s_id.setEditable(false);
	     nobt.setBounds(175,250,100,30);
	     p_charge.setBounds(175,300,100,30);
	     mot.setBounds(175,350,200,30);
	     s.setBounds(175,400,100,30);
	     s.setEditable(false);
	     lrdate.setBounds(400, 100, 150, 30);
	     lrno.setBounds(400, 150, 150, 30);
	     destination.setBounds(400, 200, 150, 30);
	    /*l1.setBounds(0,0,640,640);
			panel.add(l1);*/
	     //add to panel
	     panel.add(pack);
	     panel.add(pack_id);
	     panel.add(pack_charge);
	     panel.add(order_id);
	     panel.add(o_id);
	     panel.add(p_id);
	     panel.add(school_id);
	     panel.add(s_id);
	     panel.add(p_charge);
	     panel.add(status);
	     panel.add(s);
		 panel.add(nob);
		 panel.add(nobt);
		 panel.add(mode_of_trans);
		 panel.add(mot);
		 panel.add(lrd);
		 panel.add(lrn);
		 panel.add(dest);
		 panel.add(lrno);
		 panel.add(lrdate);
		 panel.add(destination);
		 
		 
		 
	     //add panel to frame
	     frame.add(panel);
	     pack.addActionListener(this);
	     
	     
	     }
		
	
	public static void main(String[] args) {
		
		pack_dbms pa=new pack_dbms();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pack)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con1=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				// our SQL SELECT query. 
			      // if you only need a few columns, specify them by name instead of using "*"
			      String query1 = "SELECT * FROM order_detail where order_id='"+o_id.getText()+"'";

			      // create the java statement
			      Statement st1 = con1.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs1 = st1.executeQuery(query1);
			      
			      // iterate through the java resultset
			      while (rs1.next())
			      {
			         id1 = rs1.getString("order_id");
			         id2= rs1.getString("s_id");
			         vs= rs1.getString("order_status");
			      VS=vs;
			      }
			      o_id.setText(id1);
			      s_id.setText(id2);
			      s.setText(vs);
			     System.out.println("vs="+VS);
			     a="yes";
			    
			   System.out.println("processed");

 JOptionPane.showMessageDialog(null, "SUCCESSFULLY PACKED","INFO",JOptionPane.INFORMATION_MESSAGE,null);
 Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/my_business","root","");  
	 // the insert statement
   String query = " insert into pack_Db (p_id,s_id,o_id,nob,pc,mot,lrdate,lrno,dest)"
     + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

   // create the  insert prepared statement
   PreparedStatement preparedStmt = con.prepareStatement(query);
   nb=Integer.parseInt(nobt.getText());
   pc=Integer.parseInt(p_charge.getText());
   
 
	     
   System.out.println("nob="+nb);
  System.out.println("pc="+pc);
  
   preparedStmt.setString (1, p_id.getText());
   preparedStmt.setString (2, s_id.getText());
   preparedStmt.setString (3, o_id.getText());
   preparedStmt.setInt(4,nb );
   preparedStmt.setInt (5,pc );
   preparedStmt.setString (6, mot.getText());
   preparedStmt.setString (7, lrdate.getText());
   preparedStmt.setString (8, lrno.getText());
   preparedStmt.setString (9, destination.getText());
   
   preparedStmt.execute();
  con.close();
 st1.close();
			     
			      }
			   
			
				catch(Exception ex)
				{
				
		System.err.println("exception:");
		System.err.println(ex.getMessage());
				}
			}
			

	}

}


//import statement
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.SystemUtils;

import net.proteanit.sql.DbUtils;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;

public class payment_dbms  implements ActionListener{
	
	
	static String id1,id2,id5,m_id,lrdate,lrno,dest;
	static int price,pc,qty,pri,totals;
static long t;
Integer search_pin,search_pack_charge,search_total,search_discount,search_book_charge,search_sph;
String search_s_id,search_s_name,search_sadd,search_email,search_p_id,search_mot,search_in_no,search_o_id,search_date;
	Long T;
	Integer TO,TOTALS;
	Integer PC,P;
	
	static String name,id3,id4;
	static String ph_no,ph_no1,ph_no2;
	static String address,address1,address2,address3;
	static String emailid;
	static int pin,nob;
	Integer ID,PH,PIN,TOT;
	//variables
	static int quantity;
	static int m,tot=0;
	//variables
	
	static String mot1;
	static String b;
	

	static int boc;
	Integer Q,ST,d,tb,pack,to;
	String VS,a,SID;
	
	static String school;
	
	
	Integer QTY,NO;
	//JFrame and JPanel
		JFrame frame= new JFrame("PAYMENT");
		JPanel panel=new JPanel();

		//JButton
		JButton gen=new JButton("GENERATE");
		JButton save=new JButton("SAVE");
		JButton search=new JButton("SEARCH");
		JButton print=new JButton("PRINT");
		
		
		
		//label
		JLabel pack_id=new JLabel("PACKING ID :");
		JLabel s_id=new JLabel("SCHOOL ID :");
		JLabel s_name=new JLabel("SCHOOL NAME :");
        JLabel s_add=new JLabel("ADDRESS :");
        JLabel s_pin=new JLabel("PINCODE :");
        JLabel s_email=new JLabel("EMAIL :");
        JLabel s_phno=new JLabel("PHONE NUMBER :");
        JLabel mot=new JLabel("MODE OF TRANSPORT :");
        JLabel oid=new JLabel("ORDER ID :");
        JLabel total=new JLabel("TOTAL CHARGES :");
        JLabel pac=new JLabel("PACKING CHARGES:");
        JLabel in_no=new JLabel("INVOICE NUMBER :");
        JLabel book_charge=new JLabel("BOOK CHARGES :");
        JLabel dis=new JLabel("DISCOUNT :");
        JLabel date=new JLabel("DATE :");
        JLabel sta=new JLabel("STATUS :");
      /*  ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\payment.jpg");
        JLabel l1= new JLabel(i,JLabel.CENTER);*/
      
        
        
         // AFTER COLLON
 
        JLabel sid=new JLabel("  ");
       // JLabel s;
        
        JLabel sname=new JLabel("  ");
        JLabel sadd=new JLabel( "  ");
        JLabel spin=new JLabel("  ");
        JLabel o_id=new JLabel("   ");
        JLabel email=new JLabel("  ");
        JLabel sph=new JLabel("  ");
        JLabel motr=new JLabel("  ");
        
        //JTextfield
        JTextField school_id=new JTextField();
        JTextField p_id=new JTextField();
        JTextField s=new JTextField();
        
        JTextField pack_ch=new JTextField();
        JTextField tott=new JTextField();
        JTextField discount=new JTextField();
        JTextField invoice=new JTextField();
        JTextField dates=new JTextField();
        JTextField bc=new JTextField();
payment_dbms()
		{
			//setting frame and panel
		frame.setSize(640,640);
		frame.setVisible(true);
		panel.setLayout(null);
		
		//SET BOUNDS buttons
	  
	gen.setBounds(50,500,120,30);
	save.setBounds(190,500,100,30);
	search.setBounds(300,500,100,30);
	print.setBounds(430, 500, 120, 30);
	     
	     //setBounds Jlabel
	     //invoice
	     in_no.setBounds(50, 50, 120, 20);
	     invoice.setBounds(180,50,120,20);
	     pack_id.setBounds(50, 80, 150, 20);
	     p_id.setBounds(180,80,120,20);
	     date.setBounds(380,50, 50, 30);
	     dates.setBounds(440, 50,100, 30);
	     sta.setBounds(380,90, 110, 30);
	     s.setBounds(440, 90,100, 30);
	     mot.setBounds(50, 450, 200, 30);
         motr.setBounds(200, 450, 175, 30);

	 	//order details
		    oid.setBounds(360, 150, 125, 30);//l
		     o_id.setBounds(500, 150, 125, 30);//r
		 
	    //school details
	     sid.setBounds(150, 150, 175, 20);
	     sname.setBounds(150, 180, 175, 20);
	     sadd.setBounds(150, 210, 175,20);
	     spin.setBounds(150, 240, 175, 20);
	     sph.setBounds(200, 270, 175, 20);
	     email.setBounds(150, 300, 175, 20);
/* ******************************************************************************************************************************* */	     
		/////////////////////left
	    s_id.setBounds(50, 150, 175, 20);
	     s_name.setBounds(50, 180, 175, 20);
	     s_add.setBounds(50, 210, 175,20);
	     s_pin.setBounds(50, 240, 175, 20);
	     s_phno.setBounds(50, 270, 175, 20);
	     s_email.setBounds(50, 300, 175, 20);
/* *********************************************************************************************************************************** */		    
	     //package
	     //amount
	     
	     book_charge.setBounds(360, 260, 120, 30);
	     bc.setBounds(500, 260, 100, 30);
	     total.setBounds(360, 380, 120, 30);
	     tott.setBounds(500, 380, 100, 30);
		 pac.setBounds(360,300, 140, 30);
		 pack_ch.setBounds(500,300, 100, 30);
		 dis.setBounds(360,340, 120, 30);
		 discount.setBounds(500,340, 100, 30);
  
		 //text fields setbounds
		/*  l1.setBounds(0,0,640,640);
       	panel.add(l1);
//add to panel*/
	     
	     panel.add(save);
	     panel.add(search);
	     panel.add(gen);
	     panel.add(in_no);
	     panel.add(invoice);
	     panel.add(date);
	     panel.add(dates);
	     panel.add(pack_id);
	     panel.add(p_id);
	     panel.add(print);
	     
	 
	     
	     panel.add(book_charge);
	     panel.add(bc);
	     panel.add(motr);
	     panel.add(mot);
	     
	     panel.add(sta);
	     panel.add(s);
	     panel.add(oid);
	     panel.add(o_id);
	     panel.add(sid);
		 panel.add(sname);
		 panel.add(sadd);
		 panel.add(spin);
		 panel.add(sph);
		 panel.add(email);
		 panel.add(s_id);
     	 panel.add(s_name);
		 panel.add(s_add);
         panel.add(s_pin);
		 panel.add(s_phno);
		 panel.add(s_email);
		 panel.add(total);
		 panel.add(pac);
		 panel.add(pack_ch);
		 panel.add(dis);
		 panel.add(tott);
		 panel.add(discount);
		 panel.add(date);
		 panel.add(dates);
		 panel.add(invoice);
         frame.add(panel);
         gen.addActionListener(this);
	     save.addActionListener(this);
	     search.addActionListener(this);
	     print.addActionListener(this);
	     
	     
	     }
		
	
	public static void main(String[] args) {
		
		payment_dbms pa=new payment_dbms();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==gen)
		{
			
		try {
			/// fetch s_id and o_id
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM pack_Db where p_id='"+p_id.getText()+"'";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		         id1 = rs.getString("p_id");
		         id2= rs.getString("s_id");
		         SID=id2;
		         id3= rs.getString("o_id");
		         pc= rs.getInt("pc");
		        PC=pc;
		        mot1=rs.getString("mot");
		        lrno=rs.getString("lrno");
		        lrdate=rs.getString("lrdate");
		        dest=rs.getString("dest");
		       nob= rs.getInt("nob");
		        
		        
		        
}
              o_id.setText(id3);
		      sid.setText(id2);
		      motr.setText(mot1);
		      pack_ch.setText(PC.toString());
        System.out.println("s_id"+SID);
        System.out.println("1st completed");

		      /// view school details
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query1 = "SELECT * FROM school_details where s_id='"+SID+"'";

		      // create the java statement
		      Statement st1 = con1.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs1 = st1.executeQuery(query1);
		      
		      // iterate through the java resultset
		      while (rs1.next())
		      {
		         id4 = rs1.getString("s_id");
		         name= rs1.getString("s_name");
		         ph_no= rs1.getString("s_ph_no");
		         ph_no1= rs1.getString("ph1");
		         ph_no2= rs1.getString("ph2");
			     address= rs1.getString("address");
			     address1= rs1.getString("add1");
			     address2= rs1.getString("add2");
			     address3= rs1.getString("add3");
		         
			     pin= rs1.getInt("pincode");
		         PIN=pin;
		         emailid= rs1.getString("email");
		        
		        }
		      //sid.setText(id4);
		      sname.setText(name);
		      sph.setText(ph_no);
		      sadd.setText(address);
		      spin.setText(PIN.toString());
		      email.setText(emailid);
		      
		      System.out.println("2st completed");

		      
		      
		      Class.forName("com.mysql.jdbc.Driver");
				Connection con2=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				// our SQL SELECT query. 
			      // if you only need a few columns, specify them by name instead of using "*"
			      String query2 = "select * from order_detail where order_id='"+o_id.getText()+"'";

			      // create the java statement
			      Statement st2 = con2.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs2 = st2.executeQuery(query2);
			      
			      // iterate through the java resultset
			      while (rs2.next())
			      {
			    id5= rs2.getString("s_id");
			    b= rs2.getString("order_status");
			    
			  m_id=id5;
			      }
			      System.out.println("status"+b);
			      s.setText(b);
		      System.out.println(m_id);
		       new v_o(m_id,o_id.getText());
		      
		       System.out.println("3rd completed");
			      
		       
		
		       
		       
		       
		       Class.forName("com.mysql.jdbc.Driver");
				Connection con5=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				 // the select statement
				
				String query5 = "select * from order_tot where o_id='"+o_id.getText()+"'";

			      // create the java statement
			      Statement st5 = con5.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs5 = st5.executeQuery(query5);
			      
			      // iterate through the java resultset
			      while (rs5.next())
			      {
			    pri=rs5.getInt("tot");
			   price=pri;
			   P=price;
			      }
			      System.out.println("4th completed");
 // total calculation
			      bc.setText(P.toString());
			      System.out.println(P);
		       d=Integer.parseInt(discount.getText());
		       System.out.println(d);
		       System.out.println(pc);
                 to=((price)*d)/100;
                 totals=price-to+pc;
                 TOTALS=totals;
              System.out.println("total "+TOTALS);
              tott.setText(TOTALS.toString());
			      if(invoice!=null&&date!=null)
		       {
		       Class.forName("com.mysql.jdbc.Driver");
				Connection con3=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				 // the insert statement
			      String query3 = " insert into  order_payment(p_id,s_id,discount,in_no,total,date,o_id,book_charge)"
			        + " values ( ?, ?, ?, ?, ?, ?, ?, ?)";

			      // create the  insert prepared statement
			      PreparedStatement preparedStmt3 = con3.prepareStatement(query3);
			    
			  
			     
			    		  System.out.println("inserting into table");
			      preparedStmt3.setString (1, p_id.getText());
		          System.out.println("1");
			      preparedStmt3.setString (2, sid.getText());
			      System.out.println("2");
			      preparedStmt3.setInt (3, d);
			      System.out.println("3");
			      preparedStmt3.setString (4, invoice.getText());
			      System.out.println("4");
			      preparedStmt3.setInt (5, TOTALS);
			      System.out.println("5");
			      preparedStmt3.setString (6, dates.getText());
			      System.out.println("6");
			      preparedStmt3.setString (7, o_id.getText());
			      System.out.println("7");
			      preparedStmt3.setInt (8,P);
			      System.out.println("8");
			      preparedStmt3.execute();
			      con3.close();
			      JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED","INFO",JOptionPane.INFORMATION_MESSAGE,null);
			      System.out.println("5th completed");

		       }
			      con5.close(); 
			      st.close();
		       st1.close();
		       st2.close();
		       //st4.close();
		   	
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con12=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			 // the insert statement
		      String query12 =  " insert into search_details (s_id,o_id,p_id,in_no,date)"
				        + " values (?, ?, ?, ?, ?)";

		      // create the  insert prepared statement
		      PreparedStatement preparedStmt12 = con12.prepareStatement(query12);
		     
		 
		     preparedStmt12.setString (1, sid.getText());
		     preparedStmt12.setString (2, o_id.getText());
		     preparedStmt12.setString (3,p_id.getText());
		     preparedStmt12.setString (4, invoice.getText());
		     preparedStmt12.setString(5,dates.getText());
		     con12.close(); 
		     
				
			}
			catch(Exception ex)
			{
			System.out.println("search_details.");
		System.err.println("exception:");
		System.err.println(ex.getMessage());
			}
		
		
try {
	System.out.println("printing");
	
	new trails(invoice.getText(),o_id.getText(),address,address1,address2,address3,sid.getText(),dates.getText(),lrdate,lrno,dest,motr.getText(),nob,P,d,totals,pc);
}catch(Exception ex)
{
	System.out.println("exception while printing");
	System.out.println(ex);
}
	
	
	

	}else if(e.getSource()==save)
	{
	try {
		 JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED","INFO",JOptionPane.INFORMATION_MESSAGE,null);
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
	}
	else if(e.getSource()==search)
	{
		try {
		 Class.forName("com.mysql.jdbc.Driver");
			Connection con5=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			 // the select statement
			
			String query5 = "select * from  order_payment where in_no='"+in_no.getText()+"' ";

		      // create the java statement
		      Statement st5 = con5.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs5 = st5.executeQuery(query5);
		      
		      // iterate through the java resultset
		      while (rs5.next())
		      {
		   search_s_id=rs5.getString("s_id");
		   search_s_name=rs5.getString("s_name");
		   search_sph=rs5.getInt("s_ph_no");
		   search_sadd=rs5.getString("address");
		   search_pin=rs5.getInt("pincode");
		   search_email=rs5.getString("email");
		   search_p_id=rs5.getString("pid");
		   search_mot=rs5.getString("mot");
		   search_pack_charge=rs5.getInt("pc");
		   search_discount=rs5.getInt("discount");
		  search_total=rs5.getInt("total");
		  search_in_no=rs5.getString("in_no");
		  search_date=rs5.getString("date");
		  search_o_id=rs5.getString("o_id");
	       search_book_charge=rs5.getInt("book_charge");
		}
		      s_id.setText(search_s_id);
		      s_name.setText(search_s_name);
		      sph.setText(search_sph.toString());
		      sadd.setText(search_sadd);
		      spin.setText(search_pin.toString());
		      email.setText(search_email);
		      p_id.setText(search_p_id);
		      motr.setText(search_mot);
		      pack_ch.setText(search_pack_charge.toString());
		      discount.setText(search_discount.toString());
		      total.setText(search_total.toString());
		      dates.setText(search_date);
              o_id.setText(search_o_id);
              bc.setText(search_book_charge.toString());
st5.close();
		      
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
		 try {     
			 
		      Class.forName("com.mysql.jdbc.Driver");
				Connection con2=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/my_business","root","");  
				// our SQL SELECT query. 
			      // if you only need a few columns, specify them by name instead of using "*"
			      String query2 = "select * from order_detail where order_id='"+o_id.getText()+"'";

			      // create the java statement
			      Statement st2 = con2.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs2 = st2.executeQuery(query2);
			      
			      // iterate through the java resultset
			      while (rs2.next())
			      {
			    id5= rs2.getString("s_id");
			    b= rs2.getString("order_status");
			    
			  m_id=id5;
			      }
			      
		      System.out.println(m_id);
		       new v_o(m_id,o_id.getText());
			 st2.close();
			 
		 }catch(Exception ex)
			{
				System.err.println("exception:");
				System.err.println(ex.getMessage());
			}
		
		
	}
	else if(e.getSource()==print)
	{
	try {
			
		
		}catch(Exception ex)
		{
			System.err.println("exception:");
			System.err.println(ex.getMessage());
		}
	}
		}
	
}


//import statement
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class admin extends JFrame implements ActionListener  {
	  static int ID;
	 // labels
	 JLabel user=new JLabel("user");
	 JLabel pass=new JLabel("Password");
	 JLabel id=new JLabel("ID");
	 //title label
	 JLabel title=new JLabel("ADMIN AUTHENTICATION");
	 //button
	 JButton login= new JButton("LOGIN");
	 JButton reset= new JButton("RESET");
	 JButton back= new JButton("BACK");
	 
	/* ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\admin.jpg");
	 JLabel l1= new JLabel(i,JLabel.CENTER);*/

	 
	 //text field
	 JTextField usr=new JTextField();
	 JPasswordField passcode =new JPasswordField();
	 JPasswordField regno =new JPasswordField();
	 
	 //frame and panel 
	 JFrame frame=new JFrame("ADMINISTRATOR");
	  JPanel panel=new JPanel();
	 admin()
	 {//frame
		 frame.setSize(640,640);
		 frame.setLocationRelativeTo(null);
		 
		 //user
		 id.setBounds(100, 150, 150,30 );
		 id.setFont(new Font("",Font.BOLD,16));
		 regno.setBounds(260,150,150,30);
		 user.setBounds(100,200,150,30);
		 user.setFont(new Font("User Name",Font.BOLD,16));
		 usr.setBounds(260, 200, 150, 30);
		 //password
		 pass.setBounds(100,250,150,30);
		 pass.setFont(new Font("Password",Font.BOLD,16));
		 passcode.setBounds(260, 250, 150, 30);
		 
//title
		 title.setBounds(150,50,400,50);
		 title.setFont(new Font("ADMIN AUTHENTICATION",Font.BOLD,22));
		 //buttons set bounds
		 login.setBounds(100,350,150,30);
		 reset.setBounds(275,350,150,30);
		 back.setBounds(475,500,100,30);
		 /* l1.setBounds(0,0,640,640);
		 	panel.add(l1);*/
		 //ADD COMPONENTS TO PANEL
		 panel.add(user);
		 panel.add(usr);
		 panel.add(pass);
		 panel.add(passcode);
		 panel.add(title);
		 panel.add(login);
		 panel.add(reset);
		 panel.add(back);
		 panel.add(id);
		 panel.add(regno);
		 
		 
		//add panel to frame
		 frame.add(panel);
		 //set panel layout
		 panel.setLayout(null); 
		 login.addActionListener(this);
		 reset.addActionListener(this);
		 back.addActionListener(this);
		 frame.setVisible(true);
	 }
	 
	 public static void main(String[] args) {
		//admin a=new admin();
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login) {
			if(!usr.getText().equals("") || !passcode.getText().equals("") || (!usr.getText().equals("") && !passcode.getText().equals("")) )
			{
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "select * from admin_login where uid='"+regno.getText()+"' and uname='"+usr.getText()+"' and upass='"+passcode.getText()+"'";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
				if(rs.next())
				{String reg=(regno.getText());
                 //ID=Integer.parseInt(reg);*/
                 
			        frame.dispose();
			        JOptionPane.showMessageDialog(null, "LOGGED IN AS ADMIN","Welcome",JOptionPane.INFORMATION_MESSAGE,null);
                     new ADMIN_FIRST_DBMS();
                    
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Credentials","Warning",JOptionPane.ERROR_MESSAGE,null);
					regno.setText(null);
					usr.setText(null);
					passcode.setText(null);
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
				regno.setText(null);
				usr.setText(null);
				passcode.setText(null);
			}
		}
			else if(e.getSource()==reset) {
				regno.setText(null);
			usr.setText(null);
			passcode.setText(null);
			}
			else if(e.getSource()==back)
			{
			 new first_opening();	
			 frame.dispose();
}

		
	}

}

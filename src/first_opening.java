
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
public class first_opening extends JFrame implements ActionListener{
	
	//frame and panel
	JFrame frame=new JFrame("BOOK PUBLICATION MANAGEMENT");
	JPanel panel =new JPanel();
	
	//labels
	JLabel welcome= new JLabel("WELCOME");
	JLabel choose= new JLabel("SELECT THE AUTHORITY OF YOURS");

	//buttons
	JButton admin=new JButton("ADMIN");
	JButton employee=new JButton("EMPLOYEE");
	
	first_opening()
	{
		//frame setting
		frame.setSize(640,640);
		frame.setVisible(true);
		//panel settings
		panel.setLayout(null);
       //set bounds labels
		welcome.setBounds(220,50,200,30);
	    welcome.setFont(new Font("WELCOME",Font.BOLD,20));
		choose.setBounds(150,110,400,30);
		choose.setFont(new Font("user",Font.BOLD,18)); 
		
	
	//set bounds buttons
	admin.setBounds(220,200,150,30);
	employee.setBounds(220,300,150,30);
	//add components to panel
	panel.add(welcome);
	panel.add(choose);
	panel.add(admin);
	panel.add(employee);
	//add panel to frame
	frame.add(panel);
	admin.addActionListener(this);
	employee.addActionListener(this);
	
	}
	public static void main(String[] args) {
		
		first_opening fo=new first_opening();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==admin)
		{
			 new admin();
			 frame.dispose();
		}
		else if(e.getSource()==employee)
		{
			new emp_dbms();
			frame.dispose();
			
		}
	}

}

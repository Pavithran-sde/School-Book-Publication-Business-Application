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
public class s2_dbms extends JFrame implements ActionListener {
	//frame and panel
			JFrame frame=new JFrame("SCHOOL MANAGEMENT");
			JPanel panel = new JPanel();
			//labels
			JLabel title=new JLabel("Select the Operation");
			
			//buttons
			JButton view=new JButton("VIEW  SCHOOL DETAILS");
			JButton add=new JButton("ADD SCHOOL DETAILS");
			JButton back=new JButton("BACK");
		
			
			s2_dbms()
			{ //FRAME AND PANEL SETTINGS
				frame.setSize(640,640);
				frame.setVisible(true);
		        panel.setLayout(null);		
			//set bounds label
		        title.setBounds(200,50,450,30);
		        title.setFont(new Font("",Font.BOLD,22));
		        //set bounds buttons
		        view.setBounds(200,130,200, 30);
				add.setBounds(200,180,200, 30);
				back.setBounds(450,450,120, 30);
			
			
			
			
			
			//add components to panel
		
			
			panel.add(view);
			panel.add(add);
			panel.add(back);
			panel.add(title);

			//add panel to frame
			frame.add(panel);
			//ADDING TO  ACTION LISTENER
			view.addActionListener(this);
			add.addActionListener(this);
			back.addActionListener(this);
			}
			
			
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==view)
			{
				 try {
					new view_school_dbms();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource()==add)
			{
				try {
					new add_school_dbms();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource()==back)
			{
				new EMP_FIRST_DBMS();
				frame.dispose();
			}
			
		}
}

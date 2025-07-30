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

public class EMP_FIRST_DBMS extends JFrame implements ActionListener{
	//frame and panel
	JFrame frame=new JFrame("EMPLOYEE ENTITY");
	JPanel panel = new JPanel();
	//labels
	JLabel title=new JLabel("Select the Entity");
	//JLabel l2=new JLabel("choose the entity you want to visit");
	//JLabel l=new JLabel("choose the entity you want to visit");

	//buttons
	JButton school=new JButton("SCHOOL MANAGEMENT");
	JButton warehouse=new JButton("WARE HOUSE AND STOCKS");
	JButton order=new JButton("ORDER");
	JButton pack=new JButton("PACKAGE");
	JButton back=new JButton("BACK");
	ImageIcon i=new ImageIcon("C:\\Users\\Pavithran.M\\Desktop\\employee.jpg");
	JLabel l1= new JLabel(i,JLabel.CENTER);

	
	
	EMP_FIRST_DBMS()
	{ //FRAME AND PANEL SETTINGS
		frame.setSize(640,640);
		frame.setVisible(true);
        panel.setLayout(null);		
	//set bounds label
        title.setBounds(210,50,450,30);
        title.setFont(new Font("",Font.BOLD,22));
     //set bounds buttons
	school.setBounds(205,140,200, 30);
	warehouse.setBounds(205,190,200, 30);
	pack.setBounds(205,240,200, 30);
	back.setBounds(450,490,100,30);
	order.setBounds(205,290,200,30);
	
	/* l1.setBounds(0,0,640,640);
		panel.add(l1);*/
	//add components to panel
	panel.add(school);
	panel.add(warehouse);
	panel.add(pack);
     panel.add(title);
	panel.add(order);
	panel.add(back);

	//add panel to frame
	frame.add(panel);
	
	
	warehouse.addActionListener(this);
	school.addActionListener(this);
	pack.addActionListener(this);
    order.addActionListener(this);
	back.addActionListener(this);
	
	}
	public static void main(String[] args) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==school)
	 {
		new s2_dbms(); 
		frame.dispose();
	 }
	 else if(e.getSource()==warehouse)
	 {
		 new warehouse_dbms();
	 }
	
	 else if(e.getSource()==pack)
	 {
		 new pack_dbms();
	 }
	 else if(e.getSource()==order)
	 {
		 new order_first_dbms();
		 
	 }
	else if(e.getSource()==back)
	 {
		 new emp_dbms();
		 frame.dispose();
		 
	 }
	 
  
			
	}
}

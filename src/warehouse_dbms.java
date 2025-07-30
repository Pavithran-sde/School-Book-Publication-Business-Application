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

public class warehouse_dbms implements ActionListener{

//Jframe and Jpanel
	JFrame frame= new JFrame("WARE HOUSE");
	JPanel panel=new JPanel();
	//JLabel
	JLabel l1=new JLabel("STOCKS");
	JLabel l2=new JLabel("WAREHOUSE");
	
//jbutton
	JButton view=new JButton("VIEW BOOKS");
	JButton add=new JButton("ADD BOOKS");
	JButton a=new JButton("ADD WARE HOUSE");
	JButton v=new JButton("VIEW WARE HOUSE");
	JButton e=new JButton("EDIT WARE HOUSE");
	JButton d=new JButton("DELETE WARE HOUSE");
	

	
	warehouse_dbms()
	{
	frame.setSize(640,640);
	frame.setVisible(true);
	panel.setLayout(null);
	//SET BOUNDS
    l1.setBounds(100, 90, 100, 20); 
	view.setBounds(100,130,150,30);
     add.setBounds(100,180,150,30);
     
     
     l2.setBounds(100,220, 150,30);
     v.setBounds(100,260,200,30);
     a.setBounds(100,310,200,30);
     e.setBounds(330,260,200,30);
     d.setBounds(330,310,200,30);
     
     
     //add to panel

     panel.add(add);
     panel.add(view);
     panel.add(v);
     panel.add(a);
     panel.add(e);
     panel.add(d);
     panel.add(l1);
     panel.add(l2);
     
     //add panel to frame
     
     
     
     
     frame.add(panel);
     view.addActionListener(this);
     add.addActionListener(this);
     v.addActionListener(this);
     a.addActionListener(this);
     e.addActionListener(this);
     d.addActionListener(this);
     
     
	}
	public static void main(String[] args) throws SQLException {
		warehouse_dbms v=new  warehouse_dbms();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==view) {
			new view_books();
			
		}else if(e.getSource()==add) {
			
			new add_books();
		}else if(e.getSource()==v) {
			new view_warehouse();
	}else if(e.getSource()==a) {
		new add_warehouse();
}else if(e.getSource()==e) {
	new edit_warehouse();
}else if(e.getSource()==d) {
	new delete_warehouse();
}
		
	}

}

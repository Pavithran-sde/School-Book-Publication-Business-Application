
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
public class v_o implements ActionListener{
	String id,o_id;
	JLabel title=new JLabel("ORDER LIST");
	JFrame frame=new JFrame("ORDER LIST");
	JTable tabel=new JTable();
	JPanel panel=new JPanel();
	JScrollPane pane=new JScrollPane(tabel);
	v_o(String id,String o_id) throws SQLException
	{
this.id=id;
this.o_id=o_id;

frame.setSize(640,640);
frame.setVisible(true);
title.setBounds(50,50,100,30);
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//panel.setBackground(Color.WHITE);
tabel.setBounds(75,100,300,300);
//tabel.setBackground(Color.DARK_GRAY);
//tabel.setForeground(Color.WHITE);

panel.add(pane);
frame.add(panel);
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/my_business","root","");  
   String sql="select s_id,b_id,b_name,qty,total from order_book where s_id='"+id+"' and o_id='"+o_id+"' "; 
	PreparedStatement pst=con.prepareStatement(sql);
	ResultSet rs=pst.executeQuery();
	tabel.setModel(DbUtils.resultSetToTableModel(rs));
}
	catch(Exception ex)
	{ 
		
	System.err.println("exception:");
    System.err.println(ex.getMessage());
	}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		}
	
	public static void main(String[] arg) throws SQLException
	{
	//	new v_o();
	}
	
}

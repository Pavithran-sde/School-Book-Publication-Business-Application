package Database_management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class trails1 extends JFrame implements ActionListener {

	JTextArea a1=new JTextArea();;
	JButton b1=new JButton("PRINT");
	JButton b2=new JButton("EXIT");
	
	JLabel l1=new JLabel("maran publishers");
JFrame frame=new JFrame("printing");
JPanel panel=new JPanel();

	//
	public trails1(String in_no,String o_id,String s_add1,String s_add2,String s_add3,String s_id,String date,String lrdate,String lrno,String dest)
	{ frame.setSize(640, 640);
		frame.setVisible(true);
		panel.setLayout(null);
		a1.setBounds(10,10,605,500);
	    b1.setBounds(300,520,100,30);
	    b2.setBounds(450,520,100,30);
		panel.add(a1);
		panel.add(b1);
		panel.add(b2);
		frame.add(panel);
		a1.setEditable(false);
		b1.addActionListener(this);
		
	/*
	
	
	
	pw.println("                                           "+"MARAN PUBLISHERS");
	pw.println("                                 "+"54/6,SIVANKOIL STREET, KODAMBAKKAM ");
	pw.println("                                        "+"CHENNAI - 600024");
	pw.println("       "+"PHONE NO :044-24811426 / 9443335246 "+"                           "+"GSTIN : 33ALEPM2183R1ZO");
	pw.println("                           "+"EMAIL : maranpublishers@gmail.com");
	pw.println("  "+"INVOICE NO : "+in_no+"                                        "+"ORDER REG.NO : "+o_id);
	pw.println("  "+"CUS DETAILS"+"  THE PRINCIPAL :"+"                                        "+"DATE : "+date);
	pw.println("                 "+s_add1);
	pw.println("                 "+s_add2);
	pw.println("                 "+s_add3);
	pw.println("  "+"_________________________________________________________________________________________________________");
	pw.println("     "+"SL NO"+"   "+"BOOK CODE"+"       "+"NAME OF THE BOOK"+"      "+"QTY"+"      "+"RATE"+"   "+"AMOUNT");
	pw.println("                                                                     "+"(NOS)"+"    "+"(RS)"+"   "+" (RS)");
	pw.println("  "+"_________________________________________________________________________________________________________");
	/*
	 * table
	 * 
	 
	pw.println("  "+"_________________________________________________________________________________________________________");
	*/
	
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     trails1 t=new trails1("apolloche20","apolloche20","54/6, Sivan koil street ","kodambakkam,","chennai-24.","apolloche","16-04-2020");

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

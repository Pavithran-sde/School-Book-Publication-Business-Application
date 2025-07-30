
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.lang.SystemUtils;

import Database_management.trails1;
import net.proteanit.sql.DbUtils;
public class trails {

	JFrame frame= new JFrame("print");
	JPanel panel= new JPanel();
	
	
	JTextArea a1=new JTextArea();
	JTextArea a2=new JTextArea();
	JTextArea a3=new JTextArea();
	JTextArea a4=new JTextArea();
	JTextArea a5=new JTextArea();
	
	static String bo_id,bo_name;
	static int slno=0,stoc,pric,cost,basiccost=0,bc=0;
	Integer STOCK[],PRICE[];
	Date date;
	ArrayList<String> bookidlist=new ArrayList<String>(10);
	ArrayList<String> booknamelist=new ArrayList<String>(10);
	ArrayList<Integer> qtylist=new ArrayList<Integer>(10);
	ArrayList<Integer> pricelist=new ArrayList<Integer>(10);
	ArrayList<Integer> costlist=new ArrayList<Integer>(10);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:MM:SS");
public trails(String in_no,String o_id,String s_add1,String s_add2,String s_add3,String s_add4,String s_id,String date,String lrdate,String lrno,String dest,String mod,int nob,int P,int d,int to,int pc) throws SQLException
{
	File file =new File("invoice1.txt");
	File file1 =new File("invoice2.txt");
	File file2 =new File("invoice3.txt");
	File file3 =new File("invoice4.txt");
	File file4 =new File("invoice5.txt");
	
	frame.setVisible(true);
	frame.add(panel);
	
	
	bc=(P*d)/100;
	basiccost=P-bc;
	System.out.println("staring to print");
	System.out.println(" ");
	
	   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/my_business","root","");  
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM order_book where o_id='"+o_id+"'";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		         bo_id= rs.getString("b_id");
		         bo_name= rs.getString("b_name");
		         stoc= rs.getInt("qty");
		         pric=rs.getInt("total");
		         cost=rs.getInt("price");
		         bookidlist.add(bo_id);
		      booknamelist.add(bo_name);
		      qtylist.add(stoc);
		      pricelist.add(pric);
		      costlist.add(cost);
		      }
		      	
		      System.out.println("fetched");
		    
		      st.close();
}catch(Exception e1)
		{
			System.err.println("exception:");
			System.err.println(e1.getMessage());
		}
	  
	
	try {
		if(file.exists())
		{
			    file.createNewFile();
				file1.createNewFile();
				file2.createNewFile();
				file3.createNewFile();
				file4.createNewFile();
				
	     		PrintWriter pw=new PrintWriter(file);
	     		PrintWriter pw1=new PrintWriter(file1);
	     		PrintWriter pw2=new PrintWriter(file2);
	     		PrintWriter pw3=new PrintWriter(file3);
	     		PrintWriter pw4=new PrintWriter(file4);
	     		
	     		
	     		
	     		
	     		
	     		
	     		
				pw.println("                                           "+"MARAN PUBLISHERS");
				pw.println("                                 "+"54/6,SIVANKOIL STREET, KODAMBAKKAM ");
				pw.println("                                        "+"CHENNAI - 600024");
				pw.println("       "+"PHONE NO :044-24811426 / 9443335246 "+"                           "+"GSTIN : 33ALEPM2183R1ZO");
				pw.println("                           "+"EMAIL : maranpublishers@gmail.com");
				pw.println("  "+"INVOICE NO : "+in_no+"                                        "+"ORDER REG.NO : "+o_id);
				pw.println("  "+"CUS DETAILS : "+"  THE PRINCIPAL "+"                                        "+"DATE : "+date);
				pw.println("                  "+s_add1);
				pw.println("                  "+s_add2);
				pw.println("                  "+s_add3);
				pw.println("                  "+s_add4);
				
				pw.println("  "+"_________________________________________________________________________________________________________");
				pw.println("     "+"SL NO"+"         "+"BOOK CODE"+"                "+"NAME OF THE BOOK"+"            "+"QTY"+"         "+"RATE"+"        "+"AMOUNT");
				pw.println("                                                     "+"(NOS)"+"      "+"(RS)"+"   "+" (RS)");
				pw.println("  "+"_________________________________________________________________________________________________________");
				for(String a : bookidlist)
				{
					if(slno<10)
					
				pw.println("     "+slno+1+"              "+bookidlist.get(slno)+"                "+booknamelist.get(slno)+"               "+qtylist.get(slno)+"            "+costlist.get(slno)+"          "+ pricelist.get(slno) );
					else if(10<slno && slno<25)
					{
						pw1.println("     "+"SL NO"+"   "+"BOOK CODE"+"          "+"NAME OF THE BOOK"+"      "+"QTY"+"      "+"RATE"+"   "+"AMOUNT");
						pw1.println("                                                     "+"(NOS)"+"      "+"(RS)"+"   "+" (RS)");
						pw1.println("  "+"_________________________________________________________________________________________________________");
						pw1.println("     "+slno+1+"      "+bookidlist.get(slno)+"            "+booknamelist.get(slno)+"           "+qtylist.get(slno)+"        "+costlist.get(slno)+"       "+ pricelist.get(slno) );
					}
					else if(25<slno && slno<40)
					{
						pw2.println("     "+"SL NO"+"   "+"BOOK CODE"+"          "+"NAME OF THE BOOK"+"      "+"QTY"+"      "+"RATE"+"   "+"AMOUNT");
						pw2.println("                                                     "+"(NOS)"+"      "+"(RS)"+"   "+" (RS)");
						pw2.println("  "+"_________________________________________________________________________________________________________");
						pw2.println("     "+slno+1+"      "+bookidlist.get(slno)+"            "+booknamelist.get(slno)+"           "+qtylist.get(slno)+"        "+costlist.get(slno)+"       "+ pricelist.get(slno) );
					}
					else if(40<slno && slno<55)
					{
						pw3.println("     "+"SL NO"+"   "+"BOOK CODE"+"          "+"NAME OF THE BOOK"+"      "+"QTY"+"      "+"RATE"+"   "+"AMOUNT");
						pw3.println("                                                     "+"(NOS)"+"      "+"(RS)"+"   "+" (RS)");
						pw3.println("  "+"_________________________________________________________________________________________________________");
						pw3.println("     "+slno+1+"      "+bookidlist.get(slno)+"            "+booknamelist.get(slno)+"           "+qtylist.get(slno)+"        "+costlist.get(slno)+"       "+ pricelist.get(slno) );
					}
					else if(55<slno && slno<70)
					{
						pw4.println("     "+"SL NO"+"   "+"BOOK CODE"+"          "+"NAME OF THE BOOK"+"      "+"QTY"+"      "+"RATE"+"   "+"AMOUNT");
						pw4.println("                                                     "+"(NOS)"+"      "+"(RS)"+"   "+" (RS)");
						pw4.println("  "+"_________________________________________________________________________________________________________");
						pw4.println("     "+slno+1+"      "+bookidlist.get(slno)+"            "+booknamelist.get(slno)+"           "+qtylist.get(slno)+"        "+costlist.get(slno)+"       "+ pricelist.get(slno) );
					}
						
					slno++;
					}
				pw.println("  "+"_________________________________________________________________________________________________________");
				if(slno<10)
				{
					pw.println("                                                                        "+"Total   : "+"                "+  P);
					pw.println("                                                                        "+"Discount : "+"                "+ d );
					pw.println("No of Bundels : "+nob+"                                                     "+"         "+"                    "+ basiccost);
					pw.println("L.R Date"+lrdate +"                                                      "+"Packing Charge : "+"         "+ pc);
					pw.println("L.R Number"+lrno+"                                                        "+"Net Amount : "+"               "+to);
					pw.println("Mode of Transport"+mod+"");
					pw.println("Destination"+dest+"");
					pw.println(" ");
					pw.println("");
					pw.println("                                                     CHECKED BY                                                                      ");
					pw.println("");
					pw.println("");
					pw.println("Subjected to Chennai Jurisdiction only                                                                   for Maran Publishers");
					pw.println("     ");
					pw.println("     ");
					pw.println("CUSTOMER SIGNATURE                                                                                               MANAGER    ");
					pw.println("____________________________________________________________________________________________________________________________     ");
					pw.println("                                                                                                                Page no .. 1      ");
				try {
					FileReader reader1 = new FileReader("invoice1.txt");
					BufferedReader br1 = new BufferedReader(reader1);
					a1.read(br1,null);
					br1.close();
					a1.requestFocus(); 
					panel.add(a1);
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				}
				else if(10<slno && slno<25)
				{
					pw1.println("                                                                        "+"Total   : "+"                "+  P);
					pw1.println("                                                                        "+"Discount : "+"                "+ d );
					pw1.println("No of Bundels : "+nob+"                                                     "+"         "+"                    "+ basiccost);
					pw1.println("L.R Date"+lrdate +"                                                      "+"Packing Charge : "+"         "+ pc);
					pw1.println("L.R Number"+lrno+"                                                        "+"Net Amount : "+"               "+to);
					pw1.println("Mode of Transport"+mod+"");
					pw1.println("Destination"+dest+"");
					pw1.println(" ");
					pw1.println("");
					pw1.println("                                                                 CHECKED BY                                                                      ");
					pw1.println("");
					pw1.println("");
					pw1.println("Subjected to Chennai Jurisdiction only                                                                                       for Maran Publishers");
					pw1.println("     ");
					pw1.println("     ");
					pw1.println("CUSTOMER SIGNATURE                                                                                                                   MANAGER    ");
					pw1.println("________________________________________________________________________________________________________________________________________________     ");
					pw1.println("                                                                                                                                       Page no .. 2      ");
					
					try {
						FileReader reader1 = new FileReader("invoice2.txt");
						BufferedReader br1 = new BufferedReader(reader1);
						a1.read(br1,null);
						br1.close();
						a1.requestFocus(); 
						panel.add(a1);
						
					}catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
				
				
				}
				else if(25<slno && slno<40)
				{
					pw2.println("                                                                        "+"Total   : "+"                "+  P);
					pw2.println("                                                                        "+"Discount : "+"                "+ d );
					pw2.println("No of Bundels : "+nob+"                                                     "+"         "+"                    "+ basiccost);
					pw2.println("L.R Date"+lrdate +"                                                      "+"Packing Charge : "+"         "+ pc);
					pw2.println("L.R Number"+lrno+"                                                        "+"Net Amount : "+"               "+to);
					pw2.println("Mode of Transport"+mod+"");
					pw2.println("Destination"+dest+"");
					pw2.println(" ");
					pw2.println("");
					pw2.println("                                                                 CHECKED BY                                                                      ");
					pw2.println("");
					pw2.println("");
					pw2.println("Subjected to Chennai Jurisdiction only                                                                                       for Maran Publishers");
					pw2.println("     ");
					pw2.println("     ");
					pw2.println("CUSTOMER SIGNATURE                                                                                                                   MANAGER    ");
					pw2.println("________________________________________________________________________________________________________________________________________________     ");
					pw2.println("                                                                                                                                       Page no .. 3      ");
				
					try {
						FileReader reader1 = new FileReader("invoice3.txt");
						BufferedReader br1 = new BufferedReader(reader1);
						a1.read(br1,null);
						br1.close();
						a1.requestFocus(); 
						panel.add(a1);
						
					}catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
				}
				else if(40<slno && slno<55)
				{
				pw3.println("                                                                        "+"Total   : "+"                "+  P);
				pw3.println("                                                                        "+"Discount : "+"                "+ d );
				pw3.println("No of Bundels : "+nob+"                                                     "+"         "+"                    "+ basiccost);
				pw3.println("L.R Date"+lrdate +"                                                      "+"Packing Charge : "+"         "+ pc);
				pw3.println("L.R Number"+lrno+"                                                        "+"Net Amount : "+"               "+to);
				pw3.println("Mode of Transport"+mod+"");
				pw3.println("Destination"+dest+"");
				pw3.println(" ");
				pw3.println("");
				pw3.println("                                                                 CHECKED BY                                                                      ");
				pw3.println("");
				pw3.println("");
				pw3.println("Subjected to Chennai Jurisdiction only                                                                                       for Maran Publishers");
				pw3.println("     ");
				pw3.println("     ");
				pw3.println("CUSTOMER SIGNATURE                                                                                                                   MANAGER    ");
				pw3.println("________________________________________________________________________________________________________________________________________________     ");
				pw3.println("                                                                                                                                       Page no .. 4      ");
			
				try {
					FileReader reader1 = new FileReader("invoice4.txt");
					BufferedReader br1 = new BufferedReader(reader1);
					a1.read(br1,null);
					br1.close();
					a1.requestFocus(); 
					panel.add(a1);
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
				}
				else if(55<slno && slno<70)
				{
					pw4.println("                                                                        "+"Total   : "+"                "+  P);
					pw4.println("                                                                        "+"Discount : "+"                "+ d );
					pw4.println("No of Bundels : "+nob+"                                                     "+"         "+"                    "+ basiccost);
					pw4.println("L.R Date"+lrdate +"                                                      "+"Packing Charge : "+"         "+ pc);
					pw4.println("L.R Number"+lrno+"                                                        "+"Net Amount : "+"               "+to);
					pw4.println("Mode of Transport"+mod+"");
					pw4.println("Destination"+dest+"");
					pw4.println(" ");
					pw4.println("");
					pw4.println("                                                                 CHECKED BY                                                                      ");
					pw4.println("");
					pw4.println("");
					pw4.println("Subjected to Chennai Jurisdiction only                                                                                       for Maran Publishers");
					pw4.println("     ");
					pw4.println("     ");
					pw4.println("CUSTOMER SIGNATURE                                                                                                                   MANAGER    ");
					pw4.println("________________________________________________________________________________________________________________________________________________     ");
					pw4.println("                                                                                                                                       Page no .. 5      ");
			
					try {
						FileReader reader1 = new FileReader("invoice5.txt");
						BufferedReader br1 = new BufferedReader(reader1);
						a1.read(br1,null);
						br1.close();
						a1.requestFocus(); 
						panel.add(a1);
						
					}catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
				
				}
				
				
				pw.close();
				pw1.close();
				pw2.close();
				pw3.close();
				pw4.close();
				
				System.out.println("done");
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	public static void main(String[] args) throws SQLException
	{
		
	//trails t=new trails("apolloche20","apolloche20","54/6, Sivan koil street ","kodambakkam,","chennai-24.","apolloche","16-04-2020","","","","","bo_id", 1);
	
		
	}
}

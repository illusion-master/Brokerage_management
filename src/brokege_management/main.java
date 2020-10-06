package brokege_management;
import java.util.*;

import javax.swing.JOptionPane;

import java.math.BigInteger;
import java.sql.*;
import java.sql.Date;


public class main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
		String username= "root";
		String password = "keshav123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			String sql = "create table if not exists Buyer(" + 
					"	gst varchar(15) primary key," + 
					"    name varchar(30)," + 
					"    address varchar(50)," + 
					"    phone varchar(13)," + 
					"    email varchar(30));";
			st.executeUpdate(sql);
			
			sql = "create table if not exists Seller(" + 
					"	gst varchar(15) primary key," + 
					"    name varchar(30)," + 
					"    address varchar(50)," + 
					"    phone varchar(13)," + 
					"    email varchar(30));";
			st.executeUpdate(sql);
			
			sql = "create table if not exists Item(" + 
					"	ItemNo int unsigned primary key," + 
					"    HSNCode int unsigned," + 
					"    name varchar(20)," + 
					"    description varchar(100));";
			st.executeUpdate(sql);
			
			sql = "create table if not exists Transaction(" + 
					"					invoice_no int unsigned," + 
					"					buyer_id int unsigned," + 
					"					seller_id int unsigned," + 
					"					item_no int," + 
					"					rate float not null," + 
					"					quantity bigint not null," + 
					"					commission_rate float not null," + 
					"					commission float," + 
					"					date date," + 
					"					foreign key (buyer_id) references Buyer(buyer_id) on delete cascade," + 
					"					foreign key(seller_id) references Seller(seller_id) on delete cascade," + 
					"					foreign key(item_no) references Item(item_no) on delete cascade);";
			
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Drivers not added to reference library");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Some internal error");
		}
		MainWindow mainwindow = new MainWindow();
		mainwindow.main(null);
	}
}

class Functions {
	Scanner sc = new Scanner(System.in);
	
	void chat() throws Exception {
		Chat ch = new Chat();
		ch.start();
		Client c = new Client("", "");
		c.mainf();
		c.mainf();
	}
	
}

class Chat extends Thread {
	public void run() {
		Server s = new Server();
		try {
			s.mainf();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

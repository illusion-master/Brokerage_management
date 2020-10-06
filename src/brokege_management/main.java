package brokege_management;
import java.util.*;
import java.math.BigInteger;
import java.sql.*;
import java.sql.Date;


public class main {
	public static void main(String[] args) {
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

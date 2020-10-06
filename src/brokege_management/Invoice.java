package brokege_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class Invoice extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBuyerGST;
	private JTextField textFieldSellerGST;
	private JTextField textFieldItemNO;
	private JTextField textFieldRate;
	private JTextField textFieldQuantity;
	private JTextField textFieldCR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Invoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane =new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("BROKERAGE MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1062, 40);
		getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 40, 1062, 30);
		getContentPane().add(menuBar);
		
		JMenu mnBuyer = new JMenu("Buyer");
		mnBuyer.setFont(new Font("Arial Black", Font.PLAIN, 15));
		menuBar.add(mnBuyer);
		
		JMenuItem mntmAddBuyer = new JMenuItem("Add Buyer");
		mntmAddBuyer.setFont(new Font("Arial", Font.PLAIN, 15));
		mntmAddBuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame add_buyer = new AddBuyer();
				add_buyer.setVisible(true);
				dispose();
			}
		});
		mnBuyer.add(mntmAddBuyer);
		
		JMenuItem mntmDeleteBuyer = new JMenuItem("Delete Buyer");
		mntmDeleteBuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBuyer view_buyer = new ViewBuyer();
				view_buyer.setVisible(true);
				dispose();
			}
		});
		mntmDeleteBuyer.setFont(new Font("Arial", Font.PLAIN, 15));
		mnBuyer.add(mntmDeleteBuyer);
		
		JMenuItem mntmViewBuyer = new JMenuItem("View Buyers");
		mntmViewBuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBuyer view_buyer = new ViewBuyer();
				view_buyer.setVisible(true);
				dispose();
			}
		});
		mntmViewBuyer.setFont(new Font("Arial", Font.PLAIN, 15));
		mnBuyer.add(mntmViewBuyer);
		
		JMenu mnSeller = new JMenu("Seller");
		mnSeller.setFont(new Font("Arial Black", Font.PLAIN, 15));
		menuBar.add(mnSeller);
		
		JMenuItem mntmAddSeller = new JMenuItem("Add Seller");
		mntmAddSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame add_seller = new AddSeller();
				add_seller.setVisible(true);
				dispose();
			}
		});
		mntmAddSeller.setFont(new Font("Arial", Font.PLAIN, 15));
		mnSeller.add(mntmAddSeller);
		
		JMenuItem mntmDeleteSeller = new JMenuItem("Delete Seller");
		mntmDeleteSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame delete_seller = new ViewSeller();
				delete_seller.setVisible(true);
				dispose();				
			}
		});
		mntmDeleteSeller.setFont(new Font("Arial", Font.PLAIN, 15));
		mnSeller.add(mntmDeleteSeller);
		
		JMenuItem mntmViewSeller = new JMenuItem("View Sellers");
		mntmViewSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame view_seller = new ViewSeller();
				view_seller.setVisible(true);
				dispose();
			}
		});
		mntmViewSeller.setFont(new Font("Arial", Font.PLAIN, 15));
		mnSeller.add(mntmViewSeller);
		
		JMenu mnItem = new JMenu("Item");
		mnItem.setFont(new Font("Arial Black", Font.PLAIN, 15));
		menuBar.add(mnItem);
		
		JMenuItem mntmAddItem = new JMenuItem("Add Item");
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItem add_item = new AddItem();
				add_item.setVisible(true);
				dispose();
			}
		});
		mntmAddItem.setFont(new Font("Arial", Font.PLAIN, 15));
		mnItem.add(mntmAddItem);
		
		JMenuItem mntmDeleteItem = new JMenuItem("Delete Item");
		mntmDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame delete_item = new ViewItem();
				delete_item.setVisible(true);
				dispose();
			}
		});
		mntmDeleteItem.setFont(new Font("Arial", Font.PLAIN, 15));
		mnItem.add(mntmDeleteItem);
		
		JMenuItem mntmViewItem = new JMenuItem("View Items");
		mntmViewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame view_item = new ViewItem();
				view_item.setVisible(true);
				dispose();
			}
		});
		mntmViewItem.setFont(new Font("Arial", Font.PLAIN, 15));
		mnItem.add(mntmViewItem);
		
		JMenu mnInvoice = new JMenu("Invoice");
		mnInvoice.setFont(new Font("Arial Black", Font.PLAIN, 15));
		menuBar.add(mnInvoice);
		
		JMenuItem mntmGenerateInvoice = new JMenuItem("Generate Invoice");
		mntmGenerateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame invoice = new Invoice();
				invoice.setVisible(true);
				dispose();
			}
		});
		mntmGenerateInvoice.setFont(new Font("Arial", Font.PLAIN, 15));
		mnInvoice.add(mntmGenerateInvoice);
		
		JMenuItem mntmRecords = new JMenuItem("Records");
		mntmRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame records = new ViewIndividual();
				records.setVisible(true);
				dispose();
			}
		});
		mntmRecords.setFont(new Font("Arial", Font.PLAIN, 15));
		mnInvoice.add(mntmRecords);		
		
		JLabel lblNewLabel_1 = new JLabel("INVOICE");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 65, 1062, 40);
		contentPane.add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
		String username= "root";
		String password = "keshav123";
		String sql = "select max(invoice_no) from invoice";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			textPane.setText(Integer.toString(rs.getInt(1)+1));			
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
		textPane.setEditable(false);
		textPane.setBounds(399, 150, 89, 25);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_2 = new JLabel("INVOICE NO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(284, 150, 103, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Buyer GST No.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(265, 195, 122, 30);
		contentPane.add(lblNewLabel_3);
		
		textFieldBuyerGST = new JTextField();
		textFieldBuyerGST.setBounds(399, 195, 290, 30);
		contentPane.add(textFieldBuyerGST);
		textFieldBuyerGST.setColumns(10);
		
		JLabel lblSellerGstNo = new JLabel("Seller GST No.");
		lblSellerGstNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSellerGstNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSellerGstNo.setBounds(265, 235, 122, 30);
		contentPane.add(lblSellerGstNo);
		
		textFieldSellerGST = new JTextField();
		textFieldSellerGST.setColumns(10);
		textFieldSellerGST.setBounds(399, 235, 290, 30);
		contentPane.add(textFieldSellerGST);
		
		JLabel lblItemNo = new JLabel("Item No.");
		lblItemNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblItemNo.setBounds(265, 275, 122, 30);
		contentPane.add(lblItemNo);
		
		textFieldItemNO = new JTextField();
		textFieldItemNO.setColumns(10);
		textFieldItemNO.setBounds(399, 275, 290, 30);
		contentPane.add(textFieldItemNO);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRate.setBounds(265, 315, 122, 30);
		contentPane.add(lblRate);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		try {
		textPane_1.setText(Float.toString(Float.parseFloat(textFieldRate.getText()) *Float.parseFloat(textFieldQuantity.getText())*Float.parseFloat(textFieldCR.getText())/100));
		} catch(Exception e) {
			textPane_1.setText("0");
		}
		textPane_1.setBounds(399, 435, 290, 25);
		contentPane.add(textPane_1);
		
		textFieldRate = new JTextField();
		textFieldRate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					textPane_1.setText(Float.toString(Float.parseFloat(textFieldRate.getText()) *Float.parseFloat(textFieldQuantity.getText())*Float.parseFloat(textFieldCR.getText())/100));
					} catch(Exception e) {
						textPane_1.setText("0");
					}
					
			}
		});
		textFieldRate.setColumns(10);
		textFieldRate.setBounds(399, 315, 290, 30);
		contentPane.add(textFieldRate);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQuantity.setBounds(265, 355, 122, 30);
		contentPane.add(lblQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
				textPane_1.setText(Float.toString((Float.parseFloat(textFieldRate.getText()) *Float.parseFloat(textFieldQuantity.getText())*Float.parseFloat(textFieldCR.getText()))/100));
				} catch(Exception ex) {
					textPane_1.setText("0");
				}
			}
		});
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(399, 355, 290, 30);
		contentPane.add(textFieldQuantity);
		
		JLabel lblCommissionRate = new JLabel("Commission rate");
		lblCommissionRate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCommissionRate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCommissionRate.setBounds(265, 395, 122, 30);
		contentPane.add(lblCommissionRate);
		
		textFieldCR = new JTextField();
		textFieldCR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
				textPane_1.setText(Float.toString((Float.parseFloat(textFieldRate.getText()) *Float.parseFloat(textFieldQuantity.getText())*Float.parseFloat(textFieldCR.getText()))/100));
				} catch(Exception ex) {
					textPane_1.setText("0");
				}
			}
		});
		textFieldCR.setColumns(10);
		textFieldCR.setBounds(399, 395, 290, 30);
		contentPane.add(textFieldCR);
		
		JLabel lblNewLabel_4 = new JLabel("Total commission");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(265, 435, 122, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblin1 = new JLabel("");
		lblin1.setBounds(701, 118, 336, 517);
		Image img = new ImageIcon(this.getClass().getResource("/in2.jpg")).getImage().getScaledInstance(lblin1.getWidth(), lblin1.getHeight(), Image.SCALE_SMOOTH);
		lblin1.setIcon(new ImageIcon(img));
		contentPane.add(lblin1);
		
		JButton btnNewButton = new JButton("Add Invoice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
				String username = "root";
				String password = "keshav123";
				String sql = "insert into invoice values(?,?,?,?,?,?,?,?,?)";

				try {
					Connection con = DriverManager.getConnection(url, username, password);
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, Integer.parseInt(textPane.getText()));
					st.setString(2, textFieldBuyerGST.getText());
					st.setString(3, textFieldSellerGST.getText());
					st.setInt(4, Integer.parseInt(textFieldItemNO.getText()));
					st.setFloat(5, Float.parseFloat(textFieldRate.getText()));
					st.setInt(6, Integer.parseInt(textFieldQuantity.getText()));
					st.setFloat(7, Float.parseFloat(textFieldCR.getText()));
					st.setFloat(8, Float.parseFloat(textPane_1.getText()));
					java.sql.Date date = getCurrentDateTime();
					st.setDate(9, date);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "INVOICE GENERATED");
				}
				catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Some internal error");
				}
				
			}
			public java.sql.Date getCurrentDateTime(){
				java.util.Date today = new java.util.Date();
				return new java.sql.Date(today.getTime());
			}
		});
		btnNewButton.setBounds(391, 491, 224, 40);
		contentPane.add(btnNewButton);
	}
}

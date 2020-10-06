package brokege_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewIndividual extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewIndividual frame = new ViewIndividual();
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
	public ViewIndividual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane =new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BROKERAGE MANAGEMENT SYSTEM");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.CYAN);
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
		
		JLabel lblBuyerGSTNO = new JLabel("Buyer GST NO.");
		lblBuyerGSTNO.setBounds(24, 117, 145, 32);
		lblBuyerGSTNO.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblBuyerGSTNO);
		
		textField = new JTextField();
		textField.setBounds(148, 117, 251, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTable table = new JTable();
		table.setBounds(86, 252, 758, 385);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 252, 1026, 385);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(794, 124, 214, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Get Details");
		btnNewButton.setBounds(411, 118, 139, 31);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
				String username= "root";
				String password = "keshav123";
				String sql = "select gst, name from Buyer where gst = ?";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password);
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, textField.getText());
					ResultSet rs = st.executeQuery();
					try{
						rs.next();
						String out = "GST = "+rs.getString(1)+", name = "+rs.getString(2);
						JOptionPane.showMessageDialog(null, out);
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "No Buyer found by this GST number!");
					}
					sql = "select * from invoice where buyer_id = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textField.getText());
					rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					sql = "select sum(commission) from invoice where buyer_id = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textField.getText());
					rs = st.executeQuery();
					rs.next();
					lblNewLabel_2.setText(rs.getString(1));
				}
				catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				catch(ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Drivers not added to reference library");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Some internal error");
				}

			}
		});
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 162, 251, 31);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JButton btnGetDetails = new JButton("Get Details");
		btnGetDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
				String username= "root";
				String password = "keshav123";
				String sql = "select gst, name from Seller where gst = ?";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password);
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, textField_1.getText());
					ResultSet rs = st.executeQuery();
					try{
						rs.next();
						String out = "GST = "+rs.getString(1)+", name = "+rs.getString(2);
						JOptionPane.showMessageDialog(null, out);
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "No Seller found by this GST number!");
					}
					sql = "select * from invoice where seller_id = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textField_1.getText());
					rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					sql = "select sum(commission) from invoice where seller_id = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textField_1.getText());
					rs = st.executeQuery();
					rs.next();
					lblNewLabel_2.setText(rs.getString(1));
				}
				catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				catch(ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Drivers not added to reference library");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Some internal error");
				}

			}
		});
		btnGetDetails.setBounds(411, 163, 139, 31);
		contentPane.add(btnGetDetails);
		
		JLabel lblSellerGstNo = new JLabel("Seller GST NO.");
		lblSellerGstNo.setBounds(24, 162, 145, 32);
		lblSellerGstNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblSellerGstNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 207, 251, 31);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JButton btnGetDetails_1 = new JButton("Get Details");
		btnGetDetails_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
				String username= "root";
				String password = "keshav123";
				String sql = "select ItemNo, name from Item where ItemNo = ?";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password);
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, textField_2.getText());
					ResultSet rs = st.executeQuery();
					try{
						rs.next();
						String out = "Item No = "+rs.getString(1)+", name = "+rs.getString(2);
						JOptionPane.showMessageDialog(null, out);
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "No Item found by this Item number!");
					}
					sql = "select * from invoice where item_no = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textField_2.getText());
					rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					sql = "select sum(commission) from invoice where item_no = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textField_2.getText());
					rs = st.executeQuery();
					rs.next();
					lblNewLabel_2.setText(rs.getString(1));
				}
				catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				catch(ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Drivers not added to reference library");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Some internal error");
				}
			}
		});
		btnGetDetails_1.setBounds(411, 208, 139, 31);
		contentPane.add(btnGetDetails_1);
		
		JLabel lblItemNo = new JLabel("Item NO.");
		lblItemNo.setBounds(24, 207, 145, 32);
		lblItemNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblItemNo);
		
		JLabel lblNewLabel_1 = new JLabel("Total Commission:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(637, 126, 145, 23);
		contentPane.add(lblNewLabel_1);
		
		


	}
}

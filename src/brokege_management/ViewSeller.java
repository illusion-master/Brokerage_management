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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ViewSeller extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSeller frame = new ViewSeller();
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
	public ViewSeller() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
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

		
		table = new JTable();
		table.setRowHeight(30);
		String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
		String username= "root";
		String password = "keshav123";
		String sql = "select * from Seller";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
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
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(60, 310, 750, 350);
		table.setTableHeader(null);
		contentPane.add(jsp);
		
		JLabel lblDeleteSeller = new JLabel("Delete Seller");
		lblDeleteSeller.setForeground(Color.RED);
		lblDeleteSeller.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteSeller.setBackground(new Color(240, 240, 240));
		lblDeleteSeller.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDeleteSeller.setBounds(154, 87, 204, 40);
		contentPane.add(lblDeleteSeller);
		
		JLabel lblDelSeller = new JLabel("Seller GST Number:");
		lblDelSeller.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDelSeller.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDelSeller.setBounds(39, 140, 181, 25);
		contentPane.add(lblDelSeller);
		
		textField = new JTextField();
		textField.setBounds(232, 140, 266, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButtonDelete = new JButton("Delete Seller");
		btnNewButtonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
				String username= "root";
				String password = "keshav123";
				String sql = "delete from Seller where gst = ?";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password);
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, textField.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Seller deleted SuccessFully!");
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
				
			}
		});
		btnNewButtonDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButtonDelete.setBounds(172, 178, 186, 32);
		contentPane.add(btnNewButtonDelete);
		
		JLabel lblNewLabel_1 = new JLabel("GST NO.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(60, 285, 150, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(210, 285, 150, 25);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(360, 285, 150, 25);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneNo.setBounds(510, 285, 150, 25);
		contentPane.add(lblPhoneNo);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(660, 285, 150, 25);
		contentPane.add(lblEmail);
		
		JButton btnNewButtonRefresh = new JButton("Refresh");
		btnNewButtonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
				String username= "root";
				String password = "keshav123";
				String sql = "select * from Seller";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password);
					Statement st = con.createStatement();
					ResultSet rs= st.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
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
			}
		});
		btnNewButtonRefresh.setBounds(863, 635, 187, 25);
		contentPane.add(btnNewButtonRefresh);
	}

}

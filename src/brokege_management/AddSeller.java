package brokege_management;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class AddSeller extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldGST;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSeller frame = new AddSeller();
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
	public AddSeller() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
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
		
		JLabel lblBuyerName = new JLabel("Name:");
		lblBuyerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyerName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBuyerName.setBounds(12, 134, 113, 31);
		contentPane.add(lblBuyerName);
		
		JLabel lblBuyerAddress = new JLabel("Address");
		lblBuyerAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyerAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBuyerAddress.setBounds(12, 166, 113, 31);
		contentPane.add(lblBuyerAddress);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(12, 207, 113, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone no.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(12, 241, 113, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GST ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(12, 279, 113, 31);
		contentPane.add(lblNewLabel_3);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(140, 138, 230, 27);
		contentPane.add(textFieldName);
		textFieldName.setColumns(15);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(140, 173, 230, 27);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(15);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(140, 208, 230, 27);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(15);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(140, 243, 230, 27);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(15);
		
		textFieldGST = new JTextField();
		textFieldGST.setBounds(140, 278, 230, 27);
		contentPane.add(textFieldGST);
		textFieldGST.setColumns(15);
		
		JButton btnAdd = new JButton("Add Seller");
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url ="jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
				String username = "root";
				String password = "keshav123";
				String sql = "insert into Seller values(?,?,?,?,?)";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url ,username, password);
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, textFieldGST.getText());
					st.setString(2, textFieldName.getText());
					st.setString(3, textFieldAddress.getText());
					st.setString(4, textFieldPhone.getText());
					st.setString(5, textFieldEmail.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Seller added successfully!");
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
		btnAdd.setBounds(170, 318, 178, 40);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel_4 = new JLabel("Add Seller");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(10, 78, 438, 44);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblGSTFormat = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/gst_format.png")).getImage();
		lblGSTFormat.setIcon(new ImageIcon(img));
		lblGSTFormat.setBounds(414, 97, 619, 213);
		contentPane.add(lblGSTFormat);
		
		JLabel lblGuidelines = new JLabel("");
		lblGuidelines.setBounds(40, 407, 968, 232);
		Image img2 = new ImageIcon(this.getClass().getResource("/guidelines.png")).getImage().getScaledInstance(lblGuidelines.getWidth(), lblGuidelines.getHeight(), Image.SCALE_SMOOTH);
		lblGuidelines.setIcon(new ImageIcon(img2));
		contentPane.add(lblGuidelines);
	}
}

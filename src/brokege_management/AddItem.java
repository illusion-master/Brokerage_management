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
import java.sql.SQLException;

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
import javax.swing.JTextArea;

public class AddItem extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldItemNo;
	private JTextField textFieldHSNCode;
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem frame = new AddItem();
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
	public AddItem() {
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
		
		JLabel lblBuyerName = new JLabel("Item number");
		lblBuyerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyerName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBuyerName.setBounds(12, 134, 113, 31);
		contentPane.add(lblBuyerName);
		
		JLabel lblBuyerAddress = new JLabel("HSN Code");
		lblBuyerAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyerAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBuyerAddress.setBounds(12, 166, 113, 31);
		contentPane.add(lblBuyerAddress);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(12, 207, 113, 31);
		contentPane.add(lblName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescription.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescription.setBounds(12, 241, 113, 31);
		contentPane.add(lblDescription);
		
		textFieldItemNo = new JTextField();
		textFieldItemNo.setBounds(140, 138, 308, 27);
		contentPane.add(textFieldItemNo);
		textFieldItemNo.setColumns(15);
		
		textFieldHSNCode = new JTextField();
		textFieldHSNCode.setBounds(140, 173, 308, 27);
		contentPane.add(textFieldHSNCode);
		textFieldHSNCode.setColumns(15);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(140, 208, 308, 27);
		contentPane.add(textFieldName);
		textFieldName.setColumns(15);
		
		JTextArea textAreaDescripiton = new JTextArea();
		textAreaDescripiton.setBounds(137, 247, 308, 146);
		contentPane.add(textAreaDescripiton);
		
		JButton btnAdd = new JButton("Add Item");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url ="jdbc:mysql://localhost:3306/brokerage?autoReconnect=true&useSSL=false";
				String username = "root";
				String password = "keshav123";
				String sql = "insert into Item(ItemNo, HSNCode, name, description) values(?, ?, ?, ?)";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url ,username, password);
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, Integer.parseInt(textFieldItemNo.getText()));
					st.setInt(2, Integer.parseInt(textFieldHSNCode.getText()));
					st.setString(3, textFieldName.getText());
					st.setString(4, textAreaDescripiton.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added successfully!");
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
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnAdd.setBounds(206, 421, 178, 40);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel_4 = new JLabel("Add Item");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(10, 78, 438, 44);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(510, 134, 520, 480);
		Image img = new ImageIcon(this.getClass().getResource("/gstslabs.jpg")).getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel_1);
		
	}
}

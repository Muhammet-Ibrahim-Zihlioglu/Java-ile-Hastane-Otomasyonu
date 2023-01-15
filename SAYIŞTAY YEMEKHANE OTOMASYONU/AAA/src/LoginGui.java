
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helper.*;
import model.*;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGui extends JFrame {
	dbConnection conn=new dbConnection();
	
	Yonetici yonetici =new Yonetici();
	
	private JPanel contentPane;
	private JTextField textFieldyonetictc;
	private JTextField textFieldyoneticisifre;
	private JTextField textFieldpersoneltc;
	private JTextField textFieldpersonelsifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui frame = new LoginGui();
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
	public LoginGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 144, 666, 246);
		contentPane.add(tabbedPane);
		
		JPanel panelyonetici = new JPanel();
		tabbedPane.addTab("Y\u00F6netici", null, panelyonetici, null);
		panelyonetici.setLayout(null);
		
		JLabel lblyoneticitc = new JLabel("T.C. Numaran\u0131z : ");
		lblyoneticitc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblyoneticitc.setBounds(10, 26, 193, 43);
		panelyonetici.add(lblyoneticitc);
		
		JLabel lblyoneticisifre = new JLabel("\u015Eifreniz : ");
		lblyoneticisifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblyoneticisifre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblyoneticisifre.setBounds(10, 92, 193, 43);
		panelyonetici.add(lblyoneticisifre);
		
		textFieldyonetictc = new JTextField();
		textFieldyonetictc.setBounds(206, 26, 357, 43);
		panelyonetici.add(textFieldyonetictc);
		textFieldyonetictc.setColumns(10);
		
		textFieldyoneticisifre = new JTextField();
		textFieldyoneticisifre.setColumns(10);
		textFieldyoneticisifre.setBounds(206, 92, 357, 43);
		panelyonetici.add(textFieldyoneticisifre);
		
		JButton btnNewButton = new JButton("Giri\u015F Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldyonetictc.getText().length()==0 ||textFieldyoneticisifre.getText().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Lütfen Bütün Bilgilerinizi Giriniz.");
				}
				else {
					Connection con= conn.connDb();
					try {
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select*from yönetici ");
						if(rs.next()) {
							textFieldyonetictc.getText().equals(yonetici.getTc());
							textFieldyoneticisifre.getText().equals(yonetici.getPassword());
							YoneticiGui yGui=new YoneticiGui();
							 yGui.setVisible(true);
						     dispose();// kullanýlan guiyi kapatýyor
						}else
							JOptionPane.showMessageDialog(null, "Lütfen bilgilerinizi kontrol edip daha sonra tekrar deneyiniz.");
						} catch (SQLException e1) {
						
						e1.printStackTrace();
						}
					}
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(443, 145, 120, 43);
		panelyonetici.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Personel", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panelyonetici_1 = new JPanel();
		panelyonetici_1.setLayout(null);
		panelyonetici_1.setBounds(0, 0, 661, 219);
		panel_1.add(panelyonetici_1);
		
		JLabel lblpersoneltc = new JLabel("T.C. Numaran\u0131z : ");
		lblpersoneltc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblpersoneltc.setBounds(10, 26, 193, 43);
		panelyonetici_1.add(lblpersoneltc);
		
		JLabel lblpersonelsifre = new JLabel("\u015Eifreniz : ");
		lblpersonelsifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblpersonelsifre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblpersonelsifre.setBounds(10, 92, 193, 43);
		panelyonetici_1.add(lblpersonelsifre);
		
		textFieldpersoneltc = new JTextField();
		textFieldpersoneltc.setColumns(10);
		textFieldpersoneltc.setBounds(206, 26, 357, 43);
		panelyonetici_1.add(textFieldpersoneltc);
		
		textFieldpersonelsifre = new JTextField();
		textFieldpersonelsifre.setColumns(10);
		textFieldpersonelsifre.setBounds(206, 92, 357, 43);
		panelyonetici_1.add(textFieldpersonelsifre);
		
		JButton buttonpersonelgiris = new JButton("Giri\u015F Yap");
		buttonpersonelgiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldpersoneltc.getText().length()==0 ||textFieldpersonelsifre.getText().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Lütfen Bütün Bilgilerinizi Giriniz.");
				}
				else {
					Connection con= conn.connDb();
					try {
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select*from personel");
						if(rs.next()) {
							textFieldpersoneltc.getText().equals(yonetici.getTc());
							textFieldpersonelsifre.getText().equals(yonetici.getPassword());							
							PersonelGui yGui=new PersonelGui();
							 yGui.setVisible(true);
						     dispose();// kullanýlan guiyi kapatýyor
						}else
							JOptionPane.showMessageDialog(null, "Lütfen bilgilerinizi kontrol edip daha sonra tekrar deneyiniz.");
						} catch (SQLException e1) {
						
						e1.printStackTrace();
						}
					}
				}
		});
		buttonpersonelgiris.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonpersonelgiris.setBounds(443, 145, 120, 43);
		panelyonetici_1.add(buttonpersonelgiris);
		
		JLabel lblimageicon = new JLabel(new ImageIcon(getClass().getResource("Sayistay.png.png")));
		lblimageicon.setBounds(257, 10, 161, 101);
		contentPane.add(lblimageicon);
	
		
		JLabel lblsystyHsgelndnz = new JLabel("SAYEM'e Ho\u015Fgeldiniz");
		lblsystyHsgelndnz.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblsystyHsgelndnz.setHorizontalAlignment(SwingConstants.CENTER);
		lblsystyHsgelndnz.setBounds(10, 114, 666, 31);
		contentPane.add(lblsystyHsgelndnz);
	}
}

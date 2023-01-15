import Helper.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PersonelGui extends JFrame {
	
	
	Menüyonetici menu=new Menüyonetici();	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel menu_model;
	private DefaultTableModel menu_model1;
	private DefaultTableModel menu_model2;
	private DefaultTableModel menu_model3;
	private DefaultTableModel menu_model4;
	private Object[] menuData=null;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblorbaAd_2;
	private JLabel lblorbaAd_3;
	private JLabel lblorbaAd_4;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_24;
	private JLabel lblSayemPersonelSistemine;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblorbaAd_1;
	private JLabel lblorbaAd_5;
	private JLabel lblorbaAd_6;
	private JLabel lblorbaAd_7;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_33;
	private JLabel lblNewLabel_34;
	private JLabel lblNewLabel_35;
	private JLabel lblNewLabel_36;
	private JLabel lblNewLabel_37;
	private JLabel lblNewLabel_38;
	private JLabel lblNewLabel_39;
	
 /// git toolu kur
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelGui frame = new PersonelGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PersonelGui() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				
		
		menu_model = new DefaultTableModel();
		menu_model1 = new DefaultTableModel();
		menu_model2 = new DefaultTableModel();
		menu_model3 = new DefaultTableModel();
		menu_model4 = new DefaultTableModel();
		Object[] colummenuName= new Object[6];
		colummenuName[0]="Id1";
		colummenuName[1]="Gun";
		colummenuName[2]="Corba";
		colummenuName[3]="Anayemek";
		colummenuName[4]="Aperatif";
		colummenuName[5]="Yanürün";
		menu_model.setColumnIdentifiers(colummenuName);
		menu_model1.setColumnIdentifiers(colummenuName);
		menu_model2.setColumnIdentifiers(colummenuName);
		menu_model3.setColumnIdentifiers(colummenuName);
		menu_model4.setColumnIdentifiers(colummenuName);
		menuData =new Object[6];
		for(int i =0 ;i<1;i++) {
			menuData[0]= menu.getMenüList().get(i).getId1();
			menuData[1]= menu.getMenüList().get(i).getGün();
			menuData[2]= menu.getMenüList().get(i).getCorba();
			menuData[3]= menu.getMenüList().get(i).getAnayemek();
			menuData[4]= menu.getMenüList().get(i).getAperatif();
			menuData[5]= menu.getMenüList().get(i).getYanürün();
			menu_model.addRow(menuData);
		}
		
		menuData =new Object[6];
		for(int i =1 ;i<2;i++) {
			menuData[0]= menu.getMenüList().get(i).getId1();
			menuData[1]= menu.getMenüList().get(i).getGün();
			menuData[2]= menu.getMenüList().get(i).getCorba();
			menuData[3]= menu.getMenüList().get(i).getAnayemek();
			menuData[4]= menu.getMenüList().get(i).getAperatif();
			menuData[5]= menu.getMenüList().get(i).getYanürün();
			menu_model1.addRow(menuData);
		}
		
		menuData =new Object[6];
		for(int i =2 ;i<3;i++) {
			menuData[0]= menu.getMenüList().get(i).getId1();
			menuData[1]= menu.getMenüList().get(i).getGün();
			menuData[2]= menu.getMenüList().get(i).getCorba();
			menuData[3]= menu.getMenüList().get(i).getAnayemek();
			menuData[4]= menu.getMenüList().get(i).getAperatif();
			menuData[5]= menu.getMenüList().get(i).getYanürün();
			menu_model2.addRow(menuData);
		}
		menuData =new Object[6];
		for(int i =3 ;i<4;i++) {
			menuData[0]= menu.getMenüList().get(i).getId1();
			menuData[1]= menu.getMenüList().get(i).getGün();
			menuData[2]= menu.getMenüList().get(i).getCorba();
			menuData[3]= menu.getMenüList().get(i).getAnayemek();
			menuData[4]= menu.getMenüList().get(i).getAperatif();
			menuData[5]= menu.getMenüList().get(i).getYanürün();
			menu_model3.addRow(menuData);
		}
		menuData =new Object[6];
		for(int i =4 ;i<5;i++) {
			menuData[0]= menu.getMenüList().get(i).getId1();
			menuData[1]= menu.getMenüList().get(i).getGün();
			menuData[2]= menu.getMenüList().get(i).getCorba();
			menuData[3]= menu.getMenüList().get(i).getAnayemek();
			menuData[4]= menu.getMenüList().get(i).getAperatif();
			menuData[5]= menu.getMenüList().get(i).getYanürün();
			menu_model4.addRow(menuData);
		}
		table = new JTable(menu_model);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setEnabled(false);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setForeground(Color.BLACK);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(10, 81, 600, 20);
		contentPane.add(table);
		
		table_2 = new JTable(menu_model1);
		table_2.setForeground(Color.BLACK);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		table_2.setEnabled(false);
		table_2.setFillsViewportHeight(true);
		table_2.setBackground(Color.LIGHT_GRAY);
		table_2.setCellSelectionEnabled(true);
		table_2.setColumnSelectionAllowed(true);
		table_2.setShowGrid(false);
		table_2.setShowHorizontalLines(false);
		table_2.setShowVerticalLines(false);
		table_2.setBounds(10, 133, 603, 20);
		contentPane.add(table_2);
		
		table_3 = new JTable(menu_model2);
		table_3.setForeground(Color.BLACK);
		table_3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		table_3.setRowSelectionAllowed(false);
		table_3.setShowGrid(false);
		table_3.setShowHorizontalLines(false);
		table_3.setShowVerticalLines(false);
		table_3.setCellSelectionEnabled(true);
		table_3.setColumnSelectionAllowed(true);
		table_3.setFillsViewportHeight(true);
		table_3.setEnabled(false);
		table_3.setBackground(Color.LIGHT_GRAY);
		table_3.setBounds(10, 187, 603, 20);
		contentPane.add(table_3);
		
		table_4 = new JTable(menu_model3);
		table_4.setForeground(Color.BLACK);
		table_4.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_4.setBackground(Color.LIGHT_GRAY);
		table_4.setEnabled(false);
		table_4.setShowVerticalLines(false);
		table_4.setRowSelectionAllowed(false);
		table_4.setShowHorizontalLines(false);
		table_4.setShowGrid(false);
		table_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		table_4.setFillsViewportHeight(true);
		table_4.setColumnSelectionAllowed(true);
		table_4.setCellSelectionEnabled(true);
		table_4.setBounds(10, 244, 603, 20);
		contentPane.add(table_4);
		
		table_5 = new JTable(menu_model4);
		table_5.setForeground(Color.BLACK);
		table_5.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_5.setRowSelectionAllowed(false);
		table_5.setShowGrid(false);
		table_5.setShowHorizontalLines(false);
		table_5.setShowVerticalLines(false);
		table_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		table_5.setEnabled(false);
		table_5.setFillsViewportHeight(true);
		table_5.setCellSelectionEnabled(true);
		table_5.setColumnSelectionAllowed(true);
		table_5.setBackground(Color.LIGHT_GRAY);
		table_5.setBounds(10, 299, 603, 20);
		contentPane.add(table_5);
		
		JLabel lblNewLabel = new JLabel("Yemek_ID");
		lblNewLabel.setBounds(10, 61, 100, 20);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		lblSayemPersonelSistemine = new JLabel("SAYEM PERSONEL S\u0130STEM\u0130NE HO\u015EGELD\u0130N\u0130Z");
		lblSayemPersonelSistemine.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblSayemPersonelSistemine.setBackground(Color.BLACK);
		lblSayemPersonelSistemine.setBounds(10, 10, 421, 37);
		contentPane.add(lblSayemPersonelSistemine);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGui yGui=new LoginGui();
				 yGui.setVisible(true);
			     dispose();
				
			}
		});
		btnNewButton.setBounds(534, 17, 81, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblorbaAd = new JLabel("G\u00FCn");
		lblorbaAd.setBounds(111, 61, 100, 20);
		contentPane.add(lblorbaAd);
		
		lblNewLabel_2 = new JLabel("\u00C7orba");
		lblNewLabel_2.setBounds(213, 61, 100, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Anayemek");
		lblNewLabel_3.setBounds(314, 62, 100, 20);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Aperatif");
		lblNewLabel_4.setBounds(415, 62, 100, 20);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Yan \u00DCr\u00FCn");
		lblNewLabel_5.setBounds(515, 62, 100, 20);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_1 = new JLabel("Yemek_ID");
		lblNewLabel_1.setBounds(10, 115, 100, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_6 = new JLabel("Yemek_ID");
		lblNewLabel_6.setBounds(10, 168, 100, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Yemek_ID");
		lblNewLabel_7.setBounds(10, 226, 100, 20);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Yemek_ID");
		lblNewLabel_8.setBounds(10, 282, 100, 20);
		contentPane.add(lblNewLabel_8);
		
		lblorbaAd_1 = new JLabel("G\u00FCn");
		lblorbaAd_1.setBounds(111, 113, 100, 20);
		contentPane.add(lblorbaAd_1);
		
		lblorbaAd_5 = new JLabel("G\u00FCn");
		lblorbaAd_5.setBounds(111, 168, 100, 20);
		contentPane.add(lblorbaAd_5);
		
		lblorbaAd_6 = new JLabel("G\u00FCn");
		lblorbaAd_6.setBounds(111, 224, 100, 20);
		contentPane.add(lblorbaAd_6);
		
		lblorbaAd_7 = new JLabel("G\u00FCn");
		lblorbaAd_7.setBounds(111, 280, 100, 20);
		contentPane.add(lblorbaAd_7);
		
		lblNewLabel_9 = new JLabel("\u00C7orba");
		lblNewLabel_9.setBounds(213, 112, 100, 20);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_25 = new JLabel("\u00C7orba");
		lblNewLabel_25.setBounds(213, 168, 100, 20);
		contentPane.add(lblNewLabel_25);
		
		lblNewLabel_26 = new JLabel("\u00C7orba");
		lblNewLabel_26.setBounds(213, 223, 100, 20);
		contentPane.add(lblNewLabel_26);
		
		lblNewLabel_27 = new JLabel("\u00C7orba");
		lblNewLabel_27.setBounds(213, 281, 100, 20);
		contentPane.add(lblNewLabel_27);
		
		lblNewLabel_28 = new JLabel("Anayemek");
		lblNewLabel_28.setBounds(314, 112, 100, 20);
		contentPane.add(lblNewLabel_28);
		
		lblNewLabel_29 = new JLabel("Anayemek");
		lblNewLabel_29.setBounds(314, 169, 100, 20);
		contentPane.add(lblNewLabel_29);
		
		lblNewLabel_30 = new JLabel("Anayemek");
		lblNewLabel_30.setBounds(314, 223, 100, 20);
		contentPane.add(lblNewLabel_30);
		
		lblNewLabel_31 = new JLabel("Anayemek");
		lblNewLabel_31.setBounds(314, 278, 100, 20);
		contentPane.add(lblNewLabel_31);
		
		lblNewLabel_32 = new JLabel("Aperatif");
		lblNewLabel_32.setBounds(415, 115, 100, 20);
		contentPane.add(lblNewLabel_32);
		
		lblNewLabel_33 = new JLabel("Aperatif");
		lblNewLabel_33.setBounds(415, 168, 100, 20);
		contentPane.add(lblNewLabel_33);
		
		lblNewLabel_34 = new JLabel("Aperatif");
		lblNewLabel_34.setBounds(415, 224, 100, 20);
		contentPane.add(lblNewLabel_34);
		
		lblNewLabel_35 = new JLabel("Aperatif");
		lblNewLabel_35.setBounds(415, 278, 100, 20);
		contentPane.add(lblNewLabel_35);
		
		lblNewLabel_36 = new JLabel("Yan \u00DCr\u00FCn");
		lblNewLabel_36.setBounds(515, 115, 100, 20);
		contentPane.add(lblNewLabel_36);
		
		lblNewLabel_37 = new JLabel("Yan \u00DCr\u00FCn");
		lblNewLabel_37.setBounds(515, 168, 100, 20);
		contentPane.add(lblNewLabel_37);
		
		lblNewLabel_38 = new JLabel("Yan \u00DCr\u00FCn");
		lblNewLabel_38.setBounds(515, 223, 100, 20);
		contentPane.add(lblNewLabel_38);
		
		lblNewLabel_39 = new JLabel("Yan \u00DCr\u00FCn");
		lblNewLabel_39.setBounds(515, 277, 100, 20);
		contentPane.add(lblNewLabel_39);

		
		
		
		
		
	}
}

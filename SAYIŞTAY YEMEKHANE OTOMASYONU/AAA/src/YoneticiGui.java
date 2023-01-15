
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.TableView.TableCell;

import Helper.dbConnection;
import model.Menüyonetici;
import model.Yonetici;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class YoneticiGui extends JFrame {

	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private DefaultTableModel personel_model;
	private Object[] personelData=null;
	private DefaultTableModel menu_model;
	private Object[] menuData=null;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiGui frame = new YoneticiGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//	public class ButtonColumn extends JFrame{
//		public ButtonColumn() {
//			super("Button Column Example");
//		}
//		
//	}
//	

//		@Override
//		//constructer
//		public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus,
//				int row, int column) {
//			// TODO Auto-generated method stub
//			setText((obj==null) ? "":obj.toString() );
//			return this;
//		}
//		
//	}
//	
//	//ButtonEditor 
//
//	class ButtonEditor extends DefaultCellEditor{
//		protected JButton btn;
//		private String lbl;
//		private Boolean clicked;
//		public ButtonEditor(JTextField txt) {
//			super(txt);
//			// TODO Auto-generated constructor stub
//			btn=new JButton();
//			btn.setOpaque(true);
//			//when button is cliicked
//			btn.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//		}
////		override a couple of methods
//		@Override
//		public Component getTableCellEditorComponent(JTable table, Object obj, boolean isSelected, int row,
//				int column) {
//			// TODO Auto-generated method stub
//			// set text to buttton set clickeed true then return the buton object
//			lbl = (obj==null)?"":obj.toString();
//			btn.setText(lbl);
//			clicked = true;
//			return btn;
//		}
//	}
//	
//	public Object getCellEditorValue(boolean clicked, Component btn, String lbl) {
//		if(clicked)
//			JOptionPane.showMessageDialog(btn, lbl+"Clicked");
//		clicked=false;
//		return new String(lbl);
//	}
//	
//	private boolean stopCellEditing(boolean clicked) {
//		clicked=false;
//		return false;
//		// TODO Auto-generated method stub
//
//	}
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public YoneticiGui() throws SQLException {
		
		Yonetici yonetici=new Yonetici();
		Menüyonetici menu=new Menüyonetici();
	
		personel_model = new DefaultTableModel();
		Object[] columpersonelName= new Object[5];
		columpersonelName[0]="Id";
		columpersonelName[1]="Ad";
		columpersonelName[2]="Soyad";
		columpersonelName[3]="Tc";
		columpersonelName[4]="Þifre";
		personel_model.setColumnIdentifiers(columpersonelName);
		personelData =new Object[5];
		for(int i =0 ;i<yonetici.getPersonelList().size();i++) {
			personelData[0]= yonetici.getPersonelList().get(i).getId();
			personelData[1]= yonetici.getPersonelList().get(i).getName();
			personelData[2]= yonetici.getPersonelList().get(i).getSurname();
			personelData[3]= yonetici.getPersonelList().get(i).getTc();
			personelData[4]= yonetici.getPersonelList().get(i).getPassword();
			personel_model.addRow(personelData);
		}
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 53, 666, 300);
		contentPane.add(tabbedPane);
		
		JPanel panelprs = new JPanel();
		tabbedPane.addTab("Personel", null, panelprs, null);
		panelprs.setLayout(null);
		
		table = new JTable(personel_model);
		table.setBackground(SystemColor.scrollbar);
		table.setBounds(10, 31, 430, 232);
		panelprs.add(table);
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType()==TableModelEvent.UPDATE) {
					try {
						int selectId=Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
						String selectName=table.getValueAt(table.getSelectedRow(), 1).toString();
						String selectSurname=table.getValueAt(table.getSelectedRow(),2).toString();
						String selectTc=table.getValueAt(table.getSelectedRow(),3).toString();
						String selectPassword=table.getValueAt(table.getSelectedRow(),4).toString();
						Boolean control=yonetici.updatePersonel(selectId, selectName, selectSurname, selectTc, selectPassword);	
						if(control)
							JOptionPane.showMessageDialog(null, "iþlem baþarýlý");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				
			}
		});

		
		textField = new JTextField();
		textField.setBounds(569, 13, 82, 26);
		panelprs.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Personel Ad\u0131");
		lblNewLabel_1.setBounds(457, 10, 102, 31);
		panelprs.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personel Soyad\u0131");
		lblNewLabel_1_1.setBounds(456, 46, 102, 31);
		panelprs.add(lblNewLabel_1_1);
		
		textField_1 =new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(569, 49, 82, 26);
		panelprs.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Personel TC No");
		lblNewLabel_1_1_1.setBounds(457, 87, 102, 31);
		panelprs.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(569, 85, 82, 26);
		panelprs.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Personel \u015Eifre");
		lblNewLabel_1_1_1_1.setBounds(457, 122, 102, 31);
		panelprs.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(569, 121, 82, 26);
		panelprs.add(textField_3);
		  //Icon icon = new ImageIcon("B:\\indir.PNG"); Jbuttonun içine icon yazýlacak.
		JButton btnPersonelEkle = new JButton();
		btnPersonelEkle.setText("Add");
		btnPersonelEkle.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
              if(textField.getText().length()==0 ||textField_1.getText().length()==0||textField_2.getText().length()==0||textField_3.getText().length()==0) {
					
			 		JOptionPane.showMessageDialog(null, "Lütfen Bütün Bilgilerinizi Giriniz.");
			     	}
              else {
            	  boolean control = yonetici.addPersonel(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
            	  if(control) {
            		  JOptionPane.showMessageDialog(null, "iþlem baþarýlý");
            		  textField.setText(null);
            		  textField_1.setText(null);
            		  textField_2.setText(null);
            		  textField_3.setText(null); 
            		  try {
						updatePersonel(yonetici);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
            	  }
              }
             
	    
	    }
		
		});
		btnPersonelEkle.setBounds(569, 157, 82, 31);
		panelprs.add(btnPersonelEkle);
		
		textField_4 = new JTextField();
		textField_4.setBounds(569, 198, 82, 26);
		panelprs.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(457, 193, 102, 31);
		panelprs.add(lblNewLabel_4);
		
		JButton btnpersonelcýkar = new JButton("Remove");
		btnpersonelcýkar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if(textField_4.getText().length()==0) {
				 		JOptionPane.showMessageDialog(null, "Lütfen Bütün Bilgilerinizi Giriniz.");
				   }
				  else if(!textField_4.getText().equals(yonetici.getId())) {
					  JOptionPane.showMessageDialog(null, "Personel bulunamadý");
				  }
				  else {
					int selectId=Integer.parseInt(textField_4.getText());
					boolean control = yonetici.removePersonel(selectId);
					textField_4.setText(null);
					if(control) {
						JOptionPane.showMessageDialog(null, "iþlem baþarýlý");
					}
				}
				  try {
					textField_4.setText(null);
					updatePersonel(yonetici);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnpersonelcýkar.setBounds(566, 234, 85, 29);
		panelprs.add(btnpersonelcýkar);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 32, 427, 26);
		panelprs.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(10, 10, 86, 26);
		panelprs.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("AD");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(96, 9, 86, 26);
		panelprs.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("SOYAD");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(183, 8, 86, 26);
		panelprs.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("TC K\u0130ML\u0130K NO");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setBounds(270, 8, 86, 26);
		panelprs.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("\u015E\u0130FRE");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setBounds(354, 8, 86, 26);
		panelprs.add(lblNewLabel_2_4);
		
		////////////////////////////////////////////////////////////////
		
		
		menu_model = new DefaultTableModel();
		Object[] colummenuName= new Object[6];
		colummenuName[0]="Id1";
		colummenuName[1]="Gun";
		colummenuName[2]="Corba";
		colummenuName[3]="Anayemek";
		colummenuName[4]="Aperatif";
		colummenuName[5]="Yanürün";
		menu_model.setColumnIdentifiers(colummenuName);
		menuData =new Object[6];
		for(int i =0 ;i<menu.getMenüList().size();i++) {
			menuData[0]= menu.getMenüList().get(i).getId1();
			menuData[1]= menu.getMenüList().get(i).getGün();
			menuData[2]= menu.getMenüList().get(i).getCorba();
			menuData[3]= menu.getMenüList().get(i).getAnayemek();
			menuData[4]= menu.getMenüList().get(i).getAperatif();
			menuData[5]= menu.getMenüList().get(i).getYanürün();
			menu_model.addRow(menuData);
		}
		
		JPanel panelmenü = new JPanel();
		tabbedPane.addTab("Men\u00FC", null, panelmenü, null);
		panelmenü.setLayout(null);
		
		JPanel panelprs_1 = new JPanel();
		panelprs_1.setLayout(null);
		panelprs_1.setBounds(0, 0, 661, 273);
		panelmenü.add(panelprs_1);

		
		table_1 = new JTable(menu_model);
		table_1.setBackground(SystemColor.scrollbar);
		table_1.setBounds(10, 31, 426, 232);
		panelprs_1.add(table_1);
		
		
		
		table_1.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType()==TableModelEvent.UPDATE) {
					try {
						int selectId1=Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(),0).toString());
						String selectGün=table_1.getValueAt(table_1.getSelectedRow(), 1).toString();
						String selectCorba=table_1.getValueAt(table_1.getSelectedRow(),2).toString();
						String selectAnayemek=table_1.getValueAt(table_1.getSelectedRow(),3).toString();
						String selectAperatif=table_1.getValueAt(table_1.getSelectedRow(),4).toString();
						String selectYanürün=table_1.getValueAt(table_1.getSelectedRow(),5).toString();
						Boolean control=menu.updateMenu(selectId1,selectGün, selectCorba, selectAnayemek, selectAperatif, selectYanürün);	
						
						if(control)
							JOptionPane.showMessageDialog(null, "iþlem baþarýlý");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				
			}
		});
		
		
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(569, 8, 82, 18);
		panelprs_1.add(textField_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("G\u00FCn");
		lblNewLabel_1_2.setBounds(457, 10, 102, 18);
		panelprs_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("\u00C7orba Ad\u0131");
		lblNewLabel_1_1_2.setBounds(457, 38, 102, 18);
		panelprs_1.add(lblNewLabel_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(569, 36, 82, 18);
		panelprs_1.add(textField_6);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Anayemek Ad\u0131");
		lblNewLabel_1_1_1_2.setBounds(457, 66, 102, 18);
		panelprs_1.add(lblNewLabel_1_1_1_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(569, 64, 82, 18);
		panelprs_1.add(textField_7);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Aperatif");
		lblNewLabel_1_1_1_1_2.setBounds(457, 94, 102, 18);
		panelprs_1.add(lblNewLabel_1_1_1_1_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(569, 92, 82, 18);
		panelprs_1.add(textField_8);
		
		JButton btnMenuekle = new JButton("Add");
		btnMenuekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(textField_5.getText().length()==0 ||textField_6.getText().length()==0||textField_7.getText().length()==0||textField_8.getText().length()==0||textField_10.getText().length()==0) {
						
				 		JOptionPane.showMessageDialog(null, "Lütfen Bütün Bilgilerinizi Giriniz.");
				     	}
	              else {
	            	  boolean control = menu.addMenu(textField_5.getText(),textField_6.getText(),textField_7.getText(),textField_8.getText(),textField_10.getText());
	            	  if(control) {
	            		  JOptionPane.showMessageDialog(null, "iþlem baþarýlý");
	            		  textField_5.setText(null);
	            		  textField_6.setText(null);
	            		  textField_7.setText(null);
	            		  textField_8.setText(null); 
	            		  textField_10.setText(null);
	            		  menu_model.setRowCount(0);
	            		  try {
	            			 
							updateMenu(menu);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}  
	            	  }
	              }
	             
		    
		    }
			
			});
		btnMenuekle.setBounds(569, 148, 82, 31);
		panelprs_1.add(btnMenuekle);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(569, 189, 82, 26);
		panelprs_1.add(textField_9);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1_1_1_1.setBounds(457, 186, 102, 31);
		panelprs_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JButton btnMenüÇýkar = new JButton("Remove");
		btnMenüÇýkar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
					  
				 if(textField_9.getText().length()==0) {
				 		JOptionPane.showMessageDialog(null, "Lütfen Bütün Bilgilerinizi Giriniz.");
				   }else if(!textField_9.getText().equals(menu.getId1())) {
						  JOptionPane.showMessageDialog(null, "Menü bulunamadý");
					  }
				   
				  else {
					  int selectId1=Integer.parseInt(textField_9.getText());
						boolean control = menu.removeMenu(selectId1);
						textField_9.setText(null);
						if(control) {
							JOptionPane.showMessageDialog(null, "iþlem baþarýlý");
				  }
				  menu_model.setRowCount(0);
				  try {
					
					updateMenu(menu);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  }
				 
			}
		});
		btnMenüÇýkar.setBounds(566, 225, 85, 29);
		panelprs_1.add(btnMenüÇýkar);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Yan \u00DCr\u00FCn");
		lblNewLabel_1_1_1_1_2_1.setBounds(457, 122, 102, 18);
		panelprs_1.add(lblNewLabel_1_1_1_1_2_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(569, 120, 82, 18);
		panelprs_1.add(textField_10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 13, 71, 18);
		panelprs_1.add(lblNewLabel);
		
		JLabel lblorba = new JLabel("G\u00FCn");
		lblorba.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblorba.setHorizontalAlignment(SwingConstants.CENTER);
		lblorba.setBounds(82, 13, 71, 18);
		panelprs_1.add(lblorba);
		
		JLabel lblorba_1 = new JLabel("\u00C7orba");
		lblorba_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblorba_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblorba_1.setBounds(154, 13, 71, 18);
		panelprs_1.add(lblorba_1);
		
		JLabel lblAnayemek = new JLabel("Anayemek");
		lblAnayemek.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblAnayemek.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnayemek.setBounds(227, 14, 71, 18);
		panelprs_1.add(lblAnayemek);
		
		JLabel lblAperatif = new JLabel("Aperatif");
		lblAperatif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblAperatif.setHorizontalAlignment(SwingConstants.CENTER);
		lblAperatif.setBounds(298, 15, 71, 18);
		panelprs_1.add(lblAperatif);
		
		JLabel lblYanrn = new JLabel("Yan \u00DCr\u00FCn");
		lblYanrn.setHorizontalAlignment(SwingConstants.CENTER);
		lblYanrn.setBounds(368, 14, 71, 18);
		panelprs_1.add(lblYanrn);
		
		setTitle("SAYEM Y\u00D6NET\u0130M S\u0130STEM\u0130");
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("SAYEM Y\u00D6NET\u0130M S\u0130STEM\u0130NE HO\u015EGELD\u0130N\u0130Z");
		lblNewLabel1.setBackground(Color.BLACK);
		lblNewLabel1.setBounds(10, 10, 348, 37); 
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		getContentPane().add(lblNewLabel1);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGui yGui=new LoginGui();
				 yGui.setVisible(true);
			     dispose();
			}
		});
		btnNewButton.setBounds(583, 22, 81, 30);
		contentPane.add(btnNewButton);

	}
	
	
	public void updatePersonel(Yonetici yonetici) throws SQLException {
		DefaultTableModel clearmodel=(DefaultTableModel) table.getModel();
		clearmodel.setRowCount(0);
		for(int i=0;i<yonetici.getPersonelList().size();i++) {
			personelData[0] =   yonetici.getPersonelList().get(i).getId();
			personelData[1] =  yonetici.getPersonelList().get(i).getName();
			personelData[2] =  yonetici.getPersonelList().get(i).getSurname();
			personelData[3] = yonetici.getPersonelList().get(i).getTc();
			personelData[4] =  yonetici.getPersonelList().get(i).getPassword();
			personel_model.addRow(personelData);
			}
		
		
		}
	
	public void updateMenu(Menüyonetici menü) throws SQLException {
		DefaultTableModel clearmodel=(DefaultTableModel) table.getModel();
		clearmodel.setRowCount(0);
		

		for(int i=0;i<menü.getMenüList().size();i++) {
			menuData[0] =   menü.getMenüList().get(i).getId1();
			menuData[1] =  menü.getMenüList().get(i).getGün();
			menuData[2] =  menü.getMenüList().get(i).getCorba();
			menuData[3] = menü.getMenüList().get(i).getAnayemek();
			menuData[4] =  menü.getMenüList().get(i).getAperatif();
			menuData[5] =  menü.getMenüList().get(i).getYanürün();
			menu_model.addRow(menuData);
			}
		
		
		}
}

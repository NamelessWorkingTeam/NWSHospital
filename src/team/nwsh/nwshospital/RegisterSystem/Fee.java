package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import team.nwsh.nwshospital.MySQLConnect;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fee extends JFrame {
	
	static String F_ID;           //身份证号
	static String F_NAME;			//姓名
	static String F_MED;			//储存RESULTS表查询到的RES_MED 药品收费
	static String [] F_MED_SPLIT;	//将F_MED分割开
	static String F_ITEMS;			//储存RESULTS表查询到的RES_ITEMS 项目收费
	static String [] F_ITEMS_SPLIT;	//将F_ITEMS分隔开
	
	private JPanel contentPane;
	private JTable table;
	private static JTable table_MED;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee frame = new Fee();
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
	public Fee() {
		F_ID=RegisterSystem.PAT_ID;					//把输入身份证号页面的身份证号传给了F_ID
		
		//查询姓名
				String sql_name= "SELECT PAT_NAME FROM PATIENTS WHERE PAT_ID='"+F_ID+"'";
				MySQLConnect con_name= new MySQLConnect(sql_name);
				try {
					ResultSet ResultSet_NAME = con_name.pst.executeQuery();
					while(ResultSet_NAME.next()){
						F_NAME=ResultSet_NAME.getString("PAT_NAME");//将名字查询结果赋值给了F_NAME
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		//查询药品收费
				String sql_med= "SELECT RES_MED FROM RESULTS WHERE PAT_ID='"+F_ID+"'";
				MySQLConnect con_med= new MySQLConnect(sql_med);
				try {
					ResultSet ResultSet_MED = con_med.pst.executeQuery();
					while(ResultSet_MED.next()){
						F_MED=ResultSet_MED.getString("RES_MED");//将药品查询结果赋值给了F_MED
						
						F_MED_SPLIT=F_MED.split(",");				//split方法
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		//查询项目收费
				String sql_items= "SELECT RES_ITEMS FROM RESULTS WHERE PAT_ID='"+F_ID+"'";
				MySQLConnect con_items= new MySQLConnect(sql_items);
				try {
					ResultSet ResultSet_ITEMS = con_items.pst.executeQuery();
					while(ResultSet_ITEMS.next()){
						F_ITEMS=ResultSet_ITEMS.getString("RES_ITEMS");//将收费项目查询结果赋值给了F_ITEMS
						
						F_ITEMS_SPLIT=F_ITEMS.split(",");				//split方法
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(50, 10, 433, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u6536\u8D39");
		label.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label.setBounds(202, 20, 41, 36);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(50, 76, 433, 40);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setBounds(57, 10, 42, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setBounds(189, 10, 70, 30);
		panel_1.add(label_2);
		
		JLabel Label_NAME = new JLabel("");
		Label_NAME.setForeground(Color.BLACK);
		Label_NAME.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		Label_NAME.setBounds(109, 10, 70, 30);
		panel_1.add(Label_NAME);
		Label_NAME.setText(F_NAME);//显示名字
		
		JLabel Label_ID = new JLabel("");
		Label_ID.setForeground(Color.BLACK);
		Label_ID.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		Label_ID.setBounds(269, 10, 154, 30);
		panel_1.add(Label_ID);
		Label_ID.setText(F_ID);//显示身份证号
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 126, 433, 211);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_5 = new JLabel("\u836F\u7269\u6536\u8D39\uFF1A");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_5.setBounds(10, 10, 70, 30);
		panel_2.add(label_5);
		
		
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u7F16\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel.setBounds(41, 39, 70, 30);
		panel_2.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(195, 39, 60, 30);
		panel_2.add(label_3);
		
		JLabel label_6 = new JLabel("\u5355\u4EF7");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_6.setBounds(331, 39, 35, 30);
		panel_2.add(label_6);
		
		//MedicineTable();
		table_MED = new JTable();
		table_MED.setBounds(10, 68, 413, 133);
		panel_2.add(table_MED);
		
		JButton button = new JButton("\u5DF2\u6536\u8D39");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				for(int i=0;i<F_MED_SPLIT.length;i++){				//split方法测试
//					System.out.println(F_MED_SPLIT[i]);
//					System.out.println("长度为："+F_MED_SPLIT.length);
//				}
				
				System.out.println(F_MED_SPLIT[0]);					//测试传值用例
				
				String state = "UPDATE STATE SET STA_TUS =5 WHERE PAT_ID='"+F_ID+"'";
				MySQLConnect STATE = new MySQLConnect(state);
				try {
					STATE.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "收费成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "收费失败！", "提示", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(160, 583, 93, 23);
		contentPane.add(button);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(50, 347, 433, 211);
		contentPane.add(panel_3);
		
		JLabel label_8 = new JLabel("\u9879\u76EE\u6536\u8D39\uFF1A");
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_8.setBounds(10, 10, 70, 30);
		panel_3.add(label_8);
		

		
//		DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();   
//		r2.setHorizontalAlignment(JLabel.CENTER);   
//		table_MED.setDefaultRenderer(Object.class,r2);
		
		
		JLabel label_7 = new JLabel("\u9879\u76EE\u7F16\u53F7");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_7.setBounds(61, 39, 70, 30);
		panel_3.add(label_7);
		
		JLabel label_9 = new JLabel("\u9879\u76EE\u540D\u79F0");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_9.setBounds(197, 39, 70, 30);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("\u5355\u4EF7");
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_10.setBounds(342, 39, 70, 30);
		panel_3.add(label_10);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(294, 583, 93, 23);
		contentPane.add(button_1);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
	
//	public static void MedicineTable() {
//		// 药品列表
////		int i = 0;
//        String String_SQL_MED_NAME = "SELECT MED_NAME, MED_PRICE " +
//									 	  "FROM MEDICINE " + 
//									 	  "WHERE MED_ID = '"+F_MED_SPLIT[0]+"' " ;
//									 	  
//		MySQLConnect MySQLConnect_MED_NAME = new MySQLConnect(String_SQL_MED_NAME);
//		ResultSet RS_MED_NAME;
//		Vector RowData_MED_NAME, ColumnNames_MED_NAME;
//		ColumnNames_MED_NAME= new Vector();
//		ColumnNames_MED_NAME.add("");
//		ColumnNames_MED_NAME.add("");
//		// 建立表头
//		
//		RowData_MED_NAME=new Vector(); 
//		boolean INT_Found_MED_NAME = false;
//	    try {
//	    	RS_MED_NAME = MySQLConnect_MED_NAME.pst.executeQuery();
//	    	if(RS_MED_NAME.next()) {
//	    		INT_Found_MED_NAME = true;
//	    		Vector hang_MED=new Vector();
//	    		hang_MED.add(RS_MED_NAME.getString("MED_NAME"));
//	        	hang_MED.add(RS_MED_NAME.getString("MED_PRICE"));
//	        	RowData_MED_NAME.add(hang_MED);
//				while (RS_MED_NAME.next()) {
//		            hang_MED=new Vector();
//		            hang_MED.add(RS_MED_NAME.getString("MED_NAME"));
//		            hang_MED.add(RS_MED_NAME.getString("MED_PRICE"));
//		        	RowData_MED_NAME.add(hang_MED);
//		        }
//				RS_MED_NAME.close();
//		        MySQLConnect_MED_NAME.close();
//	    	}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
//	    
//		table_MED=new JTable(RowData_MED_NAME, ColumnNames_MED_NAME) {
//			// 设置表内数据不可修改
//			public boolean isCellEditable(int row, int column) { 
//			    return false;
//			}
//		};
//		table_MED.setEnabled(false);
//
//
//		table_MED.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table_MED.setFont(new Font("微软雅黑", Font.PLAIN, 24));
//		table_MED.setRowHeight(50);
//		
//		if(INT_Found_MED_NAME) {
//			// START 设置 table_MED 内容居中
//			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//			tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
//			table_MED.setDefaultRenderer(Object.class, tcr);
//			// END 设置 table_MED 内容居中
//		}
//		// END 候诊病人列表展示		
//	}
//	
	
//	
//	
//	
//	
//	
//	
//	
//	
//	
	

}

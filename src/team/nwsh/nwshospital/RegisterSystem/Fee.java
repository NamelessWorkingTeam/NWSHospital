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
	
	static double F_SUM;
	static String F_SUM_STRING;   //转换为string类型的F_SUM
	static String F_ID;           //身份证号
	static String F_NAME;			//姓名
	static String F_MED;			//储存RESULTS表查询到的RES_MED 药品收费
	static String [] F_MED_SPLIT;	//将F_MED分割开
	static String F_ITEM;			//储存RESULTS表查询到的RES_ITEM 项目收费
	static String [] F_ITEM_SPLIT;	//将F_ITEM分隔开
	
	private JPanel contentPane;
	private JTable table;
	private static JTable table_MED;
	private static JTable table_ITEM;
	
	/**
	 * To LiuYeBian:
	 * 整个MedicineTable()方法有重写！构造函数有修改！需要从RegisterSystem登录！
	 * 还有170至181行添加了新的搜索方法
	 * 另外，请在183至212药品和收费项目查询中添加搜索记录为空的判断！防止造成方法中查询错误！(已完成√)
	 * From Liu Yummy
	 */
	public static void MedicineTable() {
		// 药品列表
		
		// 根据SPLIT获取的数组制作要查询的WHERE部分的SQL语句
		int i = 0;
		String String_SQL_MED_ID_GROUP = "";
		while(i < F_MED_SPLIT.length) {
			
			String_SQL_MED_ID_GROUP = String_SQL_MED_ID_GROUP + F_MED_SPLIT[i];
			i = i + 1;
			if(i != F_MED_SPLIT.length) {
				String_SQL_MED_ID_GROUP = String_SQL_MED_ID_GROUP + " OR MED_ID = ";
			}
			
		}
		
	    String String_SQL_MED_NAME = "SELECT MED_ID, MED_NAME, MED_PRICE " +
									 	  "FROM MEDICINE " + 
									 	  "WHERE MED_ID = " + String_SQL_MED_ID_GROUP;
									 	  
		MySQLConnect MySQLConnect_MED_NAME = new MySQLConnect(String_SQL_MED_NAME);
		ResultSet RS_MED_NAME;
		Vector RowData_MED_NAME, ColumnNames_MED_NAME;
		ColumnNames_MED_NAME= new Vector();
		ColumnNames_MED_NAME.add("");
		ColumnNames_MED_NAME.add("");
		ColumnNames_MED_NAME.add("");
		// 建立表头
		
		RowData_MED_NAME=new Vector(); 
		boolean INT_Found_MED_NAME = false;
	    try {
	    	RS_MED_NAME = MySQLConnect_MED_NAME.pst.executeQuery();
	    	if(RS_MED_NAME.next()) {
	    		INT_Found_MED_NAME = true;
	    		Vector hang_MED=new Vector();
	    		hang_MED.add(RS_MED_NAME.getString("MED_ID"));
	    		hang_MED.add(RS_MED_NAME.getString("MED_NAME"));
	        	hang_MED.add(RS_MED_NAME.getString("MED_PRICE"));
	        	RowData_MED_NAME.add(hang_MED);
				while (RS_MED_NAME.next()) {
		            hang_MED=new Vector();
		            hang_MED.add(RS_MED_NAME.getString("MED_ID"));
		            hang_MED.add(RS_MED_NAME.getString("MED_NAME"));
		            hang_MED.add(RS_MED_NAME.getString("MED_PRICE"));
		        	RowData_MED_NAME.add(hang_MED);
		        }
				RS_MED_NAME.close();
		        MySQLConnect_MED_NAME.close();
	    	}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table_MED=new JTable() {
			// 设置表内数据不可修改
			public boolean isCellEditable(int row, int column) { 
			    return false;
			}
		};
		
	    // 用以上生成的“列数据集合”和“行数据集合”作为参数声明一个新的 表格模板
		DefaultTableModel model_table_MED = new DefaultTableModel(RowData_MED_NAME, ColumnNames_MED_NAME);
		table_MED.setModel(model_table_MED);		// 将表格模板更换为新生成的模板模板
	
		table_MED.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_MED.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		table_MED.setRowHeight(20);
		
		if(INT_Found_MED_NAME) {
			// START 设置 table_MED 内容居中
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
			table_MED.setDefaultRenderer(Object.class, tcr);
			// END 设置 table_MED 内容居中
		}
		// END 第一个表格 药品收费表格		
	}
	
	
	public static void ItemTable() {
		// 收费项目列表
		
		// 根据SPLIT获取的数组制作要查询的WHERE部分的SQL语句
		int i = 0;
		String String_SQL_ITEM_ID_GROUP = "";
		while(i < F_ITEM_SPLIT.length) {
			
			String_SQL_ITEM_ID_GROUP = String_SQL_ITEM_ID_GROUP + F_ITEM_SPLIT[i];
			i = i + 1;
			if(i != F_ITEM_SPLIT.length) {
				String_SQL_ITEM_ID_GROUP = String_SQL_ITEM_ID_GROUP + " OR ITEM_ID = ";
			}
			
		}
		
	    String String_SQL_ITEM_NAME = "SELECT ITEM_ID, ITEM_NAME, ITEM_PRICE " +
									 	  "FROM ITEMS " + 
									 	  "WHERE ITEM_ID = " + String_SQL_ITEM_ID_GROUP;
									 	  
		MySQLConnect MySQLConnect_ITEM_NAME = new MySQLConnect(String_SQL_ITEM_NAME);
		ResultSet RS_ITEM_NAME;
		Vector RowData_ITEM_NAME, ColumnNames_ITEM_NAME;
		ColumnNames_ITEM_NAME= new Vector();
		ColumnNames_ITEM_NAME.add("");
		ColumnNames_ITEM_NAME.add("");
		ColumnNames_ITEM_NAME.add("");
		// 建立表头
		
		RowData_ITEM_NAME=new Vector(); 
		boolean INT_Found_ITEM_NAME = false;
	    try {
	    	RS_ITEM_NAME = MySQLConnect_ITEM_NAME.pst.executeQuery();
	    	if(RS_ITEM_NAME.next()) {
	    		INT_Found_ITEM_NAME = true;
	    		Vector hang_ITEM=new Vector();
	    		hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_ID"));
	    		hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_NAME"));
	        	hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_PRICE"));
	        	RowData_ITEM_NAME.add(hang_ITEM);
				while (RS_ITEM_NAME.next()) {
		            hang_ITEM=new Vector();
		            hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_ID"));
		            hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_NAME"));
		            hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_PRICE"));
		        	RowData_ITEM_NAME.add(hang_ITEM);
		        }
				RS_ITEM_NAME.close();
		        MySQLConnect_ITEM_NAME.close();
	    	}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table_ITEM=new JTable() {
			// 设置表内数据不可修改
			public boolean isCellEditable(int row, int column) { 
			    return false;
			}
		};
		
	    // 用以上生成的“列数据集合”和“行数据集合”作为参数声明一个新的 表格模板
		DefaultTableModel model_table_ITEM = new DefaultTableModel(RowData_ITEM_NAME, ColumnNames_ITEM_NAME);
		table_ITEM.setModel(model_table_ITEM);		// 将表格模板更换为新生成的模板模板
	
		table_ITEM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_ITEM.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		table_ITEM.setRowHeight(20);
		
		if(INT_Found_ITEM_NAME) {
			// START 设置 table_ITEM 内容居中
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
			table_ITEM.setDefaultRenderer(Object.class, tcr);
			// END 设置 table_ITEMITEM 内容居中
		}
		// END 第一个表格 药品收费表格		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee frame = new Fee(null);	// *修改*新构造函数
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param PAT_ID 
	 */
	public Fee(String PAT_ID) {         // *修改*新构造函数
		F_ID=PAT_ID;					// *修改*新构造函数，把输入身份证号页面的身份证号传给了F_ID
		//查询姓名
				String sql_name= "SELECT PAT_NAME FROM PATIENTS WHERE PAT_ID='"+F_ID+"'";
				MySQLConnect con_name= new MySQLConnect(sql_name);
				try {
					ResultSet ResultSet_NAME = con_name.pst.executeQuery();
					while(ResultSet_NAME.next()){
						F_NAME=ResultSet_NAME.getString("PAT_NAME");//将名字查询结果赋值给了F_NAME
					}
					ResultSet_NAME.close();
					con_name.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		//*修改*查询最新的RES_ID，因为要获取最新一条Result进行下方查询
		String SQL_RES_ID= "SELECT RESULTS_ID FROM PATIENTS WHERE PAT_ID = '" + F_ID + "' LIMIT 1" ;
		String RES_ID = null;
		MySQLConnect con_RES_ID= new MySQLConnect(SQL_RES_ID);
		try {
			ResultSet ResultSet_RES_ID = con_RES_ID.pst.executeQuery();
			ResultSet_RES_ID.next();
			RES_ID= String.valueOf(ResultSet_RES_ID.getInt("RESULTS_ID"));//将最新的RES_ID查询结果赋值给了RES_ID
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//查询药品收费并对非空进行判断   			*修改*用RES_ID进行查询
				String sql_med= "SELECT RES_MED FROM RESULTS WHERE RES_ID="+RES_ID;
				MySQLConnect con_med= new MySQLConnect(sql_med);
				try {
					ResultSet ResultSet_MED = con_med.pst.executeQuery();
						ResultSet_MED.next();
						if(ResultSet_MED.getString("RES_MED").compareTo("NULL")==0){
							JOptionPane.showMessageDialog(null, "药品收费查询结果为空", "提示", JOptionPane.ERROR_MESSAGE);
						}
						else{ 
							F_MED=ResultSet_MED.getString("RES_MED");//将药品查询结果赋值给了F_MED
							F_MED_SPLIT=F_MED.split(",");				//split方法
						}
							
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//JOptionPane.showMessageDialog(null, "药品收费查询结果为空", "提示", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				
		   //查询项目收费并对非空进行判断
				String sql_ITEM= "SELECT RES_ITEMS FROM RESULTS WHERE RES_ID="+RES_ID;
				MySQLConnect con_ITEM= new MySQLConnect(sql_ITEM);
				try {
					ResultSet ResultSet_ITEM = con_ITEM.pst.executeQuery();
					ResultSet_ITEM.next();
					if(ResultSet_ITEM.getString("RES_ITEMS").compareTo("NULL")==0){
						JOptionPane.showMessageDialog(null, "项目收费查询结果为空", "提示", JOptionPane.ERROR_MESSAGE);
					}
					else {
						F_ITEM=ResultSet_ITEM.getString("RES_ITEMS");//将收费项目查询结果赋值给了F_ITEM
						F_ITEM_SPLIT=F_ITEM.split(",");				//split方法
					}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			//查询收费总价并对非空进行判断
				String sql_SUM= "SELECT RES_SUM FROM RESULTS WHERE RES_ID="+RES_ID;
				MySQLConnect con_SUM= new MySQLConnect(sql_SUM);
				try {
					ResultSet ResultSet_SUM = con_SUM.pst.executeQuery();
					ResultSet_SUM.next();
					//ResultSet_SUM.getDouble("RES_SUM");
					F_SUM=ResultSet_SUM.getDouble("RES_SUM");		//将收费总价查询结果赋值给了F_SUM
					F_SUM_STRING=Double.toString(F_SUM);			//结果转string为F_SUM_STRING
					//JOptionPane.showMessageDialog(null, "项目收费查询结果为空", "提示", JOptionPane.ERROR_MESSAGE);
		
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
		lblNewLabel.setBounds(55, 39, 70, 30);
		panel_2.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(195, 39, 60, 30);
		panel_2.add(label_3);
		
		JLabel label_6 = new JLabel("\u5355\u4EF7");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_6.setBounds(342, 39, 35, 30);
		panel_2.add(label_6);
		
		MedicineTable();
		// table_MED = new JTable();
		table_MED.setBounds(10, 68, 413, 133);
		panel_2.add(table_MED);
		
		JButton button = new JButton("\u5DF2\u6536\u8D39");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				for(int i=0;i<F_MED_SPLIT.length;i++){				//split方法测试
//					System.out.println(F_MED_SPLIT[i]);
//					System.out.println("长度为："+F_MED_SPLIT.length);
//				}
				
				//System.out.println(F_MED_SPLIT[0]);					//测试传值用例
				
				String state = "UPDATE STATE SET STA_TUS = 5 WHERE PAT_ID='" + F_ID + "'";
				MySQLConnect STATE = new MySQLConnect(state);
				try {
					STATE.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "收费成功！请去药房取药！", "提示",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "收费失败！", "提示", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(159, 601, 93, 23);
		contentPane.add(button);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(50, 347, 433, 244);
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
		label_7.setBounds(55, 39, 70, 30);
		panel_3.add(label_7);
		
		JLabel label_9 = new JLabel("\u9879\u76EE\u540D\u79F0");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_9.setBounds(195, 39, 70, 30);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("\u5355\u4EF7");
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_10.setBounds(342, 39, 70, 30);
		panel_3.add(label_10);
		
		ItemTable();
		//table_ITEM = new JTable();
		table_ITEM.setBounds(10, 68, 413, 133);
		panel_3.add(table_ITEM);
		
		JLabel label_4 = new JLabel("\u603B\u4EF7\uFF1A");
		label_4.setBounds(10, 211, 70, 30);
		panel_3.add(label_4);
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		JLabel lblSum = new JLabel("<sum>");
		lblSum.setBounds(55, 211, 85, 30);
		panel_3.add(lblSum);
		lblSum.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblSum.setText(F_SUM_STRING);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterSystem back = new RegisterSystem();
				back.setResizable(false);
				back.setLocationRelativeTo(null);
				back.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setBounds(293, 601, 93, 23);
		contentPane.add(button_1);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
	}
}

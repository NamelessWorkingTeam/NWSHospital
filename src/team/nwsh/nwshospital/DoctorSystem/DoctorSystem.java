package team.nwsh.nwshospital.DoctorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import team.nwsh.nwshospital.MySQLConnect;
import team.nwsh.nwshospital.GeneralLogin.GeneralLogin;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Panel;

public class DoctorSystem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * @wbp.nonvisual location=969,148
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorSystem frame = new DoctorSystem(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param DOC_NAME 
	 */
	public DoctorSystem(String DOC_NAME) {
		setTitle("NWSH \u533B\u751F\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setBounds(100, 100, 1691, 1419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("\u83DC\u5355");
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		menuBar.add(menu);
		
		
		JMenuItem menuItem = new JMenuItem("\u767B\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        GeneralLogin JFrame_Login = new GeneralLogin();		// 新建登录窗口
		        JFrame_Login.setLocationRelativeTo(null);			// 将窗口放置于屏幕正中心
		        dispose(); 											// 关闭当前窗口
		        JFrame_Login.setVisible(true);						// 开启窗口
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("\u5F00\u59CB\u63A5\u8BCA");
		JMenuItem menuItem_2 = new JMenuItem("\u7ED3\u675F\u63A5\u8BCA");
		
				menuItem_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						menuItem_1.setEnabled(false);
						menuItem_2.setEnabled(true);
						menuItem.setEnabled(false);
						table_1.setEnabled(true);
						table_2.setEnabled(true);
					}
				});
				menuItem_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						menuItem_1.setEnabled(true);
						menuItem_2.setEnabled(false);
						menuItem.setEnabled(true);
						table_1.setEnabled(false);
						table_2.setEnabled(false);
					}
				});
				menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menu.add(menuItem_1);

				menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menu.add(menuItem_2);
				menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menuItem.setHorizontalAlignment(SwingConstants.RIGHT);
				menu.add(menuItem);
		
		// START候诊病人列表展示
        String String_SQL_PAT_NAME_WAIT = "SELECT STATE.STA_ID, PATIENTS.PAT_NAME " +
									 	  "FROM PATIENTS JOIN STATE ON PATIENTS.PAT_ID = STATE.PAT_ID " + 
									 	  "WHERE STATE.STA_TUS = 1 OR STATE.STA_TUS = 2 " +
									 	  "ORDER BY STATE.STA_TUS ASC;";
		MySQLConnect MySQLConnect_Connection = new MySQLConnect(String_SQL_PAT_NAME_WAIT);
		ResultSet RS_PAT_NAME_WAIT;
		Vector RowData_WAIT, ColumnNames_WAIT;
		ColumnNames_WAIT= new Vector();
		ColumnNames_WAIT.add("");
		ColumnNames_WAIT.add("");
		// ColumnNames_WAIT.add("");
		// 建立表头
		
		RowData_WAIT=new Vector(); 
		boolean INT_Found_PAT_NAME_WAIT = false;
	    try {
	    	RS_PAT_NAME_WAIT = MySQLConnect_Connection.pst.executeQuery();
	    	if(RS_PAT_NAME_WAIT.next()) {
	    		INT_Found_PAT_NAME_WAIT = true;
	    		Vector hang_WAIT=new Vector();
	    		hang_WAIT.add(RS_PAT_NAME_WAIT.getString("STA_ID"));
	        	hang_WAIT.add(RS_PAT_NAME_WAIT.getString("PAT_NAME"));
	        	RowData_WAIT.add(hang_WAIT);
				while (RS_PAT_NAME_WAIT.next()) {
		            hang_WAIT=new Vector();
		            hang_WAIT.add(RS_PAT_NAME_WAIT.getString("STA_ID"));
		            hang_WAIT.add(RS_PAT_NAME_WAIT.getString("PAT_NAME"));
		        	RowData_WAIT.add(hang_WAIT);
		        }
				RS_PAT_NAME_WAIT.close();
		        MySQLConnect_Connection.close();
	    	}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		table_1=new JTable(RowData_WAIT, ColumnNames_WAIT) {
			// 设置表内数据不可修改
			public boolean isCellEditable(int row, int column) { 
			    return false;
			}
		};
		table_1.setEnabled(false);


		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		table_1.setRowHeight(50);
		
		if(INT_Found_PAT_NAME_WAIT) {
			// START 设置 table_1 内容居中
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
			table_1.setDefaultRenderer(Object.class, tcr);
			// END 设置 table_1 内容居中
		}
		

		
		JLabel label = new JLabel("\u5019\u8BCA\u75C5\u4EBA");
		label.setFont(new Font("微软雅黑", Font.BOLD, 28));
		// END 候诊病人列表展示
		
		// START 已就诊病人列表展示
		
		String String_SQL_PAT_NAME_DONE = "SELECT PATIENTS.PAT_NAME " +
				 "FROM PATIENTS JOIN STATE ON PATIENTS.PAT_ID = STATE.PAT_ID " + 
				 "WHERE STATE.STA_TUS = 3;";
		MySQLConnect MySQLConnect_Connection_DONE = new MySQLConnect(String_SQL_PAT_NAME_DONE);
		ResultSet RS_PAT_NAME_DONE;
		Vector RowData_DONE, ColumnNames_DONE;
		ColumnNames_DONE= new Vector();
		ColumnNames_DONE.add("");
		// 建立表头
		
		RowData_DONE=new Vector(); 
		boolean INT_Found_PAT_NAME_DONE = false;
		try {
			RS_PAT_NAME_DONE = MySQLConnect_Connection_DONE.pst.executeQuery();
			if(RS_PAT_NAME_DONE.next()) {
				INT_Found_PAT_NAME_DONE = true;
				Vector hang_DONE=new Vector();
				hang_DONE.add(RS_PAT_NAME_DONE.getString("PAT_NAME"));
				RowData_DONE.add(hang_DONE);
				while (RS_PAT_NAME_DONE.next()) {
					hang_DONE=new Vector();
					hang_DONE.add(RS_PAT_NAME_DONE.getString("PAT_NAME"));
					RowData_DONE.add(hang_DONE);
				}
				RS_PAT_NAME_DONE.close();
				MySQLConnect_Connection_DONE.close();
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		

		JLabel label_1 = new JLabel("\u5DF2\u5C31\u8BCA\u75C5\u4EBA");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 28));
		
		table_2 = new JTable(RowData_DONE, ColumnNames_DONE) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_2.setEnabled(false);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setRowHeight(50);
		table_2.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		if(INT_Found_PAT_NAME_DONE) {
			// START 设置table内容居中
			DefaultTableCellRenderer tsr_DONE = new DefaultTableCellRenderer();   
			tsr_DONE.setHorizontalAlignment(JLabel.CENTER);   
			table_2.setDefaultRenderer(Object.class, tsr_DONE);
			// END 设置table内容居中
		}
		
		JLabel label_2 = new JLabel("\u5965\u65AF\u7279\u6D1B\u592B");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 50));
		

		
		JLabel label_3 = new JLabel("\u533B\u751F\uFF0C\u60A8\u597D\uFF01");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("微软雅黑", Font.BOLD, 50));

        String String_SQL_DOC_NAME = "SELECT ACC_NAME " +
				 "FROM ACCOUNTS WHERE ACC_ID = " + DOC_NAME;
		MySQLConnect Connection_DOC_NAME = new MySQLConnect(String_SQL_DOC_NAME);
		try {
			ResultSet RS_DOC_NAME = Connection_DOC_NAME.pst.executeQuery();
			RS_DOC_NAME.next();
			label_2.setText(RS_DOC_NAME.getString("ACC_NAME"));
			RS_DOC_NAME.close();
			Connection_DOC_NAME.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel label_13 = new JLabel("\u75C5   \u5386");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("微软雅黑", Font.BOLD, 50));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("\u4FDD   \u5B58");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 28));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(502, Short.MAX_VALUE)
					.addComponent(label_13)
					.addGap(497))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(518, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(513))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(14)
					.addComponent(label_13)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(30))
		);
		panel_1.setLayout(gl_panel_1);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 1655, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addComponent(label))
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
						.addComponent(table_2, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(label_1)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(label_2)
							.addGap(2)
							.addComponent(label_3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1148, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(202, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(3)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 645, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(table_2, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
							.addContainerGap())))
		);
		
		JLabel label_4 = new JLabel("\u75C5\u4EBA\u4FE1\u606F");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 50));
		
		JLabel label_5 = new JLabel("\u59D3   \u540D\uFF1A");
		label_5.setFont(new Font("微软雅黑", Font.BOLD, 50));
		
		JLabel label_6 = new JLabel("\u5E74   \u9F84\uFF1A");
		label_6.setFont(new Font("微软雅黑", Font.BOLD, 50));
		
		JLabel label_7 = new JLabel("\u6027   \u522B\uFF1A");
		label_7.setFont(new Font("微软雅黑", Font.BOLD, 50));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("微软雅黑", Font.BOLD, 30));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("微软雅黑", Font.BOLD, 30));
		textField_2.setColumns(10);
		
		JLabel label_8 = new JLabel("\u7535   \u8BDD\uFF1A");
		label_8.setFont(new Font("微软雅黑", Font.BOLD, 50));
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("微软雅黑", Font.BOLD, 30));
		textField_3.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(474, Short.MAX_VALUE)
					.addComponent(label_4)
					.addGap(470))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(283, 283, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
						.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
					.addGap(300))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addComponent(label_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
					.addGap(34))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		// END 已就诊病人列表展示
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 获取选中单元格的值
				String String_Selected_STA_ID = table_1.getValueAt(table_1.getSelectedRow(), table_1.getColumnCount() - 2).toString();
		        String String_SQL_PAT_INFO = "SELECT PAT_NAME, PAT_AGE, PAT_SEX, PAT_TEL " +
						 					 "FROM PATIENTS WHERE PAT_ID = " + 
						 					 "(SELECT PAT_ID FROM STATE WHERE STA_ID = " + 
						 					 String_Selected_STA_ID + ");";
				MySQLConnect Connection_PAT_INFO = new MySQLConnect(String_SQL_PAT_INFO);
				try {
					ResultSet RS_PAT_INFO = Connection_PAT_INFO.pst.executeQuery();
					if(RS_PAT_INFO.next()) {
						textField.setText(RS_PAT_INFO.getString("PAT_NAME"));
						textField_1.setText(RS_PAT_INFO.getString("PAT_AGE"));
						if(RS_PAT_INFO.getString("PAT_SEX").compareTo("男") == 0) {
							textField_2.setText("男");
						}
						else {
							textField_2.setText("女");
						}

						textField_3.setText(RS_PAT_INFO.getString("PAT_TEL"));
						RS_PAT_INFO.close();
						Connection_PAT_INFO.close();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}

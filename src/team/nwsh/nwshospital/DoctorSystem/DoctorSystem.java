package team.nwsh.nwshospital.DoctorSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import team.nwsh.nwshospital.MySQLConnect;
import team.nwsh.nwshospital.GeneralLogin.GeneralLogin;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

/**
 * 
 * @author liu
 * 请参考107至171行学习使用表格信息的插入！
 * 请在仔细查看后再进行修改！
 * 祝一次成功！
 * 
 */


public class DoctorSystem extends JFrame {

	private JPanel contentPane;
	private static JTable table_1;
	private static JTable table_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;
	

    private JTable table;
    private JTable table_3;
    private JTable table_4;
    private JTable table_5;
    
    private String PAT_ID = null;
    private Vector vData_table_4 = null;
    private Vector vName_table_4 = null;
    private Vector vRow_table_4 = null;
    private Vector vData_table_5 = null;
    private Vector vName_table_5 = null;
    private Vector vRow_table_5 = null;
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

	public class NwshClient {
		
		// private JTextArea incoming;
		
		public String incoming = null;

		// private JTextField outgoing;
		
		public String outgoing;

		private BufferedReader reader;

		private PrintWriter writer;

		private Socket socket;

		/**
		 * @author Liu Yummy
		 * @create 2016/12/26 11:14
		 * 负责客户端的启动,包括的功能:
		 * 1. 初始化网络;
		 * 2. 从服务端读取消息,动态刷新本地内容;
		 * 另外，原本想将本类写成模块独立开来，
		 * 但是发现IncomingReader在调用的时候无法独立调用，
		 * 所以暂且用此方法进行使用！
		 */
		public void startUp()
		{
	        outgoing = "new";

	        setupNetwork();
	        
	        // 处理接收到的信息
	        Thread readerThread = new Thread(new IncomingReader());
	        readerThread.start();

		}

		private void setupNetwork() {
			try {
				// 进行网络初始化: 创建socket连接,获取socket的输入输出流
				socket = new Socket("127.0.0.1", 5000);
				
				InputStreamReader stream = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(stream);
				
				writer = new PrintWriter(socket.getOutputStream());
				
				System.out.println("网络初始化已经完成,服务端已连接!");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void SendMessage() {
			try {
				// 向socket中写入消息
				writer.println(outgoing);
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				// 发生数据流，刷新
				writer.flush();
				// System.out.println("writer closed");
			}
		}
		
		public class IncomingReader implements Runnable {
			public void run() {
				String message;
				try {
					// 从socket中读取消息
					while((message = reader.readLine()) != null) {
						incoming = message;
						if(incoming.compareTo("new") == 0) {
							textArea.append(incoming + "\n");
							PatientWaitTable();
							PatientDoneTable();
						}

					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void PatientWaitTable() {
		// START候诊病人列表展示
        String String_SQL_PAT_NAME_WAIT = "SELECT STATE.STA_ID, PATIENTS.PAT_NAME " +
									 	  "FROM PATIENTS JOIN STATE ON PATIENTS.PAT_ID = STATE.PAT_ID " + 
									 	  "WHERE STATE.STA_TUS = 1 OR STATE.STA_TUS = 2 " +
									 	  "ORDER BY STATE.STA_TUS ASC;";
		MySQLConnect MySQLConnect_Connection_WAIT = new MySQLConnect(String_SQL_PAT_NAME_WAIT);
		ResultSet RS_PAT_NAME_WAIT;
		Vector RowData_WAIT, ColumnNames_WAIT;
		ColumnNames_WAIT= new Vector();			// 建立列集合
		ColumnNames_WAIT.add("");				// 添加列头
		ColumnNames_WAIT.add("");				// 添加列头
		
		RowData_WAIT=new Vector(); 				// 建立行数据集合
		boolean INT_Found_PAT_NAME_WAIT = false;
	    try {
	    	RS_PAT_NAME_WAIT = MySQLConnect_Connection_WAIT.pst.executeQuery();
	    	if(RS_PAT_NAME_WAIT.next()) {
	    		INT_Found_PAT_NAME_WAIT = true;
	    		Vector hang_WAIT=new Vector();								// 建立行内数据集合
	    		hang_WAIT.add(RS_PAT_NAME_WAIT.getString("STA_ID"));		// 添加行内第一列数据
	        	hang_WAIT.add(RS_PAT_NAME_WAIT.getString("PAT_NAME"));		// 添加行内第二列数据
	        	RowData_WAIT.add(hang_WAIT);								// 将添加完数据的 行内数据集 添加到 行数据集合 中去
				while (RS_PAT_NAME_WAIT.next()) {							// 循环创建 行内数据集 并添加到 行数据集合
		            hang_WAIT=new Vector();
		            hang_WAIT.add(RS_PAT_NAME_WAIT.getString("STA_ID"));
		            hang_WAIT.add(RS_PAT_NAME_WAIT.getString("PAT_NAME"));
		        	RowData_WAIT.add(hang_WAIT);
		        }
				RS_PAT_NAME_WAIT.close();
		        MySQLConnect_Connection_WAIT.close();
	    	}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    /**
	     * 
	     * 注意！此处我们使用模板来向表中添加数据！
	     * 这样可以避免重复声明表格的步骤！方便多次修改！
	     * 多次修改的用法请参考本文件第947行上下文使用方式！
	     * 本文件还涉及到另一种动态添加的方式，请参考本文件562行至601行内容！
	     * 
	     */
	    
	    // 用以上生成的“列数据集合”和“行数据集合”作为参数声明一个新的 表格模板
		DefaultTableModel model_table_1 = new DefaultTableModel(RowData_WAIT, ColumnNames_WAIT);
		table_1.setModel(model_table_1);		// 将表格模板更换为新生成的模板模板
		
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
		// END 候诊病人列表展示		
	}
	
	public static void PatientDoneTable() {
		// START 已就诊病人列表展示
		
		String String_SQL_PAT_NAME_DONE = "SELECT STATE.STA_ID, PATIENTS.PAT_NAME " +
				 "FROM PATIENTS JOIN STATE ON PATIENTS.PAT_ID = STATE.PAT_ID " + 
				 "WHERE STATE.STA_TUS = 4;";
		MySQLConnect MySQLConnect_Connection_DONE = new MySQLConnect(String_SQL_PAT_NAME_DONE);
		ResultSet RS_PAT_NAME_DONE;
		Vector RowData_DONE, ColumnNames_DONE;
		ColumnNames_DONE= new Vector();
		ColumnNames_DONE.add("");
		ColumnNames_DONE.add("");
		// 建立表头
		
		RowData_DONE=new Vector(); 
		boolean INT_Found_PAT_NAME_DONE = false;
		try {
			RS_PAT_NAME_DONE = MySQLConnect_Connection_DONE.pst.executeQuery();
			if(RS_PAT_NAME_DONE.next()) {
				INT_Found_PAT_NAME_DONE = true;
				Vector hang_DONE=new Vector();
				hang_DONE.add(RS_PAT_NAME_DONE.getString("STA_ID"));
				hang_DONE.add(RS_PAT_NAME_DONE.getString("PAT_NAME"));
				RowData_DONE.add(hang_DONE);
				while (RS_PAT_NAME_DONE.next()) {
					hang_DONE=new Vector();
					hang_DONE.add(RS_PAT_NAME_DONE.getString("STA_ID"));
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
		


		DefaultTableModel model_table_2 = new DefaultTableModel(RowData_DONE, ColumnNames_DONE);
		table_2.setModel(model_table_2);
		
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
		// END 已就诊病人列表展示
	}
	
	/**
	 * Create the frame.
	 * @param DOC_NAME 
	 */
	public DoctorSystem(String DOC_ID) {
		setTitle("NWSH \u533B\u751F\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);

		setBounds(100, 100, 2610, 1419);
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
		menuItem_2.setEnabled(false);
		

				menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menu.add(menuItem_1);

				menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menu.add(menuItem_2);
				menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menuItem.setHorizontalAlignment(SwingConstants.RIGHT);
				menu.add(menuItem);
		
		
				
		// 列出等候病人列表
		table_1=new JTable() {
		// 设置表内数据不可修改
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		PatientWaitTable();

				

		
		JLabel label = new JLabel("\u5019\u8BCA\u75C5\u4EBA");
		label.setFont(new Font("微软雅黑", Font.BOLD, 28));

		

		
		JLabel label_1 = new JLabel("\u5DF2\u5C31\u8BCA\u75C5\u4EBA");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 28));
		
		
		
		
		// 列出已诊断病人列表
		table_2 = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		PatientDoneTable();
		
		
		NwshClient UpdatePatientInfoClient = new NwshClient();
		UpdatePatientInfoClient.startUp();
		
		System.out.println(UpdatePatientInfoClient.incoming);
		
		
		JLabel label_2 = new JLabel("\u5965\u65AF\u7279\u6D1B\u592B");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 50));

		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("微软雅黑", Font.BOLD, 40));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"    \u836F       \u54C1", "    \u68C0\u67E5\u9879\u76EE"}));
		
		JButton button = new JButton("\u641C   \u7D22");
		button.setEnabled(false);
		button.setFont(new Font("微软雅黑", Font.BOLD, 40));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String String_SQL = null;
				if(comboBox.getSelectedIndex() == 0) {
					String_SQL = "SELECT MED_ID, MED_NAME, MED_PRICE " +
							 "FROM MEDICINE " + 
							 "WHERE MED_NAME LIKE '%" + textField_4.getText() + "%'";
				}
				if(comboBox.getSelectedIndex() == 1) {
					String_SQL = "SELECT ITEM_ID, ITEM_NAME, ITEM_PRICE " +
							 "FROM ITEMS " + 
							 "WHERE ITEM_NAME LIKE '%" + textField_4.getText() + "%'";
				}
				TableModel mm=new TableModel(String_SQL);
				table.setRowHeight(50);
				table.setFont(new Font("微软雅黑", Font.PLAIN, 24));
				table.setModel(mm);
			}
		});
		
		JLabel lblnwsh = new JLabel("\u533B\u751F\uFF0C\u60A8\u597D\uFF01\u6B22\u8FCE\u4F7F\u7528NWSH \u533B\u751F\u7AEF\uFF01");
		lblnwsh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnwsh.setFont(new Font("微软雅黑", Font.BOLD, 50));

        String String_SQL_DOC_NAME = "SELECT ACC_NAME " +
				 "FROM ACCOUNTS WHERE ACC_ID = " + DOC_ID;
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
		
		JLabel label_13 = new JLabel("\u75C5   \u5386");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("微软雅黑", Font.BOLD, 50));
		
		textArea = new JTextArea();
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel = new JLabel("\u8FD9\u91CC\u662F\u4E00\u4E2A\u65F6\u949F\u6A21\u5757\u54E6\uFF01");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 40));
		
	    ActionListener taskPerformer = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            String s=String.format("%tY-%<tm-%<td   %<tH:%<tM:%<tS",new Date());
	            lblNewLabel.setText(s);
	        }
	    };  
	    new Timer(1000, taskPerformer).start();
		

	    
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 2837, Short.MAX_VALUE)
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1148, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1098, Short.MAX_VALUE)
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
								.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
								.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(label_2)
							.addGap(2)
							.addComponent(lblnwsh)
							.addGap(631)
							.addComponent(lblNewLabel)))
					.addGap(265))
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
							.addComponent(table_2, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblnwsh, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 485, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		
		JLabel label_9 = new JLabel("\u68C0\u67E5\u9879\u76EE");
		label_9.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		table_5 = new JTable();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(table_5, GroupLayout.PREFERRED_SIZE, 1052, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(489, Short.MAX_VALUE)
					.addComponent(label_9)
					.addGap(485))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addGap(11)
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(table_5, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel label_3 = new JLabel("\u836F   \u65B9");
		label_3.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		table_3 = new JTable();
		
		table_4 = new JTable();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(table_4, GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(table_3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 777, Short.MAX_VALUE)
							.addComponent(label_3)
							.addGap(501))))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(table_3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_4, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		table = new JTable();
		vData_table_4 = new Vector();
		vName_table_4 = new Vector();
		vName_table_4.add("column1");
		vName_table_4.add("column2");
		vName_table_4.add("column3");
		table_4.setRowHeight(50);
		table_4.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		vData_table_5 = new Vector();
		vName_table_5 = new Vector();
		vName_table_5.add("column1");
		vName_table_5.add("column2");
		vName_table_5.add("column3");
		table_5.setRowHeight(50);
		table_5.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(comboBox.getSelectedIndex() == 0) {
					vRow_table_4 = new Vector();
					vRow_table_4.add(table.getValueAt(table.getSelectedRow(), table.getColumnCount() - 3).toString());
					vRow_table_4.add(table.getValueAt(table.getSelectedRow(), table.getColumnCount() - 2).toString());
					vRow_table_4.add(table.getValueAt(table.getSelectedRow(), table.getColumnCount() - 1).toString());
					vData_table_4.add(vRow_table_4.clone());
					DefaultTableModel model_table_4 = new DefaultTableModel(vData_table_4, vName_table_4);
					table_4.setModel(model_table_4);
				}
				if(comboBox.getSelectedIndex() == 1) {
					vRow_table_5 = new Vector();
					vRow_table_5.add(table.getValueAt(table.getSelectedRow(), table.getColumnCount() - 3).toString());
					vRow_table_5.add(table.getValueAt(table.getSelectedRow(), table.getColumnCount() - 2).toString());
					vRow_table_5.add(table.getValueAt(table.getSelectedRow(), table.getColumnCount() - 1).toString());
					vData_table_5.add(vRow_table_5.clone());
					DefaultTableModel model_table_5 = new DefaultTableModel(vData_table_5, vName_table_5);
					table_5.setModel(model_table_5);
				}
			}
		});
		
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
		);
		panel_5.setLayout(gl_panel_5);
		
		
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setFont(new Font("微软雅黑", Font.BOLD, 42));
		textField_4.setColumns(10);
		

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(281))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
						.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
					.addGap(510))
		);
		panel_2.setLayout(gl_panel_2);
		
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
		
		JButton button1 = new JButton("\u63A5  \u8BCA");
		button1.setEnabled(false);
		button1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		JButton button2 = new JButton("\u7ED3  \u675F");
		button2.setEnabled(false);
		button2.setFont(new Font("微软雅黑", Font.BOLD, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(182, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_8)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
							.addGap(126))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addGap(205)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addGap(145))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
										.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
										.addComponent(label_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(25))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(243, Short.MAX_VALUE))))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		// END 已就诊病人列表展示
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 获取选中单元格的值
				String String_Selected_STA_ID = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
		        String String_SQL_PAT_INFO = "SELECT PAT_NAME, PAT_AGE, PAT_SEX, PAT_TEL, PAT_ID " +
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
						PAT_ID = RS_PAT_INFO.getString("PAT_ID");
						RS_PAT_INFO.close();
						Connection_PAT_INFO.close();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				button1.setEnabled(true);
			}
		});
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
				button1.setEnabled(false);
				button2.setEnabled(false);
			}
		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button1.setEnabled(false);
				button2.setEnabled(true);
				menuItem_2.setEnabled(false);
				comboBox.setEnabled(true);
				textField_4.setEnabled(true);
				button.setEnabled(true);
				// 将状态码修改为就诊状态 STA_TUS = 3
		        String String_SQL_UPDATE_STATE = "UPDATE STATE SET STA_TUS = 3 "
						+ "WHERE PAT_ID = '" + PAT_ID + "';";
				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(String_SQL_UPDATE_STATE);
				try {
				MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
				MySQLConnect_Connection_UPDATE_STATE.pst.close();
				MySQLConnect_Connection_UPDATE_STATE.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button2.setEnabled(false);
				menuItem_2.setEnabled(true);
				comboBox.setEnabled(false);
				textField_4.setEnabled(false);
				button.setEnabled(false);
				
				// 以下是生成结果部分
				
				String String_RES_MED = null;
				String String_RES_ITEMS = null;
				Double Double_RES_SUM = 0.0;
				
				int i = 1;
				if(i <= table_4.getRowCount()) {
					String_RES_MED = table_4.getValueAt(0, 0).toString();
					Double_RES_SUM = Double_RES_SUM + Double.parseDouble(table_4.getValueAt(0, 2).toString());
					while(i < table_4.getRowCount()) {
						String_RES_MED = String_RES_MED + "," + table_4.getValueAt(i, 0).toString();
						Double_RES_SUM = Double_RES_SUM + Double.parseDouble(table_4.getValueAt(i, 2).toString());
						i = i + 1;
					}
				}
				else {
					String_RES_MED = "NULL";
				}

				i = 1;
				if(i <= table_5.getRowCount()) {
					String_RES_ITEMS = table_5.getValueAt(0, 0).toString();
					Double_RES_SUM = Double_RES_SUM + Double.parseDouble(table_5.getValueAt(0, 2).toString());
					while(i < table_5.getRowCount()) {
						String_RES_ITEMS = String_RES_ITEMS + "," + table_5.getValueAt(i, 0).toString();
						Double_RES_SUM = Double_RES_SUM + Double.parseDouble(table_5.getValueAt(i, 2).toString());
						i = i + 1;
					}
				}
				else {
					String_RES_ITEMS = "NULL";
				}
				// 将RES_NUM四舍五入保留两位小数
		        DecimalFormat df = new DecimalFormat("#.00");
		        Double_RES_SUM = Double.parseDouble(df.format(Double.parseDouble(Double_RES_SUM.toString())));
		        
		        // 插入结果记录到RESULTS表
		        String String_SQL_INSERT_RESULT = "INSERT INTO RESULTS VALUES(NULL, "
		        																	+ "'" + DOC_ID + "', "
		        																	+ "'" + PAT_ID + "', "
		        																	+ "'" + String_RES_MED + "', "
		        																	+ "'" + String_RES_ITEMS + "', "
		        																	+ Double_RES_SUM + ");";
				MySQLConnect MySQLConnect_Connection_INSERT_RESULT = new MySQLConnect(String_SQL_INSERT_RESULT);
				try {
					MySQLConnect_Connection_INSERT_RESULT.pst.executeUpdate();
					MySQLConnect_Connection_INSERT_RESULT.pst.close();
					MySQLConnect_Connection_INSERT_RESULT.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// 获取病人最新的结果编号
				int int_RES_ID = 0;
		        String String_SQL_RES_ID = "SELECT RES_ID " +
						 "FROM RESULTS WHERE PAT_ID = '" + PAT_ID + "' ORDER BY RES_ID DESC LIMIT 1;";
				MySQLConnect Connection_RES_ID = new MySQLConnect(String_SQL_RES_ID);
				try {
					ResultSet RS_RES_ID = Connection_RES_ID.pst.executeQuery();
					RS_RES_ID.next();
					int_RES_ID = RS_RES_ID.getInt("RES_ID");
					RS_RES_ID.close();
					Connection_RES_ID.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// 将病人与最后一次就诊记录连接
		        String String_SQL_UPDATE_PATIENT = "UPDATE PATIENTS SET RESULTS_ID = " + int_RES_ID
						+ " WHERE PAT_ID = '" + PAT_ID + "';";
				MySQLConnect MySQLConnect_Connection_UPDATE_PATIENT = new MySQLConnect(String_SQL_UPDATE_PATIENT);
				try {
				MySQLConnect_Connection_UPDATE_PATIENT.pst.executeUpdate();
				MySQLConnect_Connection_UPDATE_PATIENT.pst.close();
				MySQLConnect_Connection_UPDATE_PATIENT.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				
				// 将状态码修改为已结诊待收取医药费状态 STA_TUS = 4
		        String String_SQL_UPDATE_STATE = "UPDATE STATE SET STA_TUS = 4 "
						+ "WHERE PAT_ID = '" + PAT_ID + "';";
				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(String_SQL_UPDATE_STATE);
				try {
				MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
				MySQLConnect_Connection_UPDATE_STATE.pst.close();
				MySQLConnect_Connection_UPDATE_STATE.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				
				vData_table_4 = new Vector();
				vName_table_4 = new Vector();
				vName_table_4.add("column1");
				vName_table_4.add("column2");
				vName_table_4.add("column3");
				vRow_table_4 = new Vector();
				DefaultTableModel model_table_4 = new DefaultTableModel(vData_table_4, vName_table_4);
				table_4.setModel(model_table_4);
				
				vData_table_5 = new Vector();
				vName_table_5 = new Vector();
				vName_table_5.add("column1");
				vName_table_5.add("column2");
				vName_table_5.add("column3");
				vRow_table_5 = new Vector();
				DefaultTableModel model_table_5 = new DefaultTableModel(vData_table_5, vName_table_5);
				table_5.setModel(model_table_5);
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				
				PatientWaitTable();
				PatientDoneTable();
				
			}
		});
		

		

	}
}

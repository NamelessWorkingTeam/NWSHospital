package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;
import team.nwsh.nwshospital.DoctorSystem.DoctorSystem.NwshClient.IncomingReader;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Register extends JFrame {
	static String sec;
	static String sex;
	static String R_ID=RegisterSystem.PAT_ID;
	private JPanel contentPane;

	
	public class NwshClient {
		
		public String incoming = null;
		
		public String outgoing;

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
		public void startUp() {
	        setupNetwork();
		}

		private void setupNetwork() {
			try {
				// 进行网络初始化: 创建socket连接,获取socket的输入输出流
				socket = new Socket("127.0.0.1", 5000);
				
				InputStreamReader stream = new InputStreamReader(socket.getInputStream());
				
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
				outgoing = "newpatient";
				writer.println(outgoing);
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				// 发生数据流，刷新
				writer.flush();
			}
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 10, 433, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6302\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setBounds(202, 20, 41, 36);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 76, 433, 306);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(128, 63, 64, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(128, 103, 64, 30);
		panel_1.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(128, 183, 64, 30);
		panel_1.add(lblNewLabel_5);
		
		JLabel label = new JLabel("\u5E74\u9F84");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setBounds(128, 143, 64, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u79D1\u5BA4");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setBounds(128, 223, 64, 30);
		panel_1.add(label_1);
		
		JTextField textField_NAME = new JTextField();
		textField_NAME.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_NAME.setBounds(202, 63, 136, 30);
		panel_1.add(textField_NAME);
		
		JTextField textField_AGE = new JTextField();
		textField_AGE.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_AGE.setBounds(202, 143, 136, 30);
		panel_1.add(textField_AGE);
		
		JTextField textField_PHONE = new JTextField();
		textField_PHONE.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_PHONE.setBounds(202, 183, 136, 30);
		panel_1.add(textField_PHONE);
		
		JComboBox comboBox_SEC = new JComboBox();
		comboBox_SEC.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		comboBox_SEC.setToolTipText("\u9009\u62E9\u79D1\u5BA4");
		comboBox_SEC.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u5916\u79D1", "\u666E\u901A\u5185\u79D1", "\u4E94\u5B98\u79D1", "\u68C0\u9A8C\u79D1"}));
		
		
		//System.out.println(sec);
		comboBox_SEC.setBounds(202, 223, 136, 30);
		panel_1.add(comboBox_SEC);
		
		// 新建客户端与网络端的连接
		NwshClient RegisterClient = new NwshClient();
		RegisterClient.startUp();
		
//		if(comboBox_SEC.getSelectedItem().toString().compareTo("普通外科") == 0) {
//			// sec="5000";
//			System.out.println("success!!");
//		}
		
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_2.setBounds(128, 23, 64, 30);
		panel_1.add(label_2);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JTextField textField_ID = new JTextField();
		textField_ID.setBounds(202, 23, 136, 30);
		panel_1.add(textField_ID);
		textField_ID.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_ID.setText(R_ID);
		
		JLabel label_3 = new JLabel("\u9700\u8981\u6536\u53D6\u6302\u53F7\u8D39\uFF1A2 \u5143");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_3.setBounds(128, 263, 210, 30);
		panel_1.add(label_3);
		
		JComboBox comboBox_SEX = new JComboBox();
		comboBox_SEX.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox_SEX.setToolTipText("\u9009\u62E9\u79D1\u5BA4");
		comboBox_SEX.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		comboBox_SEX.setBounds(202, 103, 136, 30);
		panel_1.add(comboBox_SEX);
		
		JButton btnNewButton_2 = new JButton("\u6536\u8D39\u5E76\u6302\u53F7");
		btnNewButton_2.setBounds(165, 392, 108, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		JButton btnNewButton_3 = new JButton("\u8FD4\u56DE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterSystem back = new RegisterSystem();
				back.setResizable(false);
				back.setLocationRelativeTo(null);
				back.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				back.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton_3.setBounds(314, 392, 93, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_SEC.getSelectedItem().toString().compareTo("普通外科") == 0) sec="5000";
				if(comboBox_SEC.getSelectedItem().toString().compareTo("普通内科") == 0) sec="5001";
				if(comboBox_SEC.getSelectedItem().toString().compareTo("五官科") == 0)	sec="5002";
				if(comboBox_SEC.getSelectedItem().toString().compareTo("检验科") == 0)	sec="5003";
				if(comboBox_SEC.getSelectedItem().toString().compareTo("神经科") == 0)	sec="5004";
				
				if(comboBox_SEX.getSelectedItem().toString().compareTo("男") == 0) sex="M";
				if(comboBox_SEX.getSelectedItem().toString().compareTo("女") == 0) sex="F";
				String sql = "INSERT INTO PATIENTS VALUES('"+textField_ID.getText()+"','"+textField_NAME.getText()+"','"+textField_AGE.getText()+"','"+sex+"','"+textField_PHONE.getText()+"',null)";
				String sql2= "INSERT INTO STATE VALUES(NULL,'"+textField_ID.getText()+"','"+sec+"',NULL,2)";
				MySQLConnect con2= new MySQLConnect(sql2);
				MySQLConnect con = new MySQLConnect(sql);
				
				
				
				try {
					if(textField_ID.getText().length()==18){
						con.pst.executeUpdate();
						con2.pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "挂号成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
						RegisterClient.SendMessage();
					}
					else JOptionPane.showMessageDialog(null, "身份证必须18位！", "提示",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "挂号失败！", "提示", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
//				try {
//					ResultSet result = con.pst.executeQuery();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
			}
		});
	}
}

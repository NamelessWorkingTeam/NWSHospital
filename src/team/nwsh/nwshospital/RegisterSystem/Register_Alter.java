package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Register_Alter extends JFrame {
	
	static String sec;
	
	static String P_ID;//上一页面获取的身份证号
	static String P_NAME;
	static String P_SEX;
	static String P_AGE;//记得转换类型
	static String P_TEL;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {					
					Register_Alter frame = new Register_Alter();
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
	//构造方法 传值 传 姓名、性别、年龄、电话。科室信息重新用if判断
	public Register_Alter() {
		P_ID = RegisterSystem.PAT_ID;//从上个页面获取身份证号传值给P_ID
		
		
		//查询姓名
		String sql_name= "SELECT PAT_NAME FROM PATIENTS WHERE PAT_ID='"+P_ID+"'";
		MySQLConnect con_name= new MySQLConnect(sql_name);
		try {
			ResultSet ResultSet_NAME = con_name.pst.executeQuery();
			while(ResultSet_NAME.next()){
				P_NAME=ResultSet_NAME.getString("PAT_NAME");//将名字查询结果赋值给了P_NAME
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//查询性别
		String sql_sex= "SELECT PAT_SEX FROM PATIENTS WHERE PAT_ID='"+P_ID+"'";
		MySQLConnect con_sex= new MySQLConnect(sql_sex);
		try {
			ResultSet ResultSet_SEX = con_sex.pst.executeQuery();
			while(ResultSet_SEX.next()){
				P_SEX=ResultSet_SEX.getString("PAT_SEX");//将名字查询结果赋值给了P_SEX
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//查询年龄
				String sql_age= "SELECT PAT_AGE FROM PATIENTS WHERE PAT_ID='"+P_ID+"'";
				MySQLConnect con_age= new MySQLConnect(sql_age);
				try {
					ResultSet ResultSet_AGE = con_age.pst.executeQuery();
					while(ResultSet_AGE.next()){
						P_AGE=ResultSet_AGE.getString("PAT_AGE");//将名字查询结果赋值给了P_AGE
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
				//查询电话
				String sql_tel= "SELECT PAT_TEL FROM PATIENTS WHERE PAT_ID='"+P_ID+"'";
				MySQLConnect con_tel= new MySQLConnect(sql_tel);
				try {
					ResultSet ResultSet_TEL = con_tel.pst.executeQuery();
					while(ResultSet_TEL.next()){
						P_TEL=ResultSet_TEL.getString("PAT_TEL");//将名字查询结果赋值给了P_AGE
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(48, 10, 433, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u9884\u7EA6\u4FE1\u606F\u786E\u8BA4");
		label.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label.setBounds(157, 20, 147, 36);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(48, 76, 433, 281);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setBounds(128, 63, 64, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setBounds(128, 103, 64, 30);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_3.setBounds(128, 183, 64, 30);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\u5E74\u9F84");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_4.setBounds(128, 143, 64, 30);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("\u79D1\u5BA4");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_5.setBounds(128, 223, 64, 30);
		panel_1.add(label_5);
		
		JTextField textField_NAME = new JTextField();
		textField_NAME.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_NAME.setBounds(202, 63, 136, 30);
		panel_1.add(textField_NAME);
		textField_NAME.setText(P_NAME);//表格填充名字
		
		JTextField textField_SEX = new JTextField();
		textField_SEX.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_SEX.setBounds(202, 103, 136, 30);
		panel_1.add(textField_SEX);
		textField_SEX.setText(P_SEX);//表格填充性别
		
		JTextField textField_AGE = new JTextField();
		textField_AGE.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_AGE.setBounds(202, 143, 136, 30);
		panel_1.add(textField_AGE);
		textField_AGE.setText(P_AGE);//表格填充年龄
		
		JTextField textField_TEL = new JTextField();
		textField_TEL.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_TEL.setBounds(202, 183, 136, 30);
		panel_1.add(textField_TEL);
		textField_TEL.setText(P_TEL);//表格填充电话
		
		JComboBox comboBox_KESHI = new JComboBox();
		comboBox_KESHI.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u5916\u79D1", "\u666E\u901A\u5185\u79D1", "\u4E94\u5B98\u79D1", "\u68C0\u9A8C\u79D1"}));
		comboBox_KESHI.setToolTipText("\u9009\u62E9\u79D1\u5BA4");
		comboBox_KESHI.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		comboBox_KESHI.setBounds(202, 223, 136, 30);
		panel_1.add(comboBox_KESHI);
		
		JLabel label_6 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_6.setBounds(128, 23, 64, 30);
		panel_1.add(label_6);
		
		JTextField textField_ID = new JTextField();
		textField_ID.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_ID.setBounds(202, 23, 136, 30);
		panel_1.add(textField_ID);
		textField_ID.setText(P_ID);//上一页面获取的身份证号
		
		JButton button_2 = new JButton("\u53D6\u6D88");
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		button_2.setBounds(312, 380, 93, 23);
		contentPane.add(button_2);
		//按钮“确认修改并收费”
		JButton button_1 = new JButton("\u786E\u8BA4\u9884\u7EA6\u5E76\u6536\u8D39");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_KESHI.getSelectedItem().toString().compareTo("普通外科") == 0) sec="5000";
				if(comboBox_KESHI.getSelectedItem().toString().compareTo("普通内科") == 0) sec="5001";
				if(comboBox_KESHI.getSelectedItem().toString().compareTo("五官科") == 0)	sec="5002";
				if(comboBox_KESHI.getSelectedItem().toString().compareTo("检验科") == 0)	sec="5003";
				
//修改科室信息，并把状态STA_TUS置为1				
				String sql = " UPDATE STATE SET SEC_ID='"+sec+"',STA_TUS=1 WHERE PAT_ID='"+P_ID+"' ";

				MySQLConnect con = new MySQLConnect(sql);
				try {
					con.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "数据库写入成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "数据库写入失败！", "提示", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				
				
				
				

			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		button_1.setBounds(155, 380, 147, 23);
		contentPane.add(button_1);
	}
}

package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;
import team.nwsh.nwshospital.GeneralLogin.GeneralLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class RegisterSystem extends JFrame {
	
	static String PAT_ID;//获取输入的身份证号
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterSystem frame = new RegisterSystem();
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
	public RegisterSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 10, 435, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u6302\u53F7\u5904");
		label.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label.setBounds(199, 10, 50, 35);
		panel.add(label); 
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setBounds(162, 90, 126, 35);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		textField.setBounds(162, 135, 180, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		
		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PAT_ID=textField.getText();			//把textfield的值存到PAT_ID
				//String String_SQL_PAT_ID = "SELECT STA_TUS FROM STATE WHERE PAT_ID = '" + textField.getText() + "'";
				String String_SQL_PAT_ID = "SELECT STA_TUS FROM STATE WHERE PAT_ID = '"+PAT_ID+"'";
				MySQLConnect con = new MySQLConnect(String_SQL_PAT_ID);
				try {
					ResultSet result = con.pst.executeQuery();
						// result.next();
						if(result.next()) {
							String state = result.getString("STA_TUS");
							int i = Integer.parseInt(state);
							switch(i){
							case 0://预约病人，需要确认
								Register_Alter alter = new Register_Alter();
								alter.setResizable(false);
								alter.setLocationRelativeTo(null);
								alter.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
								alter.setVisible(true);
								dispose();
								break;
							case 1:
								JOptionPane.showMessageDialog(null, "已收费的预约病人，请去就诊！", "提示", JOptionPane.INFORMATION_MESSAGE); 
								//System.out.print("已收费的预约病人");
							break;
							case 2:
								JOptionPane.showMessageDialog(null, "已收费的挂号病人，请去就诊！", "提示", JOptionPane.INFORMATION_MESSAGE); 
								//System.out.print("已收费的挂号病人");
								break;
							case 3:
								JOptionPane.showMessageDialog(null, "正在就诊！", "提示", JOptionPane.ERROR_MESSAGE);
								break;
							case 4:
								Fee fee2 = new Fee();
								fee2.setResizable(false);
								fee2.setLocationRelativeTo(null);
								fee2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
								fee2.setVisible(true);
								dispose();
								break;
							}
						}
						else {
							Register register = new Register();
							register.setResizable(false);
							register.setLocationRelativeTo(null);
							register.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							register.setVisible(true);
							dispose();
						}

					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		button_1.setBounds(162, 179, 80, 27);
		panel.add(button_1);
		
		JButton button = new JButton("\u9000\u51FA\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneralLogin back = new GeneralLogin();
				back.setResizable(false);
				back.setLocationRelativeTo(null);
				back.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				back.setVisible(true);
				dispose();
				
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		button.setBounds(325, 354, 100, 27);
		panel.add(button);
	}
}

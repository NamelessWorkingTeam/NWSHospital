package team.nwsh.nwshospital.GeneralLogin;

import team.nwsh.nwshospital.DirectorSystem.*;
import team.nwsh.nwshospital.DoctorSystem.*;
import team.nwsh.nwshospital.RegisterSystem.*;
import team.nwsh.nwshospital.MySQLConnect;
import team.nwsh.nwshospital.AdminSystem.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GeneralLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralLogin frame = new GeneralLogin();
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
	public GeneralLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NWSHospital \u7EDF\u4E00\u767B\u5F55");
		lblNewLabel.setBounds(71, 21, 331, 49);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(122, 74, 229, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setBounds(0, 2, 72, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setBounds(0, 40, 72, 29);
		panel.add(label);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		textField = new JTextField();
		textField.setBounds(83, 0, 146, 35);
		panel.add(textField);
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		textField.setColumns(10);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, lblNewLabel_1, label, textField, passwordField}));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 38, 146, 35);
		panel.add(passwordField);
		passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		passwordField.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String String_SQL_ACC_ID = "SELECT ACC_PASSWORD FROM ACCOUNTS WHERE ACC_ID = '" + textField.getText() + "'";
				MySQLConnect MySQLConnect_Connection = new MySQLConnect(String_SQL_ACC_ID);
				
				int Int_IfEmptyField = 0;
				if(textField.getText().trim().compareTo("") == 0) {
					Int_IfEmptyField = Int_IfEmptyField + 1;
					System.out.println(Int_IfEmptyField);
				}
				if(String.valueOf(passwordField.getPassword()).compareTo("") == 0) {
					Int_IfEmptyField = Int_IfEmptyField + 2;
					System.out.println(Int_IfEmptyField);
				}
				
				String String_EmptyField = "";
				switch(Int_IfEmptyField) {
				case 1:
					String_EmptyField = "账号不能为空！";
					break;
				case 2:
					String_EmptyField = "密码不能为空！";
					break;
				case 3:
					String_EmptyField = "账号和密码不能为空！";
					break;
				}

				if(Int_IfEmptyField == 0) {
					try {
						ResultSet ResultSet_PASSWORD = MySQLConnect_Connection.pst.executeQuery();
					
						if(ResultSet_PASSWORD.next()) {
							if(ResultSet_PASSWORD.getString("ACC_PASSWORD").compareTo(String.valueOf(passwordField.getPassword())) == 0) {
								switch(Integer.parseInt(textField.getText()) / 100000) {
								case 1:
									DirectorSystem DirectorSystem_NewFrame = new DirectorSystem();
									DirectorSystem_NewFrame.setResizable(false);
									DirectorSystem_NewFrame.setLocationRelativeTo(null);
									DirectorSystem_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
									DirectorSystem_NewFrame.setVisible(true);
									dispose();
									break;
								case 2:
									AdminSystem AdminSystem_NewFrame = new AdminSystem();
									AdminSystem_NewFrame.setResizable(false);
									AdminSystem_NewFrame.setLocationRelativeTo(null);
									AdminSystem_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
									AdminSystem_NewFrame.setVisible(true);
									dispose();	
									break;
								case 3:
									RegisterSystem RegisterSystem_NewFrame = new RegisterSystem();
									RegisterSystem_NewFrame.setResizable(false);
									RegisterSystem_NewFrame.setLocationRelativeTo(null);
									RegisterSystem_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
									RegisterSystem_NewFrame.setVisible(true);
									dispose();
									break;
								case 4:
									JOptionPane.showMessageDialog(null,
											"这里应该弹出的是药房界面！", "系统信息", JOptionPane.INFORMATION_MESSAGE);
									break;
								case 5:
									DoctorSystem DoctorSystem_NewFrame = new DoctorSystem();
									DoctorSystem_NewFrame.setResizable(false);
									DoctorSystem_NewFrame.setLocationRelativeTo(null);
									DoctorSystem_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
									DoctorSystem_NewFrame.setVisible(true);
									dispose();
									break;
								}
							}
							else {
								JOptionPane.showMessageDialog(null, 
										"用户名或密码错误！", "系统信息", JOptionPane.WARNING_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, 
									"用户名或密码错误！", "系统信息", JOptionPane.WARNING_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, 
							String_EmptyField, "系统信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		button.setBounds(132, 157, 96, 37);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		button_1.setBounds(243, 157, 96, 37);
		contentPane.add(button_1);
	}
}

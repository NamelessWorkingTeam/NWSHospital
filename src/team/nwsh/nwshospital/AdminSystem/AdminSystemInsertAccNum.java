package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminSystemInsertAccNum extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemInsertAccNum frame = new AdminSystemInsertAccNum();
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
	public AdminSystemInsertAccNum() {
		setTitle("\u589E\u52A0\u8D26\u53F7\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBounds(75, 84, 65, 25);
		contentPane.add(label);
		
		Label label_1 = new Label("\u8BF7\u8F93\u5165\u8D26\u53F7\u4FE1\u606F");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_1.setBounds(129, 10, 161, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(188, 54, 147, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label label_2 = new Label("\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(90, 121, 44, 25);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 122, 147, 24);
		contentPane.add(passwordField);
		
		Label label_3 = new Label("\u7528\u6237 ID\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(71, 53, 65, 25);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 85, 147, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Label label_4 = new Label("\u6240\u5C5E\u79D1\u5BA4\uFF1A");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_4.setBounds(60, 152, 77, 25);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(188, 152, 147, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="INSERT INTO ACCOUNTS VALUES ('"+textField.getText()+"','"+textField_1.getText()+"','"+passwordField.getText()+"','"+textField_2.getText()+"')";
				   MySQLConnect con=new MySQLConnect(sql);
				   int key=1;//定义一个中间变量，来判断输入信息的窗口，如果成功 则 保存成功
				   try{
					if(textField.getText().equals("")||textField_1.getText().equals("")||passwordField.getText().equals("")||textField_2.getText().equals("")) 
				   {JOptionPane.showMessageDialog(null, "内容不能为空"); key=0;}	
				   if(key==1) { con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "保存成功");}
				   }catch(SQLException e1){
					   e1.printStackTrace();
				   }
					
		           }

			
		});
		btnNewButton.setBounds(305, 190, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemAddInfo newframe = new AdminSystemAddInfo();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton_1.setBounds(305, 225, 113, 27);
		contentPane.add(btnNewButton_1);
	}
}

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminSystemItemChange extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemItemChange frame = new AdminSystemItemChange();
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
	public AdminSystemItemChange() {
		setTitle("\u9879\u76EE\u4FEE\u6539\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u9879\u76EE\u540D\u79F0\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBounds(27, 85, 77, 25);
		contentPane.add(label);
		
		Label label_1 = new Label("\u9879\u76EE\u4EF7\u683C\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(27, 129, 77, 25);
		contentPane.add(label_1);
		
		Label label_2 = new Label("\u9879\u76EEID(\u9ED8\u8BA4\u4E0D\u53D8)\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(27, 41, 130, 25);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(199, 42, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 86, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 129, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("保存");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="UPDATE ITEMS SET ITEM_NAME=('"+textField_1.getText()+"') ,ITEM_PRICE = ('"+textField_2.getText()+"') WHERE ITEM_ID =('"+textField.getText()+"')";
				   MySQLConnect con=new MySQLConnect(sql);
				   int key=1;//定义一个中间变量，来判断输入信息的窗口，如果成功 则 保存成功
				   try{
					if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")) 
				   {JOptionPane.showMessageDialog(null, "内容不能为空"); key=0;}	
				   if(key==1) { con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "保存成功");}
				   }catch(SQLException e1){
					   e1.printStackTrace();
				   }
			}
		});
		btnNewButton.setBounds(318, 173, 86, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5173\u95ED");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_1.setBounds(318, 213, 86, 27);
		contentPane.add(btnNewButton_1);
	}

}

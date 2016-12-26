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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminSystemInsertMedicines extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemInsertMedicines frame = new AdminSystemInsertMedicines();
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
	public AdminSystemInsertMedicines() {
		setTitle("\u589E\u8BBE\u836F\u54C1\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_1 = new Label("\u836F\u54C1\u540D\u79F0\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(55, 65, 77, 25);
		contentPane.add(label_1);
		
		Label label_2 = new Label("\u836F\u54C1\u4EF7\u683C\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(55, 110, 77, 25);
		contentPane.add(label_2);
		
		Label label_3 = new Label("\u836F\u54C1\u6570\u91CF\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(55, 153, 77, 25);
		contentPane.add(label_3);
		
		Label label_4 = new Label("\u8BF7\u589E\u52A0\u836F\u54C1");
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_4.setBounds(159, 9, 113, 25);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 65, 150, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 110, 150, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(138, 154, 150, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sql="INSERT INTO MEDICINE VALUES (null,'"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"')";
		    MySQLConnect con=new MySQLConnect(sql);
		    int key=1;//定义一个中间变量，来判断输入信息的窗口，如果成功 则 保存成功
			       try{
					   if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")) 
					   {JOptionPane.showMessageDialog(null, "内容不能为空"); key=0;}	
					 if(key==1) { con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "保存成功");}
				   }catch(SQLException e1){
					   e1.printStackTrace();
				   }
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton.setBounds(305, 181, 113, 27);
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
		btnNewButton_1.setBounds(305, 221, 113, 27);
		contentPane.add(btnNewButton_1);
	}
}

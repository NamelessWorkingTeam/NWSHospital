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

public class AdminSystemMEDChange extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemMEDChange frame = new AdminSystemMEDChange();
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
	public AdminSystemMEDChange() {
		setTitle("\u4FEE\u6539\u836F\u54C1\u4FE1\u606F\u3002");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_1 = new Label("\u836F\u54C1\u540D\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(34, 85, 77, 25);
		contentPane.add(label_1);
		
		Label label_2 = new Label("\u836F\u54C1\u4EF7\u683C\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(34, 121, 77, 25);
		contentPane.add(label_2);
		
		Label label_3 = new Label("\u836F\u54C1\u6570\u91CF\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(34, 162, 77, 25);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 48, 113, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 85, 113, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 122, 113, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql="UPDATE MEDICINE SET MED_NAME=('"+textField_2.getText()+"') ,MED_PRICE = ('"+textField_3.getText()+"'),MED_STORGE = ('"+textField.getText()+"') WHERE MED_ID =('"+textField_1.getText()+"')";
				   MySQLConnect con=new MySQLConnect(sql);
				   int key=1;//定义一个中间变量，来判断输入信息的窗口，如果成功 则 保存成功
				   try{
					if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")) 
				   {JOptionPane.showMessageDialog(null, "内容不能为空"); key=0;}	
				   if(key==1) { con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "保存成功");}
				   }catch(SQLException e1){
					   e1.printStackTrace();
				   }
			}
		});
		button.setBounds(331, 177, 87, 27);
		contentPane.add(button);
		
		Label label = new Label("\u836F\u54C1ID:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBounds(34, 48, 77, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(150, 163, 113, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemShowMEDInfo newframe = new AdminSystemShowMEDInfo();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(331, 217, 87, 27);
		contentPane.add(btnNewButton);
	}
}

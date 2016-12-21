package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class AdminSystemManage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemManage frame = new AdminSystemManage();
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
	public AdminSystemManage() {
		setTitle("\u7BA1\u7406\u5458\u7BA1\u7406\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u7BA1\u7406\u5458\u7BA1\u7406\u83DC\u5355");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(142, 10, 138, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(75, 63, 231, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label label_1 = new Label("\u68C0\u7D22\u4FE1\u606F\uFF1A");
		label_1.setBounds(24, 63, 77, 25);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.setBounds(320, 62, 71, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0\u4FE1\u606F");
		btnNewButton_1.setBounds(24, 118, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u4FE1\u606F");
		btnNewButton_2.setBounds(151, 118, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_3.setBounds(278, 118, 113, 27);
		contentPane.add(btnNewButton_3);
	}
}

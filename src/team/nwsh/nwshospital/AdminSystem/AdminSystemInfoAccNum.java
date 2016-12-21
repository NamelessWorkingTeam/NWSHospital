package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSystemInfoAccNum extends JFrame {

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
					AdminSystemInfoAccNum frame = new AdminSystemInfoAccNum();
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
	public AdminSystemInfoAccNum() {
		setTitle("\u589E\u52A0\u8D26\u53F7\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u7528\u6237\u540D\uFF1A");
		label.setBounds(28, 103, 77, 25);
		contentPane.add(label);
		
		Label label_1 = new Label("\u8BF7\u8F93\u5165\u8D26\u53F7\u4FE1\u606F");
		label_1.setBounds(149, 10, 140, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(111, 53, 201, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label label_2 = new Label("\u5BC6\u7801\uFF1A");
		label_2.setBounds(42, 153, 44, 25);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 153, 200, 24);
		contentPane.add(passwordField);
		
		Label label_3 = new Label("\u7528\u6237 ID\uFF1A");
		label_3.setBounds(26, 53, 77, 25);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 103, 200, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Label label_4 = new Label("\u6240\u5C5E\u79D1\u5BA4\uFF1A");
		label_4.setBounds(18, 197, 77, 25);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 197, 201, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(333, 220, 80, 27);
		contentPane.add(btnNewButton);
	}
}

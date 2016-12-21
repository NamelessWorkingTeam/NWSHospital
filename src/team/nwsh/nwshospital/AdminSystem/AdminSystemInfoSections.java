package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminSystemInfoSections extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemInfoSections frame = new AdminSystemInfoSections();
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
	public AdminSystemInfoSections() {
		setTitle("\u589E\u8BBE\u79D1\u5BA4\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u8BF7\u589E\u8BBE\u79D1\u5BA4");
		label.setBounds(161, 17, 77, 25);
		contentPane.add(label);
		
		Label label_1 = new Label("\u79D1\u5BA4 ID\uFF1A");
		label_1.setBounds(34, 57, 77, 25);
		contentPane.add(label_1);
		
		Label label_2 = new Label("\u79D1\u5BA4\u540D\u79F0\uFF1A");
		label_2.setBounds(22, 125, 77, 25);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(128, 59, 152, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 125, 152, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.setBounds(304, 206, 113, 27);
		contentPane.add(btnNewButton);
	}

}

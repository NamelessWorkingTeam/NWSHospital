package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AdminSystemInfoItems extends JFrame {

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
					AdminSystemInfoItems frame = new AdminSystemInfoItems();
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
	public AdminSystemInfoItems() {
		setTitle("\u589E\u8BBE\u6536\u8D39\u9879\u76EE\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u6536\u8D39\u9879\u76EE ID\uFF1A");
		label.setBounds(22, 51, 92, 25);
		contentPane.add(label);
		
		Label label_1 = new Label("\u6536\u8D39\u9879\u76EE\u540D\u79F0\uFF1A");
		label_1.setBounds(8, 98, 111, 25);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.setBounds(294, 208, 113, 27);
		contentPane.add(btnNewButton);
		
		Label label_2 = new Label("\u8BF7\u589E\u8BBE\u6536\u8D39\u9879\u76EE");
		label_2.setBounds(156, 10, 77, 25);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(147, 51, 162, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 98, 162, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Label label_3 = new Label("\u9879\u76EE\u8D39\u7528\uFF1A");
		label_3.setBounds(39, 149, 77, 25);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 149, 162, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}

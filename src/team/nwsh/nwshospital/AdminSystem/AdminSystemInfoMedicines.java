package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminSystemInfoMedicines extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					AdminSystemInfoMedicines frame = new AdminSystemInfoMedicines();
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
	public AdminSystemInfoMedicines() {
		setTitle("\u589E\u8BBE\u836F\u54C1\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u836F\u54C1 ID\uFF1A");
		label.setBounds(45, 64, 77, 25);
		contentPane.add(label);
		
		Label label_1 = new Label("\u836F\u54C1\u540D\u79F0\uFF1A");
		label_1.setBounds(34, 95, 77, 25);
		contentPane.add(label_1);
		
		Label label_2 = new Label("\u836F\u54C1\u4EF7\u683C\uFF1A");
		label_2.setBounds(34, 125, 77, 25);
		contentPane.add(label_2);
		
		Label label_3 = new Label("\u836F\u54C1\u6570\u91CF\uFF1A");
		label_3.setBounds(35, 154, 77, 25);
		contentPane.add(label_3);
		
		Label label_4 = new Label("\u8BF7\u589E\u52A0\u836F\u54C1");
		label_4.setBounds(159, 9, 77, 25);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(138, 64, 150, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 95, 150, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 125, 150, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(138, 154, 150, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.setBounds(305, 214, 113, 27);
		contentPane.add(btnNewButton);
	}

}

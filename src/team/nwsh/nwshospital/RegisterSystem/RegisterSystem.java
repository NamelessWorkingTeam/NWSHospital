package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterSystem extends JFrame {

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
					RegisterSystem frame = new RegisterSystem();
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
	public RegisterSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 245, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u6302\u53F7");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label.setBounds(95, 10, 50, 35);
		panel.add(label);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_2.setBounds(31, 90, 126, 35);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		textField.setBounds(31, 135, 167, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		button.setBounds(31, 166, 80, 27);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(265, 10, 245, 391);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u6536\u8D39");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label_1.setBounds(106, 10, 50, 35);
		panel_1.add(label_1);
		
		JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_3.setBounds(30, 90, 126, 35);
		panel_1.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(31, 135, 167, 21);
		panel_1.add(textField_1);
		
		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		button_1.setBounds(30, 166, 80, 27);
		panel_1.add(button_1);
	}
}

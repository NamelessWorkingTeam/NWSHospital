package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class Fee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee frame = new Fee();
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
	public Fee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(50, 10, 433, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u6536\u8D39");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label.setBounds(202, 20, 41, 36);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(50, 76, 433, 50);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_1.setBounds(57, 10, 42, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_2.setBounds(189, 10, 70, 30);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u5F20\u4E09");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_3.setBounds(109, 10, 70, 30);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("123456789123456789");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_4.setBounds(269, 10, 154, 30);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 136, 433, 144);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_5 = new JLabel("\u836F\u7269\u6536\u8D39\uFF1A");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_5.setBounds(10, 10, 70, 30);
		panel_2.add(label_5);
		
		JButton button = new JButton("\u5DF2\u6536\u8D39");
		button.setBounds(130, 428, 93, 23);
		contentPane.add(button);
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(50, 290, 433, 128);
		contentPane.add(panel_3);
		
		JLabel label_8 = new JLabel("\u9879\u76EE\u6536\u8D39\uFF1A");
		label_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_8.setBounds(10, 10, 70, 30);
		panel_3.add(label_8);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(327, 428, 93, 23);
		contentPane.add(button_1);
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
	}

}

package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterSystem extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 536, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 0, 433, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6302\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(77, 9, 41, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6536\u8D39");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(288, 9, 56, 36);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(47, 66, 211, 342);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 21, 54, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 103, 54, 30);
		panel_1.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD");
		lblNewLabel_5.setFont(new Font("SimSun", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 183, 54, 30);
		panel_1.add(lblNewLabel_5);
		
		JLabel label = new JLabel("\u5E74\u9F84");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(10, 143, 54, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u79D1\u5BA4");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(10, 223, 54, 30);
		panel_1.add(label_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(65, 21, 136, 30);
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(65, 103, 136, 30);
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(65, 143, 136, 30);
		panel_1.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(65, 183, 136, 30);
		panel_1.add(textPane_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 12));
		comboBox.setToolTipText("\u9009\u62E9\u79D1\u5BA4");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5916\u79D1", "\u5185\u79D1", "\u5987\u79D1", "\u513F\u79D1", "\u4E94\u5B98\u79D1", "\u76AE\u80A4\u79D1", "\u653E\u5C04\u79D1"}));
		comboBox.setBounds(65, 223, 136, 30);
		panel_1.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("\u786E\u5B9A");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 309, 93, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u53D6\u6D88");
		btnNewButton_3.setBounds(113, 309, 93, 23);
		panel_1.add(btnNewButton_3);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_2.setBounds(10, 61, 54, 30);
		panel_1.add(label_2);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(65, 63, 136, 30);
		panel_1.add(textPane_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(269, 66, 211, 342);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("\u5DF2\u6536\u8D39");
		btnNewButton.setBounds(10, 309, 93, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBounds(109, 309, 93, 23);
		panel_2.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}

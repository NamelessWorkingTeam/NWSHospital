package team.nwsh.nwshospital.AdminSystem;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminSystemAddInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemAddInfo frame = new AdminSystemAddInfo();
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
	public AdminSystemAddInfo() {
		setTitle("\u589E\u52A0\u4FE1\u606F\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u8BF7\u589E\u52A0\u5404\u9879\u4FE1\u606F");
		label.setFont(new Font("Dialog", Font.PLAIN, 17));
		label.setBounds(146, 10, 136, 25);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\u589E\u8BBE\u8D26\u53F7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemInfoAccNum newframe = new AdminSystemInfoAccNum();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(150, 51, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u589E\u8BBE\u79D1\u5BA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemInfoSections newframe = new AdminSystemInfoSections();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(150, 87, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u589E\u8BBE\u836F\u54C1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemInfoMedicines newframe = new AdminSystemInfoMedicines();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(150, 124, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u589E\u8BBE\u9879\u76EE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemInfoItems newframe = new AdminSystemInfoItems();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(150, 161, 113, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystem newframe = new AdminSystem();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(150, 197, 113, 27);
		contentPane.add(btnNewButton_4);
	}
}

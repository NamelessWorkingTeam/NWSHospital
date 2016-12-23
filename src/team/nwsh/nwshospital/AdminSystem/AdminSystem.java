package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.GeneralLogin.GeneralLogin;

import java.awt.Label;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class AdminSystem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystem frame = new AdminSystem();
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
	public AdminSystem() {
		setTitle("\u7BA1\u7406\u5458\u7BA1\u7406\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u7BA1\u7406\u5458\u7BA1\u7406\u83DC\u5355");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 25));
		label.setBounds(213, 10, 196, 25);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0\u6240\u6709\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemAddInfo newframe = new AdminSystemAddInfo();
				newframe.setVisible(true);
				 dispose();
				
			  }
		});
		btnNewButton_1.setBounds(48, 68, 128, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u8D26\u53F7\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemShowACCInfo newframe = new AdminSystemShowACCInfo();
				newframe.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(244, 68, 128, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u79D1\u5BA4\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemShowSECTIONInfo newframe = new AdminSystemShowSECTIONInfo();
				newframe.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(244, 161, 128, 52);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2\u9879\u76EE\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemShowITEMInfo newframe = new AdminSystemShowITEMInfo();
				newframe.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_3.setBounds(48, 161, 128, 52);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u67E5\u8BE2\u836F\u54C1\u4FE1\u606F");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSystemShowMEDInfo newframe = new AdminSystemShowMEDInfo();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(439, 68, 128, 52);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u767B\u51FA");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneralLogin newframe = new GeneralLogin();
				newframe.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_5.setBounds(48, 255, 128, 52);
		contentPane.add(btnNewButton_5);
	}
}

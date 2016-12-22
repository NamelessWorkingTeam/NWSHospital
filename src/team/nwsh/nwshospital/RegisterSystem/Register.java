package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 10, 433, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6302\u53F7");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		lblNewLabel.setBounds(202, 20, 41, 36);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 76, 433, 281);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(128, 63, 64, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(128, 103, 64, 30);
		panel_1.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD");
		lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(128, 183, 64, 30);
		panel_1.add(lblNewLabel_5);
		
		JLabel label = new JLabel("\u5E74\u9F84");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label.setBounds(128, 143, 64, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u79D1\u5BA4");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_1.setBounds(128, 223, 64, 30);
		panel_1.add(label_1);
		
		JTextPane textPane_NAME = new JTextPane();
		textPane_NAME.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textPane_NAME.setBounds(202, 63, 136, 30);
		panel_1.add(textPane_NAME);
		
		JTextPane textPane_SEX = new JTextPane();
		textPane_SEX.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textPane_SEX.setBounds(202, 103, 136, 30);
		panel_1.add(textPane_SEX);
		
		JTextPane textPane_AGE = new JTextPane();
		textPane_AGE.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textPane_AGE.setBounds(202, 143, 136, 30);
		panel_1.add(textPane_AGE);
		
		JTextPane textPane_PHONE = new JTextPane();
		textPane_PHONE.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textPane_PHONE.setBounds(202, 183, 136, 30);
		panel_1.add(textPane_PHONE);
		
		JComboBox comboBox_KESHI = new JComboBox();
		comboBox_KESHI.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		comboBox_KESHI.setToolTipText("\u9009\u62E9\u79D1\u5BA4");
		comboBox_KESHI.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u5916\u79D1", "\u666E\u901A\u5185\u79D1", "\u4E94\u5B98\u79D1", "\u68C0\u9A8C\u79D1"}));
		comboBox_KESHI.setBounds(202, 223, 136, 30);
		panel_1.add(comboBox_KESHI);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_2.setBounds(128, 23, 64, 30);
		panel_1.add(label_2);
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JTextPane textPane_ID = new JTextPane();
		textPane_ID.setBounds(202, 23, 136, 30);
		panel_1.add(textPane_ID);
		textPane_ID.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		JButton btnNewButton_2 = new JButton("\u6302\u53F7");
		btnNewButton_2.setBounds(244, 367, 93, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		JButton btnNewButton_3 = new JButton("\u53D6\u6D88");
		btnNewButton_3.setBounds(347, 367, 93, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button.setBounds(141, 367, 93, 23);
		contentPane.add(button);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "INSERT INTO PATIENTS VALUES('"+textPane_ID.getText()+"','"+textPane_NAME.getText()+"','"+textPane_AGE.getText()+"','"+textPane_SEX.getText()+"','"+textPane_PHONE.getText()+"',null)";
				MySQLConnect con = new MySQLConnect(sql);
				try {
					con.pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				try {
//					ResultSet result = con.pst.executeQuery();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
			}
		});
	}
}

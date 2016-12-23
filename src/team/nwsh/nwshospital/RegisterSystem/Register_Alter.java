package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Register_Alter extends JFrame {
	
	static String P_ID;//…œ“ª“≥√ÊªÒ»°µƒ…Ì∑›÷§∫≈
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {					
					Register_Alter frame = new Register_Alter();
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
	public Register_Alter() {
		P_ID = RegisterSystem.PAT_ID;//¥”…œ∏ˆ“≥√ÊªÒ»°…Ì∑›÷§∫≈¥´÷µ∏¯P_ID
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(48, 10, 433, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u9884\u7EA6\u4FE1\u606F\u786E\u8BA4");
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 16));
		label.setBounds(157, 20, 147, 36);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(48, 76, 433, 281);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		label_1.setBounds(128, 63, 64, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		label_2.setBounds(128, 103, 64, 30);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		label_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		label_3.setBounds(128, 183, 64, 30);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\u5E74\u9F84");
		label_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		label_4.setBounds(128, 143, 64, 30);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("\u79D1\u5BA4");
		label_5.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		label_5.setBounds(128, 223, 64, 30);
		panel_1.add(label_5);
		
		JTextField textField_NAME = new JTextField();
		textField_NAME.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		textField_NAME.setBounds(202, 63, 136, 30);
		panel_1.add(textField_NAME);
		
		JTextField textField_SEX = new JTextField();
		textField_SEX.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		textField_SEX.setBounds(202, 103, 136, 30);
		panel_1.add(textField_SEX);
		
		JTextField textField_AGE = new JTextField();
		textField_AGE.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		textField_AGE.setBounds(202, 143, 136, 30);
		panel_1.add(textField_AGE);
		
		JTextField textField_PHONE = new JTextField();
		textField_PHONE.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		textField_PHONE.setBounds(202, 183, 136, 30);
		panel_1.add(textField_PHONE);
		
		JComboBox comboBox_KESHI = new JComboBox();
		comboBox_KESHI.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u5916\u79D1", "\u666E\u901A\u5185\u79D1", "\u4E94\u5B98\u79D1", "\u68C0\u9A8C\u79D1"}));
		comboBox_KESHI.setToolTipText("\u9009\u62E9\u79D1\u5BA4");
		comboBox_KESHI.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		comboBox_KESHI.setBounds(202, 223, 136, 30);
		panel_1.add(comboBox_KESHI);
		
		JLabel label_6 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_6.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		label_6.setBounds(128, 23, 64, 30);
		panel_1.add(label_6);
		
		JTextField textField_ID = new JTextField();
		textField_ID.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		textField_ID.setBounds(202, 23, 136, 30);
		panel_1.add(textField_ID);
		textField_ID.setText(P_ID);//…œ“ª“≥√ÊªÒ»°µƒ…Ì∑›÷§∫≈
		
		JButton button_2 = new JButton("\u53D6\u6D88");
		button_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		button_2.setBounds(312, 380, 93, 23);
		contentPane.add(button_2);
		
		JButton button_1 = new JButton("\u786E\u8BA4\u9884\u7EA6\u5E76\u6536\u8D39");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(P_ID);

				String sql= "";
				MySQLConnect con1= new MySQLConnect(sql);
				try {
					con1.pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		button_1.setBounds(155, 380, 147, 23);
		contentPane.add(button_1);
	}
}

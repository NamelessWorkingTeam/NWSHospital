package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class RegisterSystem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		panel.setBounds(50, 10, 435, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u6302\u53F7\u5904");
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 16));
		label.setBounds(199, 10, 50, 35);
		panel.add(label);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		label_2.setBounds(162, 90, 126, 35);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		textField.setBounds(162, 135, 180, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String String_SQL_PAT_ID = "SELECT STA_TUS FROM STATE WHERE PAT_ID = '" + textField.getText() + "'";
				MySQLConnect con = new MySQLConnect(String_SQL_PAT_ID);
				try {
					ResultSet result = con.pst.executeQuery();
						// result.next();
						if(result.next()) {
							String state = result.getString("STA_TUS");
							int i = Integer.parseInt(state);
							switch(i){
							case 0:
								Fee fee = new Fee();
								fee.setResizable(false);
								fee.setLocationRelativeTo(null);
								fee.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
								fee.setVisible(true);
								dispose();
								break;
							case 1:
								System.out.print("“— ’∑—µƒ‘§‘º≤°»À");
							break;
							case 2:
								System.out.print("“— ’∑—µƒπ“∫≈≤°»À");
								break;
							}
						}
						else {
							Register register = new Register();
							register.setResizable(false);
							register.setLocationRelativeTo(null);
							register.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							register.setVisible(true);
							dispose();
						}

					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		button_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		button_1.setBounds(162, 179, 80, 27);
		panel.add(button_1);
	}
}

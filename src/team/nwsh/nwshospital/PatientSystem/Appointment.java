package team.nwsh.nwshospital.PatientSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import team.nwsh.nwshospital.MySQLConnect;
import team.nwsh.nwshospital.AdminSystem.AdminSystem;
import team.nwsh.nwshospital.DirectorSystem.DirectorSystem;
import team.nwsh.nwshospital.DoctorSystem.DoctorSystem;
import team.nwsh.nwshospital.RegisterSystem.RegisterSystem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Appointment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField DateField;
	private JTextField IDField;
     int x=2;
     private JTextField SessionField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment frame = new Appointment();
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
	public Appointment() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("                      \u9884\u7EA6\u6302\u53F7");
		textField.setFont(new Font("ËÎÌו", Font.PLAIN, 25));
		textField.setBounds(0, 0, 700, 69);
		contentPane.add(textField);
		textField.setColumns(10);
		
		TextField textField_2 = new TextField();
		textField_2.setText("   \u8BF7\u586B\u5199\u8EAB\u4EFD\u8BC1");
		textField_2.setEditable(false);
		textField_2.setBounds(44, 120, 105, 17);
		contentPane.add(textField_2);
		
		TextField textField_1 = new TextField();
		textField_1.setText("\u586B\u5199\u9884\u7EA6\u79D1\u5BA4\u53F7\u7801");
		textField_1.setEditable(false);
		textField_1.setBounds(241, 120, 114, 17);
		contentPane.add(textField_1);
		
		TextField textField_3 = new TextField();
		textField_3.setText("\u586B\u5199\u65F6\u95F4\uFF08\u4F8B\uFF1A2016122217\uFF09");
		textField_3.setEditable(false);
		textField_3.setBounds(481, 120, 170, 17);
		contentPane.add(textField_3);
		
		JComboBox SessionSelect = new JComboBox();
		SessionSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		SessionSelect.setModel(new DefaultComboBoxModel(new String[] {"\u67E5\u770B\u53EF\u9009\u79D1\u5BA4", "5000.\u666E\u901A\u5916\u79D1", "5001.\u666E\u901A\u5185\u79D1", "5002.\u4E94\u5B98\u79D1", "5003.\u68C0\u9A8C\u79D1"}));
		SessionSelect.setBounds(361, 120, 114, 21);
		contentPane.add(SessionSelect);
		
		DateField = new JTextField();
		DateField.setBounds(481, 155, 170, 21);
		contentPane.add(DateField);
		DateField.setColumns(10);
		
		IDField = new JTextField();
		IDField.setColumns(10);
		IDField.setBounds(39, 155, 170, 21);
		contentPane.add(IDField);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		button.setBounds(583, 312, 111, 32);
		contentPane.add(button);
		
		SessionField = new JTextField();
		SessionField.setColumns(10);
		SessionField.setBounds(241, 155, 170, 21);
		contentPane.add(SessionField);
		
		JButton Submitting = new JButton("\u63D0\u4EA4");
		Submitting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IDField.getText().length()==0||DateField.getText().length()!=10||Integer.parseInt(SessionField.getText())<5000||Integer.parseInt(SessionField.getText())>5003){
					Warning newframe = new Warning();
					newframe.setVisible(true);
				}
				else{
		             String sql = "INSERT INTO STATE(STA_ID,PAT_ID,SEC_ID,STA_DATE,STA_TUS) VALUES(null,null,'"+SessionField.getText()+"','"+DateField.getText()+"',0)";
						MySQLConnect con = new MySQLConnect(sql);
						try {  
							con.pst.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             
		             
				}
	           
			}
		});
		Submitting.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		Submitting.setBounds(434, 312, 111, 32);
		contentPane.add(Submitting);
		
		}
		}

	

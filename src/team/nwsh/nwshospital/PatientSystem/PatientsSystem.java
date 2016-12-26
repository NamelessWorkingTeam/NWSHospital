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

public class PatientsSystem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField DateField;
	private JTextField IDField;
	private JTextField NameField;
	private JTextField PhoneField;
	private JTextField AgeField;
	
	static String sec;
	static String sex;
	
	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientsSystem frame = new PatientsSystem();
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
	public PatientsSystem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("                      \u9884\u7EA6\u6302\u53F7");
		textField.setFont(new Font("宋体", Font.PLAIN, 25));
		textField.setBounds(0, 0, 700, 69);
		contentPane.add(textField);
		textField.setColumns(10);
		
		TextField textField_2 = new TextField();
		textField_2.setText("   \u8BF7\u586B\u5199\u8EAB\u4EFD\u8BC1");
		textField_2.setEditable(false);
		textField_2.setBounds(280, 120, 105, 17);
		contentPane.add(textField_2);
		
		TextField textField_1 = new TextField();
		textField_1.setText("\u9009\u62E9\u9884\u7EA6\u79D1\u5BA4");
		textField_1.setEditable(false);
		textField_1.setBounds(401, 248, 114, 17);
		contentPane.add(textField_1);
		
		TextField textField_3 = new TextField();
		textField_3.setText("\u586B\u5199\u65F6\u95F4\uFF08\u4F8B\uFF1A2016122217\uFF09");
		textField_3.setEditable(false);
		textField_3.setBounds(43, 248, 170, 17);
		contentPane.add(textField_3);
		
		JComboBox SectionSelect = new JComboBox();
		SectionSelect.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u5916\u79D1", "\u666E\u901A\u5185\u79D1", "\u4E94\u5B98\u79D1", "\u68C0\u9A8C\u79D1", "\u795E\u7ECF\u79D1"}));
		SectionSelect.setBounds(401, 287, 114, 21);
		contentPane.add(SectionSelect);
		
		DateField = new JTextField();
		DateField.setBounds(43, 287, 170, 21);
		contentPane.add(DateField);
		DateField.setColumns(10);
		
		IDField = new JTextField();
		IDField.setColumns(10);
		IDField.setBounds(249, 158, 170, 21);
		contentPane.add(IDField);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(579, 418, 111, 32);
		contentPane.add(button);
		
		
		
		
		TextField Field = new TextField();
		Field.setText("   \u8BF7\u9009\u62E9\u6027\u522B");
		Field.setEditable(false);
		Field.setBounds(539, 248, 105, 17);
		contentPane.add(Field);
		
		TextField Field2 = new TextField();
		Field2.setText("   \u8BF7\u586B\u5199\u5E74\u9F84");
		Field2.setEditable(false);
		Field2.setBounds(249, 248, 105, 17);
		contentPane.add(Field2);
		
		TextField textField_4 = new TextField();
		textField_4.setText("   \u8BF7\u586B\u5199\u7535\u8BDD\u53F7\u7801");
		textField_4.setEditable(false);
		textField_4.setBounds(494, 120, 127, 17);
		contentPane.add(textField_4);
		
		TextField textField_5 = new TextField();
		textField_5.setText("   \u8BF7\u586B\u5199\u59D3\u540D");
		textField_5.setEditable(false);
		textField_5.setBounds(52, 120, 105, 17);
		contentPane.add(textField_5);
		
		NameField = new JTextField();
		NameField.setColumns(10);
		NameField.setBounds(52, 158, 101, 21);
		contentPane.add(NameField);
		
		PhoneField = new JTextField();
		PhoneField.setColumns(10);
		PhoneField.setBounds(464, 158, 170, 21);
		contentPane.add(PhoneField);
		
		AgeField = new JTextField();
		AgeField.setColumns(10);
		AgeField.setBounds(263, 287, 73, 21);
		contentPane.add(AgeField);
		
		JComboBox SexSelect = new JComboBox();
		SexSelect.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		SexSelect.setBounds(562, 287, 38, 21);
		contentPane.add(SexSelect);
		
		if(SectionSelect.getSelectedItem().toString().compareTo("普通外科") == 0) sec="5000";
		if(SectionSelect.getSelectedItem().toString().compareTo("普通内科") == 0) sec="5001";
		if(SectionSelect.getSelectedItem().toString().compareTo("五官科") == 0)	sec="5002";
		if(SectionSelect.getSelectedItem().toString().compareTo("检验科") == 0)	sec="5003";
		if(SectionSelect.getSelectedItem().toString().compareTo("神经科") == 0)	sec="5004";
		if(SexSelect.getSelectedItem().toString().compareTo("男") == 0)	sex="M";
		if(SexSelect.getSelectedItem().toString().compareTo("女") == 0)	sex="F";
		
		
		JButton Submitting = new JButton("\u63D0\u4EA4");
		Submitting.setFont(new Font("宋体", Font.PLAIN, 18));
		Submitting.setBounds(433, 418, 111, 32);
		contentPane.add(Submitting);
		Submitting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IDField.getText().length()==0||DateField.getText().length()!=10){
					Warning newframe = new Warning();
					newframe.setVisible(true);
				}
				else{

					String sql = "INSERT INTO PATIENTS VALUES('"+IDField.getText()+"','"+NameField.getText()+"','"+AgeField.getText()+"','"+sex+"','"+PhoneField.getText()+"',null)";
					String sql2= "INSERT INTO STATE VALUES(NULL,'"+IDField.getText()+"','"+sec+"','"+DateField.getText()+"',0)";
					MySQLConnect con2= new MySQLConnect(sql2);
					MySQLConnect con = new MySQLConnect(sql);
					try {
						con.pst.executeUpdate();
						con2.pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "已成功预约！", "提示",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "预约失败！", "提示", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}		             		 
				}
	
			}
		});
		}
		}

	

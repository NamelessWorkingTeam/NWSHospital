package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import team.nwsh.nwshospital.MySQLConnect;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwsh.nwshospital.MySQLConnect;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DirectorDoctorQuery extends JFrame implements ActionListener  {
	/**
	 *  
	 */
	private JPanel contentPane;
	private JTextField textField;
    JTable Dmjt=null;
    JScrollPane Dmjsp=null;
	JButton BtnNewButton = new JButton("\u67E5\u8BE2");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectorDoctorQuery frame = new DirectorDoctorQuery();
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
	public DirectorDoctorQuery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lbNewLabel = new JLabel("\u533B\u751F\u540D\uFF1A");
		panel.add(lbNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		BtnNewButton.addActionListener(this);
		panel.add(BtnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		panel_1.add(btnNewButton_2);
		
		setTitle("\u533B\u751F\u60C5\u51B5\u67E5\u8BE2");
		
        DoctorModel Dm=new DoctorModel();
		Dmjt=new JTable(Dm);
		Dmjsp=new JScrollPane(Dmjt);
		getContentPane().add(Dmjsp);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);
		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(arg0.getSource()==BtnNewButton)//检查
		{
			String name=this.textField.getText().trim();//获取textfield信息
			String sql="SELECT ACC_ID,ACC_NAME,(SELECT SEC_NAME FROM SECTIONS WHERE SECTIONS.SEC_ID=ACCOUNTS.SEC_ID),(SELECT ifnull(sum(ifnull(RES_SUM,0)), 0) FROM RESULTS WHERE RESULTS.ACC_ID=ACCOUNTS.ACC_ID),(SELECT COUNT(*) FROM RESULTS WHERE RESULTS.ACC_ID=ACCOUNTS.ACC_ID)FROM ACCOUNTS WHERE ACCOUNTS.ACC_NAME like '%"+name+"%'";
			DoctorModel Dm=new DoctorModel(sql);
			Dmjt.setModel(Dm);
		}
	}
}



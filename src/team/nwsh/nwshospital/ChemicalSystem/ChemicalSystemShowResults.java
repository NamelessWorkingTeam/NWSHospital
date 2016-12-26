package team.nwsh.nwshospital.ChemicalSystem;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

public class ChemicalSystemShowResults extends JFrame implements ActionListener  {
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    JTable jt=null;
    JScrollPane jsp=null;
    private JTextField PatientField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChemicalSystemShowResults frame = new ChemicalSystemShowResults();
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
	public ChemicalSystemShowResults() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 484, 354, 33);
		contentPane.add(panel_1);
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u836F\u54C1\u4FE1\u606F");
		btnNewButton_2.setBounds(227, 0, 117, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChemicalSystemMedicineInfo newframe = new ChemicalSystemMedicineInfo();
				newframe.setVisible(true);
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton_2);
		
		

		
		
		setTitle("\u5C31\u8BCA\u7ED3\u679C\u67E5\u8BE2");
		

        ResultsModel rm=new ResultsModel();
		jt=new JTable(rm);
		jsp=new JScrollPane(jt);
		jsp.setBounds(5, 56, 354, 428);
		getContentPane().add(jsp);
		
		PatientField = new JTextField();
		PatientField.setBounds(114, 10, 82, 21);
		contentPane.add(PatientField);
		PatientField.setColumns(10);
		
		JButton Dispending = new JButton("\u53D1\u836F");
		Dispending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="DELETE FROM STATE WHERE STATE.PAT_ID=(SELECT PAT_ID FROM PATIENTS WHERE PATIENTS.PAT_NAME=('"+PatientField.getText()+"'))";
				MySQLConnect con=new MySQLConnect(sql);	
				int key=1;//定义一个中间变量，来判断输入信息的窗口，如果成功 则 保存成功
				try{
					if(PatientField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "用户不存在或已发药"); key=0;}
					if(key==1){ con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "发药成功");}
					con.pst.executeUpdate();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		Dispending.setBounds(219, 9, 93, 23);
		contentPane.add(Dispending);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u75C5\u4EBA");
		lblNewLabel.setBounds(44, 10, 60, 21);
		contentPane.add(lblNewLabel);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);

		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}



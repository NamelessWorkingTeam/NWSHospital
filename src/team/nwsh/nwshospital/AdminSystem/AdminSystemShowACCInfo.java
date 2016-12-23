package team.nwsh.nwshospital.AdminSystem;

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
import team.nwsh.nwshospital.AdminSystem.ACCOUNTSModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwsh.nwshospital.MySQLConnect;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class AdminSystemShowACCInfo extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField textField;
    JTable Adjt=null;
    JScrollPane Adjsp=null;
	JButton BtnNewButton = new JButton("\u67E5\u8BE2");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemShowACCInfo frame = new AdminSystemShowACCInfo();
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
	public AdminSystemShowACCInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8D26\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		BtnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		BtnNewButton.addActionListener(this);
		panel.add(BtnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("修改");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("删除");
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(btnNewButton_4);
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminSystem newframe = new AdminSystem();
				newframe.setVisible(true);
				
				dispose();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		panel_1.add(btnNewButton_2);

		
		
		setTitle("账号管理系统");

		ACCOUNTSModel am=new ACCOUNTSModel();
		Adjt=new JTable(new DefaultTableModel(
			new Object[][] {
				{"100000", "\u6768\u67F3", "123", "1000"},
				{"100001", "\u571F\u8C46", "123", "1000"},
				{"200000", "ADMIN", "123", "2000"},
				{"300000", "\u5434\u5955\u950B", "123", "3000"},
				{"300001", "\u80E1\u5C0F\u519B", "123", "3000"},
				{"400000", "\u516D\u53F7", "123", "4000"},
				{"400001", "\u4E03\u53F7", "123", "4000"},
				{"400002", "\u516B\u53F7", "123", "4001"},
				{"400003", "\u4E5D\u53F7", "123", "4002"},
				{"500000", "\u5F20\u9152", "123", "5000"},
				{"500001", "\u53E4\u6708", "123", "5001"},
			},
			new String[] {
				"\u8D26\u6237ID", "\u7528\u6237\u540D", "\u5BC6\u7801", "\u6240\u5C5E\u79D1\u5BA4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Adjsp=new JScrollPane(Adjt);
		getContentPane().add(Adjsp);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);

		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(arg0.getSource()==BtnNewButton)//检查
		{
			String name=this.textField.getText().trim();//获取textfield信息
			//String sql="select * from A where MED_NAME='"+name+"'";//实现模糊查询
			String sql="select * from ACCOUNTS where ACC_NAME like'%"+name+"%'";
			ACCOUNTSModel am=new ACCOUNTSModel(sql);
			Adjt.setModel(am);
		}
	}
}



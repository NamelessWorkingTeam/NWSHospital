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
import team.nwsh.nwshospital.AdminSystem.ITEMSModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwsh.nwshospital.MySQLConnect;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class AdminSystemShowITEMInfo extends JFrame implements ActionListener  {
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
					AdminSystemShowITEMInfo frame = new AdminSystemShowITEMInfo();
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
	public AdminSystemShowITEMInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u9879\u76EE\u540D\uFF1A");
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

		
		
		setTitle("项目管理系统");

		ITEMSModel am=new ITEMSModel();
		Adjt=new JTable(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "\u6302\u53F7\u8D39", new Double(2.0)},
				{new Integer(2), "\u8BCA\u67E5\u8D39", new Double(20.3)},
				{new Integer(3), "\u6025\u8BCA\u8D39", new Double(30.3)},
				{new Integer(4), "\u8840\u5E38\u89C4", new Double(210.8)},
				{new Integer(5), "\u5E38\u89C4\u4F53\u68C0", new Double(336.9)},
				{new Integer(6), "\u5FC3\u7535\u56FE\u68C0\u67E5", new Double(33.9)},
				{new Integer(7), "\u9AA8\u6298\u590D\u539F\u672F", new Double(300.9)},
				{new Integer(8), "X\u7EBF\u900F\u89C6\u68C0\u67E5", new Double(274.9)},
				{new Integer(9), "B\u8D85\u5E38\u89C4\u68C0\u67E5", new Double(527.8)},
				{new Integer(10), "\u514D\u75AB\u529F\u80FD\u68C0\u67E5", new Double(157.8)},
			},
			new String[] {
				"\u9879\u76EE\u5E8F\u53F7", "\u9879\u76EE\u540D", "\u9879\u76EE\u4EF7\u683C"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
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
			String sql="select * from ITEMS where ITEM_NAME like'%"+name+"%'";
			ACCOUNTSModel am=new ACCOUNTSModel(sql);
			Adjt.setModel(am);
		}
	}
}



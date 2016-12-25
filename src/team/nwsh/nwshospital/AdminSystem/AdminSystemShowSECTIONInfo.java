package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import team.nwsh.nwshospital.AdminSystem.SECTIONSModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwsh.nwshospital.MySQLConnect;

import javax.swing.table.DefaultTableModel;

public class AdminSystemShowSECTIONInfo extends JFrame implements ActionListener  {
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
					AdminSystemShowSECTIONInfo frame = new AdminSystemShowSECTIONInfo();
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
	public AdminSystemShowSECTIONInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u79D1\u5BA4\u540D\uFF1A");
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
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="DELETE FROM SECTIONS WHERE SEC_NAME = ('"+textField.getText()+"')";
				MySQLConnect con=new MySQLConnect(sql);	
				int key=1;//定义一个中间变量，来判断输入信息的窗口，如果成功 则 保存成功
				try{
					if(textField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "内容不能为空"); key=0;}
					if(key==1){ con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "保存成功");}
					con.pst.executeUpdate();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
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

		
		
		setTitle("科室管理系统");

		SECTIONSModel am=new SECTIONSModel();
		Adjt=new JTable(new DefaultTableModel(
			new Object[][] {
				{"1000", "\u9662\u957F\u5BA4", new Integer(2)},
				{"2000", "\u4FE1\u606F\u79D1", new Integer(0)},
				{"3000", "\u6302\u53F7\u5904", new Integer(0)},
				{"4000", "\u897F\u836F\u623F", new Integer(0)},
				{"4001", "\u4E2D\u836F\u623F", new Integer(0)},
				{"4002", "\u7EFC\u5408\u836F\u623F", new Integer(0)},
				{"5000", "\u666E\u901A\u5916\u79D1", new Integer(10)},
				{"5001", "\u666E\u901A\u5185\u79D1", new Integer(10)},
				{"5002", "\u4E94\u5B98\u79D1", new Integer(10)},
				{"5003", "\u68C0\u9A8C\u79D1", new Integer(10)},
				{"5004", "\u795E\u7ECF\u79D1", new Integer(0)},
			},
			new String[] {
				"\u79D1\u5BA4ID", "\u79D1\u5BA4\u540D", "\u79D1\u5BA4\u4EBA\u6570"
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
			String sql="select * from SECTIONS where SEC_NAME like'%"+name+"%'";
			ACCOUNTSModel am=new ACCOUNTSModel(sql);
			Adjt.setModel(am);
		}
	}
}



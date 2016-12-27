//查询账户信息，删除需要精确搜索
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
import team.nwsh.nwshospital.MySQLConnect;
import team.nwsh.nwshospital.AdminSystem.ACCOUNTSModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwsh.nwshospital.MySQLConnect;

public class AdminSystemShowACCInfo extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
    JTable jt=null;
    JScrollPane jsp=null;
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
		
		JLabel lblNewLabel = new JLabel("请输入账户名");
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
				
				AdminSystemAccChange newframe = new AdminSystemAccChange();
				newframe.setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("删除");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="DELETE FROM ACCOUNTS WHERE ACC_NAME = ('"+textField.getText()+"')";
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

		
		
		setTitle("\u8D26\u53F7\u60C5\u51B5\u67E5\u8BE2");

        ACCOUNTSModel mm=new ACCOUNTSModel();
        jt=new JTable(mm);
		jsp=new JScrollPane(jt);
		getContentPane().add(jsp);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);

		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(arg0.getSource()==BtnNewButton)//检查
		{
			String name=this.textField.getText().trim();//获取textfield信息
			//String sql="select * from MEDICINE where MED_NAME='"+name+"'";//实现模糊查询
			String sql="select * from ACCOUNTS where ACC_NAME like'%"+name+"%'";
			ACCOUNTSModel mm=new ACCOUNTSModel(sql);
			jt.setModel(mm);
		}
	}
}



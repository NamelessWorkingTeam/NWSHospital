package team.nwsh.nwshospital.DirectorSystem;

import java.sql.ResultSet;
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
import team.nwsh.nwshospital.MySQLConnect;

public class MedicineAlarm {
    static String String_CheckStorgesql = null;   
    static MySQLConnect db = null;  
    static ResultSet Result_Storge = null;    
    
    
public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String_CheckStorgesql= "SELECT MED_NAME,MED_STORGE FROM MEDICINE";	
    	 // 此处填写要执行的语句
        db = new MySQLConnect(String_CheckStorgesql);							// 新建一个数据库连接
        try {
        	Result_Storge = db.pst.executeQuery();					// 执行sql语句，得到结果集
			while (Result_Storge.next()) {
                String String_CheckName = Result_Storge.getString("MED_NAME");
                int Int_CheckStorge = Result_Storge.getInt("MED_STORGE");// 获取执行sql语句后结果集中列名为ACC_NAME的一个值	
                if (Int_CheckStorge<=20)//判断药品库存不足20时提醒
                { 
                //System.out.println(String_CheckName);
                //System.out.println(Result_Storge.getInt("MED_STORGE"));//控制台输出
                JOptionPane.showMessageDialog(null, String_CheckName+"库存不足，余量为"+Int_CheckStorge, "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
                	}
                }
			Result_Storge.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

/*重新打开一个窗口输出库存不足的药品 仍有问题 
 * 在调试 考虑到可能会出现多个药品库存不足 打算通过窗口用Jlist展示
public void Warning(String[] arg0) {
	setTitle("\u8B66\u544A\uFF01");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 302, 201);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel WarningLabel = new JLabel("\u8B66\u544A\uFF01");
	WarningLabel.setFont(new Font("宋体", Font.BOLD, 20));
	WarningLabel.setBounds(111, 10, 63, 34);
	contentPane.add(WarningLabel);
	
	JLabel WarningMarkedWords = new JLabel("\u5728\u5E93\u5B58\u4E2D\u4F59\u91CF\u53EA\u6709");
	WarningMarkedWords.setFont(new Font("宋体", Font.BOLD, 20));
	WarningMarkedWords.setBounds(69, 72, 192, 40);
	contentPane.add(WarningMarkedWords);
	
	JLabel WarningMedicineName = new JLabel("New label");
	WarningMedicineName.setBounds(10, 87, 54, 15);
	contentPane.add(WarningMedicineName);
	
	JLabel WarningMedicineStorge = new JLabel("New label");
	WarningMedicineStorge.setBounds(244, 87, 54, 15);
	contentPane.add(WarningMedicineStorge);
}
private void setTitle(String string) {
	// TODO 自动生成的方法存根
	
}
private void setContentPane(JPanel contentPane) {
	// TODO 自动生成的方法存根
	
}
private void setBounds(int i, int j, int k, int l) {
	// TODO 自动生成的方法存根
	
}
private void setDefaultCloseOperation(int exitOnClose) {
	// TODO 自动生成的方法存根
	
}
MedicineAlarm (String n,int a) {

}*/
    }
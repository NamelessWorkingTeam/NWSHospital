package team.nwsh.nwshospital.DirectorSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import team.nwsh.nwshospital.MySQLConnect;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DirectorPharmacyQuery extends JFrame{
	Vector RowData,ColumnNames;
    JTable jt=null;
    JScrollPane jsp=null;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
     public static void main(String[] args) throws SQLException
     {
    	 DirectorPharmacyQuery DirectorPharmacyQuery=new DirectorPharmacyQuery();
     }


public DirectorPharmacyQuery() throws SQLException
{
	setTitle("\u836F\u623F\u60C5\u51B5\u67E5\u8BE2");
	ColumnNames= new Vector();
	ColumnNames.add("序号");
	ColumnNames.add("药品名");
	ColumnNames.add("单价");
	ColumnNames.add("库存");
	//建立表头
	
	RowData=new Vector(); 
	sql = "SELECT * FROM MEDICINE";						// 此处填写要执行的语句
    db = new MySQLConnect(sql);							// 新建一个数据库连接
    try {
		ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
		while (ret.next()) {
            Vector hang=new Vector();
        	hang.add(ret.getInt(1));
        	hang.add(ret.getString(2));
        	hang.add(ret.getInt(3));
        	hang.add(ret.getInt(4));
        	RowData.add(hang);
        }
        ret.close();		// 关闭执行的语句连接
        db.close();			// 关闭数据库连接
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	jt=new JTable(RowData,ColumnNames);
	jsp=new JScrollPane(jt);
	this.add(jsp);
	this.setBounds(12, 76, 380, 560);
	this.setVisible(true);
	}

}
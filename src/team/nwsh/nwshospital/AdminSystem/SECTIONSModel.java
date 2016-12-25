//一个SECTIONS表的模型,即科室表
package team.nwsh.nwshospital.AdminSystem;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;

import team.nwsh.nwshospital.MySQLConnect;

public class SECTIONSModel extends AbstractTableModel {
	Vector RowData,ColumnNames;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 

    //通过传递的sql语句来获得数据模型
    public SECTIONSModel(String sql)
    {
    	//建立表头
    	ColumnNames= new Vector();
		ColumnNames.add("科室ID");
		ColumnNames.add("科室名");
		ColumnNames.add("科室人数");
		
		
		RowData=new Vector(); 						// 此处填写要执行的语句
	    db = new MySQLConnect(sql);							// 新建一个数据库连接
	    try {
			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getInt(3));
	        	
	        	
	        	RowData.add(hang);
	        }
	        ret.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //建立构造函数初始化数据模型
    public SECTIONSModel()
    {
    	ColumnNames= new Vector();
		ColumnNames.add("科室ID");
		ColumnNames.add("科室名");
		ColumnNames.add("科室人数");
		
		//建立表头
		RowData=new Vector(); 
		sql = "SELECT * FROM SECTIONS";						// 此处填写要执行的语句
	    db = new MySQLConnect(sql);							// 新建一个数据库连接
	    try {
			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
			while (ret.next()) {
	            Vector line=new Vector();
	        	line.add(ret.getString(1));
	        	line.add(ret.getString(2));
	        	line.add(ret.getInt(3));
	        	
	        	RowData.add(line);
	        }
	        ret.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.RowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.ColumnNames.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO 自动生成的方法存根
		return ((Vector)this.RowData.get(row)).get(column);
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO 自动生成的方法存根
		return (String)this.ColumnNames.get(arg0);
	}

    


}
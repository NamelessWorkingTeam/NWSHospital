/**
 * 这是我的一个Doctor表的模型
 */
package team.nwsh.nwshospital.DirectorSystem;

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

public class DoctorModel extends AbstractTableModel {
	Vector RowData,ColumnNames;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
 
    //通过传递的sql语句来获得数据模型
    public DoctorModel(String sql)
    {
    	//建立表头  
    	ColumnNames= new Vector();	
		ColumnNames.add("编号");
		ColumnNames.add("姓名");
		ColumnNames.add("科室");
		ColumnNames.add("就诊总金额");
		ColumnNames.add("就诊总人次");
		RowData=new Vector(); 						// 此处填写要执行的语句
	    db = new MySQLConnect(sql);							// 新建一个数据库连接
	    try {
			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getString(3));
	        	hang.add(ret.getDouble(4));
	        	hang.add(ret.getInt(5));
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
    public DoctorModel()
    {
		ColumnNames= new Vector();
		ColumnNames.add("编号");
		ColumnNames.add("姓名");
		ColumnNames.add("科室");
		ColumnNames.add("就诊总金额");
		ColumnNames.add("就诊总人次");
		//建立表头

		RowData=new Vector(); 
		sql = "SELECT ACC_ID,ACC_NAME,(SELECT SEC_NAME FROM SECTIONS WHERE SECTIONS.SEC_ID=ACCOUNTS.SEC_ID),(SELECT IFNULL(SUM(IFNULL(RES_SUM,0)),0) FROM RESULTS WHERE RESULTS.ACC_ID=ACCOUNTS.ACC_ID),(SELECT COUNT(*) FROM RESULTS WHERE RESULTS.ACC_ID=ACCOUNTS.ACC_ID) FROM ACCOUNTS WHERE CAST(ACCOUNTS.ACC_ID AS UNSIGNED INT)>=500000";						// 此处填写要执行的语句
	    db = new MySQLConnect(sql);							// 新建一个数据库连接
	    try {
			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
			while (ret.next()) {
	            Vector hang=new Vector();
	            hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getString(3));
	        	hang.add(ret.getDouble(4));
	        	hang.add(ret.getInt(5));
	        	RowData.add(hang);
	        }
	        ret.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	//得到共有多少列
	public int getColumnCount() {
		
		// TODO 自动生成的方法存根
		return this.ColumnNames.size();
	}

	//得到共有多少行
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.RowData.size();   
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO 自动生成的方法存根
		return (String)this.ColumnNames.get(arg0);
	}


	//得到某行某列的数据
	public Object getValueAt(int row, int column) {
		// TODO 自动生成的方法存根
		return ((Vector)this.RowData.get(row)).get(column);
	}


 
}

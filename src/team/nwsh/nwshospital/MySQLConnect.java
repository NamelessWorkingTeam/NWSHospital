package team.nwsh.nwshospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Liu Yummy
 * 
 *  这是一个用来连接数据库的类，***所有的代码***都不需要修改。
 *  可以参考NWSHospital中的样例进行调用！
 *	如果在使用过程中，有任何问题，或此类无法满足你的需要，请告知我修改，或修改时添加个人注释！
 *	
 */

public class MySQLConnect {

	public static final String url = "jdbc:mysql://114.215.112.200/NWSHospital";	// 数据库地址
	public static final String name = "com.mysql.jdbc.Driver";						// 驱动名
	public static final String user = "general";									// 数据库用户名
	public static final String password = "123456";									// 用户密码
	
	public Connection conn = null;				// 建立一个空的Connection对象
	public PreparedStatement pst = null;		// 建立一个空的PreparedStatement对象

	public MySQLConnect(String sql) {
		try {
			Class.forName(name);										// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);	// 获取数据库连接
			pst = conn.prepareStatement(sql);							// 准备执行语句
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void close() {  
            try {
				this.conn.close();		// 关闭数据库连接
				this.pst.close();		// 结束执行语句
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    }  
}

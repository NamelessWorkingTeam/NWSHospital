package team.nwsh.nwshospital;

import java.sql.*;

/**
 * 
 * @author Liu Yummy
 * 
 *	这个类是用来告知大家新功能的用法和临时测试使用的！
 *	请各位在 Commit 和 Push 时将此文件置于 Unstaged Changes 内！
 *	以免将此文件覆盖，影响其他成员！谢谢合作！
 *
 *	This Class is used to test new functions and temporary tests!
 *	In order not to misunderstand other team mates, 
 *	please ***KEEP*** this class in Unstaged Changes when you are going to Commit or Push!
 *	Thanks for your cooperation!
 *		   
 */

public class NWSHospital {

    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null;  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM ACCOUNTS";						// 此处填写要执行的语句
        db = new MySQLConnect(sql);							// 新建一个数据库连接
        try {
			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
			while (ret.next()) {
                String uid = ret.getString("ACC_NAME");		// 获取执行sql语句后结果集中列名为ACC_NAME的一个值	
                System.out.println(uid);					// 输出获取的值
            }
	        ret.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}

}

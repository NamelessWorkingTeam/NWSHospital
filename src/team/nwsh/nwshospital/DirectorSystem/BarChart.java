package team.nwsh.nwshospital.DirectorSystem;
import java.awt.Font;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;

import team.nwsh.nwshospital.MySQLConnect;  
  
public class BarChart {  
    ChartPanel frame1;  
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
 
    public  BarChart(){  
        CategoryDataset dataset = getDataSet();  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                             "医院各科室业绩", // 图表标题  
                            "科室名", // 目录轴的显示标签  
                            "就诊总金额", // 数值轴的显示标签  
                            dataset, // 数据集  
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                            true,           // 是否显示图例(对于简单的柱状图必须是false)  
                            false,          // 是否生成工具  
                            false           // 是否生成URL链接  
                            );  
        
        FileOutputStream fos_jpg=null;  
        try {  
            fos_jpg=new FileOutputStream("D:\\BarChart.jpg");  
            //下面的参数分别是输出流、质量、图表数据、宽度、高度、备注信息  
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart,400, 300,null);  
        }catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                fos_jpg.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
          
        //从这里开始  
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
            
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题  
            
         frame1=new ChartPanel(chart,true);      }  //这里也可以用chartFrame,可以直接生成一个独立的Frame  
           
    }  
       private static CategoryDataset getDataSet() {  
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
//           dataset.addValue(100, "北京", "苹果");  
//           dataset.addValue(100, "上海", "苹果");  
//           dataset.addValue(100, "广州", "苹果");  
//           dataset.addValue(200, "北京", "梨子");  
//           dataset.addValue(200, "上海", "梨子");  
//           dataset.addValue(200, "广州", "梨子");  
//           dataset.addValue(300, "北京", "葡萄");  
//           dataset.addValue(300, "上海", "葡萄");  
//           dataset.addValue(300, "广州", "葡萄");  
//           dataset.addValue(400, "北京", "香蕉");  
//           dataset.addValue(400, "上海", "香蕉");  
//           dataset.addValue(400, "广州", "香蕉");  
//           dataset.addValue(500, "北京", "荔枝");  
//           dataset.addValue(500, "上海", "荔枝");  
//           dataset.addValue(500, "广州", "荔枝");  
   		sql = "SELECT   (SELECT IFNULL(SUM(IFNULL(RESULTS.RES_SUM,0)),0) FROM RESULTS WHERE RESULTS.ACC_ID =  (SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )),SECTIONS.SEC_NAME FROM SECTIONS WHERE CAST(SECTIONS.SEC_ID AS UNSIGNED INT)>=5000"	;					// 此处填写要执行的语句
   	    db = new MySQLConnect(sql);							// 新建一个数据库连接
   	    try {
   			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
   			while (ret.next()) {
   	            dataset.addValue(ret.getInt(1),ret.getString(2),ret.getString(2));
   	     //return dataset; 
   	        }
   	        ret.close();		// 关闭执行的语句连接
   	        db.close();			// 关闭数据库连接
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
		return dataset;
       }
            
public ChartPanel getChartPanel(){  
    return frame1;  
      
}  
}  
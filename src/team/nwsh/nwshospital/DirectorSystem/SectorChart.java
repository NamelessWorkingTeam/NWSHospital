package team.nwsh.nwshospital.DirectorSystem;

import java.awt.Font;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;  
import java.text.NumberFormat;  
  
import javax.swing.JPanel;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;

import team.nwsh.nwshospital.MySQLConnect;  
  
public class SectorChart {  
    ChartPanel frame1;  
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
    
    public SectorChart(){  
          DefaultPieDataset data = getDataSet();  
          JFreeChart chart = ChartFactory.createPieChart3D("医院业务量",data,true,false,false);  
        //设置百分比  
          PiePlot pieplot = (PiePlot) chart.getPlot();  
          DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
          NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
          pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
        
      //没有数据的时候显示的内容  
          pieplot.setNoDataMessage("无数据显示");  
          pieplot.setCircular(false);  
          pieplot.setLabelGap(0.02D);  
        
          pieplot.setIgnoreNullValues(true);//设置不显示空值  
          pieplot.setIgnoreZeroValues(true);//设置不显示负值  
         frame1=new ChartPanel (chart,true);  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
          PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象  
          piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码  
          chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));  
          
          FileOutputStream fos_jpg=null;  
          try {  
              fos_jpg=new FileOutputStream("D:\\SectorChart.jpg");  
              //下面的参数分别是输出流、质量、图表数据、宽度、高度、备注信息  
              ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart,400, 300,null);  
          }catch (Exception e) {  
              e.printStackTrace();  
          }finally{  
              try {  
                  fos_jpg.close();  
              } catch (Exception e) {  
                  e.printStackTrace();  }}
    }  
    private static DefaultPieDataset getDataSet() {  
        DefaultPieDataset dataset = new DefaultPieDataset();  
        
//        dataset.setValue("苹果",100);  
//        dataset.setValue("梨子",200);  
//        dataset.setValue("葡萄",300);  
//        dataset.setValue("香蕉",400);  
//        dataset.setValue("荔枝",500); 
        
        sql = "SELECT (SELECT COUNT(*) AS SEC_NUMBER FROM RESULTS WHERE RESULTS.ACC_ID = "
   				+ "(SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )) ,"
   				+ "SECTIONS.SEC_NAME FROM SECTIONS WHERE CAST(SECTIONS.SEC_ID AS UNSIGNED INT)>=5000"	;					// 此处填写要执行的语句
   	    db = new MySQLConnect(sql);							// 新建一个数据库连接
   	    try {
   			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
   			while (ret.next()) {
   	            dataset.setValue(ret.getString(2),ret.getInt(1));
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
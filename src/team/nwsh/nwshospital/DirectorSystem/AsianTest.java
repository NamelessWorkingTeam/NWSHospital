package team.nwsh.nwshospital.DirectorSystem;

import java.io.FileOutputStream;  
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.lowagie.text.*;  
import com.lowagie.text.pdf.PdfWriter;
import team.nwsh.nwshospital.MySQLConnect;
import com.lowagie.text.pdf.BaseFont;  
import com.lowagie.text.Font;  
import java.awt.Color;  

public class AsianTest {    
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
    
    
  public static void AT(String[] args) {  
      // 创建一个Document对象  
	  
      Document document = new Document();  
      try {  
          // 生成名为 AsianTest.pdf 的文档  
          PdfWriter.getInstance(document, new FileOutputStream(  
                  "C:\\REPORT\\HospitalReport.pdf"));  
          /** 
           * 新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀 
           * UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H 代表文字版式是 横版， 相应的 V 
           * 代表竖版 
           */  
          BaseFont bfChinese = BaseFont.createFont("STSongStd-Light",  
                  "UniGB-UCS2-H", false);  

          Font bold_fontChinese = new Font(bfChinese, 12, Font.BOLD,  
                  Color.BLACK);  
          Font italic_fontChinese = new Font(bfChinese, 36, Font.ITALIC,  
                  Color.BLACK);  
          Font impressFont = new Font(bfChinese, 16, Font.BOLDITALIC,  
                  Color.BLACK);  
          // 打开文档，将要写入内容  
          document.open();  
          // 插入一个段落  
          // Paragraph par = new Paragraph("我们", fontChinese);  
          // document.add(par); 
          //以下为如何添加文字
          //String[] WoZuiShuai = { "孙翊飞最帅。" };  
          // for (String s : WoZuiShuai) {  
          //document.add(new Paragraph(s, italic_fontChinese));  
          //document.add(new Paragraph(" ", italic_fontChinese));  
          //  
          // Chapter  
          Paragraph title11 = new Paragraph("医院近期工作情况如下", italic_fontChinese);  
          Chapter chapter11 = new Chapter(title11, 1);  
          title11.setAlignment(Element.ALIGN_CENTER);
          chapter11.setNumberDepth(0); 
          Paragraph title1 = new Paragraph("警告！药品库存不足！情况如下：", bold_fontChinese);  
          Chapter chapter1 = new Chapter(title1, 1);  
          chapter1.setNumberDepth(0);  
        //test创建一个四列的表格
          Table TM=new Table(2);
          //设置边框
          TM.setBorder(1);
          //创建表头 

          Cell cellTM1=new Cell(new Phrase("药品名",bold_fontChinese));
          cellTM1.setHorizontalAlignment(Element.ALIGN_CENTER);
          cellTM1.setVerticalAlignment(Element.ALIGN_CENTER);
          cellTM1.setHeader(true);
          cellTM1.setBackgroundColor(Color.RED);

          Cell cellTM2=new Cell(new Phrase("库存",bold_fontChinese));
          cellTM2.setHorizontalAlignment(Element.ALIGN_CENTER);
          cellTM2.setVerticalAlignment(Element.ALIGN_CENTER);
          cellTM2.setHeader(true);
          cellTM2.setBackgroundColor(Color.RED);
          TM.addCell(cellTM1);
          TM.addCell(cellTM2);
          //添加此代码后每页都会显示表头
          TM.endHeaders();
          //以下代码的作用是创建行数据,其中每行有四列,列依次为 编号 科室名 就诊总金额 就诊总人次
          sql = "SELECT MED_NAME,MED_STORGE FROM MEDICINE"	;// 此处填写要执行的语句
  	    db = new MySQLConnect(sql);							// 新建一个数据库连接
  	    try {
  			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
  			while (ret.next()) {
  				String String_CheckName = ret.getString("MED_NAME");
  	             int Int_CheckStorge = ret.getInt("MED_STORGE");// 获取执行sql语句后结果集中列名为ACC_NAME的一个值	
  	             if (Int_CheckStorge<=20){
                //设置编号单元格
                Cell cell11=new Cell(new Phrase(ret.getString(1),bold_fontChinese));
                //设置姓名单元格
                Cell cell22=new Cell(new Phrase(ret.getString(2)));
                //单元格水平对齐方式
                cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
                //单元格垂直对齐方式
                cell11.setVerticalAlignment(Element.ALIGN_CENTER);

                cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell22.setVerticalAlignment(Element.ALIGN_CENTER);
                TM.addCell(cell11);
                TM.addCell(cell22);
  	             }
  	        }
  	        ret.close();		// 关闭执行的语句连接
  	        db.close();			// 关闭数据库连接
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}    
  	  document.add(chapter11); 
  	  document.add(chapter1);    
      document.add(TM);

          //构建一段落
          Paragraph par3=new Paragraph("科室工作情况",bold_fontChinese);
          //设置局中对齐
          par3.setAlignment(Element.ALIGN_CENTER);
          //添加到文档
          document.add(par3);
          //创建一个四列的表格
          Table table=new Table(4);
          //设置边框
          table.setBorder(1);
          //创建表头
          Cell cell1=new Cell(new Phrase("编号",bold_fontChinese));
          cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
          cell1.setVerticalAlignment(Element.ALIGN_CENTER);
          cell1.setHeader(true);
          cell1.setBackgroundColor(Color.RED);

          Cell cell2=new Cell(new Phrase("科室名",bold_fontChinese));
          cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
          cell2.setVerticalAlignment(Element.ALIGN_CENTER);
          cell2.setHeader(true);
          cell2.setBackgroundColor(Color.RED);

          Cell cell3=new Cell(new Phrase("就诊总金额",bold_fontChinese));
          cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
          cell3.setVerticalAlignment(Element.ALIGN_CENTER);
          cell3.setHeader(true);
          cell3.setBackgroundColor(Color.RED);

          Cell cell4=new Cell(new Phrase("就诊总人次",bold_fontChinese));
          cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
          cell4.setVerticalAlignment(Element.ALIGN_CENTER);
          cell4.setHeader(true);
          cell4.setBackgroundColor(Color.RED);
          
          

          table.addCell(cell1);
          table.addCell(cell2);
          table.addCell(cell3);
          table.addCell(cell4);
          //添加此代码后每页都会显示表头
          table.endHeaders();
          //以下代码的作用是创建行数据,其中每行有四列,列依次为 编号 科室名 就诊总金额 就诊总人次
          sql = "SELECT SECTIONS.SEC_ID, SECTIONS.SEC_NAME, (SELECT round(IFNULL(SUM(IFNULL(RESULTS.RES_SUM,0)),0),2) FROM RESULTS WHERE RESULTS.ACC_ID =  (SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )),(SELECT COUNT(*) AS SEC_NUMBER FROM RESULTS WHERE RESULTS.ACC_ID = (SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )) FROM SECTIONS WHERE CAST(SECTIONS.SEC_ID AS UNSIGNED INT)>=5000"	;// 此处填写要执行的语句
  	    db = new MySQLConnect(sql);							// 新建一个数据库连接
  	    try {
  			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
  			while (ret.next()) {
                //设置编号单元格
                Cell cell11=new Cell(new Phrase(ret.getString(1)));
                //设置姓名单元格
                Cell cell22=new Cell(new Phrase(ret.getString(2),bold_fontChinese));
                //设置性别单元格
                Cell cell33=new Cell(new Phrase(ret.getString(3)));
                //设置备注单元格
                Cell cell44=new Cell(new Phrase(ret.getString(4)));

                //单元格水平对齐方式
                cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
                //单元格垂直对齐方式
                cell11.setVerticalAlignment(Element.ALIGN_CENTER);

                cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell22.setVerticalAlignment(Element.ALIGN_CENTER);

                cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell33.setVerticalAlignment(Element.ALIGN_CENTER);

                cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell44.setVerticalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell11);
                table.addCell(cell22);
                table.addCell(cell33);
                table.addCell(cell44);
  	        }
  			
  	        ret.close();		// 关闭执行的语句连接
  	        db.close();			// 关闭数据库连接
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}



          //test end
          document.add(table);
          Image jpeg1 = Image.getInstance("C:\\REPORT\\BarChart.jpg");  
          Image jpeg2 = Image.getInstance("C:\\REPORT\\HistogramChart.jpg");  
          Image jpeg3 = Image.getInstance("C:\\REPORT\\PieChart.jpg");  
          Image jpeg4 = Image.getInstance("C:\\REPORT\\SectorChart.jpg");  

          
          // 图片居中  
          jpeg1.setAlignment(Image.ALIGN_CENTER);  
          jpeg2.setAlignment(Image.ALIGN_CENTER);  
          jpeg3.setAlignment(Image.ALIGN_CENTER);  
          jpeg4.setAlignment(Image.ALIGN_CENTER);  
          
          document.add(jpeg1);  
          document.add(jpeg2); 
          document.add(jpeg3); 
          document.add(jpeg4); 
      } catch (DocumentException de) {  
          System.err.println(de.getMessage());  
      } catch (IOException ioe) {  
          System.err.println(ioe.getMessage());  
      }  

      
      // 关闭打开的文档  
      document.close();  
  }  
  
}
 
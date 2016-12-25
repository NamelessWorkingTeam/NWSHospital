package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class Visualization extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualization frame = new Visualization();
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
	public Visualization() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	public void Cake(){
        // 默认数据类型  
        DefaultPieDataset dataType = new DefaultPieDataset();  
        // 数据参数 内容，数量  
        dataType.setValue("IE6", 156);  
        dataType.setValue("IE7", 230);  
        dataType.setValue("IE8", 45);  
        dataType.setValue("火狐", 640);  
        dataType.setValue("谷歌", 245);    
        DefaultPieDataset data = dataType;  
            // 生成普通饼状图除掉 3D 即可  
            // 生产3D饼状图  
            PiePlot3D plot = new PiePlot3D(data);  
            JFreeChart chart = new JFreeChart(  
                    "用户使用的浏览器类型",            // 图形标题  
                    JFreeChart.DEFAULT_TITLE_FONT, // 标题字体  
                    plot,                          // 图标标题对象  
                    true                           // 是否显示图例  
            );  

            // 设置图片有边框  
            chart.setBorderVisible(true);  
            // 配置字体  
            Font kfont = new Font("宋体", Font.PLAIN, 12);    // 底部  
            Font titleFont = new Font("宋体", Font.BOLD, 25); // 图片标题  
            // 图片标题  
            chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));  
            // 底部  
            chart.getLegend().setItemFont(kfont);  
	//test end
}
}
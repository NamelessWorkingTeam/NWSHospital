package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Fee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee frame = new Fee();
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
	public Fee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(50, 10, 433, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u6536\u8D39");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		label.setBounds(202, 20, 41, 36);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(50, 76, 433, 40);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_1.setBounds(57, 10, 42, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_2.setBounds(189, 10, 70, 30);
		panel_1.add(label_2);
		
		JLabel lblLabel = new JLabel("label3");
		lblLabel.setForeground(Color.BLACK);
		lblLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		lblLabel.setBounds(109, 10, 70, 30);
		panel_1.add(lblLabel);
		
		JLabel lblLabel_1 = new JLabel("label4");
		lblLabel_1.setForeground(Color.BLACK);
		lblLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		lblLabel_1.setBounds(269, 10, 154, 30);
		panel_1.add(lblLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 126, 433, 211);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_5 = new JLabel("\u836F\u7269\u6536\u8D39\uFF1A");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_5.setBounds(10, 10, 70, 30);
		panel_2.add(label_5);
		
		table = new JTable();
		table.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(20, 66, 403, 144);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class,r);
		panel_2.add(table);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u7F16\u53F7");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel.setBounds(41, 39, 70, 30);
		panel_2.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_3.setFont(new Font("ËÎÌå", Font.PLAIN, 12));
		label_3.setBounds(148, 39, 60, 30);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\u6570\u91CF");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_4.setBounds(262, 39, 52, 30);
		panel_2.add(label_4);
		
		JLabel label_6 = new JLabel("\u5355\u4EF7");
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_6.setBounds(358, 39, 35, 30);
		panel_2.add(label_6);
		
		JButton button = new JButton("\u5DF2\u6536\u8D39");
		button.setBounds(160, 583, 93, 23);
		contentPane.add(button);
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(50, 347, 433, 211);
		contentPane.add(panel_3);
		
		JLabel label_8 = new JLabel("\u9879\u76EE\u6536\u8D39\uFF1A");
		label_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_8.setBounds(10, 10, 70, 30);
		panel_3.add(label_8);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{5, "¹ÒºÅ·Ñ", 2},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.setBounds(20, 64, 403, 144);
		DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();   
		r2.setHorizontalAlignment(JLabel.CENTER);   
		table_1.setDefaultRenderer(Object.class,r2);
		panel_3.add(table_1);
		
		JLabel label_7 = new JLabel("\u9879\u76EE\u7F16\u53F7");
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_7.setBounds(61, 39, 70, 30);
		panel_3.add(label_7);
		
		JLabel label_9 = new JLabel("\u9879\u76EE\u540D\u79F0");
		label_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_9.setBounds(197, 39, 70, 30);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("\u4EF7\u683C");
		label_10.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_10.setBounds(342, 39, 70, 30);
		panel_3.add(label_10);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(294, 583, 93, 23);
		contentPane.add(button_1);
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
	}
}

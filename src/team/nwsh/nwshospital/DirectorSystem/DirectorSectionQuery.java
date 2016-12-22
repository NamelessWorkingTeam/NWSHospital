package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DirectorSectionQuery extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -681747462607739352L;
	private JPanel DirectorSectionQuery;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectorSectionQuery frame = new DirectorSectionQuery();
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
	public DirectorSectionQuery() {
		setTitle("\u79D1\u5BA4\u60C5\u51B5\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 380, 560);
		DirectorSectionQuery = new JPanel();
		DirectorSectionQuery.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorSectionQuery.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorSectionQuery);
		
		JPanel panel = new JPanel();
		DirectorSectionQuery.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel DirectorSectionQueryTitle = new JLabel("\u79D1\u5BA4\u5DE5\u4F5C\u60C5\u51B5\u67E5\u8BE2");
		DirectorSectionQueryTitle.setFont(new Font("宋体", Font.BOLD, 30));
		DirectorSectionQueryTitle.setBounds(48, 10, 257, 62);
		panel.add(DirectorSectionQueryTitle);
		
		JComboBox SectionBox = new JComboBox();
		SectionBox.setFont(new Font("宋体", Font.PLAIN, 16));
		SectionBox.setBounds(87, 108, 91, 16);
		panel.add(SectionBox);
		
		JButton NumberButton = new JButton("\u67E5\u8BE2\u7EDF\u8BA1\u6302\u53F7\u91CF");
		NumberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		NumberButton.setFont(new Font("宋体", Font.PLAIN, 12));
		NumberButton.setBounds(116, 173, 121, 23);
		panel.add(NumberButton);
		
		JLabel NumberLabel = new JLabel("");
		NumberLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		NumberLabel.setBounds(226, 140, 54, 23);
		panel.add(NumberLabel);
		
		JLabel CashLabel = new JLabel(" ");
		CashLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		CashLabel.setBounds(220, 197, 60, 23);
		panel.add(CashLabel);
		
		JLabel NumberMarkedWords = new JLabel("\u8BE5\u79D1\u5BA4\u603B\u6302\u53F7\u91CF\u4E3A\uFF1A");
		NumberMarkedWords.setFont(new Font("宋体", Font.PLAIN, 12));
		NumberMarkedWords.setBounds(23, 140, 155, 25);
		panel.add(NumberMarkedWords);
		
		JLabel CashMarkedWords = new JLabel("\u8BE5\u79D1\u5BA4\u5C31\u8BCA\u603B\u91D1\u989D\u4E3A\uFF1A");
		CashMarkedWords.setFont(new Font("宋体", Font.PLAIN, 12));
		CashMarkedWords.setBounds(23, 194, 168,30);
		panel.add(CashMarkedWords);
		
		JButton CashButton = new JButton("\u67E5\u8BE2\u5C31\u8BCA\u603B\u91D1\u989D");
		CashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CashButton.setFont(new Font("宋体", Font.PLAIN, 12));
		CashButton.setBounds(116, 234, 121, 23);
		panel.add(CashButton);
		
		JButton ShapingButton = new JButton("\u751F\u6210\u997C\u72B6\u56FE");
		ShapingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ShapingButton.setFont(new Font("宋体", Font.PLAIN, 12));
		ShapingButton.setBounds(124, 329, 106, 23);
		panel.add(ShapingButton);
		
		JButton DirectorSectionQueryQuitButton = new JButton("\u9000\u51FA");
		DirectorSectionQueryQuitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		DirectorSectionQueryQuitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		DirectorSectionQueryQuitButton.setBounds(135, 461, 83, 23);
		panel.add(DirectorSectionQueryQuitButton);
		
		JLabel SectionMarkedWords = new JLabel("\u79D1\u5BA4\uFF1A");
		SectionMarkedWords.setFont(new Font("宋体", Font.PLAIN, 12));
		SectionMarkedWords.setBounds(23, 110, 54, 15);
		panel.add(SectionMarkedWords);
		
		JLabel SectionMarkedWordsLabel = new JLabel("\u8BF7\u9009\u62E9\u79D1\u5BA4\u8FDB\u884C\u67E5\u8BE2");
		SectionMarkedWordsLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		SectionMarkedWordsLabel.setBounds(25, 69, 171, 31);
		panel.add(SectionMarkedWordsLabel);
		
		JLabel NumberUnit = new JLabel("\u4EBA\u6B21");
		NumberUnit.setFont(new Font("宋体", Font.PLAIN, 12));
		NumberUnit.setBounds(290, 140, 54, 23);
		panel.add(NumberUnit);
		
		JLabel CashUnit = new JLabel("\u5143");
		CashUnit.setFont(new Font("宋体", Font.PLAIN, 12));
		CashUnit.setBounds(290, 198, 54, 22);
		panel.add(CashUnit);
	}

}

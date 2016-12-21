package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;

public class DirectorDoctorQuery extends JFrame {
	private JPanel DirectorDoctorQuery;
	private JTextField SearchTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectorDoctorQuery frame = new DirectorDoctorQuery();
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
	public DirectorDoctorQuery() {
		setTitle("\u533B\u751F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 380, 560);
		DirectorDoctorQuery = new JPanel();
		DirectorDoctorQuery.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorDoctorQuery.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorDoctorQuery);
		
		JPanel panel = new JPanel();
		DirectorDoctorQuery.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	
		SearchTextField = new JTextField();
		SearchTextField.setFont(new Font("宋体", Font.PLAIN, 16));
		SearchTextField.setBounds(45, 107, 139, 23);
		panel.add(SearchTextField);
		SearchTextField.setColumns(10);
		
		JButton SearchButton = new JButton("\u641C\u7D22");
		SearchButton.setFont(new Font("宋体", Font.PLAIN, 16));
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String String_InputDoctorName = SearchTextField.getText();//获取SearchTextField内容
				/*If(=String_InputDoctorName)
				{
				DirectorDoctorQueryGoal newframe = new DirectorDoctorQueryGoal();
							
				newframe.setVisible(true);
				}*/
			}
		});
		SearchButton.setBounds(228, 107, 104, 23);
		panel.add(SearchButton);
		
		JLabel SearchMarkedWords = new JLabel("\u8BF7\u8F93\u5165\u533B\u751F\u540D\u5B57\uFF1A");
		SearchMarkedWords.setFont(new Font("宋体", Font.PLAIN, 16));
		SearchMarkedWords.setBounds(35, 65, 181, 40);
		panel.add(SearchMarkedWords);
		
		JComboBox SelectSectionBox = new JComboBox();
		SelectSectionBox.setFont(new Font("宋体", Font.PLAIN, 16));
		SelectSectionBox.setBounds(89, 175, 85, 23);
		panel.add(SelectSectionBox);
		
		JComboBox SelectDoctorBox = new JComboBox();
		SelectDoctorBox.setFont(new Font("宋体", Font.PLAIN, 16));
		SelectDoctorBox.setBounds(89, 224, 86, 25);
		panel.add(SelectDoctorBox);
		
		JLabel DirectorDoctorQueryTitle = new JLabel("\u533B\u751F\u5DE5\u4F5C\u60C5\u51B5\u67E5\u8BE2");
		DirectorDoctorQueryTitle.setFont(new Font("宋体", Font.BOLD, 30));
		DirectorDoctorQueryTitle.setBounds(23, 10, 257, 62);
		panel.add(DirectorDoctorQueryTitle);
		
		JLabel SelectSectionLabel = new JLabel("\u79D1\u5BA4\uFF1A");
		SelectSectionLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		SelectSectionLabel.setBounds(35, 175, 64, 25);
		panel.add(SelectSectionLabel);
		
		JLabel SelectDoctorLabel = new JLabel("\u59D3\u540D\uFF1A");
		SelectDoctorLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		SelectDoctorLabel.setBounds(35, 224, 64, 25);
		panel.add(SelectDoctorLabel);
		
		JButton SelectButton = new JButton("\u9009\u62E9");
		SelectButton.setFont(new Font("宋体", Font.PLAIN, 16));
		SelectButton.setBounds(228, 174, 104, 25);
		panel.add(SelectButton);
		
		JButton ComfirmButton = new JButton("\u67E5\u8BE2");
		ComfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ComfirmButton.setBounds(184, 346, 135, 40);
		panel.add(ComfirmButton);
		ComfirmButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JList ComfirmList = new JList();
		ComfirmList.setBounds(35, 307, 104, 182);
		panel.add(ComfirmList);
		
		JLabel SelectMarkedWords = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u6761\u4EF6\uFF1A");
		SelectMarkedWords.setFont(new Font("宋体", Font.PLAIN, 16));
		SelectMarkedWords.setBounds(33, 140, 159, 25);
		panel.add(SelectMarkedWords);
		
		JLabel ComfirmMarkedWords = new JLabel("\u9009\u62E9\u533B\u751F\u59D3\u540D\uFF1A");
		ComfirmMarkedWords.setFont(new Font("宋体", Font.PLAIN, 16));
		ComfirmMarkedWords.setBounds(34, 259, 128, 40);
		panel.add(ComfirmMarkedWords);
		
		JButton DirectorDoctorQueryQuitButton = new JButton("\u9000\u51FA");
		DirectorDoctorQueryQuitButton.setFont(new Font("宋体", Font.PLAIN, 16));
		DirectorDoctorQueryQuitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		DirectorDoctorQueryQuitButton.setBounds(184, 427, 135, 40);
		panel.add(DirectorDoctorQueryQuitButton);
	}
}

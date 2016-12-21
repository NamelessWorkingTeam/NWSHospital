package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setBounds(100, 100, 800, 500);
		DirectorDoctorQuery = new JPanel();
		DirectorDoctorQuery.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorDoctorQuery.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorDoctorQuery);
		
		JPanel panel = new JPanel();
		DirectorDoctorQuery.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SearchButton.setBounds(337, 125, 93, 23);
		panel.add(SearchButton);
		
		SearchTextField = new JTextField();
		SearchTextField.setBounds(62, 125, 229, 23);
		panel.add(SearchTextField);
		SearchTextField.setColumns(10);
		
		JLabel SearchMarkedWords = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u6240\u533B\u751F\u540D\u5B57\uFF1A");
		SearchMarkedWords.setBounds(62, 67, 181, 51);
		panel.add(SearchMarkedWords);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(460, 95, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(596, 95, 93, 23);
		panel.add(btnNewButton_2);
		
		JList list = new JList();
		list.setBounds(470, 128, 219, 313);
		panel.add(list);
		
		JComboBox SectionComboBox = new JComboBox();
		SectionComboBox.setBounds(62, 205, 85, 23);
		panel.add(SectionComboBox);
		
		JComboBox DoctorComboBox_1 = new JComboBox();
		DoctorComboBox_1.setBounds(173, 205, 86, 22);
		panel.add(DoctorComboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(62, 252, 85, 23);
		panel.add(lblNewLabel_1);
		
		JLabel Title = new JLabel("\u533B\u751F\u5DE5\u4F5C\u60C5\u51B5\u67E5\u8BE2");
		Title.setFont(new Font("ËÎÌו", Font.BOLD, 22));
		Title.setBounds(62, 10, 257, 62);
		panel.add(Title);
	}
}

package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DirectorDoctorQueryGoal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectorDoctorQueryGoal frame = new DirectorDoctorQueryGoal();
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
	public DirectorDoctorQueryGoal() {
		setTitle("\u4F60\u6240\u67E5\u8BE2\u533B\u751F\u7684\u5DE5\u4F5C\u60C5\u51B5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel GoalNameLabel = new JLabel("\u59D3\u540D");
		GoalNameLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		GoalNameLabel.setBounds(20, 34, 54, 24);
		contentPane.add(GoalNameLabel);
		
		JLabel GoalNumberLabel = new JLabel("\u5C31\u8BCA\u603B\u4EBA\u6B21");
		GoalNumberLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		GoalNumberLabel.setBounds(95, 34, 80, 24);
		contentPane.add(GoalNumberLabel);
		
		JLabel GoalCashLabel = new JLabel("\u5C31\u8BCA\u603B\u91D1\u989D");
		GoalCashLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		GoalCashLabel.setBounds(209, 34, 85, 24);
		contentPane.add(GoalCashLabel);
		
		JLabel GoalName = new JLabel(" ");
		GoalName.setFont(new Font("宋体", Font.PLAIN, 16));
		GoalName.setBounds(20, 106, 65, 24);
		contentPane.add(GoalName);
		
		JLabel GoalNumber = new JLabel(" ");
		GoalNumber.setFont(new Font("宋体", Font.PLAIN, 16));
		GoalNumber.setBounds(95, 106, 80, 24);
		contentPane.add(GoalNumber);
		
		JLabel GoalCash = new JLabel(" ");
		GoalCash.setFont(new Font("宋体", Font.PLAIN, 16));
		GoalCash.setBounds(209, 106, 85, 24);
		contentPane.add(GoalCash);
		
		JButton btnNewButton = new JButton("\u5173\u95ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(105, 148, 93, 23);
		contentPane.add(btnNewButton);
	}

}

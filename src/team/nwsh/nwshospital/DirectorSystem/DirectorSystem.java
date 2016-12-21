package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DirectorSystem extends JFrame {

	private JPanel DirectorMianMeau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectorSystem frame = new DirectorSystem();
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
	public DirectorSystem() {
		setTitle("\u9662\u957F\u67E5\u8BE2\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 459);
		DirectorMianMeau = new JPanel();
		DirectorMianMeau.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorMianMeau.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorMianMeau);
		
		JPanel panel = new JPanel();
		DirectorMianMeau.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton PharmacyQuery = new JButton("\u836F\u623F\u67E5\u8BE2");
		PharmacyQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectorPharmacyQuery newframe = new DirectorPharmacyQuery();
				newframe.setVisible(true);
			}
		});
		PharmacyQuery.setBounds(10, 38, 158, 78);
		panel.add(PharmacyQuery);
		
		JButton SectionQuery = new JButton("\u79D1\u5BA4\u67E5\u8BE2");
		SectionQuery.setBounds(10, 149, 158, 78);
		SectionQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectorSectionQuery newframe = new DirectorSectionQuery();
			newframe.setVisible(true);
			}
		});
		panel.add(SectionQuery);
		
		JButton DoctorQuery = new JButton("\u533B\u751F\u67E5\u8BE2");
		DoctorQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DirectorDoctorQuery newframe = new DirectorDoctorQuery();
				newframe.setVisible(true);
			}
		});
		DoctorQuery.setBounds(10, 275, 158, 78);
		panel.add(DoctorQuery);
		
		JLabel MedicineAlarm = new JLabel("");
		MedicineAlarm.setBounds(145, 7, 169, 21);
		panel.add(MedicineAlarm);
		
		JButton CreatReport = new JButton("\u751F\u6210\u62A5\u544A");
		CreatReport.setBounds(226, 275, 158, 78);
		panel.add(CreatReport);
		
		JButton button_1 = new JButton("\u5BFC\u51FA\u62A5\u544A");
		button_1.setBounds(439, 275, 158, 78);
		panel.add(button_1);
	}
}

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
		setBounds(100, 100, 800, 500);
		DirectorMianMeau = new JPanel();
		DirectorMianMeau.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorMianMeau.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorMianMeau);
		
		JPanel panel = new JPanel();
		DirectorMianMeau.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton PharmacyQuery = new JButton("\u836F\u623F\u60C5\u51B5\u67E5\u8BE2");
		PharmacyQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectorPharmacyQuery newframe = new DirectorPharmacyQuery();
				newframe.setVisible(true);
			}
		});
		PharmacyQuery.setBounds(63, 43, 158, 78);
		panel.add(PharmacyQuery);
		
		JButton SectionQuery = new JButton("\u79D1\u5BA4\u60C5\u51B5\u67E5\u8BE2");
		SectionQuery.setBounds(63, 194, 158, 78);
		SectionQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectorSectionQuery newframe = new DirectorSectionQuery();
			newframe.setVisible(true);
			}
		});
		panel.add(SectionQuery);
		
		JButton DoctorQuery = new JButton("\u533B\u751F\u60C5\u51B5\u67E5\u8BE2");
		DoctorQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DirectorDoctorQuery newframe = new DirectorDoctorQuery();
				newframe.setVisible(true);
			}
		});
		DoctorQuery.setBounds(63, 334, 158, 78);
		panel.add(DoctorQuery);
		
		JLabel MedicineAlarm = new JLabel("");
		MedicineAlarm.setBounds(284, 43, 443, 78);
		panel.add(MedicineAlarm);
		
		JButton CreatReport = new JButton("\u751F\u6210\u62A5\u544A");
		CreatReport.setBounds(319, 194, 158, 78);
		panel.add(CreatReport);
		
		JButton PublishReport = new JButton("\u5BFC\u51FA\u62A5\u544A");
		PublishReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PublishReport.setBounds(319, 334, 158, 78);
		panel.add(PublishReport);
		
		JButton QuitButton = new JButton("\u9000\u51FA");
		QuitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		QuitButton.setBounds(569, 334, 158, 78);
		panel.add(QuitButton);
	}
}

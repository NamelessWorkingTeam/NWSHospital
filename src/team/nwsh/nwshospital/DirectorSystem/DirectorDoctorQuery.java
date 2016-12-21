package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DirectorDoctorQuery extends JFrame {

	private JPanel DirectorDoctorQuery;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		DirectorDoctorQuery = new JPanel();
		DirectorDoctorQuery.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorDoctorQuery.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorDoctorQuery);
	}

}

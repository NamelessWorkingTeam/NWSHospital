package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DirectorSectionQuery extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		DirectorSectionQuery = new JPanel();
		DirectorSectionQuery.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorSectionQuery.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorSectionQuery);
	}

}

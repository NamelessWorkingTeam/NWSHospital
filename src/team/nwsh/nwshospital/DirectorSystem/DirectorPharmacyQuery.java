package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DirectorPharmacyQuery extends JFrame {


	private JPanel DirectorPharmacyQuery;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectorPharmacyQuery frame = new DirectorPharmacyQuery();
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
	public DirectorPharmacyQuery() {
		setTitle("\u836F\u623F\u60C5\u51B5\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 800, 500);
		DirectorPharmacyQuery = new JPanel();
		DirectorPharmacyQuery.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorPharmacyQuery.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorPharmacyQuery);
		
		JPanel panel = new JPanel();
		DirectorPharmacyQuery.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}

package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 380, 560);
		DirectorPharmacyQuery = new JPanel();
		DirectorPharmacyQuery.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorPharmacyQuery.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorPharmacyQuery);
		
		JPanel panel = new JPanel();
		DirectorPharmacyQuery.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel DirectorPharmacyQueryTitle = new JLabel("\u836F\u623F\u60C5\u51B5\u67E5\u8BE2");
		DirectorPharmacyQueryTitle.setFont(new Font("ËÎÌו", Font.BOLD, 30));
		DirectorPharmacyQueryTitle.setBounds(23, 10, 257, 62);
		panel.add(DirectorPharmacyQueryTitle);
		
		
		JButton DirectorPharmacyQueryQuitButton = new JButton("\u9000\u51FA");
		DirectorPharmacyQueryQuitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		DirectorPharmacyQueryQuitButton.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		DirectorPharmacyQueryQuitButton.setBounds(130, 459, 93, 30);
		panel.add(DirectorPharmacyQueryQuitButton);
	}

}

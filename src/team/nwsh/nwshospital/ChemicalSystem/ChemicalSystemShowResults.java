package team.nwsh.nwshospital.ChemicalSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.sql.*;

import javax.swing.*;

import team.nwsh.nwshospital.MySQLConnect;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import team.nwsh.nwshospital.MySQLConnect;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ChemicalSystemShowResults extends JFrame implements ActionListener  {
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    JTable jt=null;
    JScrollPane jsp=null;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChemicalSystemShowResults frame = new ChemicalSystemShowResults();
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
	public ChemicalSystemShowResults() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u836F\u54C1\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChemicalSystemMedicineInfo newframe = new ChemicalSystemMedicineInfo();
				newframe.setVisible(true);
			}
		});
		panel_1.add(btnNewButton_2);
		
		

		
		
		setTitle("\u5C31\u8BCA\u7ED3\u679C\u67E5\u8BE2");

        ResultsModel rm=new ResultsModel();
		jt=new JTable(rm);
		jsp=new JScrollPane(jt);
		getContentPane().add(jsp);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);

		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}



package team.nwsh.nwshospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Screen extends JFrame {

	private static JLabel patient_name1;
	private static JLabel patient_statusid1;
	private static JLabel patient_name2;
	private static JLabel patient_statusid2;
	private static JLabel patient_name3;
	private static JLabel patient_statusid3;
	
	
	public class NwshClient {
		
		// private JTextArea incoming;
		
		public String incoming = null;

		// private JTextField outgoing;
		
		public String outgoing;

		private BufferedReader reader;

		private PrintWriter writer;

		private Socket socket;

		/**
		 * @author Liu Yummy
		 * @create 2016/12/26 11:14
		 * 负责客户端的启动,包括的功能:
		 * 1. 初始化网络;
		 * 2. 向客户端发送信息，通知其进行刷新;
		 * 3. 从服务端读取消息,动态刷新本地内容;
		 * 另外，原本想将本类写成模块独立开来，
		 * 但是发现IncomingReader在调用的时候无法独立调用，
		 * 所以暂且此模块作为学习使用！
		 */
		public void startUp()
		{
	        outgoing = "new";

	        setupNetwork();
	        
	        // 处理接收到的信息
	        Thread readerThread = new Thread(new IncomingReader());
	        readerThread.start();

		}

		private void setupNetwork() {
			try {
				// 进行网络初始化: 创建socket连接,获取socket的输入输出流
				socket = new Socket("127.0.0.1", 5000);
				
				InputStreamReader stream = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(stream);
				
				writer = new PrintWriter(socket.getOutputStream());
				
				System.out.println("网络初始化已经完成,服务端已连接!");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void SendMessage() {
			try {
				// 向socket中写入消息
				writer.println(outgoing);
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				// 发生数据流，刷新
				writer.flush();
				// System.out.println("writer closed");
			}
		}
		
		public class IncomingReader implements Runnable {
			public void run() {
				String message;
				try {
					// 从socket中读取消息
					while((message = reader.readLine()) != null) {
						incoming = message;
						LatestNumber();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void LatestNumber() {
		// 获取最新的叫号
		String[][] LatestNumber = new String[3][2];
        String String_SQL_LatestNumber = "SELECT STATE.STA_ID, PATIENTS.PAT_NAME " + 
        								 "FROM STATE JOIN PATIENTS ON PATIENTS.PAT_ID = STATE.PAT_ID " + 
        								 "WHERE STATE.STA_TUS = 1 OR STATE.STA_TUS = 2 " + 
        								 "ORDER BY STA_TUS ASC, STA_ID ASC LIMIT 3;";
		MySQLConnect Connection_LatestNumber = new MySQLConnect(String_SQL_LatestNumber);
		try {
			ResultSet RS_LatestNumber = Connection_LatestNumber.pst.executeQuery();
			int i = 0;
			while(RS_LatestNumber.next()) {
				LatestNumber[i][0] = RS_LatestNumber.getString("STA_ID");
				LatestNumber[i][1] = RS_LatestNumber.getString("PAT_NAME");
				i = i + 1;
			}
			RS_LatestNumber.close();
			Connection_LatestNumber.close();
			
			if(LatestNumber[0][0] != null) {
				patient_statusid1.setText(LatestNumber[0][0]);
				patient_name1.setText(LatestNumber[0][1]);	
			}
			if(LatestNumber[1][0] != null) {
				patient_statusid2.setText(LatestNumber[1][0]);
				patient_name2.setText(LatestNumber[1][1]);	
			}
			if(LatestNumber[2][0] != null) {
				patient_statusid3.setText(LatestNumber[2][0]);
				patient_name3.setText(LatestNumber[2][1]);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
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
	public Screen() {
		setTitle("\u666E\u901A\u5916\u79D1\u5927\u5C4F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5019   \u8BCA   \u533A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 40));
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u5230\u666E\u901A\u5916\u79D1 1 \u53F7\u8BCA\u5BA4\u5C31\u8BCA");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		patient_name1 = new JLabel("New label");
		patient_name1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		patient_statusid1 = new JLabel("New label");
		patient_statusid1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		patient_name2 = new JLabel("New label");
		patient_name2.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		patient_statusid2 = new JLabel("New label");
		patient_statusid2.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		patient_name3 = new JLabel("New label");
		patient_name3.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		patient_statusid3 = new JLabel("New label");
		patient_statusid3.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		LatestNumber();
		
		NwshClient ScreenClient = new NwshClient();
		ScreenClient.startUp();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(patient_name1)
						.addComponent(patient_statusid1))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(patient_name2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(patient_statusid2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(patient_name3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(patient_statusid3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(227, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(218))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(140, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(130))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(patient_name3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(patient_statusid3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(patient_name2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(patient_statusid2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(patient_name1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(patient_statusid1)))
					.addGap(50)
					.addComponent(lblNewLabel_1)
					.addGap(185))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

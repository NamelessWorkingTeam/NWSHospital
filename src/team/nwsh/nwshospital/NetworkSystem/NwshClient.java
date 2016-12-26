package team.nwsh.nwshospital.NetworkSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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
					System.out.println("The message received is " + message);
					incoming = message;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

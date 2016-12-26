package team.nwsh.nwshospital.NetworkSystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class NwshClientTest {
	
	private JTextArea incoming;

	private JTextField outgoing;

	private BufferedReader reader;

	private PrintWriter writer;

	private Socket socket;

	public static void main(String[] args)
	{
		NwshClientTest client = new NwshClientTest();
		client.startUp();
	}

	/**
	 * @author Liu Yummy
	 * @create 2016/12/26 11:14
	 * 负责客户端的启动,包括的功能:
	 * 1. 初始化网络
	 * 2. 向服务器端发送消息
	 * 3. 从服务端读取消息,打印.
	 */
	public void startUp()
	{
		// 以下的GUI不用理会
		JFrame frame = new JFrame("简单的聊天客户端");
        JPanel mainPanel = new JPanel();
        
        incoming = new JTextArea(15,20); 
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
       
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        

        outgoing = new JTextField(20);
        

        JButton sendButton = new JButton("发送");
        // 这里注册一个actionListener,监听发送信息请求
        sendButton.addActionListener(new SendButtonListener());

        
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        
        // 初始化网络信息
        setupNetwork();
        
        // 处理接收到的信息
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
          
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400,500);
        frame.setVisible(true);
	}

	private void setupNetwork()
	{
		try
		{
			// 进行网络初始化: 创建socket连接,获取socket的输入输出流
			socket = new Socket("127.0.0.1", 5000);
			
			InputStreamReader stream = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(stream);
			
			writer = new PrintWriter(socket.getOutputStream());
			
			System.out.println("网络初始化已经完成,服务端已连接!");
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public class SendButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				// 向socket中写入消息
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception ex)
			{
				ex.printStackTrace();
			} finally 
			{
				// 关闭数据流
				writer.flush();
				System.out.println("writer closed");
			}
			//重置输入框数据
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			// 向socket中写入消息
			writer.println(outgoing.getText());
			writer.flush();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally 
		{
			// 关闭数据流
			writer.flush();
			// System.out.println("writer closed");
		}
		//重置输入框数据
		outgoing.setText("");
		outgoing.requestFocus();
	}
	
	
	
	public class IncomingReader implements Runnable
	{
		public void run()
		{
			String message;
			try
			{
				// 从socket中读取消息
				while((message = reader.readLine()) != null)
				{
					System.out.println("The message received is " + message);
					incoming.append(message + "\n");
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
//			finally
//			{
//				try
//				{
//					// 关闭数据流
//					reader.close();
//					System.out.println("reader closed");
//				} catch (IOException e)
//				{
//					e.printStackTrace();
//				}
//			}
		}
	}
}

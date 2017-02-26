package com.heima.socket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Demo4_guiChat extends Frame{
	
	private TextArea viewText;
	private TextArea sendText;
	private Button shake;
	private Button clear;
	private Button log;
	private Button send;
	private TextField tField;
	private DatagramSocket socket;
	private BufferedWriter bufferedWriter;

	public Demo4_guiChat() {
		init();
		southPanel();
		centerPanel();	
		event();
	}
	
	public void event() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				socket.close();
				try {
					bufferedWriter.close();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					send();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					logFile();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}

			
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewText.setText("");
			}
		});
		
		shake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					send(new byte[]{-1},tField.getText());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}

			
		});
		
	}
	private void shake() {
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		
		for(int i = 0;i < 40;i++){
			
			try {
				this.setLocation(x+20,y+20);
				Thread.sleep(20);
				this.setLocation(x+20,y-20);
				Thread.sleep(20);
				this.setLocation(x-20,y+20);
				Thread.sleep(20);
				this.setLocation(x-20,y-20);
				Thread.sleep(20);
				this.setLocation(x, y);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}
	public void logFile() throws IOException {
		bufferedWriter.flush();
		
		FileInputStream fileInputStream = new FileInputStream("config.txt");
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		int len;
		byte[] arr = new byte[8192];
		while ((len = fileInputStream.read(arr)) != -1) {
			byteArrayOutputStream.write(arr,0,len);
			 
		}
		
		String string = byteArrayOutputStream.toString();
		
		viewText.setText(string);
		fileInputStream.close();
	}
	
	public void send(byte[] arr, String ip) throws Exception {
		DatagramPacket packet = 
				new DatagramPacket(arr, arr.length,InetAddress.getByName(ip),9999);
		socket.send(packet);
	}
	
	private void send() throws Exception {
		String message = sendText.getText();
		String ip = tField.getText();		
		
		send(message.getBytes(),ip);
	
		
		String time = getCurrentTime();
		
		String str = time + "我对"+ ip + "说" + "\r\n" + message +"\r\n";
		viewText.append(str);//将信息添加到显示区域中
		bufferedWriter.write(str);
		sendText.setText("");//清空发送区域
		
	}

	private String getCurrentTime() {
		Date data = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");		
		return simpleDateFormat.format(data);
	}

	public void centerPanel() {
		Panel center = new Panel();
		viewText = new TextArea();
		sendText = new TextArea(5,1);
		center.setLayout(new BorderLayout());
		center.add(sendText,BorderLayout.SOUTH);
		center.add(viewText, BorderLayout.CENTER);
		viewText.setEditable(false);
		viewText.setBackground(Color.WHITE);
		sendText.setFont(new Font("xxx", Font.PLAIN, 15));
		viewText.setFont(new Font("xxx", Font.PLAIN, 15));
		this.add(center,BorderLayout.CENTER);
	}
	
	public void southPanel() {
		Panel south = new Panel();
		tField = new TextField(15);
		tField.setText("127.0.0.1");
		send = new Button("发送");
		log = new Button("记录");
		clear = new Button("清屏");
		shake = new Button("振动");
		south.add(tField);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		
		this.add(south,BorderLayout.SOUTH);
	} 

	private void init() {
		this.setLocation(500,50);
		this.setSize(400,600);
		new Receive().start();
		try {
			socket = new DatagramSocket();
			bufferedWriter = new BufferedWriter(new FileWriter("config.txt",true));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	private class Receive extends Thread{
		@Override
		public void run() {
			 try {
				DatagramSocket socket = new DatagramSocket(9999);
				DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
				while(true){
					socket.receive(packet);
					byte[] arr = packet.getData();
					int len = packet.getLength();
					
					if(arr[0] == -1 && len == 1){
						shake();
						continue;
					}
					
					String message = new String(arr, 0, len);
					String time = getCurrentTime();
					String ip = packet.getAddress().getHostAddress();
					String str = time + " "+ ip + "对我说\r\n" + message +"\r\n";
					viewText.append(str);
					bufferedWriter.write(str);
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Demo4_guiChat();
	}

}

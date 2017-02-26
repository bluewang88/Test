package com.heima.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo03_MoreThread {

	public static void main(String[] args) {
		new Receive().start();
		new Send().start();
	}

}

class Receive extends Thread{
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(64666);
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			while(true){
				socket.receive(packet);
				
				byte[] arr = packet.getData();
				int len = packet.getLength();//获取有效字节数字
				String ip = packet.getAddress().getHostAddress();
				int port = packet.getPort();
				System.out.println(new String(arr,0,len) + ip + port);			
			}
		} catch (SocketException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}

class Send extends Thread{
	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(System.in);
//		String str = "heiheih";
			DatagramSocket socket = new DatagramSocket(); //创建Socket
			
			while(true){
				String line = scanner.nextLine();
				if ("quit".equals(line)) {
					break;
				}
				DatagramPacket packet =                         //创建package
						new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("127.0.0.1"),64666);
				
				socket.send(packet);
				
			}
			
			socket.close();
		} catch (SocketException e) {
			
			e.printStackTrace();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
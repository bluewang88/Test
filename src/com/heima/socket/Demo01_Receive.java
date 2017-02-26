package com.heima.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo01_Receive {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(64666);
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		socket.receive(packet);
		
		byte[] arr = packet.getData();
		int len = packet.getLength();//获取有效字节数字
		System.out.println(new String(arr,0,len));
		
		
	}

}

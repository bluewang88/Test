package com.heima.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Demo01_Send {
	
	public static void main(String[] args) throws IOException {
		String str = "heiheih";
 		DatagramSocket socket = new DatagramSocket(); //创建Socket
		DatagramPacket packet =                         //创建package
				new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"),64666);
		
		socket.send(packet);
		socket.close();
	}
}

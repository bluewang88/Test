package com.heima.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;



public class Demo02_Send {
	
	public static void main(String[] args) throws IOException {
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
	}
}

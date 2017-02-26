package com.heima.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2_Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12345);
		Socket socket = serverSocket.accept();
		
		InputStream iStream = socket.getInputStream();
		OutputStream oStream = socket.getOutputStream();
		
		oStream.write("百度一下".getBytes());
		
		byte[] arr = new byte[1024];
		int len = iStream.read(arr);
		System.out.println(new String(arr,0,len));
		
		System.out.println();

	}

}

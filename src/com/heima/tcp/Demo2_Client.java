package com.heima.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo2_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 12345);
		InputStream iStream = socket.getInputStream();
		OutputStream oStream = socket.getOutputStream();
		
		byte[] arr = new byte[1024];
		int len = iStream.read(arr);
		System.out.println(new String(arr,0,len));
		
		oStream.write("Ñ§Ï°ÍÚ¾ò»ú".getBytes());
		socket.close();
	}
}

package com.heima.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo1_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 12345);
		BufferedReader bReader = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		
		System.out.println(bReader.readLine());
		printStream.println("baiming");
		
		socket.close();
	}
}

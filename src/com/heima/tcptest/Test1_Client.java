package com.heima.tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Test1_Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner scanner = new Scanner(System.in);
		Socket socket = new Socket("127.0.0.1", 54321);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		
		printStream.println(scanner.nextLine()); // 将字符串写到服务器
		
		System.out.println(bufferedReader.readLine());
		
		

	}

}

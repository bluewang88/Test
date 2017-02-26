package com.coreJava;

import java.io.Console;
import java.util.Scanner;

/**
 * This program demonstrate console input
 * @version 1.10 2017-1-21
 * @author bluewang
 *
 */

public class inputTest {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		
//		//Get frist input
//		System.out.println("What's you name?");
//		String name = in.nextLine();
//		
//		//Get second input
//		System.out.println("How old are you?");
//		int age = in.nextInt();
//		
//		//display output on console
//		System.out.println("Hello," + name +" .Next year, you'll be " + (age + 1));
//		
		// Get passport from console
		Console console = System.console();
		if(console != null){
		String username = console.readLine("User name :");
		console.format("%s\n", username);
		char[] passwd = console.readPassword("Password:");
		console.format("%s\n",new String(passwd));
		
		}
		
		/*
		 * Java.io.Console 只能用在标准输入、输出流未被重定向的原始控制台中使用，
		 * 在 Eclipse 或者其他 IDE 的控制台是用不了的。
		 * 在原始控制台中输入就像Linux中有些地方输入密码一样，你输入了，但是看不见，所以只要按了键盘就管用，不要以
		 * 为好像没输入一样以为错了。
		 */
	}

}

package com.heima.thread;

import sun.security.jca.GetInstance;

public class Demo1_Singleton {
	public static void main(String[] args) {
//		Singleton s1 = Singleton.s;
//		Singleton s2 = Singleton.s;
//		
//		System.out.println(s1 == s2);
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
	
}

/**
 * ¶öººÊ½
 * @author bluewang
 *
 */
//class Singleton{
//	//private constructor ,other class cannot access this constructor
//	private Singleton() {
//	}
//	
//	//creat a object belong to this class
//	
//	private static Singleton s = new Singleton();
//	//provide public method to get this class instance
//	public static Singleton getInstance() {
//		return s;
//	}
//	
//}

/**
 * ÀÁººÊ½ 
 * @author bluewang
 *
 */
class Singleton{
	//private constructor ,other class cannot access this constructor
	private Singleton() {
	}
	
	//creat a object belong to this class
	
	private static Singleton s;
	//provide public method to get this class instance
	public static Singleton getInstance() {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}
	
}


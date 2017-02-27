package com.heima.reflect;

import com.heima.bean.Person;

public class Demo1_Reflect {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = Class.forName("com.heima.bean.Person");
		Class clazz2 = Person.class;
		Person person = new Person();
		
		Class clazz3 = person.getClass();
		System.out.println( clazz1 == clazz2);
		System.out.println(clazz1 == clazz3);
		System.out.println(clazz2 == clazz3);
		
		
	}

}

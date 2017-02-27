package com.heima.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.heima.bean.Person;

public class Demo3_Constructor {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Class.forName("com.heima.bean.Person");
		Constructor	constructor = clazz.getConstructor(String.class,int.class);
		Person person = (Person) constructor.newInstance("уехЩ",23);
		System.out.println(person);
	}

}

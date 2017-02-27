package com.heima.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.heima.bean.Person;


public class Demo4_Field {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class class1 = Class.forName("com.heima.Person");
		Constructor constructor = class1.getConstructor(String.class,int.class);
		
		Person person = (Person) constructor.newInstance("张三",23);
		
		Field field = class1.getDeclaredField("name");
		field.setAccessible(true); // 去除私有权限
		field.set(person, "李四");
		
	}

}

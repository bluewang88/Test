package com.heima.reflecttest;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class Test1 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(111);
		
		Class class1 = Class.forName("java.util.ArrayList");
		
		Method method = class1.getMethod("add", Object.class);
		method.invoke(list, "abc");
		System.out.println(list);

	}

}

package com.heima.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


import com.heima.bean.Person;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.MethodAccessor_Short;



public class Demo5_Method {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		Class class1 = Class.forName("com.heima.bean.Person");
		Constructor constructor = class1.getConstructor(String.class,int.class);
		
		Person person = (Person) constructor.newInstance("ÕÅÈý",23);
		
		Method method = class1.getMethod("eat");
		method.invoke(person);
		
		Method method2 = class1.getMethod("eat", int.class);
		method2.invoke(person, 10);
		
		

	}

}

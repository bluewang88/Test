package com.heima.reflecttest;

import java.lang.reflect.Field;

public class Tool {
	@SuppressWarnings("rawtypes")
	public void setProperty(Object object,String propertyName,Object value) throws Exception{
		
		Class class1 = object.getClass();
		Field field = class1.getDeclaredField(propertyName);
		field.setAccessible(true);
		field.set(object, value);
		
	}
}

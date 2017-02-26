package com.coreJava.generic;

import java.util.HashMap;
import java.util.Map;

import com.coreJava.equals.Employee;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<>();
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		
		System.out.println(staff);
		
		for(Map.Entry<String, Employee> entry : staff.entrySet()){
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key = " + key + ", value = " + value);
			
		}
	}
}

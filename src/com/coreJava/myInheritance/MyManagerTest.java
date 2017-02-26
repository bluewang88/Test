package com.coreJava.myInheritance;

import javax.net.ssl.ManagerFactoryParameters;

import com.sun.org.glassfish.gmbal.ManagedAttribute;

/**
 * @version 2017-2-1
 * @author bluewang
 *
 */

public class MyManagerTest {

	public static void main(String[] args) {
		MyManager boss = new MyManager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		
		Employee[] staff = new Employee[3];
		
		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
		
		if (staff[1] instanceof MyManager) {
			MyManager myBoss = (MyManager) staff[1];
		}
		
		
		for (Employee employee : staff) {
			System.out.println("name = " + employee.getName() + " , salary = " 
		                        + employee.getSalary());
		}

	}

}

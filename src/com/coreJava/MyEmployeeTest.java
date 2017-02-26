package com.coreJava;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * @version 2017-1-30
 * @author bluewang
 *
 */

public class MyEmployeeTest {

	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		for (Employee e : staff) {
			e.raiseSalary(5);
		}
		
		for (Employee e : staff) {
			System.out.println("name = "+ e.getName() + ",salary = " + e.getSalary()
			+ ",hireDay" + e.getHireDay());
		}
		
		

	}

}



class Employee{
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String n,double s,int year,int month,int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year,month - 1, day);
		hireDay = calendar.getTime();
		
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public Date getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPrecent) {
		double raise = salary*byPrecent / 100;
		salary += raise;
	}
}

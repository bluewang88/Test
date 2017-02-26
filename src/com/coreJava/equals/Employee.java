package com.coreJava.equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * @version 2017-2-3
 * @author bluewang
 *
 */

public class Employee {
	
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String nString,double s,int year,int month,int day) {
		name = nString;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		hireDay = calendar.getTime();
		
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getHireDay() {
		return hireDay;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) {
			return true;
		}
		
		if (otherObject == null) {
			return false;
		}
		
		if (getClass() != otherObject.getClass()) {
			return false;
		}
		
		Employee other = (Employee) otherObject;
		
		return Objects.equals(name, other.name) && salary == other.salary &&
				Objects.equals(hireDay, other.hireDay);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, salary, hireDay);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "[name = " + name + "]"; 
	}

	

}

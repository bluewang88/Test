package com.coreJava.myInheritance;

/**
 * @version 2017-2-1
 * @author bluewang
 *
 */

public class MyManager extends Employee {

	private double bonus;
	
	/**
	 * 
	 * @param n the employee's name
	 * @param s the salary
	 * @param year the hire year
	 * @param month the hire month
	 * @param day the hire day
	 */
	
	public MyManager(String n,double s,int year,int month,int day) {
		super(n, s, year, month, day);
		bonus = 0;
	}
	
	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}

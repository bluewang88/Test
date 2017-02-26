package com.coreJava.equals;

/**
 * @version 2017-2-3
 * @author bluewang
 *
 */

public class Manager extends Employee {
	private  double bonus;
	
	public Manager(String nString, double s, int year,int month, int day) {
		super(nString, s, year, month, day);
		bonus = 0;
	}
	
	@Override
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) { 
			return false;
		}
		
		Manager other = (Manager) otherObject;
		
		return bonus == other.bonus;
	}
	
	@Override
	public int hashCode() {
		
		return super.hashCode() + 17 * new Double(bonus).hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "[bonus = " + bonus + "]"; 
	}

}

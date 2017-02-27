package com.heima.reflecttest;

import java.io.PrintStream;

public class Test2 {

	public static void main(String[] args) throws Exception {
		
		Student student = new Student("张三",23);
		System.out.println(student);
		
		Tool tool = new Tool();
		tool.setProperty(student, "name", "李四");
		System.out.println(student);

	}

}

class Student{
	private String name;
	private int age;
	public Student() {
		super();
		
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
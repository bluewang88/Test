package com.heima.facorymethod;

public class Test {

	public static void main(String[] args) {
		DogFactory dFactory = new DogFactory();
		Dog dog = (Dog) dFactory.creatAnimal();
		dog.eat();
	}

}

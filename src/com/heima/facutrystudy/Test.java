package com.heima.facutrystudy;



public class Test {
	public static void main(String[] args) {
//		Dog dog = AnimalFactory.creatDog();
//		Cat cat = AnimalFactory.creatCat();
//		dog.eat();
//		cat.eat();
//		
		Dog dog = (Dog) AnimalFactory.creatAnimal("dog");
		dog.eat();
		
	}
	
	
}

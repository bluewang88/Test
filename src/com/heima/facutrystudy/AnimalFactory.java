package com.heima.facutrystudy;

public class AnimalFactory {
//	public static Dog creatDog() {
//		return new Dog();
//	}
//	
//	public static Cat creatCat() {
//		return new Cat();
//	}
	
	//���Ϸ���������̫��
	
	public static Animal creatAnimal(String name) {
		if ("dog".equals(name)) {
			return new Dog();
		}else if ("cat".equals(name)) {
			return new Cat();
		}else {
			return null;
		}
	}
	
}

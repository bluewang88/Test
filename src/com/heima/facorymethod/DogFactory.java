package com.heima.facorymethod;

public class DogFactory implements Factory {

	@Override
	public Animal creatAnimal() {

		return new Dog();
	}

}

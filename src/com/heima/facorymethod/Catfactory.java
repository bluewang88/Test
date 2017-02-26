package com.heima.facorymethod;

public class Catfactory implements Factory {

	@Override
	public Animal creatAnimal() {
		
		return new Cat();
	}

}

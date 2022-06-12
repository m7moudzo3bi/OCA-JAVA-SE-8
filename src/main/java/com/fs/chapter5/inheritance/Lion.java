package com.fs.chapter5.inheritance;

public class Lion extends Animal {

	private void roar() {
		System.out.print("Hi from " + getClass().getSimpleName() + " class, My father's age is: " + getAge());
	}

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.setAge(100);
		
		Lion lion = new Lion();
		lion.roar();
	}
}

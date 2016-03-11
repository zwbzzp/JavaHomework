package ch2;

import java.awt.Window.Type;

class Animal {
	public String bark = "haha";
	public void move() {
		System.out.println("动物可以移动");
		System.out.println(bark);
	}
}

class Dog extends Animal{
	public String bark = "wangwang";
	public void move() {
		System.out.println("狗可以走和跑");
		System.out.println(bark);
	}
}


public class overridden {
	public static void main(String[] args) {
		Animal b = new Dog();
		b.move();
		System.out.println(b.bark);
	}
}



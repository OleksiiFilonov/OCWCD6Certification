package com.example.inheritance.child;

import com.example.inheritance.Parent;


public class Child extends Parent {
	
	protected void printString() {
		System.out.println("Child");
		super.printString();
	}
	
	public static void main(String[] args) {
		Child child = new Child();
		child.printString();
	}

}

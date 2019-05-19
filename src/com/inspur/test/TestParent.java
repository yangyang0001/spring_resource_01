package com.inspur.test;

public class TestParent {
	
	static {
		System.out.println("5");
	}
	
	public TestParent(){
		System.out.println("0");
	}
	
	public static void main(String[] args) {	//5 4 7 6 1	2 3
		System.out.println("4");
		B b = new B();
		b.print();
	}
	
	//5
	//4
	//7
	//6
	//1
	//2
	//3


}

class A{
	
	static {
		System.out.println("7");
	}
	
	public A(){
		System.out.println("1");
	}
}

class B extends A{
	
	static {
		System.out.println("6");
	}
	
	public B(){
		System.out.println("2");
	}
	
	public void print(){
		System.out.println("3");
	}
}

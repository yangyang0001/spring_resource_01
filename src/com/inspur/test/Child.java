package com.inspur.test;

public class Child extends Parent{
	public void sayHelloTest(String data){
		this.sayHello(data);
	}
	
	public static void main(String[] args) {
		
		Child child = new Child();
		child.sayHelloTest("zhangsan");
		
		System.out.println("child.resultData -------------:" + child.resultData);
		
	}
}




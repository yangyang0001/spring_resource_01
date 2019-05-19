package com.inspur.test;

public class Singleton {
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}
	private Singleton(){}
	
	public static final Singleton getSingleton(){
		return SingletonHolder.INSTANCE;
	}
	
	public static void main(String[] args) {
		
		Singleton s = Singleton.getSingleton();
		Singleton s1 = Singleton.getSingleton();
		
		System.out.println(s == s1);
		
		
	}
}

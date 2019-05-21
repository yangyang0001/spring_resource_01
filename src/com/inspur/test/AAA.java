package com.inspur.test;

import java.util.HashMap;
import java.util.Hashtable;

public class AAA {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(null, "NULL_KEY_VALUE");
		System.out.println(map.get(null));
		
		Hashtable<Object, Object> table = new Hashtable<Object, Object>();
		table.put(null, "AAAA");
		System.out.println(table.get(null));
		
		
		Class.forName("");
		
	}

}

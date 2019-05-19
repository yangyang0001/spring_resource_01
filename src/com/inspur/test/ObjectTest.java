package com.inspur.test;

import java.io.InputStream;

import org.dom4j.DocumentException;

public class ObjectTest {
	
	public static void main(String[] args) throws DocumentException {
		
		/*		
 		String str = "IHn7n5bFHlPNzzKQ6mx1508399263801";
		
		System.out.println(str.length());
		
		String url = "localhost:8080/ums/iptvuserfori6_searchUserInfoByMac.do?action.time=1508463777857&action.riddle=5b87e71924a7d063e8c8ecb15ae881fd&user.user_boxmac=44:07:63:db:e0:a1";
		
		System.out.println(url.indexOf("/"));
		*/
		
		/*InputStream inputSteam = null;
		
		String xmlString =  "";
		
		Document doc = DocumentHelper.parseText(xmlString);
		
		System.out.println("---------------------------------------------------------------");*/
		
		String str = String.valueOf(System.currentTimeMillis());
		
		System.out.println(str + "------------" + str.length());
		
		
	}
	
	public InputStream getInputStream(){
		
		InputStream inputStream = this.getClass().getResourceAsStream("");
		
		return null;
	}

}

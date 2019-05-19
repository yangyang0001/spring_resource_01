package com.inspur.test;

import java.text.SimpleDateFormat;

public class SimpleDateFormatUtil {
	
	private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
		@Override
		protected SimpleDateFormat initialValue() {
			threadLocal.set(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
			threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	
	public static SimpleDateFormat getDefaultSDF(){
		return threadLocal.get();
	}
	
}

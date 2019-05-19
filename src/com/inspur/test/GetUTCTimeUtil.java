package com.inspur.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class GetUTCTimeUtil {

	private static DateFormat defaultSDF = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * @Func  获取时间的方法
	 * @param date
	 * @param time
	 * @param duration
	 * @return
	 */
	private static Date getDateByTimeStr(String date, String time, String duration){
		
		try {
			if(StringUtils.isNotBlank(duration)) {
				Date startDate = defaultSDF.parse(date + time);
				long startDateTimes = startDate.getTime();
				long durationTimes = Long.valueOf(duration).longValue() * 1000;
				Date lastDate = new Date(startDateTimes + durationTimes);
				return lastDate;
			} else {
				return defaultSDF.parse(date + time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	/**
	 * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
	 * 如果获取失败，返回null
	 * 
	 * @return
	 */
	public static String getUTCTimeStr(String dateString, String timeString, String durationString) {
		
		StringBuffer UTCTimeBuffer = new StringBuffer();
		
		try {
			Date date = getDateByTimeStr(dateString, timeString, durationString);
			
			// 1、取得本地时间：
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			// 2、取得时间偏移量：
			int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
			// 3、取得夏令时差：
			int dstOffset = cal.get(Calendar.DST_OFFSET);
			// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
			cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);
			
			String monthStr = month <10 ? "0" + month : "" + month;
			String dayStr = day <10 ? "0" + day : "" + day;
			String hourStr = hour <10 ? "0" + hour : "" + hour;
			String minuteStr = minute <10 ? "0" + minute : "" + minute;
			String secondStr = second <10 ? "0" + second : "" + second;
			
			UTCTimeBuffer.append(year).append(monthStr).append(dayStr);
			UTCTimeBuffer.append("T").append(hourStr).append(minuteStr).append(secondStr).append(".00Z");
			
			return UTCTimeBuffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	startDate="20171020"
	startTime="142600"
	duration="3060"
	status="1"
	description=""
	startTime=20171020T062600.00Z&amp;
			  20171020T071700.00Z
	
	3060 / 60 
	endTime=  20171020T071700.00Z"/>
	 */
	public static void main(String[] args) {
		String UTCTimeStr = getUTCTimeStr("20171020","142600","");
		System.out.println(UTCTimeStr);
		
		String UTCTimeStr1 = getUTCTimeStr("20171020","142600","3060");
		System.out.println(UTCTimeStr1);
	}

}

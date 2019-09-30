package com.sgnbs.energy.core.common.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

	public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE = "yyyy-MM-dd";


	public static String monthParse(String month){
		Calendar now = Calendar.getInstance();
		String day = null;
		if(month.length()<2){
			month="0"+month;
		}
		day = now.get(Calendar.YEAR)+"-"+month+"-"+"01";
		return day;
	}
	
	public static String dateParse(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String sdate = (new SimpleDateFormat("yyyyMMddHHmmss")).format(date);
		return sdate;
	}

	public static String formatDateTime(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sdf.format(date);
	}

	public static String formatDate(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sdf.format(date);
	}

	public static String formatDateTime(Date date, String style) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sdf.format(date);
	}

	/**
	 * 字符串转时间
	 * 
	 * @param dateString
	 * @param style
	 * @return
	 */
	public static Date string2Date(String dateString, String style) {
		if (StringUtils.isBlank(dateString))
			return null;
		Date date = new Date();
		SimpleDateFormat strToDate = new SimpleDateFormat(style);
		try {
			date = strToDate.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 判断传入的时间是否在当前时间之后，返回boolean值 true: 过期 false: 还没过期
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isExpire(Date date) {
		if (date.before(new Date()))
			return true;
		return false;
	}

	public static Date getHourAfter(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.roll(11, hour);
		return calendar.getTime();
	}

	public static Date getHourBefore(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.roll(11, -hour);
		return calendar.getTime();
	}

	public static Date getDateBefore(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.roll(5, -day);
		return calendar.getTime();
	}

	public static Date getDateAfter(Date date, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(5, now.get(5) + day);
		return now.getTime();
	}

	public static Date getMinuteAfter(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	public static Date getMinuteBefore(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, -minute);
		return calendar.getTime();
	}

	
	public static synchronized List getRecentMonths(int num){
		List maps = new ArrayList();
		//当前时所在月份的第一天和最后一天
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
		//设置startDate
		Calendar c = Calendar.getInstance();
		//设置endDate
		Calendar c2 = Calendar.getInstance();
		for (int i = 0; i < num; i++) {
			HashMap dateMap = new HashMap();
			//设置start
			//设置为1号,当前日期既为本月第一天
			c.set(Calendar.DAY_OF_MONTH,1);
			//设置为0点0分0秒
			c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH), 0, 0, 0);
			//存入年月显示
			dateMap.put("yearMonthStr",format.format(c.getTime()));
			maps.add(format.format(c.getTime()));
			dateMap.put("startDate",c.getTime());
			//将c 设置为下个月
			c.add(c.DATE, -1);
 
 
 
			//设置end 为当前月的月底 23时59分59秒
			c2.set(Calendar.DAY_OF_MONTH,1);
			//设置时间 23时59分59秒
			c2.set(c2.get(c.YEAR), c2.get(c.MONTH), c2.get(c.DAY_OF_MONTH), 23, 59, 59);
			//获得当前月最后一天
			c2.add(Calendar.MONTH, 1);
			c2.set(Calendar.DAY_OF_MONTH, 0);
			//存入map
			dateMap.put("endDate",c2.getTime());
			//获取当前时间的下一个月
			c2.add(Calendar.MONTH, -1);
			//将c2设置为当前时间上一个月
			c2.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH));
			//放入集合
			//maps.add(dateMap);
 
		}
		return maps;
	}

//	public static void main(String[] args) {
//
//		DateUtil.getRecentMonths(5);
//	}
}

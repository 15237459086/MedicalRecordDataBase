package com.kurumi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DateUtil
 * @author lyh
 *
 */
public class DateUtil {

	private static SimpleDateFormat dateFormat;
	
	/**
	 * date_format yyyy-MM-dd
	 */
	public static final String DATE_FORMATE = "yyyy-MM-dd";
	
	/**
	 * date_time_format yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_TIME_FORMATE = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * time_format HH:mm:ss
	 */
	public static final String TIME_FORMATE = "HH:mm:ss";
	
	/**
	 * millis of second
	 */
	public static final long MILLIS_SECOND = 1000;
	
	/**
	 * millis of minute
	 */
	public static final long MILLIS_MINUTE = MILLIS_SECOND*60;
	
	/**
	 * millis of hour
	 */
	public static final long MILLIS_HOUR = MILLIS_MINUTE*60;
	
	/**
	 * millis of day
	 */
	public static final long MILLIS_DAY = MILLIS_HOUR*24;
	
	/**
	 * Downward days
	 * @param startDateTime
	 * @param endDateTime
	 * @return days
	 */
	public static int getDaysBetweenOfDownward(Date startDateTime,Date endDateTime){
		long diffMillis = Math.abs(endDateTime.getTime()-startDateTime.getTime());
		long daysBetween = diffMillis/MILLIS_DAY;
		return Integer.parseInt(String.valueOf(daysBetween));
	}
	
	/**
	 * Upward days
	 * @param startDateTime
	 * @param endDateTime
	 * @return days
	 */
	public static int getDaysBetweenOfUpward(Date startDateTime,Date endDateTime){
		
		long diffMillis = Math.abs(endDateTime.getTime()-startDateTime.getTime());
		long daysBetween = diffMillis%MILLIS_DAY==0 ? diffMillis/MILLIS_DAY : diffMillis/MILLIS_DAY + 1;
		return Integer.parseInt(String.valueOf(daysBetween));
	}
	
	/**
	 * diff days
	 * @param startDate
	 * @param endDate
	 * @return days
	 * @throws ParseException
	 */
	public static int getDaysBetween(Date startDate,Date endDate) throws ParseException{
		
		long diffMillis = Math.abs(dateTimeConvert(endDate).getTime()-dateTimeConvert(startDate).getTime());
		long daysBetween = diffMillis/MILLIS_DAY;
		return Integer.parseInt(String.valueOf(daysBetween));
	}
	
	/**
	 * date to str
	 * @param format
	 * @param date
	 * @return str
	 */
	public static String dateFormat(String format,Date date){
		dateFormat=new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	/**
	 * date/datetime/time to str yyyy-MM-dd
	 * @param format
	 * @param date
	 * @return str
	 */
	public static String dateFormat(Date date){
		dateFormat=new SimpleDateFormat(DATE_FORMATE);
		return dateFormat.format(date);
	}
	
	/**
	 * string to date/datetime/time
	 * @param format
	 * @param str
	 * @return date/datetime/time
	 * @throws ParseException
	 */
	public static Date dateParse(String format,String str) throws ParseException{
		dateFormat=new SimpleDateFormat(format);
		return dateFormat.parse(str);
	}
	
	/**
	 * string to date/datetime/time 
	 * @param str
	 * @return date/datetime/time yyyy-MM-dd
	 * @throws ParseException
	 */
	public static Date dateParse(String str) throws ParseException{
		dateFormat=new SimpleDateFormat(DATE_FORMATE);
		return dateFormat.parse(str);
	}
	
	/**
	 * datetime to date
	 * @param dateTime
	 * @return date
	 * @throws ParseException
	 */
	public static Date dateTimeConvert(Date dateTime) throws ParseException {
		return dateParse(dateFormat(dateTime));
	}
	
	/**
	 * date compare
	 * @param firstDate
	 * @param secondDate
	 * @return 1/0/-1
	 * @throws ParseException
	 */
	public static int compare(Date firstDate,Date secondDate) throws ParseException{
		return dateParse(dateFormat(firstDate)).compareTo(dateParse(dateFormat(secondDate)));
		
	}
	
	/**
	 * 获取前一天日期
	 * @param date
	 * @return
	 */
	public static Date getLastDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	/**
	 * 获取后一天日期
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	
	public static Date addDay(Date date,int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}
	
	public static Date getMinDateOfYear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	public static Date getMaxDateOfYear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DATE, 31);
		return calendar.getTime();
	}
}

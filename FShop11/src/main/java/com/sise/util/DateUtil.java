package com.sise.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	public static Date getCurrentDate() throws ParseException{
    Date date = new Date();  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    String dateNowStr = sdf.format(date);
    Date dateNow=sdf.parse(dateNowStr);
    return  dateNow;
	}
	//转换时间格式
	public static String changeDateFormatFactory(Date date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateNowStr = sdf.format(date);
		return dateNowStr;
	}
	public static void main(String[] args) throws ParseException{
	System.out.println(DateUtil.changeDateFormatFactory(DateUtil.getCurrentDate()));
	System.out.println(DateUtil.getCurrentDate());
	}
}

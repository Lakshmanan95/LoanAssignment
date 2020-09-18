package com.example.loan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeUtil {

	
	public static String changeDatetoString(Date date){
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	      return ft.format(date);
	}
	
	public static Date stringToDate(String argDate) {
		Date t = null;
		try {
			//TimeZone tz = TimeZone.getDefault();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			sdf.setLenient(false);
			//sdf.setTimeZone(tz);
			t = new Date(sdf.parse(argDate).getTime());

		} catch (java.text.ParseException pe) {
			//logger_.debug("ParseException encountered in stringToTimestamp. String = " + argDate + ", Msg = " + pe.getMessage());
		}
		return t;
	}
	
	public static void main(String[] args) throws ParseException {
		Date dat = stringToDate("2020-09-18");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.parse("2020-09-18"));
		System.out.println(dat);
	}
	
}

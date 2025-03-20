package com.makemytrip.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDateFormat {
	public static String convertDate(String excelDate) {
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");  // Your Excel format
	    SimpleDateFormat outputFormat = new SimpleDateFormat("EEE MMM dd yyyy", Locale.ENGLISH);  // MakeMyTrip format

	    try {
	        Date date = inputFormat.parse(excelDate);
	        return outputFormat.format(date).toString();  // Convert to MakeMyTrip format
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return excelDate;  // Return as-is if an error occurs
	    }
	}

}

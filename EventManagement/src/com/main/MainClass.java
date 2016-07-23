package com.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class MainClass {
	public static void main(String...strings ){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		String dateInString = "02-08-2016";
		try {
			Date date = sdf.parse(dateInString);
			System.out.println(date);
			System.out.println(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {


		
		public int random() 
		{
			 Random ran = new Random();
			 int random=ran.nextInt(2000);
			 return random;
		}
		
		public String getSystemDate() {
			
			Date dt=new Date();
			String date=dt.toString();
			return date;			
		}
		
		public String formatSystemDate() {
			SimpleDateFormat dateformate = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
			Date dt=new Date();
			String getDateAndTime=dateformate.format(dt);
			getDateAndTime.replaceAll(":","-");
			return getDateAndTime;			
		}
	}


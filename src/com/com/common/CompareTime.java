package com.com.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2018年6月21日 上午11:39:52 
*/

public class CompareTime {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date begin = new Date();
		Date now = new Date();
		String str1 = "2018-06-20 10:38:51";
		long hours=0; 
		try {
			begin = df.parse(str1);
			hours = (now.getTime()-begin.getTime())/ (1000 * 60 * 60);
			if(hours<=24) {
				System.out.println("not need to update");
			}else {
				System.out.println("auto update");
			}
			System.out.println(hours);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


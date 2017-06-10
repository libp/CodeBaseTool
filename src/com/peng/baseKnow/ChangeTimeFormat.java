package com.peng.baseKnow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年6月10日 下午9:36:53 
 * @version 1.0 
 * @return  
 */

public class ChangeTimeFormat {
	public static void main(String[] args) {
		String s = "2017年05月22日";
		DateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日");      
		
		Date date = null;    
		            
		// String转Date    
		try {    
           date = format1.parse(s);   
		} catch (ParseException e) {    
           e.printStackTrace();    
		} 
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		
		System.out.println(dateString);
	}
}


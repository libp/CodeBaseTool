package com.peng.baseKnow;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年4月21日 上午11:47:25 
 * @version 1.0 
 * @return  
 */

public class SpiltString {
	public static void main(String asg[]) {
		String name = "PIT-LE-LSR-VM-ptculgp14";
		String rule = "PIT-LE-LSR-VM-";
		int length = rule.length();
		String name2 = "PITptculgp14";
		String name3 = "PIT-SW-APS-AP2-全渠道网银退货系统";
		String[] tStrings = name.split("-");
		String[] tStrings2 = name2.split("-");
		System.out.println(tStrings[4]);
		System.out.println(tStrings.length);
		System.out.println(name.substring(length)+"=============");
		System.out.println("ok"+length);
		
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "");
		map.put("groupname", "dd");
		map.put("id", "2222");
		System.out.println(map.get("id"));
	}
}


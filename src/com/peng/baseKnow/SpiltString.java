package com.peng.baseKnow;
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
		String[] tStrings = name.split("-");
		System.out.println(tStrings[4]);
		System.out.println(tStrings.length);
		System.out.println("ok");
	}
}


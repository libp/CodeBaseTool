package com.peng.baseKnow;
/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年6月10日 下午9:36:53 
 * @version 1.0 
 * @return  
 */

public class GetHashValue {
	public static void main(String[] args) {
		String s = "安徽";
		int hash = s.hashCode();
		String x = String.valueOf(System.currentTimeMillis());
		System.out.println(x);
	}
}


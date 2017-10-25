package com.peng.encrypt;

import org.jasypt.util.text.BasicTextEncryptor;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年10月25日 下午4:13:35 
*/

public class Jasypt {
	public static void main(String[] args) {
		
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword("lbp");
		String encrypted = encryptor.encrypt("000000");
		System.out.println(encrypted);
		System.out.println();
	}
}


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
		encryptor.setPassword("password");
		String encrypted = encryptor.encrypt("xuyaojiamideshuju");
		System.out.println(encrypted);
		
		
		
		 BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();  
		 textEncryptor2.setPassword("password");  
		 String decrypt = textEncryptor2.decrypt("xuyaojiemidezifu");  
		 System.out.println(decrypt);  
		
		
	}
}


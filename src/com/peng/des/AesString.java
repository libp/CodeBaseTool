package com.peng.des;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.peng.des.BASE64;
/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年4月5日 下午5:25:11 
 * @version 1.0 
 * @return  
 */

/**
 * 加解密字符串
 * @author Peng
 *
 */
public class AesString {
	private final static String DES = "DES";
	private final static String KEY = "GTL1699JGS";
	
	public static void main(String[] args) {
		String env = "TEST";
//		String env = "PRODUCTION";
		
		String content1 = "#!/bin/bash"+"\n"
						+"echo hi"+"\n"
						+"echo $0";
		String content2 = "#!/bin/bash"+"\n"
						+"echo hi"+"\n"
						+"echo $0"+"\n"
						+"#a3af6604a996772a963ce62bbfd52bc9"+"\n"
						+"#TCjKs8AR+y4brUhTsNlefNgbMJsFXdBihS8hLJim1Gwb332HEwkqAQ==";
		if(env.equalsIgnoreCase("PRODUCTION")){
			String result =  validateMd5(content2);
			System.out.println("-----"+result);
		}else {
			String result =  setMd5AndAes(content1);
			System.out.println("-----"+result);
		}
		
		
	}
	
	public static String setMd5AndAes(String content){
		String oringalMd5 = null;
		String oringalAes = null;
		oringalMd5 = getOriginalMd5(content);
		try {
			oringalAes = encrypt(oringalMd5,KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer sbBuffer = new StringBuffer(content);
		sbBuffer.append("\n"+"#"+oringalMd5+"\n");
		sbBuffer.append("#"+oringalAes);
		return sbBuffer.toString();
	}
	
	/**
	 * @author：李彪朋
	 * 检查脚本是否经测试环境测试
	 */
	public static String getOriginalMd5(String content){
		String value = null;
		byte[] bytes = content.getBytes();
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(bytes);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
			return value;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取脚本中Md5和实际Md5比较结果
	 * @param content
	 * @return
	 */
	public static String validateMd5(String content) {
		String[] splitContent = content.split("\n");
		StringBuffer sbBuffer = new StringBuffer();
		String compareMd5 = null;
		String compareAes = null;
		String oringalMd5 = null;
		String oringalAes = null;
		for (int i = 0; i < splitContent.length; i++) {
			if(i==(splitContent.length-2)){
				if(splitContent[i].length()==33&&splitContent[i].startsWith("#")){
					oringalMd5 = splitContent[i];
				}else {
					return "该脚本未经测试环境测试！缺少脚本安全烙印！";
				}
			}else if(i==(splitContent.length-1)){
				if(splitContent[i].length()==57&&splitContent[i].startsWith("#")){
					oringalAes = splitContent[i];
				}else {
					return "该脚本未经测试环境测试！缺少脚本安全烙印！";
				}
			}else {
				sbBuffer.append(splitContent[i]+"\n");
			}
		}
		try {
			compareMd5 = getOriginalMd5(sbBuffer.toString().substring(0, sbBuffer.toString().length()-1));
			compareAes = encrypt(compareMd5,KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(compareMd5.equalsIgnoreCase(oringalMd5.substring(1, oringalMd5.length()))&&compareAes.equalsIgnoreCase(oringalAes.substring(1, oringalAes.length()))){
			return "Success";
		}else {
			return "False";
		}
	}
	
	public static void Md5Aes(){
		String md5 = "a3af6604a996772a963ce62bbfd52bc9";
		String md5ae = "b6QLV1fZvKVSTkvRAlS00g2c5IS1cXLXP2cRLHzXxeUb332HEwkqAQ==";
		String md6ae = "c6QLV1fZvKVwTkvRAlS01g2c5IS1cXLXP2cRLHzXReUb332HEwkqAQ==";
		try {
			System.out.println(encrypt(md5,KEY));
			System.out.println(decrypt(md5ae,KEY));
			System.out.println(decrypt(md6ae,KEY));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String strs = BASE64.encode(bt);
		return strs;
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static String decrypt(String data, String key) throws IOException, Exception {
		if (data == null)
			return null;
		byte[] buf = BASE64.decode(data);
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt);
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}
}


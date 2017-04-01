package com.peng.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年4月1日 下午1:38:27 
 * @version 1.0 
 * @return  
 */

public class RemoveHtmlElement {
	public static void main(String[] args) {
		
		String teString = "aswdawsdadsdffq";
		String pattern1 = "as+";
		Pattern p1=Pattern.compile(pattern1); 
		Matcher m1=p1.matcher(teString); 
		while(m1.find()){
			System.out.println(m1.start());
			System.out.println(m1.end());
			System.out.println(m1.group());
		}
		
		String htmlElementString = "<html><div style='text-align: center;'>"
				+"新建启动项任务"
				+"</div><div style='text-align: left;'>"
				+"启动项名称：test.sh</div><div style='text-align: left;'>"
				+"执行用户：lbp</div><div style='text-align: left;'>"
				+"备注：test</div></html>";
		
		String pattern2 = "<html><div style='text-align: center;'>.*(?=</div></html>)";
		Pattern p2=Pattern.compile(pattern2); 
		Matcher m2=p2.matcher(htmlElementString); 
		while(m2.find()){
			System.out.println(m2.start());
			System.out.println(m2.end());
			System.out.println(m2.group());
		}
		
		
		 String str = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd";
	        Pattern pattern = Pattern.compile("http://.*(?=TR/xhtml1.*)");
	        Matcher matcher = pattern.matcher(str);
	         
	        while (matcher.find()) {
	            System.out.println(matcher.group());
	        }
		
	        
	        Pattern p = Pattern.compile("(http://)?(([^/ ]+/)+)([^ ]+)");
	        Matcher m = p
	            .matcher("a/x.jpg http://server.php/b/x/123.jpg server/b/x/黄彪.x.jpg server/b/x/Yahoo.jpg");
	        while (m.find()) {
	            String protocol = m.group(1) == null ? "" : m.group(1);
	            System.out.println(protocol + m.group(2) + " => " + m.group(4));
	        }
	 
	        p = Pattern.compile("(([^\\. ]+\\.)+)([^ ]+)");
	        m = p.matcher(":com.factory.web.Person :com.factory.web.Animal");
	        while (m.find()) {
	            System.out.println(m.group(1) + " => " + m.group(3));
	        }
	 
	        // 这里是你需要的，前面的我懒得删除了，*^_^*
	        p = Pattern.compile("([^,]+)TR");
	        m = p.matcher("ftp://www.w3.org/TR/xhtml1/DTD/"
	                + ",http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
	                + ",http://www.w3.org/HR/xhtml1/DTD/");
	        while (m.find()) {
	            System.out.println(m.group(1));
	        }
		String newString = htmlElementString.substring(0, 38);
		System.out.println(newString);
	}
}


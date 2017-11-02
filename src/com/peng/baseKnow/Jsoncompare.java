package com.peng.baseKnow;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;


/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年10月30日 下午10:23:40 
*/

public class Jsoncompare {
	public static void main(String[] args) {
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("result","success");
		String js1 = JSONArray.toJSONString(map2);
		Object js3 = JSONArray.toJSON(map2);
		System.out.println(JSONArray.toJSONString(map2));
		System.out.println(js1);
		System.out.println(js3);
		
		
		String rs = "{\"result\":\"success\"}";
		String js2 = JSONArray.toJSONString(rs);
		Object js4 = JSONArray.toJSON(rs);
		System.out.println(rs);
		System.out.println(js2);
		System.out.println(js4);
		
		//字符串再解析成json字符串没有意义，如果转化成json对象就可以当做json使用

	}
}


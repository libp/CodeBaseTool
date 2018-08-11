package com.peng.common;
import java.util.ArrayList;
import java.util.List;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2018年4月2日 下午7:37:12 
*/

public class TestMethod {
	public static void main(String[] args) {
        JudgeNotNull();
        
    }

    public static void JudgeNotNull(){
	    String a = "";
        if (a!=null && a != ""){
            System.out.println("is not null");
        }else{
            System.out.println("is  null");
        }
    }

    public static void Method1(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("3");
        list.add("5");
        list.add("7");
        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("6");
        list2.add("8");
        list2.addAll(list);
        System.out.println(list2);
    }
	
	public static void SortList() {
		List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("3");
        list.add("5");
        list.add("7");
        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("6");
        list2.add("8");
        for (int i = 0; i < list.size(); i++) {
        	int x = Integer.parseInt(list.get(i));
        	for(int j = 0; j< list2.size();j++) {
        		System.out.println(list2.size());
        		int y = Integer.parseInt(list2.get(j));
        		if(x==y) {
        			list2.set(j, list.get(i));
        			break;
        		}else if(x<y){
        			list2.add(j, list.get(i));
        			break;
        		}
        	}
        }
        System.out.println(list2);
	}
	
	public static void TestList() {
		List<String> list = new ArrayList<String>();  
        list.add("a");  
        list.add("b");  
        list.add("c");  
        list.add("d");  
        list.add("e");  
        list.add(2, "f");  
        System.out.println(list);  
        list.set(0,"g");
        System.out.println(list);  
	}
}


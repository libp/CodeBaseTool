package com.peng.baseKnow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2018年4月2日 下午3:17:08 
*/

public class CreateFile {
	public static void main(String[] args) throws Exception {
		//输入文本
		String path1 = "C:\\Users\\Peng\\git\\CodeBaseTool\\src\\com\\peng\\baseKnow\\grn";
		String path2 = "C:\\Users\\Peng\\git\\CodeBaseTool\\src\\com\\peng\\baseKnow\\grn1";
		//输出文本
		String file3 = "C:\\Users\\Peng\\git\\CodeBaseTool\\src\\com\\peng\\baseKnow\\grn2"; 
		
		List<String> endList = new ArrayList<>(); 
		List<String> times1= getList(path1);
		List<String> times2= getList(path2);
		
		
		
//		Map<String,List<String>> map = getHHMM(times1);
//		Map<String,List<String>> map2 = getHHMM(times2);
//		
//		
//		List<String> res1 = map.get("res");
//		List<String> res2 = map2.get("res");
//		int mm1 = Integer.parseInt(res1.get(0).split("\\s+")[2].substring(3, 5));
//		int mm2 = Integer.parseInt(res2.get(0).split("\\s+")[2].substring(3, 5));
//		if(mm1==mm2) {
//			List<String> list = compareHHMM(res1,res2);
//			endList.addAll(list);
//		}else if(mm1<mm2) {
//			endList.addAll(res1);
//		}
//
//		times1 = map.get("times");
//		times2 = map2.get("times");
//		System.out.println(res2);
		
		for(int m=0;m<10;m++) {
			Map<String,List<String>> map = getHHMM(times1);
			List<String> res1 = map.get("res");
			int mm1 = Integer.parseInt(res1.get(0).split("\\s+")[2].substring(3, 5));
			for(int n=0;n<10;n++) {
				Map<String,List<String>> map2 = getHHMM(times2);
				List<String> res2 = map2.get("res");
			}
		}
		
		
		
		
		
//		for (int i = 0; i < times1.size(); i++) {
//			String [] arr1 = times1.get(i).split("\\s+");
//			for (int j = 0; j< times2.size(); j++) {
//				String [] arr2 = times2.get(j).split("\\s+");
//				if(arr1[2].equals(arr2[2])) {
//					int t = Integer.parseInt(arr1[1])+ Integer.parseInt(arr2[1]);
//					String newLine = String.format("%1$7d", t) + "  "+arr2[2];
//					res.add(newLine);
//				}
//				if(!arr1[2].equals(arr2[2])) {
//					
//				}
//			}
//			
//        }
//		createFile(res,file3);
         
	}
	
	public static List<String> compareHHMM(List<String> list1,List<String> list2){
		for (int i = 0; i < list1.size(); i++) {
			String ss1 = list1.get(i).split("\\s+")[2].substring(6, 8);
			int x = Integer.parseInt(ss1);
			for (int j = 0; j< list2.size(); j++) {
				String ss2 = list2.get(j).split("\\s+")[2].substring(6, 8);
				int y = Integer.parseInt(ss2);
				if(x==y) {
					int t = Integer.parseInt(list1.get(i).split("\\s+")[1])+ Integer.parseInt(list2.get(j).split("\\s+")[1]);
					String newLine = String.format("%1$7d", t) + " "+list2.get(j).split("\\s+")[2];
					list2.set(j,newLine);
					break;
				}else if(x<y) {
					int t = Integer.parseInt(list1.get(i).split("\\s+")[1]);
					String newLine = String.format("%1$7d", t) + " "+list1.get(i).split("\\s+")[2];
					list2.add(j,newLine);
					break;
				}
			}
        }
		
		return list2;
	}
	
	public static Map<String,List<List<String>>> getHH(List<String> times) {
		String hhmm = times.get(0).split("\\s+")[2].substring(0, 5);
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> res = new ArrayList();
		for (int i = 0; i < times.size(); i++) {
			String [] arr1 = times.get(i).split("\\s+");
			if(hhmm.equals(arr1[2].substring(0, 5))) {
//				System.out.println(arr1[2].substring(0, 5));
				res.add(times.get(i));
			}else {
				for(int m = 0; m<i;m++) {
					times.remove(0);
				}
				break;
//				System.out.println(times1);
			}
        }
		map.put("times", times);
		map.put("res", res);
		return map;
		
	}
	
	
	public static Map<String,List<String>> getHHMM(List<String> times) {
		String hhmm = times.get(0).split("\\s+")[2].substring(0, 5);
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> res = new ArrayList();
		for (int i = 0; i < times.size(); i++) {
			String [] arr1 = times.get(i).split("\\s+");
			if(hhmm.equals(arr1[2].substring(0, 5))) {
//				System.out.println(arr1[2].substring(0, 5));
				res.add(times.get(i));
			}else {
				for(int m = 0; m<i;m++) {
					times.remove(0);
				}
				break;
//				System.out.println(times1);
			}
        }
		map.put("times", times);
		map.put("res", res);
		return map;
		
	}
	
	public static void createFile(List<String> list,String path) throws Exception {
		FileWriter fw = new FileWriter(path, true);  
		BufferedWriter bw = new BufferedWriter(fw); 
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i));
			bw.newLine();  
		}
         
        bw.flush();  
        bw.close();  
        fw.close();  
		
	}
	
	public static List<String> getList(String path){
		File file = new File(path);
		FileReader fr;
		List<String> times=new ArrayList<>();
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine(); 
			while(str != null) {
				times.add(str);
				str = br.readLine(); 
			}
	         
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return times;
				
	}
}


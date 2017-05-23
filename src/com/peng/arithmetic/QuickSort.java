package com.peng.arithmetic;

import org.apache.poi.util.TempFile;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年3月9日 下午6:41:27 
 * @version 1.0 
 * @return  
 */
/*
 * 快速排序
 */

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {22,25,87,34,28,40,57,29,42,68,99,44,55,12,56,88};
		
	}
	public int getMiddle(int[] list , int low ,int high ){
		int tmp = list[low]; 
		while( low < high ){
			while (low < high && list[high] >= tmp ){
				high--;
			}
		}
		return 0;
	}
}


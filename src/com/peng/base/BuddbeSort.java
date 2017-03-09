package com.peng.base;

import java.util.Iterator;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年3月9日 下午5:00:48 
 * @version 1.0 
 * @return  
 */
/*
 * 冒泡排序，就是一次一次比，把最小的放最前面，或最大的放最后面
 */
public class BuddbeSort {
	public static void main(String[] args) {
		int[] arr = {3,2,6,8,2,9,5,4,1};
		System.out.println("排序前数组为：");
		for( int num : arr ){
			System.out.print(num+" ");
		}
		for(int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println();
		System.out.println("排序后的数组为：");
		for( int num : arr){
			System.out.print(num + " ");
		}
	}
}


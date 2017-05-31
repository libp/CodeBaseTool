package com.peng.arithmetic;

import java.util.Iterator;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年3月9日 下午5:00:48 
 * @version 1.0 
 * @return  
 */
/*
 * 冒泡排序，就是一次一次比，把最小的放最前面，或最大的放最后面.
 */
public class BuddbeSort {
	public static void main(String[] args) {
		 int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
			int temp=0;
			for(int i=0;i<a.length-1;i++){
				for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
				}
			}
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]+",");
	}
}


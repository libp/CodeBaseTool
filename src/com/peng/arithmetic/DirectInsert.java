package com.peng.arithmetic;
/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年5月23日 上午11:09:08 
 * @version 1.0 
 * @return  
 */

/**
 * 直接插入排序
 * @author Peng
 *基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排
	好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好的
 */
public class DirectInsert {
	public static void main(String[] args) {
		int a[]={8,10,20,48,19,49,38,33,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
	    int temp=0;
	    for(int i=0;i<a.length;i++){
	    	for(int j =i ; j>0 ; j--){
	    		if(a[j] < a[j-1]){
		    		temp = a[j];
		    		a[j] = a[j-1];
		    		a[j-1] = temp;
		    	}
	    	}
	    	
	    }
	    for(int i=0;i<a.length;i++)
	       System.out.print(a[i]+",");
	}
}


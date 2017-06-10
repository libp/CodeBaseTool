package com.peng.arithmetic;


/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年3月9日 下午6:41:27 
 * @version 1.0 
 * @return  
 */
/*
 * 快速排序
 * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小
 * ,一部分大于等于基准元素
 * ,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分
 */

public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  		  
		    quick(a);  
		    for(int i=0;i<a.length;i++)  
		       System.out.print(a[i]+",");
	}
	
	public static int partition(int [] list,int p,int r){
		int x=list[r];
		int i=p-1;
		int temp;
		for(int j=p;j<=r-1;j++)
		{
			if(list[j]<=x){
				i++;
				 temp=list[i];
				list[i]=list[j];
				list[j]=temp;
			}
		}
		temp=list[i+1];
		list[i+1]=list[r];
		list[r]=temp;
		return i+1;
	}
	
	public static void sort(int []list,int p,int r){
		if(p<r)
		{
			int q=partition(list, p, r);
			sort(list, p, q-1);
			sort(list, q+1, r);
		}
	}
	public static void quick(int[] a) {     
		  
        if (a.length > 0) {    //查看数组是否为空     

            sort(a, 0, a.length - 1);     
    }     

	}
}


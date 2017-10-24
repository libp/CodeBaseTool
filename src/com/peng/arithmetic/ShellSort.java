package com.peng.arithmetic;


/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年5月23日 下午1:02:02 
 * @version 1.0 
 * @return  
 */
/**
 * 
 * 希尔排序基本思想：算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录
 * 的下标相差d.对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行
 * 直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		 int a[]={99,5,51,41,88,87,23,54,6,3,78,34,16,45,56,98};
		    int d=a.length;
		    while(true)
            {
                d=d/2;
                for(int x=0;x<d;x++)
                {
                    for(int i=x+d;i<a.length;i=i+d)
                    {
                        int temp=a[i];
                        int j;
                        for(j=i-d;j>=0&&a[j]>temp;j=j-d)
                        {
                            a[j+d]=a[j];
                        }
                        a[j+d]=temp;
                    }
                }
                if(d==1)
                {
                    break;
                }
            }  
		for(int i=0;i<a.length;i++)
		       System.out.print(a[i]+",");
		}
	
}


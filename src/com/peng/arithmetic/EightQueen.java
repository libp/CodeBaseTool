package com.peng.arithmetic;
/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2018年3月20日 下午4:39:46 
*/

public class EightQueen {
	public static void main(String args[]) {
		int chessboard[][] = new int[8][8];
		for(int i=0;i<chessboard.length;i++) {
			for(int j=0;j<chessboard[i].length;j++) {
				System.out.print(chessboard[i][j]);
			}
			System.out.println();
		}
	}
	

	
}


package com.peng.doexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年3月1日 下午8:07:00 
 * @version 1.0 
 * @return  
 */

public class DealExcel {
	public static void main(String[] args){
		int i;
		WritableSheet sheet;
        Workbook book;
        WritableWorkbook wbe = null;
        String excelpath="C://Users//Peng//Desktop//dotest2.xls";
        try {
			InputStream is = new FileInputStream(excelpath);
			book = Workbook.getWorkbook(is);
			wbe = Workbook.createWorkbook(new File(excelpath),book);
			
			Cell cell1,cell5;
			sheet=wbe.getSheet(0); 
            i=1;
            while(true)
            {
                //获取每一行的单元格 
            	cell1=sheet.getWritableCell(0,i);
                cell5=sheet.getWritableCell(7,i);
                CellFormat cf = cell5.getCellFormat();
                if("".equals(cell1.getContents())==true)    //如果读取的数据为空
                    break;
//	                System.out.println(cell5.getContents());
                String txt = cell5.getContents();
                String[] ss = txt.split("\n");
                StringBuffer  tmp = new StringBuffer();
                for (int j = 0; j < ss.length; j++) {
					String regEx1 = "^\\s?su+";
					String regEx2 = "^\\s?sh+";
					Pattern pattern1 = Pattern.compile(regEx1);
					Matcher matcher1 = pattern1.matcher(ss[j]);
					Pattern pattern2 = Pattern.compile(regEx2);
					Matcher matcher2 = pattern2.matcher(ss[j]);
					if(matcher1.find()||matcher2.find()){
						tmp.append(ss[j]+"\n");
						System.out.println(ss[j]);
					}
					String newcell = tmp.toString();
					System.out.println(newcell);
					Label lbl = new jxl.write.Label(7, i, newcell);
					lbl.setCellFormat(cf);
					sheet.addCell(lbl);
				}
                i++;
	          }
            System.out.println("总共处理了"+i+"行数据");
            wbe.write();
			wbe.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 
        
    }
	
}


package com.crm.qa.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataUtil {
    public static String path="D:\\IdeaProjects\\FreeCRMAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\FREECRM_TestData.xlsx";
    static Workbook wb;
    static Sheet sheet;

    public static Object[][] getData(String sheetName) throws FileNotFoundException {
        FileInputStream fileInputStream=null;
        fileInputStream=new FileInputStream(path);
        try {
            wb= WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet=wb.getSheet(sheetName);
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0; i<sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}

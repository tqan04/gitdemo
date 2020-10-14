package example;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadExcel {
	public static Object[][] readDataFromExcel(String pathToExcel, String sheetName) throws IOException
	{
	    FileInputStream fileInputStream= new FileInputStream(pathToExcel); 
	    HSSFWorkbook workbook = new HSSFWorkbook (fileInputStream); //get my workbook from xls (not working with xlsx)
	    HSSFSheet worksheet=workbook.getSheet(sheetName);// get workbook
	    DataFormatter formatter= new DataFormatter();
        HSSFRow row=worksheet.getRow(0);     //get first row  
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// number of Rows
        int ColNum= row.getLastCellNum(); // number of Columns 
         
        Object Data[][]= new Object[RowNum-1][ColNum]; 
         
            for(int i=0; i<RowNum-1; i++) 
            {  
                row= worksheet.getRow(i+1);
                 
                for (int j=0; j<ColNum; j++) 
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        HSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell); //Get cell value as string
                            Data[i][j]=value;                         
                        }
                    }
                }
            }
        workbook.close();
        return Data;
	}

}

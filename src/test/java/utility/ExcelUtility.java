package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	FileInputStream fis;
	XSSFWorkbook wb;
	   XSSFSheet ws;
	   XSSFRow row;
	   XSSFCell cell;
	   XSSFCellStyle style;
	  
	   String filepath;
	   FileOutputStream fos;
	   
	   String sheetname;
	   
	   
	   public ExcelUtility(String filepath) {
		   this.filepath=filepath;
	   }
	
	   
	
	public int getRowCount(String filepath ,String xlsheet) throws IOException {
		
		FileInputStream fis=new FileInputStream(filepath);
		
		XSSFWorkbook wb  =new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet(xlsheet);
		
		int rowCnt=ws.getLastRowNum();
		
		wb.close();
		
		wb.close();
		
		return rowCnt;
			
	}
	
	
	
	public int getColumnCount(String filepath , String xlsheet , int rownum) throws IOException {
		
		                 fis=new FileInputStream(filepath);
		                 wb= new XSSFWorkbook(fis);
		                 ws=wb.getSheet(xlsheet);
		      
		                 row= ws.getRow(rownum);
		         int cellcnt=row.getLastCellNum();
		         
		           wb.close();
		           
		           fis.close();
		           
		           return cellcnt;
		            
	
	}	
	
	
	public String getCellData(String filepath , String xlsheet ,int rownum , int cellnum) throws IOException {
		
		FileInputStream fis =new FileInputStream(filepath);
	     	XSSFWorkbook wb= new XSSFWorkbook(fis);
	     	           ws    = wb.getSheet(xlsheet);
	     	             row = ws.getRow(rownum);
	     	            cell  = row.getCell(cellnum);
	     	            String Data;
	     	            try {
	     	            	  DataFormatter formatter =new DataFormatter();
	     	            	 Data=formatter.formatCellValue(cell); /// returns formatted value as string data only
	     	            	  
	     	            }catch(Exception e) {
	     	            	Data ="";
	     	            }
	     	            return Data;
	     	            
		
		
	}
	
    
public void setCellData(String filepath , String xlsheet ,int rownum , int cellnum , String data) throws IOException {
	
	FileInputStream fis =new FileInputStream(filepath);
 	XSSFWorkbook wb= new XSSFWorkbook();
 	           ws    = wb.getSheet(xlsheet);
 	             row = ws.getRow(rownum);
 	             
 	             cell=row.createCell(cellnum);
 	             cell.setCellValue(data);
 	             
 	            FileOutputStream fos =new FileOutputStream(filepath);
 	            wb.write(fos);
 	            wb.close();
 	            fis.close();	            
}

public void fillGreenColor(String filepath , String xlsheet ,int rownum , int cellnum , String data) throws IOException {
	   
	FileInputStream fis =new FileInputStream(filepath); 
	      XSSFWorkbook wb=new XSSFWorkbook(fis);
	                   ws=wb.getSheet(xlsheet);
	                  row=ws.getRow(rownum);
	                  cell =row.getCell(cellnum);
	                  
	                     style =wb.createCellStyle();
	                     
	                     style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	                     style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                     
	                     cell.setCellStyle(style);
	                     
	                     FileOutputStream fov =new FileOutputStream(filepath);
	      	            wb.write(fov);
	      	            wb.close();
	      	            fis.close();
	      	            fov.close();
	       
	
	
}

public void fillRedColor(String filepath , String xlsheet ,int rownum , int cellnum , String data) throws IOException {
	   
	FileInputStream fis =new FileInputStream(filepath); 
	      XSSFWorkbook wb=new XSSFWorkbook(fis);
	                   ws=wb.getSheet(xlsheet);
	                  row=ws.getRow(rownum);
	                  cell =row.getCell(cellnum);
	                  
	                     style =wb.createCellStyle();
	                     
	                     style.setFillForegroundColor(IndexedColors.RED.getIndex());
	                     style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                     
	                     cell.setCellStyle(style);
	                     
	                     FileOutputStream fov =new FileOutputStream(filepath);
	      	            wb.write(fov);
	      	            wb.close();
	      	            fis.close();
	      	            fov.close();
}

public void setCellData2(String filepath , String xlsheet ,int rownum , int cellnum , String data) throws IOException {
	
	                 File file=new File(filepath);
	                 if(!file.exists()) {
	                	 wb=new XSSFWorkbook();
	                	   fos=new FileOutputStream(filepath);
	                	   wb.write(fos);
	                 }
	                 
	                   fis =new FileInputStream(filepath);
 	      XSSFWorkbook wb= new XSSFWorkbook();
 	
 	            if(wb.getSheetIndex(sheetname)==-1) {
 	            	wb.createSheet( sheetname );
 	            	ws=wb.getSheet(sheetname);
 	            }
 	                ws= wb.getSheet(xlsheet);
 	             row = ws.getRow(rownum);
 	             
 	             cell=row.createCell(cellnum);
 	             cell.setCellValue(data);
 	             
 	            fos =new FileOutputStream(filepath);
 	            wb.write(fos);
 	            wb.close();
 	            fis.close();	            
}
	
	
}

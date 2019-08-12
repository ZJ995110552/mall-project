package com.mercury.mallproject.common.utils.poi;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class ExcelTableUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelTableUtil.class);
	
	public static List<List<String>> parseExcel(MultipartFile multipartFile,int sheet){
		String[] fileNames = multipartFile.getOriginalFilename().split("[.]");
		String fileType = fileNames[fileNames.length - 1];
		if(StringUtils.equalsIgnoreCase(fileType, "xlsx")) {
			try {
				return readXLSX(multipartFile,sheet);
			} catch (IOException e) {
				LOGGER.error("读取xlsx格式文件失败");
			}
		}else if(StringUtils.equalsIgnoreCase(fileType, "xls")) {
			try {
				return readXLS(multipartFile,sheet);
			} catch (IOException e) {
				LOGGER.error("读取xls格式文件失败");
			}
		}
		return Lists.newArrayList();
	}
	
	private static List<List<String>> readXLSX(MultipartFile multipartFile,int sheet)throws IOException{
		List<List<String>> result = Lists.newArrayList();
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(multipartFile.getInputStream());
		if (sheet >= 0 && sheet < xssfWorkbook.getNumberOfSheets()) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheet);
			if (xssfSheet != null) {
				for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
					List<String> colList = Lists.newArrayList();
					result.add(colList);
					XSSFRow xssfRow = xssfSheet.getRow(rowNum);
					if (xssfRow != null) {
						int minColIx = xssfRow.getFirstCellNum();
						int maxColIx = xssfRow.getLastCellNum();
						for (int colIx = minColIx; colIx < maxColIx; colIx++) {
							XSSFCell cell = xssfRow.getCell(colIx);
							if (cell == null) {
								colList.add(null);
							} else {
								colList.add(cell.toString());
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	
	private static List<List<String>> readXLS(MultipartFile multipartFile,int sheet)throws IOException{
		List<List<String>> result = Lists.newArrayList();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(multipartFile.getInputStream());
		
		if(sheet>=0&&sheet<hssfWorkbook.getNumberOfSheets()){
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheet);
			if (hssfSheet != null){
				for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					List<String> colList = Lists.newArrayList();
					result.add(colList);
					
					HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					int minColIx = hssfRow.getFirstCellNum();
					int maxColIx = hssfRow.getLastCellNum();
					for (int colIx = minColIx; colIx < maxColIx; colIx++) {
						HSSFCell cell = hssfRow.getCell(colIx);
						if (cell == null) {
							colList.add(null);
						}else{
							colList.add(cell.toString());
						}
					}
				}
			}
		
		}
		return result;
		
	}
	
	public static <T> Object getAttrName(T bean,String attrName){
		try {
			Field[] fs = bean.getClass().getDeclaredFields();  
			   for(int i = 0 ; i < fs.length; i++){  
			       Field f = fs[i];  
			       if(Objects.equals(attrName, f.getName())){
			    	   f.setAccessible(true); //设置些属性是可以访问的  
			    	  return f.get(bean);//得到此属性的值     
			       }
			   }
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}  
		return null;
	}
}

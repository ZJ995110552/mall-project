package com.mercury.mallproject.common.utils.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
	Workbook wb = null;
	List<String[]> dataList = new ArrayList<String[]>(100);

	public ExcelReader(String path) {
		try {
			InputStream inp = new FileInputStream(path);
			wb = WorkbookFactory.create(inp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e){
			e.printStackTrace();
		}

	}

	public ExcelReader(InputStream inp) {
		try {
			wb = WorkbookFactory.create(inp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e){
			e.printStackTrace();
		}

	}
	
	public List<String[]> getAllSheetData(boolean isIgnoreTitle){
		int totalSheet = wb.getNumberOfSheets();
		for(int i=0; i < totalSheet; i++){
			getAllData(i, isIgnoreTitle);
		}
		return dataList;
	}

	/**
	 * 取Excel所有数据，包含header
	 * 
	 * @return List<String[]>
	 */
	public List<String[]> getAllData(int sheetIndex,boolean isIgnoreTitle) {
		int columnNum = 0;
		Sheet sheet = wb.getSheetAt(sheetIndex);
		if (sheet.getRow(0) != null) {
			columnNum = sheet.getRow(0).getLastCellNum() - sheet.getRow(0).getFirstCellNum();
		}
		if (columnNum > 0) {
			int rowIndex = 0;
			for (Row row : sheet) {
				if(isIgnoreTitle && rowIndex++ == 0){
					continue;
				}
				String[] singleRow = new String[columnNum];
				int n = 0;
				for (int i = 0; i < columnNum; i++) {
					Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					switch (cell.getCellTypeEnum()) {
					case BLANK:
						singleRow[n] = "";
						break;
					case BOOLEAN:
						singleRow[n] = Boolean.toString(cell.getBooleanCellValue());
						break;
					// 数值
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							singleRow[n] = String.valueOf(cell.getDateCellValue());
						} else {
							cell.setCellType(CellType.STRING);
							String temp = cell.getStringCellValue();
							// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
							if (temp.indexOf(".") > -1) {
								singleRow[n] = String.valueOf(new Double(temp)).trim();
							} else {
								singleRow[n] = temp.trim();
							}
						}
						break;
					case STRING:
						singleRow[n] = cell.getStringCellValue().trim();
						break;
					case ERROR:
						singleRow[n] = "";
						break;
					case FORMULA:
						cell.setCellType(CellType.STRING);
						singleRow[n] = cell.getStringCellValue();
						if (singleRow[n] != null) {
							singleRow[n] = singleRow[n].replaceAll("#N/A", "").trim();
						}
						break;
					default:
						singleRow[n] = "";
						break;
					}
					n++;
				}
				if ("".equals(singleRow[0])) {
					continue;
				} // 如果第一行为空，跳过
				dataList.add(singleRow);
			}
		}
		return dataList;
	}

	/**
	 * 返回Excel最大行index值，实际行数要加1
	 * 
	 * @return
	 */
	public int getRowNum(int sheetIndex) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		return sheet.getLastRowNum();
	}

	/**
	 * 返回数据的列数
	 * 
	 * @return
	 */
	public int getColumnNum(int sheetIndex) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		Row row = sheet.getRow(0);
		if (row != null && row.getLastCellNum() > 0) {
			return row.getLastCellNum();
		}
		return 0;
	}

	/**
	 * 获取某一行数据
	 * 
	 * @param rowIndex
	 *            计数从0开始，rowIndex为0代表header行
	 * @return
	 */
	public String[] getRowData(int sheetIndex, int rowIndex) {
		String[] dataArray = null;
		if (rowIndex > this.getColumnNum(sheetIndex)) {
			return dataArray;
		} else {
			dataArray = new String[this.getColumnNum(sheetIndex)];
			return this.dataList.get(rowIndex);
		}

	}

	/**
	 * 获取某一列数据
	 * 
	 * @param colIndex
	 * @return
	 */
	public String[] getColumnData(int sheetIndex, int colIndex) {
		String[] dataArray = null;
		if (colIndex > this.getColumnNum(sheetIndex)) {
			return dataArray;
		} else {
			if (this.dataList != null && this.dataList.size() > 0) {
				dataArray = new String[this.getRowNum(sheetIndex) + 1];
				int index = 0;
				for (String[] rowData : dataList) {
					if (rowData != null) {
						dataArray[index] = rowData[colIndex];
						index++;
					}
				}
			}
		}
		return dataArray;
	}
}

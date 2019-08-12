package com.mercury.mallproject.common.utils.poi;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.*;

public class ExcelParser {
	
	public static final class JYExcelSheet {
		
		private String sheetName;
		
		private List<List<String>> sheetContent = Lists.newArrayList();
		
		public String getSheetName() {
			return sheetName;
		}
		public void setSheetName(String sheetName) {
			this.sheetName = sheetName;
		}
		public List<List<String>> getSheetContent() {
			return sheetContent;
		}
		public void setSheetContent(List<List<String>> sheetContent) {
			this.sheetContent = sheetContent;
		}
	}
	
	public static List<JYExcelSheet> parseSheet(MultipartFile file) throws Exception {
		return parseSheet(file.getInputStream());
	}
	
	public static List<JYExcelSheet> parseSheet(InputStream inputStream) throws Exception {
		List<JYExcelSheet> result = Lists.newArrayList();
		try (Workbook workBook = initWorkBook(inputStream)){
			int number = workBook.getNumberOfSheets();
			for (int i = 0; i < number; i++) {
				JYExcelSheet sheet = new JYExcelSheet();
				sheet.setSheetName(workBook.getSheetName(i));
				sheet.setSheetContent(parseSheet2(i, workBook, false));
				result.add(sheet);
			}
		}
		return result;
	}
	
	public static List<List<String>> parseSheet(Sheet sheet, boolean ignoreTableTitle) {
		int rowStart = ignoreTableTitle? 1: 0;
		int rowEnd = Math.max(1, sheet.getLastRowNum());   //至少有1行数据
		int MY_MINIMUM_COLUMN_COUNT = 10;
		List<List<String>> list = new ArrayList<List<String>>();
		for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
			Row r = sheet.getRow(rowNum);
			int lastColumn = Math.max(r.getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);
			if (isEmptyRow(r, 0, lastColumn)) {
				continue;
			}
			List<String> colList = new ArrayList<String>();
			Iterator<Cell> it = r.iterator();
			while (it.hasNext()) {
				Cell c = it.next();
				colList.add(getColumnStrValue(c));
			}
			list.add(colList);
		}
		return list;
	}
	
	public static List<List<String>> parseSheet(String fileName, int sheetNum) throws Exception {
		Workbook workBook = initWorkBook(fileName);
		return parseSheet(sheetNum, workBook, false);
	}
	
	public static List<List<String>> parseSheet(MultipartFile file, int sheetNum) throws Exception {
		try (Workbook workBook = initWorkBook(file.getInputStream())) {
			return parseSheet(sheetNum, workBook, true);
		}
	}
	
	public static List<List<String>> parseSheet2(MultipartFile file, int sheetNum) throws Exception {
		try (Workbook workBook = initWorkBook(file.getInputStream())) {
			return parseSheet2(sheetNum, workBook, true);
		}
	}
	
	public static int getSheetNumber(MultipartFile file) throws Exception {
		return getSheetNumber(file.getInputStream());
	}
	
	public static int getSheetNumber(InputStream file) throws Exception {
		try (Workbook workBook = initWorkBook(file)) {
			return workBook.getNumberOfSheets();
		}
	}
	
	public static List<List<String>> parseSheet(InputStream file, int sheetNum) throws Exception {
		try (Workbook workBook = initWorkBook(file)) {
			return parseSheet(sheetNum, workBook, true);
		}
	}
	
	public static List<List<String>> parseSheet(InputStream file, int sheetNum, boolean ignoreTableTitle) throws Exception {
		try (Workbook workBook = initWorkBook(file)) {
			return parseSheet(sheetNum, workBook, ignoreTableTitle);
		}
	}

	private static List<List<String>> parseSheet(int sheetNum, Workbook workBook, boolean ignoreTableTitle) {
		Sheet sheet = workBook.getSheetAt(sheetNum);
		int rowStart = ignoreTableTitle? 1: 0;
		int rowEnd = Math.max(1, sheet.getLastRowNum()); // 至少有1行数据
		int MY_MINIMUM_COLUMN_COUNT = 10;
		List<List<String>> list = new ArrayList<List<String>>();
		for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
			Row r = sheet.getRow(rowNum);
			if(r == null){
				continue;
			}
			int lastColumn = Math.max(r.getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);
			if (isEmptyRow(r, 0, lastColumn)) {
				continue;
			}
			List<String> colList = new ArrayList<String>();
			Iterator<Cell> it = r.iterator();
			while (it.hasNext()) {
				Cell c = it.next();
				colList.add(getColumnStrValue(c));
			}
			list.add(colList);
		}
		return list;
	}
	
	private static List<List<String>> parseSheet2(int sheetNum, Workbook workBook, boolean ignoreTableTitle) {
		Sheet sheet = workBook.getSheetAt(sheetNum);
		int rowStart = ignoreTableTitle? 1: 0;
		int rowEnd = Math.max(1, sheet.getLastRowNum()); // 至少有1行数据
		List<List<String>> list = new ArrayList<List<String>>();
		for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
			Row r = sheet.getRow(rowNum);
			if(r == null){
				continue;
			}
			int lastColumn = r.getLastCellNum();
			if (isEmptyRow(r, 0, lastColumn)) {
				continue;
			}
			List<String> colList = new ArrayList<String>();
			for (int i = 0; i < r.getLastCellNum(); i++) {
				Cell cell = r.getCell(i);
				if (cell != null) {
					colList.add(getCellValueAsString(cell));
				} else {
					colList.add(null);
				}
			}
			list.add(colList);
		}
		return list;
	}
	
	public static List<List<String>> parseSheet2(MultipartFile file, int sheetNum, boolean ignoreTableTitle) throws Exception {
		try (Workbook workBook = initWorkBook(file.getInputStream())) {
			return parseSheet2(sheetNum, workBook, ignoreTableTitle);
		}
	}
	
	public static Map<String, Map<String, String>> readProduct(byte[] bytes, String fileName, Collection<String> errors) throws IOException {
		Map<String, Map<String, String>> infos = Maps.newHashMap();
		ByteArrayInputStream bis = null;
		Workbook wb = null;
		try {
			bis = new ByteArrayInputStream(bytes);
			boolean isE2007 = false;
			if (fileName.endsWith("xlsx")) {
				isE2007 = true;
			}
			// 根据文件格式(2003或者2007)来初始化
			if (isE2007) {
				wb = new XSSFWorkbook(bis);
			} else {
				wb = new HSSFWorkbook(bis);
			}
			Sheet sheet1 = wb.getSheetAt(0); // 获得第一个表单
			Iterator<Row> rows1 = sheet1.rowIterator(); //获得第一个表单的迭代器
			Set<String> wareCodes = Sets.newHashSet();
			String[] headers = null;
			while (rows1.hasNext()) {
				Row row = rows1.next();//获得行数据
				if (row.getRowNum() == 0) {
					headers = new String[row.getLastCellNum() + 1];
					for (int i = 0; i < row.getLastCellNum(); i++) {
						Cell cell = row.getCell(i);
						headers[i] = getCellValueAsString(cell);
					}
					continue;
				}
				Map<String, String> properties = Maps.newHashMap();
				int all = row.getLastCellNum();
				for (int i = 0; i < all; i++) {
					Cell cell = row.getCell(i);
					if (cell != null) {
						String value = getCellValueAsString(cell);
						properties.put(headers[i], value);
					}
				}
				if (!properties.containsKey("商品编码")) {
					errors.add("商品编码未填写");
					continue;
				}
				String wareCode = StringUtils.trim(properties.get("商品编码"));
				if (StringUtils.isEmpty(wareCode)) {
					errors.add("商品编码未填写");
					continue;
				}
				if (wareCodes.contains(wareCode)) {
					errors.add("商品编码[" + wareCode + "]重复");
					continue;
				}
				properties.remove("商品编码");
				infos.put(wareCode, properties);
			}
		} finally {
			if (bis != null) {
				bis.close();
			}
			if (wb != null) {
				wb.close();
			}
		}
		return infos;
	}

	private static Workbook initWorkBook(String fileName) throws Exception {
		return WorkbookFactory.create(new FileInputStream(fileName));
	}
	
	private static Workbook initWorkBook(InputStream inputStream) throws Exception {
		return WorkbookFactory.create(inputStream);
	}

	private static boolean isEmptyRow(Row r, int minCol, int maxCol) {
		boolean isEmpty = true;
		for (int cn = minCol; cn < maxCol; cn++) {
			Cell c = r.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (c != null) {
				String value = getColumnValue(c) == null ? null : getColumnValue(c).toString();
				if (value != null) {
					isEmpty = false;
					if ("total".equals(value.toLowerCase())) {
						return true;
					}
				}
			}
		}
		return isEmpty;
	}

	private static String getColumnStrValue(Cell cell) {
		Object value = getColumnValue(cell);
		if (value == null)
			return null;
		if (value instanceof String)
			return (String) value;
		return value + "";
	}

	private static Object getColumnValue(Cell cell) {
		Object value = null;
		if (cell == null)
			return value;
		try {
			switch (cell.getCellTypeEnum()) {
			case STRING:
				value = cell.getRichStringCellValue().getString();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = cell.getDateCellValue();
				} else {
					value = cell.getNumericCellValue();
				}
				break;
			case BOOLEAN:
				value = cell.getBooleanCellValue();
				break;
			case FORMULA:
				cell.setCellType(CellType.NUMERIC);
				value = cell.getNumericCellValue();
				break;
			default:
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	private static String getCellValueAsString(Cell cell) {
		switch (cell.getCellTypeEnum()) {
			case NUMERIC:
				double value = cell.getNumericCellValue();
				DecimalFormat df = new DecimalFormat("#.##");
				return String.valueOf(df.format(value));
			case STRING:
				return cell.getStringCellValue();
			case BLANK:
				return "";
			default:
				break;
		}
		return null;
	}

	public static void createCell(Row row, int cellIndex, String content, boolean needStarMark, HSSFCellStyle style, HSSFFont whiteFont, HSSFFont redFont, boolean isHeader, boolean overrideStyle)
	{
		content = StringUtils.isEmpty(content) ? "" : content;
		Cell cell = row.createCell(cellIndex);
		
		HSSFRichTextString richString = null;
		cell.setCellType(CellType.STRING);
		if (isHeader)
		{
			mystyle(style, cell,overrideStyle);
			if (needStarMark)
			{
				richString = new HSSFRichTextString("*" + content);
				richString.applyFont(0, 1, redFont);
				richString.applyFont(1, content.length() + 1, whiteFont);
			}
			else
			{
				richString = new HSSFRichTextString(content);
				richString.applyFont(0, content.length(), whiteFont);
			}
			cell.setCellValue(richString);
		}
		else
		{
			cell.setCellValue(content);
		}
	}
	
	public static void mystyle(HSSFCellStyle style, Cell headCell,boolean overrideStyle) {
		if (overrideStyle) {
			style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		headCell.setCellStyle(style);
	}
	
	public static  <T> byte[] commonExport (String configName, int rowStart, Collection<T> datas, Class<T> clazz) throws Exception, IllegalAccessException {
		Workbook workbook = ExcelParser.initWorkBook(Thread.currentThread().getContextClassLoader().getResourceAsStream(configName));
		Sheet sheet = workbook.getSheetAt(0);
		List<TableMetaData> tableMetaDatas = TableMetaData.getTableMetaData(clazz);
		for (T fw : datas) {
			Row row = sheet.createRow(rowStart++);
			int i = 0;
			for (TableMetaData tableMetaData : tableMetaDatas) {
				Cell cell = row.createCell(i++);
				Object value = tableMetaData.getField().get(fw);
				Format sf = tableMetaData.getSf();
				if (value != null) {
					if (sf != null) {
						cell.setCellValue(sf.format(value));
					} else {
						cell.setCellValue(value + "");
					}
				}
			}
		}
		return ExcelParser.getByteDataForWorkbook(workbook);
	}
	
	public static byte[] getByteDataForWorkbook(Workbook workbook) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} catch (IOException e) {
			
		} finally{
			try {
				bos.close();
				workbook.close();
			} catch (IOException e) {
				
			}
		}
		return bos.toByteArray();
	}
	
	public static List<List<String>> readExcelInfoCommon(byte[] bytes, String fileName) {
        ByteArrayInputStream bis = null;
        List<List<String>> result = new ArrayList<List<String>>();
        try {
            bis = new ByteArrayInputStream(bytes);
            boolean isE2007 = false;
            if (fileName.endsWith("xlsx")) {
                isE2007 = true;
            }
            Workbook wb = null;
            // 根据文件格式(2003或者2007)来初始化
            try {
                if (isE2007) {
                    wb = new XSSFWorkbook(bis);
                } else {
                    wb = new HSSFWorkbook(bis);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Sheet sheet = wb.getSheetAt(0); // 获得第一个表单

            Row headerRow = sheet.getRow(0);
            Iterator<Cell> cellIterator = headerRow.iterator();
            List<String> header = new ArrayList<String>();
            while (cellIterator.hasNext()) {
                Cell c = cellIterator.next();
                header.add(getColumnStrValue(c));
            }

            Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器
            while (rows.hasNext()) {
                Row row = rows.next();// 获得行数据
                if (isEmptyRow(row, 0, 50)) {
                    continue;
                }
                List<String> info = new ArrayList<String>();
                
                for (int index = 0; index < header.size(); index++) {
                    Cell c = row.getCell(index);
                    info.add(getColumnStrValue(c).trim());
                }
                result.add(info);
            }
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
	
	public static void main(String[] args) {
		try {
			System.out.println(parseSheet("C:/Users/b2c019/Desktop/dangdang/category.xlsx", 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

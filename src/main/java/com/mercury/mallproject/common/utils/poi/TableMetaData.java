package com.mercury.mallproject.common.utils.poi;

import com.google.common.collect.Lists;
import com.mercury.mallproject.common.annotation.Annotations;
import com.mercury.mallproject.common.annotation.Table;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
public class TableMetaData implements Comparable<TableMetaData>{

	public static <T> List<TableMetaData> getTableMetaData(Class<T> clazz) throws Exception{
		List<TableMetaData> metaData = Lists.newArrayList();
		List<Field> fields = Annotations.getFields(clazz, Table.class);
		for (Field field : fields) {
			Table table = field.getAnnotation(Table.class);
			TableMetaData data = new TableMetaData(table.index(), table.title(), field, table.type(), table.format());
			metaData.add(data);
		}
		Collections.sort(metaData);
		return metaData;
	}
	
		private int index;
		private String title;
		private List<String> titles;
		private Field field;
		private Method generateTitleMethod;
		private String type = "label";
		private String format;
		private Format sf = null;

		public TableMetaData (){
			
		}
		
		public TableMetaData(int index, String title, Field field) {
			super();
			this.index = index;
			this.title = title;
			this.field = field;
		}
		
		public TableMetaData(int index, String title, Field field, String type, String format) {
			this(index, title, field);
			this.type = type;
			this.setFormat(format);
			if (StringUtils.equals(type, "date")) {
				setSf(new SimpleDateFormat(format));
			}
		}
		
		public boolean isList(){
			return StringUtils.startsWith(type, "list");
		}
		
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Field getField() {
			return field;
		}

		public void setField(Field field) {
			this.field = field;
		}
		@Override
		public int compareTo(TableMetaData o) {
			return Integer.compare(index, o.index);
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

		public Method getGenerateTitleMethod() {
			return generateTitleMethod;
		}

		public void setGenerateTitleMethod(Method generateTitleMethod) {
			this.generateTitleMethod = generateTitleMethod;
		}

		public List<String> getTitles() {
			return titles;
		}

		public void setTitles(List<String> titles) {
			this.titles = titles;
		}

		public String getFormat() {
			return format;
		}

		public void setFormat(String format) {
			this.format = format;
		}

		public Format getSf() {
			return sf;
		}

		public void setSf(Format sf) {
			this.sf = sf;
		}
	
}

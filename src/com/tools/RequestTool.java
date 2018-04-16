package com.tools;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.httpclient.util.DateUtil;

import com.mysql.jdbc.Field;

public class RequestTool {
	//Save the variables in the request into the instance by reflection
	//The variable name  in the request is consistent with the class
	public static <T> void getParameter(T obj,HttpServletRequest request) throws ParseException {
		try {
			Class<?> objclass=obj.getClass();
			java.lang.reflect.Field[] fields=objclass.getDeclaredFields();
			for(java.lang.reflect.Field field:fields){
				field.setAccessible(true);
				Class<?> fieldType =field.getType();
				String fieldName=field.getName();
				System.out.println(fieldName);
				System.out.println(fieldType);
				String paramVal=request.getParameter(fieldName);
				if (paramVal==null) {
					continue;
				}
				System.out.println(paramVal);
			    if (String.class == fieldType) {
			        field.set(obj, paramVal);
			    //判断类型,如果是long,则使用NumberUtils.toLong,即使为空,也赋默认值0L
			    } else if (Integer.class == fieldType || Integer.class == fieldType) {
			        field.set(obj, Integer.parseInt(paramVal));
			    //判断类型,如果是date,则使用DateUtil.parseDateNewFormat格式化日期格式
			    } else if (Date.class == fieldType) {
			    	SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    	Date date=new Date(bartDateFormat.parse(paramVal).getTime());
			        field.set(obj, date);
			    } else if (Time.class == fieldType) {
					field.set(obj, Time.valueOf(paramVal));
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

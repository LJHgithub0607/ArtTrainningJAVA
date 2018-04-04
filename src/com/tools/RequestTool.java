package com.tools;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.httpclient.util.DateUtil;

import com.mysql.jdbc.Field;

public class RequestTool {
	//Save the variables in the request into the instance by reflection
	//The variable name  in the request is consistent with the class
	public static <T> void getParameter(T obj,HttpServletRequest request) {
		try {
			Class<?> objclass=obj.getClass();
			java.lang.reflect.Field[] fields=objclass.getDeclaredFields();
			for(java.lang.reflect.Field field:fields){
				field.setAccessible(true);
				Class<?> fieldType =field.getType();
				String fieldName=field.getName();
				System.out.println(fieldName);
				String paramVal=request.getParameter(fieldName);
				if (paramVal==null) {
					continue;
				}
				System.out.println(paramVal);
			    if (String.class == fieldType) {
			        field.set(obj, paramVal);
			    //�ж�����,�����long,��ʹ��NumberUtils.toLong,��ʹΪ��,Ҳ��Ĭ��ֵ0L
			    } else if (Integer.class == fieldType || Integer.class == fieldType) {
			        field.set(obj, Integer.parseInt(paramVal));
			    //�ж�����,�����date,��ʹ��DateUtil.parseDateNewFormat��ʽ�����ڸ�ʽ
			    } else if (Date.class == fieldType) {
			        field.set(obj, DateUtil.parseDate(paramVal));
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
		} catch (DateParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

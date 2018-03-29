package com.tools;


import java.util.Date;
import java.util.TimerTask;

import com.javaweb.dao.Total_CourseDAO;
import com.javaweb.dao.impl.Total_CourseDAOJdbcImpl;
import com.javaweb.domain.Total_Course;

public class TimerThreadExecutor extends TimerTask {
	private java.sql.Date EndDate;
	private Integer courseID;
	private Total_CourseDAO total_CourseDAO = new Total_CourseDAOJdbcImpl();
	
	public TimerThreadExecutor(java.sql.Date EndDate,Integer courseID){
		this.EndDate=EndDate;
		this.courseID=courseID;
	}
	
	@Override
	public void run() {
		
		System.out.println("course"+courseID+"----start--------"+new Date().toString()); 
		while(true){
			Date now=new Date();
			if (now.getTime()==EndDate.getTime()) {
				break;
			}
		}
		total_CourseDAO.delete(courseID);
		System.out.println("course"+courseID+"----end--------"+new Date().toString());
		
	}
	
}

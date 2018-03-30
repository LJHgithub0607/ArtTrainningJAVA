package com.tools;


import java.util.Date;
import java.util.TimerTask;

import com.javaweb.dao.Total_CourseDAO;
import com.javaweb.dao.impl.Total_CourseDAOJdbcImpl;
import com.javaweb.domain.Total_Course;

public class TimerThreadExecutor implements Runnable {
	private Integer courseID;
	private long waitTime;
	private Total_CourseDAO total_CourseDAO = new Total_CourseDAOJdbcImpl();
	
	public TimerThreadExecutor(Integer courseID,long waitTime){
		this.courseID=courseID;
		this.waitTime=waitTime;
	}
	
	@Override
	public void run() {		
		System.out.println("course"+courseID+"----start--------"+new Date().toString());
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		total_CourseDAO.delete(courseID);
		System.out.println("course"+courseID+"----end--------"+new Date().toString());
		//TODO count total classtimes;
	}
	
}

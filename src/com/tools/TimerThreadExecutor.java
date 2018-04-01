package com.tools;


import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.*;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.javaweb.dao.CourseDAO;
import com.javaweb.dao.Total_CourseDAO;
import com.javaweb.dao.impl.CourseDAOJdbcImpl;
import com.javaweb.dao.impl.Total_CourseDAOJdbcImpl;
import com.javaweb.domain.Course;
import com.javaweb.domain.Total_Course;

public class TimerThreadExecutor implements Runnable {
	private Integer totalcourseID;
	private long waitTime;
	private Total_CourseDAO total_CourseDAO = new Total_CourseDAOJdbcImpl();
	private CourseDAO courseDAO=new CourseDAOJdbcImpl();
	
	public TimerThreadExecutor(Integer totalcourseID,long waitTime){
		this.totalcourseID=totalcourseID;
		this.waitTime=waitTime;
	}
	
	@Override
	public void run() {		
		System.out.println("course"+totalcourseID+"----start--------"+new Date().toString());
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Course> courselist= courseDAO.getForListWithTotalCourseID(totalcourseID);
		Integer totalcost=0;
		Integer price=total_CourseDAO.getFromID(totalcourseID).getT_Course_Price();
		java.util.Iterator<Course> iterator=courselist.iterator();
		while (iterator.hasNext()) {
			totalcost+=iterator.next().getT_Course_Total_Time()*price;
			
		}
		//TODO remind payment system the totalcost of this course
		total_CourseDAO.delete(totalcost);
		System.out.println("course"+totalcost+"----end--------"+new Date().toString());
	}
	
}

package com.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dao.Total_CourseDAO;
import com.javaweb.dao.impl.Total_CourseDAOJdbcImpl;
import com.javaweb.domain.Total_Course;
import com.tools.TimerThreadExecutor;

import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/totalCourse/*")
public class TotalCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Total_CourseDAO total_CourseDAO=new Total_CourseDAOJdbcImpl();
    ExecutorService pool=Executors.newCachedThreadPool();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName=request.getRequestURI();
		System.out.println(methodName);
		methodName=methodName.substring(21, methodName.length());//different between each servlet     for example:/javaweb/Course/example
		System.out.println(methodName);
		try {
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void AddStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        Integer studentID=Integer.parseInt(request.getParameter("studentID"));  
        Integer courseID=Integer.parseInt(request.getParameter("courseID"));
        
        Map<String, Object>  map=new HashMap<String, Object>();
        Total_Course total_Course=new Total_Course();
        total_Course=total_CourseDAO.getFromID(courseID);
        String[] totalstudentID=total_Course.getT_Teacher_Students_ID().split(",");
        if(totalstudentID.length<total_Course.getT_Course_Max_Students()){
        	total_Course.setT_Teacher_Students_ID(total_Course.getT_Teacher_Students_ID()+studentID+",");
        	map.put("result", "Success");
        }else{
        	map.put("result", "Out Of Max");
        }  
            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  		
	}
	
	private void set(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        String name=request.getParameter("name");  
        Integer teacherID=Integer.parseInt(request.getParameter("teacherID"));
        Integer courseinstitutionID=Integer.parseInt(request.getParameter("courseinstitutionID"));
        String courseclassrooms=request.getParameter("courseclassrooms");
    	java.sql.Date deadlinedate=Date.valueOf(request.getParameter("deadlinedate"));
    	java.sql.Date startdate=Date.valueOf(request.getParameter("startdate"));
    	Integer weekday=Integer.parseInt(request.getParameter("weekday"));
    	Time starttime=Time.valueOf(request.getParameter("starttime"));
    	Time endtime=Time.valueOf(request.getParameter("endtime"));
    	Integer coursetimes=Integer.parseInt(request.getParameter("coursetimes"));//this Course total Course Time of all students;
    	Integer maxstudents=Integer.parseInt(request.getParameter("maxstudents"));
        
    	Total_Course total_course=new Total_Course();
    	total_course.setT_Course_Name(name);
    	total_course.setT_Course_Teacher_ID(teacherID);
    	total_course.setT_Course_Institution_ID(courseinstitutionID);
    	total_course.setT_Course_Deadline_Date(deadlinedate);
    	total_course.setT_Course_Start_Date(startdate);
    	total_course.setT_Course_Week_Day(weekday);
    	total_course.setT_Course_Day_Start_Time(starttime);
    	total_course.setT_Course_Day_End_Time(endtime);
    	total_course.setT_Course_Times(coursetimes);
    	total_course.setT_Course_Max_Students(maxstudents);
		
    	total_CourseDAO.save(total_course);
    	Integer courseID =total_CourseDAO.getID(name, teacherID, courseinstitutionID);
    	java.util.Date now=new java.util.Date();
    	pool.execute(new TimerThreadExecutor(courseID,now.getTime()-deadlinedate.getTime()));
    	
	}

}

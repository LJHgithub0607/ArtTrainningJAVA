package com.javaweb.servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dao.CourseDAO;
import com.javaweb.dao.CriteriaTotal_Course;
import com.javaweb.dao.InstitutionDAO;
import com.javaweb.dao.StudentDAO;
import com.javaweb.dao.TeacherDAO;
import com.javaweb.dao.Total_CourseDAO;
import com.javaweb.dao.impl.CourseDAOJdbcImpl;
import com.javaweb.dao.impl.InstitutionDAOJdbcImpl;
import com.javaweb.dao.impl.StudentDAOJdbcImpl;
import com.javaweb.dao.impl.TeacherDAOJdbcImpl;
import com.javaweb.dao.impl.Total_CourseDAOJdbcImpl;
import com.javaweb.domain.Course;
import com.javaweb.domain.Json_Total_Course;
import com.javaweb.domain.Teacher;
import com.javaweb.domain.Total_Course;

import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search/*")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDAO=new TeacherDAOJdbcImpl();
    private StudentDAO studentDAO=new StudentDAOJdbcImpl();
    private InstitutionDAO institutionDAO =new InstitutionDAOJdbcImpl();
    private CourseDAO courseDAO=new CourseDAOJdbcImpl();
    private Total_CourseDAO total_CourseDAO=new Total_CourseDAOJdbcImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		methodName=methodName.substring(16, methodName.length()); //different between each servlet   for example:/javaweb/Search/example
		System.out.println(methodName); 
		try {
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void StudentSearchAllCourse(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        Integer studentID=Integer.parseInt(request.getParameter("t_Student_ID"));
       
        Map<String, Object>  map=new HashMap<String, Object>();

        	try {
        		
        		java.util.List<Course> list=courseDAO.getForListWithStudentID(studentID);
				map.put("result", 1);
				map.put("courselist", list);
				
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}

            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void SearchInstitutionInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        Integer institutionID=Integer.parseInt(request.getParameter("t_Institution_ID"));
       
        Map<String, Object>  map=new HashMap<String, Object>();

        	try {
        		
				map.put("result", 1);
				map.put("institutioninfo", institutionDAO.getFromID(institutionID));
				
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}

            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void SearchInstitutionInfoWithName(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        String realname=request.getParameter("t_Institution_Real_Name");
       
        Map<String, Object>  map=new HashMap<String, Object>();

        	try {
        		
				map.put("result", 1);
				map.put("institutionlist", institutionDAO.getFromRealName(realname));
				
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}

            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void ConditionSearchCourse(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
    	String t_Course_Name=request.getParameter("name");
    	String t_Course_Assessment=request.getParameter("assessment");
    	Integer t_Course_Price=Integer.parseInt(request.getParameter("price"));
    	String t_Course_Category=request.getParameter("category");
    	Integer t_Course_Times=Integer.parseInt(request.getParameter("times"));
    	
    	CriteriaTotal_Course criteriaTotal_Course=new CriteriaTotal_Course();
    	criteriaTotal_Course.setT_Course_Name(t_Course_Name);
    	criteriaTotal_Course.setT_Course_Assessment(t_Course_Assessment);
    	criteriaTotal_Course.setT_Course_Price(t_Course_Price);
    	criteriaTotal_Course.setT_Course_Category(t_Course_Category);
    	criteriaTotal_Course.setT_Course_Times(t_Course_Times);    	
        Map<String, Object>  map=new HashMap<String, Object>();

        	try {
        		java.util.List<Total_Course> list=total_CourseDAO.getForListWithCriteriaTotal_Course(criteriaTotal_Course);
        		java.util.List<Json_Total_Course> jsonlist=new ArrayList<>();
        		for(Total_Course course:list){
        			jsonlist.add(new Json_Total_Course(course));
        		}
				map.put("result", 1);
				map.put("total_courseinfoList", jsonlist);
				
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}

            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void SearchTeacherInfoWithName(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        String realname=request.getParameter("t_Teacher_RealName");
       
        Map<String, Object>  map=new HashMap<String, Object>();

        	try {
        		map.put("teacherlist", teacherDAO.getFromRealName(realname));
				map.put("result", 1);
				
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}

            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void SearchCourseInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        Integer CourseID=Integer.parseInt(request.getParameter("t_Course_ID"));
       
        Map<String, Object>  map=new HashMap<String, Object>();
        Total_Course total_Course=total_CourseDAO.getFromID(CourseID);
        Json_Total_Course json_Total_Course=new Json_Total_Course(total_Course);
        	try {
        		map.put("total_courseinfo", json_Total_Course);
				map.put("result", 1);
				
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}

            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void SearchCourseInfoWithTeacherID(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        Integer teacherID=Integer.parseInt(request.getParameter("t_Teacher_ID"));
       
        Map<String, Object>  map=new HashMap<String, Object>();

        	try {
        		
        		java.util.List<Total_Course> list=total_CourseDAO.getFromTeacherID(teacherID);
        		java.util.List<Json_Total_Course> jsonlist=new ArrayList<>();
        		for(Total_Course course:list){
        			jsonlist.add(new Json_Total_Course(course));
        		}
        		map.put("total_courseinfoList", jsonlist);
				map.put("result", 1);
				
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}

            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void SearchCourseInfoWithInstitutionID(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        Integer institutionID=Integer.parseInt(request.getParameter("t_Institution_ID"));
       
        Map<String, Object>  map=new HashMap<String, Object>();

        	try {
        		java.util.List<Total_Course> list=total_CourseDAO.getFromInstitutionID(institutionID);
        		java.util.List<Json_Total_Course> jsonlist=new ArrayList<>();
        		for(Total_Course course:list){
        			jsonlist.add(new Json_Total_Course(course));
        		}
        		map.put("total_courseinfoList", jsonlist);
				map.put("result", 1);
				
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}

            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
}

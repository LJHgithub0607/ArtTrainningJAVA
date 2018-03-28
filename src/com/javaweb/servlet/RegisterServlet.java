package com.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.javaweb.dao.InstitutionDAO;
import com.javaweb.dao.StudentDAO;
import com.javaweb.dao.TeacherDAO;
import com.javaweb.dao.impl.InstitutionDAOJdbcImpl;
import com.javaweb.dao.impl.StudentDAOJdbcImpl;
import com.javaweb.dao.impl.TeacherDAOJdbcImpl;
import com.javaweb.domain.Student;
import com.javaweb.domain.Teacher;
import com.javaweb.domain.Institution;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register/*")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDAO=new TeacherDAOJdbcImpl();
    private StudentDAO studentDAO=new StudentDAOJdbcImpl();
    private InstitutionDAO institutionDAO =new InstitutionDAOJdbcImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		methodName=methodName.substring(18, methodName.length()); //different between each servlet   for example:/javaweb/CourseServlet/example
		System.out.println(methodName); 
		try {
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void Teacher(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        String realname=request.getParameter("realname");
        String institutionID=request.getParameter("institutionID");
        String phonenumber=request.getParameter("phonenumber");
        
        Map<String, Object>  map=new HashMap<String, Object>();
        if (IfNotExist(username)) {
        	Teacher teacher=new Teacher();
        	teacher.setT_Teacher_User_Name(username);
        	teacher.setT_Teacher_User_PAssword(password);
        	teacher.setT_Teacher_Real_Name(realname);
        	teacher.setT_Teacher_Institution(institutionID);
        	teacher.setT_Teacher_Phone_Number(phonenumber);
        	teacherDAO.save(teacher);
        	map.put("result", 403);
		}else{
			map.put("result", 200);
		}
            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void TeacherUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Integer id=Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        String realname=request.getParameter("realname");
        String institutionID=request.getParameter("institutionID");
        String phonenumber=request.getParameter("phonenumber");
        String assessment=request.getParameter("assessment");
        Integer approvalstatus=Integer.parseInt(request.getParameter("approvalstatus"));
        
    	Teacher teacher=new Teacher();
    	teacher.setT_Teacher_ID(id);
    	teacher.setT_Teacher_User_Name(username);
    	teacher.setT_Teacher_User_PAssword(password);
    	teacher.setT_Teacher_Real_Name(realname);
    	teacher.setT_Teacher_Institution(institutionID);
    	teacher.setT_Teacher_Phone_Number(phonenumber);
    	teacher.setT_Teacher_Assessment(assessment);
    	teacher.setT_Teacher_ApprovalStatus(approvalstatus);
    	teacherDAO.updatenew(teacher);
    	
	}
	
	private void Student(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        String realname=request.getParameter("realname");
        String phonenumber=request.getParameter("phonenumber");
        
        Map<String, Object>  map=new HashMap<String, Object>();
        if (IfNotExist(username)) {
        	Student student=new Student();
        	student.setT_Sudent_User_Name(username);
        	student.setT_Sudent_User_Password(password);
        	student.setT_Sudent_Real_Name(realname);
        	student.setT_Sudent_Phone_Number(phonenumber);
        	studentDAO.save(student);
        	map.put("result", 403);
		}else{
			map.put("result", 200);
		}
            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void StudentUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Integer id=Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        String realname=request.getParameter("realname");
        String phonenumber=request.getParameter("phonenumber");
        String assessment=request.getParameter("assessment");
        
    	Student student=new Student();
    	student.setT_Sudent_ID(id);
    	student.setT_Sudent_User_Name(username);
    	student.setT_Sudent_User_Password(password);
    	student.setT_Sudent_Real_Name(realname);
    	student.setT_Sudent_Phone_Number(phonenumber);
    	student.setT_Sudent_Assessment(assessment);
    	
    	studentDAO.updatenew(student);
    	
	}
	
	private void Institution(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        String realname=request.getParameter("realname");
        String phonenumber=request.getParameter("phonenumber");
        String address=request.getParameter("address");
        
        Map<String, Object>  map=new HashMap<String, Object>();
        if (IfNotExist(username)) {
        	Institution institution=new Institution();
        	institution.setT_Institution_User_Name(username);
        	institution.setT_Institution_User_Password(password);
        	institution.setT_Institution_Real_Name(realname);
        	institution.setT_Institution_Phone(phonenumber);
        	institution.setT_Institution_Adress(address);
        	map.put("result", 403);
		}else{
			map.put("result", 200);
		}
            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void InstitutionUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Integer id=Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        String realname=request.getParameter("realname");
        String phonenumber=request.getParameter("phonenumber");
        String address=request.getParameter("address");
        String assessment=request.getParameter("assessment");
        String approvalwait=request.getParameter("approvalwait");
        
    	Institution institution=new Institution();
    	institution.setT_Institution_ID(id);
    	institution.setT_Institution_User_Name(username);
    	institution.setT_Institution_User_Password(password);
    	institution.setT_Institution_Real_Name(realname);
    	institution.setT_Institution_Phone(phonenumber);
    	institution.setT_Institution_Adress(address);
    	institution.setT_Institution_Assessment(assessment);
    	institution.setT_Institution_ApprovalWait(approvalwait);
    	institutionDAO.updatenew(institution);
    	
	}
	private boolean IfNotExist(String username){
		return (teacherDAO.getFromUseName(username)==null)&&(studentDAO.getFromUseName(username)==null)&&(institutionDAO.getFromUserName(username)==null);
	}
}

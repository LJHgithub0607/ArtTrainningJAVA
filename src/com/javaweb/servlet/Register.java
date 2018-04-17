package com.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.ParseException;
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
import com.tools.RequestTool;
import com.javaweb.domain.Institution;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register/*")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDAO=new TeacherDAOJdbcImpl();
    private StudentDAO studentDAO=new StudentDAOJdbcImpl();
    private InstitutionDAO institutionDAO =new InstitutionDAOJdbcImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
        Integer studentID=Integer.parseInt(request.getParameter("t_Student_ID"));
        Integer institutionID=Integer.parseInt(request.getParameter("t_Institution_ID"));
        Student student=studentDAO.getFromID(studentID);
        String username=student.getT_Student_User_Name(); 
        String password=student.getT_Student_User_Password();
        String realname=student.getT_Student_RealName();
        String phonenumber=student.getT_Student_Phone_Number();
        
        Map<String, Object>  map=new HashMap<String, Object>();
        	Teacher teacher=new Teacher();
        	teacher.setT_Teacher_User_Name(username);
        	teacher.setT_Teacher_User_PAssword(password);
        	teacher.setT_Teacher_Real_Name(realname);
        	teacher.setT_Teacher_Institution(institutionID);
        	teacher.setT_Teacher_Phone_Number(phonenumber);
        	try {
				teacherDAO.save(teacher);
				student.setT_Student_Authority(1);
				studentDAO.updatenew(student);
				String Institution_ApprovalWait=institutionDAO.getFromID(institutionID).getT_Institution_ApprovalWait();
				institutionDAO.getFromID(institutionID).setT_Institution_ApprovalWait(Institution_ApprovalWait+teacherDAO.getFromUseName(username).getT_Teacher_ID()+",");
				//add teacherID into institution's ApprovalWait
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
	
	private void TeacherUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, ParseException{
//		Integer id=Integer.parseInt(request.getParameter("id"));
//        String username=request.getParameter("username");  
//        String password=request.getParameter("password");
//        String realname=request.getParameter("realname");
//        Integer institutionID=Integer.parseInt(request.getParameter("institutionID"));
//        String phonenumber=request.getParameter("phonenumber");
//        String assessment=request.getParameter("assessment");
//        Integer approvalstatus=Integer.parseInt(request.getParameter("approvalstatus"));
        
        Map<String, Object>  map=new HashMap<String, Object>();
    	Teacher teacher=new Teacher();
    	RequestTool.getParameter(teacher, request);
//    	teacher.setT_Teacher_ID(id);
//    	teacher.setT_Teacher_User_Name(username);
//    	teacher.setT_Teacher_User_PAssword(password);
//    	teacher.setT_Teacher_Real_Name(realname);
//    	teacher.setT_Teacher_Institution(institutionID);
//    	teacher.setT_Teacher_Phone_Number(phonenumber);
//    	teacher.setT_Teacher_Assessment(assessment);
//    	teacher.setT_Teacher_ApprovalStatus(approvalstatus);
    	try {
			teacherDAO.updatenew(teacher);
			map.put("result", 1);
		} catch (Exception e) {
			map.put("result", 0);
			e.printStackTrace();
		}
    	
	}
	
	private void Student(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, ParseException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        String username=request.getParameter("t_Student_User_Name");
 //
//        String password=request.getParameter("password");
//        String realname=request.getParameter("realname");
//        String phonenumber=request.getParameter("phonenumber");
//        String email=request.getParameter("email");
        
        Map<String, Object>  map=new HashMap<String, Object>();
        if (IfNotExist(username)) {
        	Student student=new Student();
        	RequestTool.getParameter(student, request);
//        	student.setT_Sudent_User_Name(username);
//        	student.setT_Sudent_User_Password(password);
//        	student.setT_Sudent_Real_Name(realname);
//        	student.setT_Sudent_Phone_Number(phonenumber);
//        	student.setT_Student_Email(email);
        	try {
				studentDAO.save(student);
				map.put("result", 1);
			} catch (Exception e) {
				map.put("result", 0);
				e.printStackTrace();
			}
		}else{
			map.put("result", 0);
		}
            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void StudentUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, ParseException{
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
//		Integer id=Integer.parseInt(request.getParameter("id"));
//        String username=request.getParameter("username");  
//        String password=request.getParameter("password");
//        String realname=request.getParameter("realname");
//        String phonenumber=request.getParameter("phonenumber");
//        String assessment=request.getParameter("assessment");
//        String email=request.getParameter("email");
        
        Map<String, Object>  map=new HashMap<String, Object>();
    	Student student=new Student();
    	RequestTool.getParameter(student, request);
//    	student.setT_Sudent_ID(id);
//    	student.setT_Sudent_User_Name(username);
//    	student.setT_Sudent_User_Password(password);
//    	student.setT_Sudent_Real_Name(realname);
//    	student.setT_Sudent_Phone_Number(phonenumber);
//    	student.setT_Sudent_Assessment(assessment);
//    	student.setT_Student_Email(email);
    	
    	try {
			studentDAO.updatenew(student);
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
	
	private void Institution(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        Integer studentID=Integer.parseInt(request.getParameter("t_Student_ID"));
        String address=request.getParameter("t_Institution_Adress");
        Student student=studentDAO.getFromID(studentID);
        Map<String, Object>  map=new HashMap<String, Object>();
        	Institution institution=new Institution();
        	institution.setT_Institution_User_Name(student.getT_Student_User_Name());
        	institution.setT_Institution_User_Password(student.getT_Student_User_Password());
        	institution.setT_Institution_Phone(student.getT_Student_Phone_Number());
        	institution.setT_Institution_Real_Name(student.getT_Student_RealName());
        	institution.setT_Institution_Adress(address);
        	try {
        		student.setT_Student_Authority(2);
        		studentDAO.updatenew(student);
				institutionDAO.save(institution);
				map.put("result", 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("result", 0);
			}
            String jsonString=JSONSerializer.toJSON(map).toString();  
            writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}
	
	private void InstitutionUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, ParseException{
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
//		Integer id=Integer.parseInt(request.getParameter("id"));
//        String username=request.getParameter("username");  
//        String password=request.getParameter("password");
//        String realname=request.getParameter("realname");
//        String phonenumber=request.getParameter("phonenumber");
//        String address=request.getParameter("address");
//        String assessment=request.getParameter("assessment");
//        String approvalwait=request.getParameter("approvalwait");
        
        Map<String, Object>  map=new HashMap<String, Object>();
        
    	Institution institution=new Institution();
    	RequestTool.getParameter(institution, request);
//    	institution.setT_Institution_ID(id);
//    	institution.setT_Institution_User_Name(username);
//    	institution.setT_Institution_User_Password(password);
//    	institution.setT_Institution_Real_Name(realname);
//    	institution.setT_Institution_Phone(phonenumber);
//    	institution.setT_Institution_Adress(address);
//    	institution.setT_Institution_Assessment(assessment);
//    	institution.setT_Institution_ApprovalWait(approvalwait);
    	
    	try {
			institutionDAO.updatenew(institution);
			map.put("result", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("result", 0);
		}
        String jsonString=JSONSerializer.toJSON(map).toString();  
        writer.println(jsonString);  
   
    writer.flush();  
    writer.close();  
	}
	private boolean IfNotExist(String username){
		return studentDAO.getFromUseName(username)==null;
	}
}

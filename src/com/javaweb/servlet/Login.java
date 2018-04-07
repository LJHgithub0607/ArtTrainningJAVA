package com.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dao.InstitutionDAO;
import com.javaweb.dao.StudentDAO;
import com.javaweb.dao.TeacherDAO;
import com.javaweb.dao.impl.InstitutionDAOJdbcImpl;
import com.javaweb.dao.impl.StudentDAOJdbcImpl;
import com.javaweb.dao.impl.TeacherDAOJdbcImpl;
import com.javaweb.domain.Teacher;

import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login/*")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDAO=new TeacherDAOJdbcImpl();
    private StudentDAO studentDAO=new StudentDAOJdbcImpl();
    private InstitutionDAO institutionDAO =new InstitutionDAOJdbcImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName=request.getRequestURI();
		System.out.println(methodName);
		methodName=methodName.substring(15, methodName.length());  //different between each servlet     for example:/javaweb/Login/example
		System.out.println(methodName);
		try {
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void Check(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
        
        String username=request.getParameter("t_Student_User_Name");  
        String password=request.getParameter("t_Student_User_Password");

        Map<String, Object>  map=new HashMap<String, Object>();
        String result="";
        if (studentDAO.getFromUseName(username)!=null) {
        	result=password.equals(studentDAO.getFromUseName(username).getT_Student_User_Password())?"1":"0";
        }else{
        	result="2";
        }
        
        if (result.equals("1")) {
			map.put("studentID", studentDAO.getFromUseName(username).getT_Student_ID());
			Integer authority=studentDAO.getFromUseName(username).getT_Student_Authority();
			map.put("authority", authority);
			switch (authority) {
			case 1:
				map.put("teacherID", teacherDAO.getFromUseName(username).getT_Teacher_ID());
				break;
			case 2:
				map.put("institutionID", institutionDAO.getFromUserName(username).getT_Institution_ID());
			default:
				break;
			}
		}
        map.put("result", result);
        String jsonString=JSONSerializer.toJSON(map).toString();  
        writer.println(jsonString);  
       
        writer.flush();  
        writer.close();  
	}

}

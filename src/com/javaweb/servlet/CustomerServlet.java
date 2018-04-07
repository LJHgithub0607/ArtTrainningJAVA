package com.javaweb.servlet;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.javaweb.dao.CriteriaCustomer;
import com.javaweb.dao.CustomerDAO;
import com.javaweb.dao.impl.CustomerDAOJdbcImpl;
import com.javaweb.domain.Customer;
import com.tools.RequestTool;

@WebServlet("*.do")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO=new CustomerDAOJdbcImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName=request.getServletPath();
		System.out.println(methodName);
		methodName=methodName.substring(1, methodName.length()-3);
		try {
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void updatenew(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		Customer customer=new Customer();
		System.out.println(request.getParameter("id"));
		customer.setId(Integer.valueOf(request.getParameter("id")));
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		customer.setPhone(request.getParameter("phone"));
		customerDAO.updatenew(customer);
		response.sendRedirect("query.do");
	}

	private void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Customer customer=new Customer();
		System.out.println("start");
		RequestTool.getParameter(customer, request);
//		customer.setName(request.getParameter("name"));
//		customer.setAddress(request.getParameter("address"));
//		customer.setPhone(request.getParameter("phone"));
		customerDAO.save(customer);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	private void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Customer customer=new Customer();
		customer=customerDAO.get(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/updatenew.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id=0;
		try{
			id=Integer.valueOf(request.getParameter("id"));
		}catch (Exception e) {
			// TODO: handle exception
		}
		customerDAO.delete(id);
		response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		CriteriaCustomer cc=new CriteriaCustomer(name, address, phone);
		List<Customer> customers=customerDAO.getForListWithCriteriaCustomer(cc);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("add");
		
	}

}

package com.javaweb.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.javaweb.dao.CustomerDAO;
import com.javaweb.dao.impl.CustomerDAOJdbcImpl;
import com.javaweb.domain.Customer;

public class CustomerDAOJdbcImplTes {
	private CustomerDAO CustomerDAO=new CustomerDAOJdbcImpl();
	@Test
	public void testGetAll() {
		List<Customer> customer=CustomerDAO.getAll();
		System.out.println(customer);
	}

	@Test
	public void testSave() {
		Customer customer=new Customer();
		customer.setAddress("SHANGHAIS");
		customer.setName("JERRT");
		customer.setPhone("13786276401");
		CustomerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer cust= CustomerDAO.get(2);
		System.out.println(cust);
	}

	@Test
	public void testDelete() {
	    CustomerDAO.delete(1);
	}

	@Test
	public void testGetCountWithName() {
		fail("Not yet implemented");
	}

}

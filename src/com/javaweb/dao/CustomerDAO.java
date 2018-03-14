package com.javaweb.dao;

import java.util.List;

import com.javaweb.domain.Customer;

public interface CustomerDAO {
		public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
		public void updatenew(Customer customer);
		public List<Customer> getAll();
		public void save(Customer customer);
		public Customer get(Integer id);
		public Customer get(String name);
		public void delete(Integer id);
		public long getCountWithName(String name);
}	

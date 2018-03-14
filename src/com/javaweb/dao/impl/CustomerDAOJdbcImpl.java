package com.javaweb.dao.impl;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import com.javaweb.dao.CriteriaCustomer;
import com.javaweb.dao.CustomerDAO;
import com.javaweb.dao.DAO;
import com.javaweb.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO {

	@Override
	public List<Customer> getAll() {
		String sql="SELECT id,NAME,address,phone FROM customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql="INSERT INTO customers(name,address,phone) VALUES(?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		String sql="SELECT id,name,address,phone from customers where id=?";
		return get(sql, id);
	}
	public Customer get(String name){
		String sql="SELECT id,name,address,phone from customers where name=?";
		return get(sql, name);
	}

	@Override
	public void delete(Integer id) {
		String sql="DELETE FROM customers where id=?";
		update(sql, id);
		
	}

	@Override
	public long getCountWithName(String name) {
		String sql="SELECT COUNT(ID) FROM customers where name=?";
		return getForvalue(sql, name);
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		String sql="SELECT id,name,address,phone from customers where name like ? AND address like ? AND phone like ?";
		return getForList(sql, cc.getName(),cc.getAddress(),cc.getPhone());
	}

	@Override
	public void updatenew(Customer customer) {
		String sql="UPDATE customers SET Name = ?,address=?,phone=? WHERE id = ? ";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());		
	}

}

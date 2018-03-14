package com.javaweb.dao;

import java.awt.Window.Type;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.javaweb.db.JdbcUtils;

public class DAO<T> {
	/*
	 * 
	 * ·â×°INSERT¡¢DELETE¡¢UPDATE²Ù×÷
	 */
	private QueryRunner queryRunner =new QueryRunner();
	
	public <E> E  getForvalue(String sql,Object ...args){
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler<>(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.relaseConnection(connection);
		}
		return null;
	}
	private Class<T> clazz;
	public DAO(){
		java.lang.reflect.Type superClass=getClass().getGenericSuperclass();
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType=(ParameterizedType) superClass;
			java.lang.reflect.Type[] typeArgs=parameterizedType.getActualTypeArguments();
			if (typeArgs!=null&&typeArgs.length>0) {
				if (typeArgs[0] instanceof Class) {
					clazz=(Class<T>) typeArgs[0];
				}
			}
		}
	}
	public List<T> getForList(String sql,Object ...args){
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz),args);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			JdbcUtils.relaseConnection(connection);
		}
		return null;
	}
	public T get(String sql,Object ... args){
		
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz),args);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			JdbcUtils.relaseConnection(connection);
		}
		return null;
	}
	public void update(String sql,Object ... args){
		Connection connection=null;
		try {
			connection= JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.relaseConnection(connection);
		}
	}
	
}

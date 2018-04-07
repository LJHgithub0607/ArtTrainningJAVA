package com.javaweb.dao.impl;

import com.javaweb.dao.DAO;
import com.javaweb.dao.StudentDAO;
import com.javaweb.domain.Student;

public class StudentDAOJdbcImpl extends DAO<Student> implements StudentDAO{

	@Override
	public void updatenew(Student student) {
		String sql="update t_Student SET t_Student_User_Name=?,t_Student_User_Password=?,t_Student_Realname=?,t_Student_Phone_Number=?,t_Student_Assessment=?,t_Student_Email=?,t_Student_Authority=? WHERE t_Student_ID=?";
		update(sql, student.getT_Student_User_Name(),student.getT_Student_User_Password(),student.getT_Student_Real_Name(),student.getT_Student_Phone_Number(),student.getT_Student_Assessment(),student.getT_Student_Email(),student.getT_Student_Authority(),student.getT_Student_ID());
		
	}

	@Override
	public void save(Student student) {
		String sql="INSERT INTO t_Student(t_Student_User_Name,t_Student_User_Password,t_Student_Realname,t_Student_Phone_Number,t_Student_Assessment,t_Student_Email) VALUES(?,?,?,?,?,?)";
		update(sql, student.getT_Student_User_Name(),student.getT_Student_User_Password(),student.getT_Student_Real_Name(),student.getT_Student_Phone_Number(),student.getT_Student_Assessment(),student.getT_Student_Email());
	}

	@Override
	public void delete(Integer ID) {
		String sql="DELETE FROM t_Student WHERE t_Student_ID=?";
		update(sql, ID);
	}

	@Override
	public Student getFromID(Integer ID) {
		String sql="SELECT * FROM t_Student WHERE t_Student_ID=?";
		return get(sql, ID);
	}

	@Override
	public Student getFromUseName(String usename) {
		String sql="SELECT * FROM t_Student WHERE t_Student_User_Name=?";
		return get(sql, usename);
	}

	@Override
	public void updateAuthority(Integer authority,Integer ID) {
		String sql="update t_Student SET t_Student_Authority=? WHERE t_Student_ID=?";
		update(sql, authority,ID);
	}

	@Override
	public void updateAssessment(String assessment,Integer ID) {
		String sql="update t_Student SET t_Student_Assessment=? WHERE t_Student_ID=?";
		update(sql, assessment,ID);
		
	}
	

}

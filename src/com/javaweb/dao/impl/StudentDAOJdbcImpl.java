package com.javaweb.dao.impl;

import com.javaweb.dao.DAO;
import com.javaweb.dao.StudentDAO;
import com.javaweb.domain.Student;

public class StudentDAOJdbcImpl extends DAO<Student> implements StudentDAO{

	@Override
	public void updatenew(Student student) {
		String sql="update t_Student SET t_Sudent_User_Name=?,t_Sudent_User_Password=?,t_Sudent_Real_Name=?,t_Sudent_Phone_Number=?,t_Sudent_Assessment=?,t_Student_Email=?,t_Student_Authority=? WHERE t_Sudent_ID=?";
		update(sql, student.getT_Sudent_User_Name(),student.getT_Sudent_User_Password(),student.getT_Sudent_Real_Name(),student.getT_Sudent_Phone_Number(),student.getT_Sudent_Assessment(),student.getT_Student_Email(),student.getT_Student_Authority(),student.getT_Sudent_ID());
		
	}

	@Override
	public void save(Student student) {
		String sql="INSERT INTO t_Student(t_Sudent_User_Name,t_Sudent_User_Password,t_Sudent_Real_Name,t_Sudent_Phone_Number,t_Sudent_Assessment,t_Student_Email,t_Student_Authority),VALUES(?,?,?,?,?,?,?)";
		update(sql, student.getT_Sudent_User_Name(),student.getT_Sudent_User_Password(),student.getT_Sudent_Real_Name(),student.getT_Sudent_Phone_Number(),student.getT_Sudent_Assessment(),student.getT_Student_Email(),student.getT_Student_Authority());
	}

	@Override
	public void delete(Integer ID) {
		String sql="DELETE FROM t_Student WHERE t_Sudent_ID=?";
		update(sql, ID);
	}

	@Override
	public Student getFromID(Integer ID) {
		String sql="SELECT * FROM t_Student WHERE t_Sudent_ID=?";
		return get(sql, ID);
	}

	@Override
	public Student getFromUseName(String usename) {
		String sql="SELECT * FROM t_Student WHERE t_Sudent_User_Name=?";
		return get(sql, usename);
	}

	@Override
	public void updateAuthority(Integer authority,Integer ID) {
		String sql="update t_Student SET t_Student_Authority=? WHERE t_Sudent_ID=?";
		update(sql, authority,ID);
	}

	@Override
	public void updateAssessment(String assessment,Integer ID) {
		String sql="update t_Student SET t_Sudent_Assessment=? WHERE t_Sudent_ID=?";
		update(sql, assessment,ID);
		
	}
	

}

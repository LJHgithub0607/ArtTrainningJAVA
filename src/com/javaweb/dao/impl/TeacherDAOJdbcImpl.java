package com.javaweb.dao.impl;

import java.util.List;

import com.javaweb.dao.DAO;
import com.javaweb.dao.TeacherDAO;
import com.javaweb.domain.Teacher;

public class TeacherDAOJdbcImpl extends DAO<Teacher> implements TeacherDAO{

	@Override
	public void updatenew(Teacher teacher) {
		String sql="update t_Teacher SET t_Teacher_User_Name=?,t_Teacher_User_PAssword=?,t_Teacher_RealName=?,t_Teacher_Institution=?,"
				+ "t_Teacher_Phone_Number=?,t_Teacher_Assessment=?,t_Teacher_ApprovalStatus=? WHERE t_Teacher_ID=?";
		update(sql, teacher.getT_Teacher_User_Name(),teacher.getT_Teacher_User_PAssword(),teacher.getT_Teacher_Real_Name(),teacher.getT_Teacher_Institution(),teacher.getT_Teacher_Phone_Number(),teacher.getT_Teacher_Assessment(),teacher.getT_Teacher_ApprovalStatus(),teacher.getT_Teacher_ID());
	}

	@Override
	public void save(Teacher teacher) {
		String sql="INSERT INTO t_Teacher(t_Teacher_User_Name,t_Teacher_User_PAssword,t_Teacher_RealName,t_Teacher_Institution,"
				+ "t_Teacher_Phone_Number,t_Teacher_Assessment) VALUES(?,?,?,?,?,?)";
		update(sql, teacher.getT_Teacher_User_Name(),teacher.getT_Teacher_User_PAssword(),teacher.getT_Teacher_Real_Name(),teacher.getT_Teacher_Institution(),teacher.getT_Teacher_Phone_Number(),teacher.getT_Teacher_Assessment());
	}

	@Override
	public void delete(Integer ID) {
		String sql="DELETE FROM t_Teacher WHERE t_Teacher_ID=?";
		update(sql, ID);
		
	}

	@Override
	public Teacher getFromID(Integer ID) {
		String sql="SELECT * FROM t_Teacher WHERE t_Teacher_ID=?";
		return get(sql, ID);
	}

	@Override
	public Teacher getFromUseName(String UseName) {
		String sql="SELECT * FROM t_Teacher WHERE t_Teacher_User_Name=?";
		return get(sql, UseName);
	}

	@Override
	public List<Teacher> getFromInstitutionID(Integer InstitutionID) {
		String sql="SELECT * FROM t_Teacher WHERE t_Teacher_Institution=?";
		return getForList(sql,InstitutionID);
	}

	@Override
	public List<Teacher> getFromRealName(String realname) {
		String sql="SELECT * FROM t_Teacher WHERE t_Teacher_RealName=?";
		return getForList(sql, realname);
	}

}

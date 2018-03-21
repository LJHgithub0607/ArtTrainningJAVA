package com.javaweb.dao.impl;

import java.util.List;

import com.javaweb.dao.DAO;
import com.javaweb.dao.Total_CourseDAO;
import com.javaweb.domain.Total_Course;

public class Total_CourseDAOJdbcImpl extends DAO<Total_Course> implements Total_CourseDAO {

	@Override
	public void updatenew(Total_Course total_Course) {
		String sql="update t_Total_Course SET t_Course_Name=?,t_Course_Teacher_ID=?,t_Teacher_Students_ID=?,t_Course_Institution_ID=?,t_Course_Classrooms=?"
				+ "t_Course_Deadline_Date=?,t_Course_Start_Date=?,t_Course_Week_Day=?,t_Course_Day_Start_Time=?,t_Course_Day_End_Time=?,t_Course_Times=?"
				+ "t_Course_Max_Students=? WHERE t_Course_ID=?";
		update(sql, total_Course.getT_Course_Name(),total_Course.getT_Course_Teacher_ID(),total_Course.getT_Teacher_Students_ID(),total_Course.getT_Course_Institution_ID(),
				total_Course.getT_Course_Classrooms(),total_Course.getT_Course_Deadline_Date(),total_Course.getT_Course_Start_Date(),total_Course.getT_Course_Week_Day(),
				total_Course.getT_Course_Day_Start_Time(),total_Course.getT_Course_Day_End_Time(),total_Course.getT_Course_Times(),total_Course.getT_Course_Max_Students(),total_Course.getT_Course_ID());
		
	}

	@Override
	public void save(Total_Course total_Course) {
		String sql="INSERT INTO t_Total_Course(t_Course_Name,t_Course_Teacher_ID,t_Teacher_Students_ID,t_Course_Institution_ID,t_Course_Classrooms,t_Course_Deadline_Date"
				+ "t_Course_Start_Date,t_Course_Week_Day,t_Course_Day_Start_Time,t_Course_Day_End_Time,t_Course_Times,t_Course_Max_Students) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		update(sql, total_Course.getT_Course_Name(),total_Course.getT_Course_Teacher_ID(),total_Course.getT_Teacher_Students_ID(),total_Course.getT_Course_Institution_ID(),
				total_Course.getT_Course_Classrooms(),total_Course.getT_Course_Deadline_Date(),total_Course.getT_Course_Start_Date(),total_Course.getT_Course_Week_Day(),
				total_Course.getT_Course_Day_Start_Time(),total_Course.getT_Course_Day_End_Time(),total_Course.getT_Course_Times(),total_Course.getT_Course_Max_Students());
	}

	@Override
	public void delete(Integer ID) {
		String sql="DELETE FROM t_Total_Course WHERE t_Course_ID=?";
		update(sql, ID);
	}

	@Override
	public Total_Course getFromID(Integer ID) {
		String sql="SELECT * FROM t_Total_Course WHERE t_Course_ID=?";
		return get(sql, ID);
	}

	@Override
	public List<Total_Course> getFromTeacherID(Integer teacherID) {
		String sql="SELECT * FROM t_Total_Course WHERE t_Course_Teacher_ID=?";
		return getForList(sql, teacherID);
	}

	@Override
	public List<Total_Course> getFromInstitutionID(Integer InstitutionID) {
		String sql="SELECT * FROM t_Total_Course WHERE t_Course_Institution_ID=?";
		return getForList(sql, InstitutionID);
	}

}

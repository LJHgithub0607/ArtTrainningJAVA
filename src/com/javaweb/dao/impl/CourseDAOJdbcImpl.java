package com.javaweb.dao.impl;

import java.util.List;

import com.javaweb.dao.CourseDAO;
import com.javaweb.dao.DAO;
import com.javaweb.domain.Course;

public class CourseDAOJdbcImpl extends DAO<Course> implements CourseDAO {

	@Override
	public void updatenew(Course course) {
		String sql="update t_Course SET t_Course_theCourse_ID=?,t_Course_Student_ID=?,t_Course_Total_Time=?,t_Course_DateOfLeave=? WHERE t_Course_ID=?";
		update(sql, course.getT_Course_theCourse_ID(),course.getT_Course_Student_ID(),course.getT_Course_Total_Time(),course.getT_Course_DateOfLeave(),course.getT_Course_ID());
		
	}

	@Override
	public void save(Course course) {
		String sql="INSERT INTO t_Course(t_Course_theCourse_ID,t_Course_Student_ID,t_Course_Total_Time,t_Course_DateOfLeave) VALUES(?,?,?,?)";
		update(sql, course.getT_Course_theCourse_ID(),course.getT_Course_Student_ID(),course.getT_Course_Total_Time(),course.getT_Course_DateOfLeave());
	}

	@Override
	public void delete(Integer ID) {
		String sql="DELETE FROM t_Course WHERE t_Course_ID=?";
		update(sql, ID);
		
	}

	@Override
	public Course getFromID(Integer ID) {
		String sql="SELECT * FROM t_Course WHERE t_Course_ID=?";
		return get(sql, ID);
	}

	@Override
	public List<Course> getForListWithStudentID(Integer ID) {
		String sql="SELECT * FROM t_Course WHERE t_Course_Student_ID=?";
		return getForList(sql, ID);
	}

	@Override
	public Course getFromStudentIDAndTotalCourseID(Integer studentID, Integer totalcourseID) {
		String sql="SELECT * FROM t_Course WHERE t_Course_Student_ID=? AND t_Course_theCourse_ID=?";
		return get(sql, studentID,totalcourseID);
	}

	@Override
	public List<Course> getForListWithTotalCourseID(Integer ID) {
		String sql="SELECT * FROM t_Course WHERE t_Course_theCourse_ID=?";
		return getForList(sql, ID);
	}
	

}

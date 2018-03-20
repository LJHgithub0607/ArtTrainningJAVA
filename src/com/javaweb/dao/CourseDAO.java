package com.javaweb.dao;

import java.util.List;

import com.javaweb.domain.Course;

public interface CourseDAO {
	public void updatenew(Course course);
	public void save(Course course);
	public void delete(Course course);
	public Course getFromID(Integer ID);
	public Course getFromStudentID(Integer ID);
	public List<Course> getForListWithStudentID(Integer ID);
}

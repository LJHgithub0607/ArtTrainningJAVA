package com.javaweb.dao;

import java.util.List;

import com.javaweb.domain.Course;

public interface CourseDAO {
	public void updatenew(Course course);
	public void save(Course course);
	public void delete(Integer ID);
	public Course getFromID(Integer ID);
	public List<Course> getForListWithStudentID(Integer ID);
}

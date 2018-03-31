package com.javaweb.dao;

import java.util.List;

import com.javaweb.domain.Total_Course;

public interface Total_CourseDAO {
	public void updatenew(Total_Course total_Course);
	public void save(Total_Course total_Course);
	public void delete(Integer ID);
	public Integer getID(String name,Integer teacherID,Integer courseinstitutionID);
	public Total_Course getFromID(Integer ID);
	public List<Total_Course> getFromTeacherID(Integer teacherID);
	public List<Total_Course> getFromInstitutionID(Integer InstitutionID);
	public List<Total_Course> getForListWithCriteriaTotal_Course(CriteriaTotal_Course criteriaTotal_Course);
}
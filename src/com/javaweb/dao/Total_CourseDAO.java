package com.javaweb.dao;

import com.javaweb.domain.Total_Course;

public interface Total_CourseDAO {
	public void updatenew(Total_Course total_Course);
	public void save(Total_Course total_Course);
	public void delete(Total_Course total_Course);
	public Total_Course getFromID(Integer ID);
	public Total_Course getFromTeacherID(Integer teacherID);
	public Total_Course getFromInstitutionID(Integer InstitutionID);
}

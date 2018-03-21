package com.javaweb.dao;

import java.util.List;

import com.javaweb.domain.Teacher;

public interface TeacherDAO {
	public void updatenew(Teacher teacher);
	public void save(Teacher teacher);
	public void delete(Integer ID);
	public Teacher getFromID(Integer ID);
	public Teacher getFromUseName(String UseName);
	public List<Teacher> getFromInstitutionID(Integer InstitutionID);
}

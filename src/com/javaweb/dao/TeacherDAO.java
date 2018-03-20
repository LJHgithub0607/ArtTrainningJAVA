package com.javaweb.dao;

import com.javaweb.domain.Teacher;

public interface TeacherDAO {
	public void updatenew(Teacher teacher);
	public void save(Teacher teacher);
	public void delete(Teacher teacher);
	public Teacher getFromID(Integer ID);
	public Teacher getFromUseName(String UseName);
	public Teacher getFromInstitutionID(Integer InstitutionID);
}

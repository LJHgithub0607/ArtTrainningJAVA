package com.javaweb.dao;

import com.javaweb.domain.Student;

public interface StudentDAO {
	public void updatenew(Student student);
	public void save(Student student);
	public void delete(Student student);
	public Student getFromID(Integer ID);
	public Student getFromUseName(String UseName);
}

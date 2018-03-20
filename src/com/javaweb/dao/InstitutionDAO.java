package com.javaweb.dao;

import java.util.List;

import com.javaweb.domain.Institution;

public interface InstitutionDAO {
	public void updatenew(Institution institution);
	public void save(Institution institution);
	public void delete(Institution institution);
	public Institution getFromID(Integer ID);
}

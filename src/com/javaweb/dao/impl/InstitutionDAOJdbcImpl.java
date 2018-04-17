package com.javaweb.dao.impl;

import com.javaweb.dao.DAO;
import com.javaweb.dao.InstitutionDAO;
import com.javaweb.domain.Institution;

public class InstitutionDAOJdbcImpl extends DAO<Institution> implements InstitutionDAO {

	@Override
	public void updatenew(Institution institution) {
		String sql="UPDATE t_Institution SET t_Institution_User_Name=?,t_Institution_User_Password=?,t_Institution_Real_Name=?,t_Institution_Phone=?,"
				+ "t_Institution_Adress=?,t_Institution_Assessment=?,WHERE t_Institution_ID = ? ";
		update(sql,institution.getT_Institution_User_Name(),institution.getT_Institution_User_Password(),institution.getT_Institution_Real_Name(),institution.getT_Institution_Phone(),institution.getT_Institution_Adress(),institution.getT_Institution_Assessment(),institution.getT_Institution_ID() );		
		
	}

	@Override
	public void save(Institution institution) {
		String sql="INSERT INTO t_Institution(t_Institution_User_Name,t_Institution_User_Password,t_Institution_Real_Name,t_Institution_Phone,"
				+ "t_Institution_Adress,t_Institution_Assessment) VALUES(?,?,?,?,?,?)";
		update(sql,institution.getT_Institution_User_Name(),institution.getT_Institution_User_Password(),institution.getT_Institution_Real_Name(),institution.getT_Institution_Phone(),institution.getT_Institution_Adress(),institution.getT_Institution_Assessment());	
	}

	@Override
	public void delete(Integer ID) {
		String sql="DELETE FROM t_Institution WHERE t_Institution_ID=?";
		update(sql, ID);
	}

	@Override
	public Institution getFromID(Integer ID) {
		String sql="SELECT * FROM t_Institution WHERE t_Institution_ID = ? ";
		return get(sql, ID);
	}
	
	@Override
	public Institution getFromUserName(String username){
		String sql="SELECT * FROM t_Institution WHERE t_Institution_User_Name = ? ";
		return get(sql, username);
	}
}

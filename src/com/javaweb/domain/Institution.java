package com.javaweb.domain;

public class Institution {
	private Integer t_Institution_Id;
	private String t_Institution_User_Name;
	private String t_Institution_User_Password;
	private String t_Institution_Real_Name;
	private String t_Institution_Phone;
	private String t_Institution_Adress;
	private String t_Institution_Assessment;
	public Integer getT_Institution_Id() {
		return t_Institution_Id;
	}
	public void setT_Institution_Id(Integer t_Institution_Id) {
		this.t_Institution_Id = t_Institution_Id;
	}
	public String getT_Institution_User_Name() {
		return t_Institution_User_Name;
	}
	public void setT_Institution_User_Name(String t_Institution_User_Name) {
		this.t_Institution_User_Name = t_Institution_User_Name;
	}
	public String getT_Institution_User_Password() {
		return t_Institution_User_Password;
	}
	public void setT_Institution_User_Password(String t_Institution_User_Password) {
		this.t_Institution_User_Password = t_Institution_User_Password;
	}
	public String getT_Institution_Real_Name() {
		return t_Institution_Real_Name;
	}
	public void setT_Institution_Real_Name(String t_Institution_Real_Name) {
		this.t_Institution_Real_Name = t_Institution_Real_Name;
	}
	public String getT_Institution_Phone() {
		return t_Institution_Phone;
	}
	public void setT_Institution_Phone(String t_Institution_Phone) {
		this.t_Institution_Phone = t_Institution_Phone;
	}
	public String getT_Institution_Adress() {
		return t_Institution_Adress;
	}
	public void setT_Institution_Adress(String t_Institution_Adress) {
		this.t_Institution_Adress = t_Institution_Adress;
	}
	public String getT_Institution_Assessment() {
		return t_Institution_Assessment;
	}
	public void setT_Institution_Assessment(String t_Institution_Assessment) {
		this.t_Institution_Assessment = t_Institution_Assessment;
	}
	@Override
	public String toString() {
		return "Institution [t_Institution_Id=" + t_Institution_Id + ", t_Institution_User_Name="
				+ t_Institution_User_Name + ", t_Institution_User_Password=" + t_Institution_User_Password
				+ ", t_Institution_Real_Name=" + t_Institution_Real_Name + ", t_Institution_Phone="
				+ t_Institution_Phone + ", t_Institution_Adress=" + t_Institution_Adress + ", t_Institution_Assessment="
				+ t_Institution_Assessment + "]";
	}
	
	
}

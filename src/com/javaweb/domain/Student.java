package com.javaweb.domain;

public class Student {
	private Integer t_Sudent_ID;
	private String t_Sudent_User_Name;
	private String t_Sudent_User_Password;
	private String t_Sudent_Real_Name;
	private String t_Sudent_Phone_Number;
	private String t_Sudent_Assessment;
	private String t_Student_Email;
	private Integer t_Student_Authority;
	
	public Integer getT_Student_Authority() {
		return t_Student_Authority;
	}
	public void setT_Student_Authority(Integer t_Student_Authority) {
		this.t_Student_Authority = t_Student_Authority;
	}
	public Integer getT_Sudent_ID() {
		return t_Sudent_ID;
	}
	public String getT_Student_Email() {
		return t_Student_Email;
	}
	public void setT_Student_Email(String t_Student_Email) {
		this.t_Student_Email = t_Student_Email;
	}
	public void setT_Sudent_ID(Integer t_Sudent_ID) {
		this.t_Sudent_ID = t_Sudent_ID;
	}
	public String getT_Sudent_User_Name() {
		return t_Sudent_User_Name;
	}
	public void setT_Sudent_User_Name(String t_Sudent_User_Name) {
		this.t_Sudent_User_Name = t_Sudent_User_Name;
	}
	
	public String getT_Sudent_User_Password() {
		return t_Sudent_User_Password;
	}
	public void setT_Sudent_User_Password(String t_Sudent_User_Password) {
		this.t_Sudent_User_Password = t_Sudent_User_Password;
	}
	
	public String getT_Sudent_Real_Name() {
		return t_Sudent_Real_Name;
	}
	
	public void setT_Sudent_Real_Name(String t_Sudent_Real_Name) {
		this.t_Sudent_Real_Name = t_Sudent_Real_Name;
	}
	
	public String getT_Sudent_Phone_Number() {
		return t_Sudent_Phone_Number;
	}
	
	public void setT_Sudent_Phone_Number(String t_Sudent_Phone_Number) {
		this.t_Sudent_Phone_Number = t_Sudent_Phone_Number;
	}
	
	public String getT_Sudent_Assessment() {
		return t_Sudent_Assessment;
	}
	
	public void setT_Sudent_Assessment(String t_Sudent_Assessment) {
		this.t_Sudent_Assessment = t_Sudent_Assessment;
	}
	@Override
	public String toString() {
		return "Student [t_Sudent_ID=" + t_Sudent_ID + ", t_Sudent_User_Name=" + t_Sudent_User_Name
				+ ", t_Sudent_User_Password=" + t_Sudent_User_Password + ", t_Sudent_Real_Name=" + t_Sudent_Real_Name
				+ ", t_Sudent_Phone_Number=" + t_Sudent_Phone_Number + ", t_Sudent_Assessment=" + t_Sudent_Assessment
				+ ", t_Student_Email=" + t_Student_Email + ", t_Student_Authority=" + t_Student_Authority + "]";
	}
	
	

}

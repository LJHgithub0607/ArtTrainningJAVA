package com.javaweb.domain;

public class Teacher {
	private Integer t_Teacher_ID;
	private String t_Teacher_User_Name;
	private String t_Teacher_User_PAssword;
	private String t_Teacher_RealName;
	private Integer t_Teacher_Institution;
	private String t_Teacher_Phone_Number;
	private String t_Teacher_Assessment;
	private Integer t_Teacher_ApprovalStatus;
	public Integer getT_Teacher_ID() {
		return t_Teacher_ID;
	}
	public void setT_Teacher_ID(Integer t_Teacher_ID) {
		this.t_Teacher_ID = t_Teacher_ID;
	}
	public String getT_Teacher_User_Name() {
		return t_Teacher_User_Name;
	}
	public void setT_Teacher_User_Name(String t_Teacher_User_Name) {
		this.t_Teacher_User_Name = t_Teacher_User_Name;
	}
	public String getT_Teacher_User_PAssword() {
		return t_Teacher_User_PAssword;
	}
	public void setT_Teacher_User_PAssword(String t_Teacher_User_PAssword) {
		this.t_Teacher_User_PAssword = t_Teacher_User_PAssword;
	}
	public String getT_Teacher_Real_Name() {
		return t_Teacher_RealName;
	}
	public void setT_Teacher_Real_Name(String t_Teacher_Real_Name) {
		this.t_Teacher_RealName = t_Teacher_Real_Name;
	}
	public Integer getT_Teacher_Institution() {
		return t_Teacher_Institution;
	}
	public Integer getT_Teacher_ApprovalStatus() {
		return t_Teacher_ApprovalStatus;
	}
	public void setT_Teacher_ApprovalStatus(Integer t_Teacher_ApprovalStatus) {
		this.t_Teacher_ApprovalStatus = t_Teacher_ApprovalStatus;
	}
	public void setT_Teacher_Institution(Integer t_Teacher_Institution) {
		this.t_Teacher_Institution = t_Teacher_Institution;
	}
	public String getT_Teacher_Phone_Number() {
		return t_Teacher_Phone_Number;
	}
	public void setT_Teacher_Phone_Number(String t_Teacher_Phone_Number) {
		this.t_Teacher_Phone_Number = t_Teacher_Phone_Number;
	}
	public String getT_Teacher_Assessment() {
		return t_Teacher_Assessment;
	}
	public void setT_Teacher_Assessment(String t_Teacher_Assessment) {
		this.t_Teacher_Assessment = t_Teacher_Assessment;
	}
	@Override
	public String toString() {
		return "Teacher [t_Teacher_ID=" + t_Teacher_ID + ", t_Teacher_User_Name=" + t_Teacher_User_Name
				+ ", t_Teacher_User_PAssword=" + t_Teacher_User_PAssword + ", t_Teacher_Real_Name="
				+ t_Teacher_RealName + ", t_Teacher_Institution=" + t_Teacher_Institution + ", t_Teacher_Phone_Number="
				+ t_Teacher_Phone_Number + ", t_Teacher_Assessment=" + t_Teacher_Assessment
				+ ", t_Teacher_ApprovalStatus=" + t_Teacher_ApprovalStatus + "]";
	}
	
	
}

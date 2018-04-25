package com.javaweb.dao;

public class CriteriaTotal_Course {
	private String t_Course_Name;
	private String t_Course_Assessment;
	private Integer t_Course_Price;
	private String t_Course_Category;
	private Integer t_Course_Times;
	
	public String getT_Course_Name() {
		if (t_Course_Name=="") {
			t_Course_Name="%%";
		}else{
			t_Course_Name="%"+t_Course_Name+"%";
		}
		return t_Course_Name;
	}
	public void setT_Course_Name(String t_Course_Name) {
		this.t_Course_Name = t_Course_Name;
	}
	
	public String getT_Course_Assessment() {
		if (t_Course_Assessment=="") {
			t_Course_Assessment="%%";
		}
		return t_Course_Assessment;
	}
	public void setT_Course_Assessment(String t_Course_Assessment) {
		this.t_Course_Assessment = t_Course_Assessment;
	}
	
	public Integer getT_Course_Price() {		
		return t_Course_Price;
	}
	public void setT_Course_Price(Integer t_Course_Price) {
		this.t_Course_Price = t_Course_Price;
	}
	
	public String getT_Course_Category() {
		if (t_Course_Category=="") {
			t_Course_Category="%%";
		}
		return t_Course_Category;
	}
	public void setT_Course_Category(String t_Course_Category) {
		this.t_Course_Category = t_Course_Category;
	}
	
	public Integer getT_Course_Times() {
		return t_Course_Times;
	}
	public void setT_Course_Times(Integer t_Course_Times) {
		this.t_Course_Times = t_Course_Times;
	}
}

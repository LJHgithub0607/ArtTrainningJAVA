package com.javaweb.domain;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Json_Total_Course {
	private Integer t_Course_ID;
	private String t_Course_Name;
	private Integer t_Course_Teacher_ID;
	private String 	t_Teacher_Students_ID;//ID combination of all students participating in the course 
	                                      // example:t_Teacher_Students_ID="1,2,3,4,5" which means there are students"1","2","3","4","5" participating in the course
	private Integer t_Course_Institution_ID;
	private String 	t_Course_Classrooms;
	private java.util.Date t_Course_Deadline_Date;
	private java.util.Date t_Course_Start_Date;
	private Integer t_Course_Week_Day;
	private String t_Course_Day_Start_Time;
	private String t_Course_Day_End_Time;
	private Integer t_Course_Times;//this Course total Course Time of all students;
	private Integer t_Course_Max_Students;
	private Integer t_Course_Price;
	private String t_Course_Category;
	private String t_Course_Assessment;
	
	public Json_Total_Course(Total_Course total_Course){
		this.t_Course_ID=total_Course.getT_Course_ID();
		this.t_Course_Name=total_Course.getT_Course_Name();
		this.t_Course_Teacher_ID=total_Course.getT_Course_Teacher_ID();
		this.t_Teacher_Students_ID=total_Course.getT_Teacher_Students_ID();
		this.t_Course_Institution_ID=total_Course.getT_Course_Institution_ID();
		this.t_Course_Classrooms=total_Course.getT_Course_Classrooms();
		this.t_Course_Deadline_Date=new java.util.Date(total_Course.getT_Course_Deadline_Date().getTime());
		this.t_Course_Start_Date=new java.util.Date(total_Course.getT_Course_Start_Date().getTime());
		this.t_Course_Week_Day=total_Course.getT_Course_Week_Day();
		this.t_Course_Day_Start_Time=total_Course.getT_Course_Day_Start_Time().toString();
		this.t_Course_Day_End_Time=total_Course.getT_Course_Day_End_Time().toString();
		this.t_Course_Times=total_Course.getT_Course_Times();
		this.t_Course_Max_Students=total_Course.getT_Course_Max_Students();
	}
	
	public String DateCoverter(java.util.Date date)
	{
	   SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	   return bartDateFormat.format(date); 
	}
	
	public Integer getT_Course_ID() {
		return t_Course_ID;
	}
	public void setT_Course_ID(Integer t_Course_ID) {
		this.t_Course_ID = t_Course_ID;
	}
	public String getT_Course_Name() {
		return t_Course_Name;
	}
	public void setT_Course_Name(String t_Course_Name) {
		this.t_Course_Name = t_Course_Name;
	}
	public Integer getT_Course_Teacher_ID() {
		return t_Course_Teacher_ID;
	}
	public void setT_Course_Teacher_ID(Integer t_Course_Teacher_ID) {
		this.t_Course_Teacher_ID = t_Course_Teacher_ID;
	}
	public String getT_Teacher_Students_ID() {
		return t_Teacher_Students_ID;
	}
	public void setT_Teacher_Students_ID(String t_Teacher_Students_ID) {
		this.t_Teacher_Students_ID = t_Teacher_Students_ID;
	}
	public Integer getT_Course_Institution_ID() {
		return t_Course_Institution_ID;
	}
	public void setT_Course_Institution_ID(Integer t_Course_Institution_ID) {
		this.t_Course_Institution_ID = t_Course_Institution_ID;
	}
	public String getT_Course_Classrooms() {
		return t_Course_Classrooms;
	}
	public void setT_Course_Classrooms(String t_Course_Classrooms) {
		this.t_Course_Classrooms = t_Course_Classrooms;
	}
	public String getT_Course_Deadline_Date() {
		return DateCoverter(t_Course_Deadline_Date);
	}
	public void setT_Course_Deadline_Date(java.util.Date t_Course_Deadline_Date) {
		this.t_Course_Deadline_Date = t_Course_Deadline_Date;
	}
	public String getT_Course_Start_Date() {
		return DateCoverter(t_Course_Start_Date);
	}
	public void setT_Course_Start_Date(java.util.Date t_Course_Start_Date) {
		this.t_Course_Start_Date = t_Course_Start_Date;
	}
	public Integer getT_Course_Week_Day() {
		return t_Course_Week_Day;
	}
	public void setT_Course_Week_Day(Integer t_Course_Week_Day) {
		this.t_Course_Week_Day = t_Course_Week_Day;
	}
	public String getT_Course_Day_Start_Time() {
		return t_Course_Day_Start_Time;
	}
	public void setT_Course_Day_Start_Time(String t_Course_Day_Start_Time) {
		this.t_Course_Day_Start_Time = t_Course_Day_Start_Time;
	}
	public String getT_Course_Day_End_Time() {
		return t_Course_Day_End_Time;
	}
	public void setT_Course_Day_End_Time(String t_Course_Day_End_Time) {
		this.t_Course_Day_End_Time = t_Course_Day_End_Time;
	}
	public Integer getT_Course_Times() {
		return t_Course_Times;
	}
	public void setT_Course_Times(Integer t_Course_Times) {
		this.t_Course_Times = t_Course_Times;
	}
	public Integer getT_Course_Max_Students() {
		return t_Course_Max_Students;
	}
	public void setT_Course_Max_Students(Integer t_Course_Max_Students) {
		this.t_Course_Max_Students = t_Course_Max_Students;
	}
	public Integer getT_Course_Price() {
		return t_Course_Price;
	}
	public void setT_Course_Price(Integer t_Course_Price) {
		this.t_Course_Price = t_Course_Price;
	}
	public String getT_Course_Category() {
		return t_Course_Category;
	}
	public void setT_Course_Category(String t_Course_Category) {
		this.t_Course_Category = t_Course_Category;
	}
	public String getT_Course_Assessment() {
		return t_Course_Assessment;
	}
	public void setT_Course_Assessment(String t_Course_Assessment) {
		this.t_Course_Assessment = t_Course_Assessment;
	}
}

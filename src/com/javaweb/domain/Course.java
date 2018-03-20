package com.javaweb.domain;

public class Course {
	private Integer t_Course_ID;
	private Integer t_Course_theCourse_ID;
	private Integer t_Couser_Student_ID;
	private Integer t_Course_Total_Time;
	public Integer getT_Course_ID() {
		return t_Course_ID;
	}
	public void setT_Course_ID(Integer t_Course_ID) {
		this.t_Course_ID = t_Course_ID;
	}
	public Integer getT_Course_theCourse_ID() {
		return t_Course_theCourse_ID;
	}
	public void setT_Course_theCourse_ID(Integer t_Course_theCourse_ID) {
		this.t_Course_theCourse_ID = t_Course_theCourse_ID;
	}
	public Integer getT_Couser_Student_ID() {
		return t_Couser_Student_ID;
	}
	public void setT_Couser_Student_ID(Integer t_Couser_Student_ID) {
		this.t_Couser_Student_ID = t_Couser_Student_ID;
	}
	public Integer getT_Course_Total_Time() {
		return t_Course_Total_Time;
	}
	public void setT_Course_Total_Time(Integer t_Course_Total_Time) {
		this.t_Course_Total_Time = t_Course_Total_Time;
	}
	@Override
	public String toString() {
		return "Course [t_Course_ID=" + t_Course_ID + ", t_Course_theCourse_ID=" + t_Course_theCourse_ID
				+ ", t_Couser_Student_ID=" + t_Couser_Student_ID + ", t_Course_Total_Time=" + t_Course_Total_Time + "]";
	}
	
}

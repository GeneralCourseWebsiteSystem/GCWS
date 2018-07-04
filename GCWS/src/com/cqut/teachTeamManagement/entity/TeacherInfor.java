package com.cqut.teachTeamManagement.entity;


/**
 * 教师信息
 * @author 刘华
 *
 */
public class TeacherInfor {
	private String teacherName;
	
	private String teacherIntroduce;
	
	private String teacherAchievement;
	
	private String teacherPhone;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherIntroduce() {
		return teacherIntroduce;
	}

	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}

	public String getTeacherAchievement() {
		return teacherAchievement;
	}

	public void setTeacherAchievement(String teacherAchievement) {
		this.teacherAchievement = teacherAchievement;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public TeacherInfor() {
		super();
	}

	public TeacherInfor(String teacherName, String teacherIntroduce, String teacherAchievement, String teacherPhone) {
		super();
		this.teacherName = teacherName;
		this.teacherIntroduce = teacherIntroduce;
		this.teacherAchievement = teacherAchievement;
		this.teacherPhone = teacherPhone;
	}
}

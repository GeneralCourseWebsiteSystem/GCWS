package com.cqut.teachTeamManagement.entity;

public class Teacher {

	private Integer id;
	
	private String teacherIntroduce;
	
	private String useranme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeacherIntroduce() {
		return teacherIntroduce;
	}

	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}

	public String getUseranme() {
		return useranme;
	}

	public void setUseranme(String useranme) {
		this.useranme = useranme;
	}

	public Teacher(Integer id, String teacherIntroduce, String useranme) {
		super();
		this.id = id;
		this.teacherIntroduce = teacherIntroduce;
		this.useranme = useranme;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

}

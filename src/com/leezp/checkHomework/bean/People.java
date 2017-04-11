package com.leezp.checkHomework.bean;

public class People {

	//用于存储实验名
	public static String testName;
	//用于存储实验作业的存储路径
	public static String path;
	//用于存储实验未交人员的名单路径ַ
	public static String savePath;
	//学生学号
	private String personId;
	//学生姓名
	private String personName;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return testName+"_"+personId+"_"+personName;
	}
	
}

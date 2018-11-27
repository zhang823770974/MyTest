package com.model;

public class User {
	private int id;
	private String userName;
	private String userPwd;
	private String userAge;
	private String userSexy;
	private String fileName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserSexy() {
		return userSexy;
	}
	public void setUserSexy(String userSexy) {
		this.userSexy = userSexy;
	}
	public String getFileName() {
		return fileName;
	}
	public String setFileName(String fileName) {
		return this.fileName = fileName;
	}
	public User(int id, String userName, String userPwd, String userAge,
			String userSexy, String fileName) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAge = userAge;
		this.userSexy = userSexy;
		this.fileName = fileName;
	}
	public User(String userName, String userPwd, String userAge,
			String userSexy, String fileName) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAge = userAge;
		this.userSexy = userSexy;
		this.fileName = fileName;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPwd="
				+ userPwd + ", userAge=" + userAge + ", userSexy=" + userSexy
				+ ", fileName=" + fileName + "]";
	}

}

package com.rs.fer.bean;

public class User {
	
	private int id;
	private String FirstName;
	private String MiddleName;
	private String lastName;
	private String UserName;
	private String Password;
	private String MobileNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", FirstName=" + FirstName + ", MiddleName=" + MiddleName + ", lastName=" + lastName
				+ ", UserName=" + UserName + ", MobileNo=" + MobileNo + "]";
	}
	
}

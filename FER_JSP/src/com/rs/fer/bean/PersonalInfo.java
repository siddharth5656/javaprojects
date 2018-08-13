package com.rs.fer.bean;

public class PersonalInfo {
	private Address Address;
	private User User;

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	@Override
	public String toString() {
		return "PersonalInfo [Address=" + Address + ", User=" + User + "]";
	}

}

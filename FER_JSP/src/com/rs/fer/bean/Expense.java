package com.rs.fer.bean;

public class Expense {

	private int id;
	private String ExpenseType;
	private String Date;
	private String Pricee;
	private String noOfItems;
	private String totalAccount;
	private String byWhom;
	private int userid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpenseType() {
		return ExpenseType;
	}

	public void setExpenseType(String expenseType) {
		ExpenseType = expenseType;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getPricee() {
		return Pricee;
	}

	public void setPricee(String pricee) {
		Pricee = pricee;
	}

	public String getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(String noOfItems) {
		this.noOfItems = noOfItems;
	}

	public String getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(String totalAccount) {
		this.totalAccount = totalAccount;
	}

	public String getByWhom() {
		return byWhom;
	}

	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", ExpenseType=" + ExpenseType + ", Date=" + Date + ", Pricee=" + Pricee
				+ ", noOfItems=" + noOfItems + ", totalAccount=" + totalAccount + ", byWhom=" + byWhom + ", userid="
				+ userid + "]";
	}

}

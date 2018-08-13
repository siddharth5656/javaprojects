package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Address;
import com.concretepage.entity.Expense;
import com.concretepage.entity.PersonalInfo;
import com.concretepage.entity.User;


public interface FERDAO {
	boolean registration(User user);

	int login(String username, String password);

	boolean addExpense(Expense expense);

	boolean editExpense(Expense expense);

	boolean resetPassword(int id, String oldPassword, String newPassword);

	boolean deleteExpense(int id);

	Expense getExpense(int id);

	List<Expense> getExpenseReport(String type, String fromDate, String toDate);

	List<Expense> getExpenses();
	
	List<User> getUsers();

	boolean updatePersonalInfo(User user, Address address);

	PersonalInfo getPersonalInfo(String userName);

	//boolean isUsernameAvailable(String username);

	 boolean isUserNameIsAvailable(String username);

	
}

package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.FERDAO;
import com.concretepage.entity.Address;
import com.concretepage.entity.Expense;
import com.concretepage.entity.PersonalInfo;
import com.concretepage.entity.User;

@Service
public class FERServiceImpl implements FERService	{
	
	@Autowired
	FERDAO ferDAO;

	@Override
	public int registration(User user) {
		int numOfRecInserted = 0;
		if(ferDAO.isUserNameIsAvailable(user.getUserName())){
			if(ferDAO.registration(user)){
				numOfRecInserted =1;
			}
		}else{
			numOfRecInserted = -1;
		} 
		return numOfRecInserted;
	}

	@Override
	public int login(String username, String password) {
		return ferDAO.login(username, password);
	}

	@Override
	public boolean addExpense(Expense expense) {
		return ferDAO.addExpense(expense);
	}

	@Override
	public boolean editExpense(Expense expense) {
		return ferDAO.editExpense(expense);
	}

	@Override
	public boolean resetPassword(int id, String oldPassword, String newPassword) {
		return ferDAO.resetPassword(id, oldPassword, newPassword);
	}

	@Override
	public boolean deleteExpense(int id) {
		return ferDAO.deleteExpense(id);
	}

	@Override
	public Expense getExpense(int id) {
		return ferDAO.getExpense(id);
	}

	@Override
	public List<Expense> getExpenseReport(String type, String fromDate, String toDate) {
		return ferDAO.getExpenseReport(type, fromDate, toDate);
	}

	@Override
	public List<Expense> getExpenses() {
		return ferDAO.getExpenses();
	}
	
	@Override
	public List<User> getUsers() {
		return ferDAO.getUsers();
	}

	@Override
	public boolean updatePersonalInfo(User user, Address address) {
		return ferDAO.updatePersonalInfo(user, address);
	}

	@Override
	public PersonalInfo getPersonalInfo(String userName) {
		return ferDAO.getPersonalInfo(userName);
	}

	

}

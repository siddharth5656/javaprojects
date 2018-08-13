package com.hlv.dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.hlv.bean.Employee;
import com.hlv.entity.Users;

public interface UserDAO extends GenericDAO<Users, Long> {

	public void addUser(Users p);

	public List<Users> listUsers();

	public void removeUsers(int id);

	public void addUsers(Users p);

	public void saveUsers(Users users);

	public void editsaveUsers(int id);

	public void editUsers(Users users);

	public Users getUsers(int id);

	public List<Users> getpagination(int id);
	
	public void savepagination(Users users);

	public Users Search(int id);

}
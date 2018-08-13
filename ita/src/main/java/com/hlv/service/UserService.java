package com.hlv.service;

import java.util.Date;
import java.util.List;

import com.hlv.bean.Employee;
import com.hlv.bean.UsersBean;
import com.hlv.entity.Users;

public interface UserService {

	public Users getUserByUsername(String username);

	public Users findId(Long id);

	public void updateUser(Users p, String username, Date date);

	public UsersBean findUsers(UsersBean bean);

	public List<Users> listUsers();

	public void addListUser(List<Users> lstUser);

	public void removeUsers(int id);

	public void saveUsers(Users users);

	public void addUsers(Users p);

	public void editsaveUsers(int id);

	public Users getUsers(int id);

	public void editUsers(Users users);
	
	public List<Users> getpagination(int id);

	public void savepagination(Users users);
	public Users Search(int id);


}
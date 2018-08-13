package com.hlv.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchResult;
import com.hlv.bean.Employee;
import com.hlv.bean.UsersBean;
import com.hlv.dao.UserDAO;
import com.hlv.entity.Users;
import com.hlv.service.UserService;

@Service("UserService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	// @Transactional
	public Users getUserByUsername(String username) {
		Search search = new Search(Users.class);
		search.addFilterEqual("username", username);
		List<Users> result = userDAO.search(search);
		if (result.size() > 0)
			return result.get(0);
		return null;
	}

	@Override
	// @Transactional
	public Users findId(Long id) {
		return userDAO.find(id);
	}

	@Override
	// @Transactional
	public UsersBean findUsers(UsersBean bean) {
		// return userDAO.findUsers(p);
		Users user = bean.getEntity();
		Search search = new Search(Users.class);
		if (user != null) {
			// search.addFilterILike("username", p.getUsername());
			Filter filter1 = Filter.ilike("username",
					"%" + (user.getUsername() == null ? "" : user.getUsername()) + "%");
			search.addFilters(filter1);
			/*
			 * if (user.getUsername().isEmpty() || user.getFullname().isEmpty())
			 * { search.addFilters(filter1,filter2); } else {
			 * search.addFilterOr(filter1,filter2); }
			 */
		} else {
			search.addFilterILike("username", "%%");
		}

		search.addSort("id", true);
		search.setMaxResults(bean.getLimit());
		search.setPage(bean.getPage() - 1);
		// search.setPage(bean.getPage());
		SearchResult<Users> searchResult = userDAO.searchAndCount(search);

		bean.setListResult(searchResult.getResult());
		// bean.setPage(bean.getPage()-1);
		// bean.setPage(bean.getPage());
		bean.setTotal(searchResult.getTotalCount());

		// List<Users> result = userDAO.search(search);
		// List<Users> result = userDAO.searchAndCount(search);
		return bean;
	}
	@Override
	public void updateUser(Users p, String username, Date date) {

	}


	@Override
	@Transactional
	public List<Users> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public void addListUser(List<Users> lstUsers) {
		for (Users _us : lstUsers) {
			this.userDAO.addUser(_us);
		}
	}

	@Override
	@Transactional
	public void removeUsers(int id) {
		this.userDAO.removeUsers(id);
	}

	@Transactional
	public void addUsers(Users p) {
		this.userDAO.addUsers(p);
	}

	
	@Override
	@Transactional
	public void saveUsers(Users users) {
		this.userDAO.saveUsers(users);
	}

	@Override
	@Transactional
	public void editUsers(Users users) {
		this.userDAO.editUsers(users);
		
	}
	@Override
	@Transactional
	public Users getUsers(int id) {
		return userDAO.getUsers(id);
	}
	
	@Override
	@Transactional
	public void editsaveUsers(int id) {
		this.userDAO.editsaveUsers(id);
		
	}
	
	@Override
	@Transactional
	public Users Search(int id) {
		return userDAO.Search(id);
		
	}

	@Override
	public List<Users> getpagination(int id) {
		
		return this.userDAO.getpagination(id);
	}

	@Override
	@Transactional
	public void savepagination(Users users) {
		this. userDAO.savepagination(users);
	}




}

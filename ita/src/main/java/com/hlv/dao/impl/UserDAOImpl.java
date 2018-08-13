package com.hlv.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.hlv.bean.Employee;
import com.hlv.dao.UserDAO;
import com.hlv.entity.Users;

@Repository
public class UserDAOImpl extends GenericDAOImpl<Users, Long> implements UserDAO {

	// private static final Logger logger =
	// LoggerFactory.getLogger(UserDAOImpl.class);

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * @Autowired public void setSessionFactory(SessionFactory sf){
	 * this.sessionFactory = sf; }
	 * 
	 */
	/*@Autowired
	@Qualifier("mySessionFactory")
	private SessionFactory sessionFactory;*/
private SessionFactory sessionFactory;


	@Override
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	 

	@Override
	public void addUser(Users p) {
		// Session session = this.getSessionFactory().getCurrentSession();
		// session.persist(p);
		// has not solution for 2 case in here ????????????????
		// this.save(p); //should not use save in insert, so if exists id then
		// insert become update
		this._persist(p); // if use _persist: when create new user and has roles
							// then error, so at that time id null and can not
							// reference in user_role table
		// logger.info("Users saved successfully, Users Details="+p);
	}

	@Override
	public Users find(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users[] find(Long... arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getReference(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users[] getReferences(Long... arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeByIds(Long... arg0) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> listUsers() {
		Session session = this.getSessionFactory().getCurrentSession();

		// Criteria criteria=createEntityCriteria().addOrder(Order.asc("id"));
		// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Users> users = session.createQuery("from Users order by id asc").list();
		return users;
	}

	private Criteria createEntityCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUsers(int id) {
		Session session = this.getSessionFactory().getCurrentSession();
		Users users = (Users) session.get(Users.class, id);
		session.delete(users);
	}

	@Override
	public void addUsers(Users p) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.persist(p);
	}

	@Override
	public void saveUsers(Users users) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.persist(users);
		// this._persist(users);
		// this.save(p);
		// this._update(p); // should not use save in update, so if not exists
		// id
		// then update become to insert
		// logger.info("Users updated successfully, Users Details="+p);
	}

	@Override
	public void editUsers(Users users) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(users);

	}

	@Override
	public Users getUsers(int id) {
		return (Users) getSessionFactory().getCurrentSession().get(Users.class, id);
	}

	@Override
	public void editsaveUsers(int id) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(id);

	}

	@Override

	public List<Users> getpagination(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession().createQuery("from users order by id asc").list();
		return listUsers();

	}

	@Override
	public void savepagination(Users users) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(users);
	}

	@Override
	public Users Search(int id) {
		return (Users) this.getSessionFactory().getCurrentSession().get(Users.class, id);

	}

}

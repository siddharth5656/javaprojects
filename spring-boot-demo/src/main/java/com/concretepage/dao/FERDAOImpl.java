package com.concretepage.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.boot.context.embedded.MimeMappings.Mapping;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.Address;
import com.concretepage.entity.Expense;
import com.concretepage.entity.PersonalInfo;
import com.concretepage.entity.User;

@Repository
public class FERDAOImpl implements FERDAO {
	@PersistenceContext

	private EntityManager entityManager;

	@Override
	@Transactional
	public boolean registration(User user) {
		try {
			entityManager.persist(user);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public int login(String username, String password) {
		String hql = "from User u where user_name=? and password=?";
		int count = entityManager.createQuery(hql).setParameter(1, username).setParameter(2, password).getResultList()
				.size();
		return count;

	}

	@Override
	@Transactional
	public boolean addExpense(Expense expense) {
		try {
			entityManager.persist(expense);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean editExpense(Expense expense) {
		try {
			String hql = "update Expense set type=?,date=?,price=?,noofitems=?,total=?,byWhom=? where id=?";
			Query query = entityManager.createQuery(hql);
            query.setParameter(1,expense.getType());
            query.setParameter(2,expense.getDate());
            query.setParameter(3,expense.getPrice());
            query.setParameter(4,expense.getNoofitems());
            query.setParameter(5,expense.getTotal());
            query.setParameter(6,expense.getByWhom());
            query.setParameter(7,expense.getId());

            int editCount=0;
            
            try{
            	editCount = query.executeUpdate();
            	
            }catch(Exception ex){
            	ex.printStackTrace();
            }
            
			return editCount > 0;
			

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	@Transactional
	public boolean resetPassword(int id, String oldPassword, String newPassword) {
		try {
			String hql = "update User u set u.password='"+newPassword+"' where u.id='"+id+"' and u.password='"+oldPassword+"'";
			Query query = entityManager.createQuery(hql);
		/*	query.setParameter(1, newPassword);
			query.setParameter(2, id);
			query.setParameter(3, oldPassword);
*/
			return query.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteExpense(int id) {

		try {
			return entityManager.createQuery("delete from Expense e where e.id=" + id).executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Expense getExpense(int id) {
		Expense expense = null;
		try {
			String hql = "from Expense e where e.id="+id;

			Query query = entityManager.createQuery(hql);

			expense = (Expense) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return expense;
	}

	@Override
	public List<Expense> getExpenseReport(String type, String fromDate, String toDate) {
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			Query query = entityManager.createQuery("from Expense e where e.type='" + type + "'and e.date between '"
					+ fromDate + "'and '" + toDate + "'");
		/*	query.setParameter(0, type);
			query.setParameter(1, fromDate);
			query.setParameter(2, toDate);*/
			
			expenses = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return expenses;

	}

	@Override
	public List<Expense> getExpenses() {
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			expenses = entityManager.createQuery(" from Expense e").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return expenses;
	}

	
	@Override
	public List<User> getUsers() {

         List<User> users = new ArrayList<User>();
         try{
        	 users = entityManager.createQuery("from User u").getResultList();
         }catch(Exception e){
        	 e.printStackTrace();
         }
		
		return users;
	}
	
	@Override
	@Transactional
	public boolean updatePersonalInfo(User user, Address address) {
		boolean isUpdatedFlag = false;
		try {
			/*session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			user.setAddress(address);
			session.update(user);
			tr.commit();*/

			isUpdatedFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isUpdatedFlag;
	}

	public PersonalInfo getPersonalInfo(String userName) {

		PersonalInfo personalInfo = null;
		try {
			Query query = entityManager.createQuery("select u from User u where u.userName='" + userName + "'");
			User user = (User) query.getSingleResult();
			personalInfo = new PersonalInfo();
			personalInfo.setUser(user);
			personalInfo.setAddress((user.getAddress() == null) ? new Address() : user.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return personalInfo;
	}

	
	
	@Override
	public boolean isUserNameIsAvailable(String username) {
		String hql = "from User u where user_name=?";
		
int count = entityManager.createQuery(hql).setParameter(1, username).getResultList().size();
		return count == 0;
	}

	

	
}
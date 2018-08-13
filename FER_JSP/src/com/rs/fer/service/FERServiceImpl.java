package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {

	// static Logger log = Logger.getLogger(FERServiceImpl.class.getName());

	@Override
	public boolean registration(User user) {
		boolean isRegister = false;
		Connection connection = null;
		PreparedStatement preparestatement = null;
		// log.info("user:" + user);
		try {
			connection = DBUtil.getconnection();

			String query = "INSERT INTO user(firstName,middleName,lastName,username,password,mobileNo) VALUE (?,?,?,?,?,?)";
			preparestatement = connection.prepareStatement(query);

			System.out.println("Inserting records into the table...");

			preparestatement.setString(1, user.getFirstName());
			preparestatement.setString(2, user.getMiddleName());
			preparestatement.setString(3, user.getLastName());
			preparestatement.setString(4, user.getUserName());
			preparestatement.setString(5, user.getPassword());
			preparestatement.setString(6, user.getMobileNo());

			int totalnumber = preparestatement.executeUpdate();

			isRegister = totalnumber > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);

		}
		// log.info("isRegister:" + isRegister);
		return isRegister;

	}

	@Override
	public boolean login(String username, String Password) {
		boolean isValidUser = false;
		Connection connection = null;
		PreparedStatement preparestatement = null;
		// log.info("login:" + username);

		try {
			connection = DBUtil.getconnection();

			String query = "select * from user where UserName=? and Password=?";
			preparestatement = connection.prepareStatement(query);
			preparestatement.setString(1, username);
			preparestatement.setString(2, Password);

			ResultSet set = preparestatement.executeQuery();
			while (set.next()) {
				isValidUser = true;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		// log.info("isValidUser:" + isValidUser);
		return isValidUser;

	}

	@Override
	public boolean addExpense(Expense expense) {

		Connection connection = null;
		PreparedStatement preparestatement = null;
		boolean isAddExpns = false;
		// log.info("expense:" + expense);
		try {
			connection = DBUtil.getconnection();

			String queryExpense = "INSERT INTO expense(ExpenseType,date,price,NoOfItems,TotalAccount,ByWhom) VALUE (?,?,?,?,?,?)";
			preparestatement = connection.prepareStatement(queryExpense);
			// System.out.println("Inserting records into the table...");

			preparestatement.setString(1, expense.getExpenseType());
			preparestatement.setString(2, expense.getDate());
			preparestatement.setString(3, expense.getPricee());
			preparestatement.setString(4, expense.getNoOfItems());
			preparestatement.setString(5, expense.getTotalAccount());
			preparestatement.setString(6, expense.getByWhom());
			// preparestatement.setInt(7, expense.getUserid());

			int totalnumber = preparestatement.executeUpdate();

			isAddExpns = totalnumber > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + isAddExpns);
		} finally {
			DBUtil.closeConnection(connection);

		}
		// log.info("isAdd:" + isAddExpns);
		return isAddExpns;

	}

	@Override
	public boolean editExpense(Expense expense) {

		Connection connection = null;
		PreparedStatement preparestatement = null;
		boolean isEditExpen = false;
		// log.info("editExpense:" + isEditExpen);

		try {
			connection = DBUtil.getconnection();

			String queryEdit = "UPDATE expense SET ExpenseType=?,Date=?,Price=?,noOfItems=?,TotalAccount=?, ByWhom=? where id=? ";
			preparestatement = connection.prepareStatement(queryEdit);
			System.out.println("Updating records into the table...");

			preparestatement.setString(1, expense.getExpenseType());
			preparestatement.setString(2, expense.getDate());
			preparestatement.setString(3, expense.getPricee());
			preparestatement.setString(4, expense.getNoOfItems());
			preparestatement.setString(5, expense.getTotalAccount());
			preparestatement.setString(6, expense.getByWhom());
			preparestatement.setInt(7, expense.getId());

			int totalnumber = preparestatement.executeUpdate();

			isEditExpen = totalnumber > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + isEditExpen);
		} finally {
			DBUtil.closeConnection(connection);

		}
		// log.info("editExpense:" + isEditExpen);
		return isEditExpen;

	}

	@Override
	public boolean deleteExpense(int id) {

		Connection connection = null;
		PreparedStatement preparestatement = null;
		boolean isDeleteExpen = false;
		// log.info("deleteExpense:" + isDeleteExpen);

		try {
			connection = DBUtil.getconnection();

			String query = "DELETE FROM expense where id=?";
			preparestatement = connection.prepareStatement(query);
			System.out.println("Deleting records from the table...");

			preparestatement.setInt(1, id);
			int number = preparestatement.executeUpdate();

			isDeleteExpen = number > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + isDeleteExpen);
		} finally {
			DBUtil.closeConnection(connection);

		}
		// log.info("DeleteExpense:" + isDeleteExpen);
		return isDeleteExpen;
	}

	@Override
	public List<Expense> getExpenses(int userId) {
		Connection connection = null;
		PreparedStatement preparestatement = null;
		List<Expense> expenses = new ArrayList<Expense>(1);
		// log.info("getExpenses:" + expenses);
		try {
			connection = DBUtil.getconnection();

			String query = "select * from expense where userId=?";
			preparestatement = connection.prepareStatement(query);

			preparestatement.setInt(1, userId);
			ResultSet set = preparestatement.executeQuery();

			Expense expense = null;

			while (set.next()) {
				expense = new Expense();

				expense.setExpenseType(set.getString("expenseType"));
				expense.setDate(set.getString("date"));
				expense.setPricee(set.getString("price"));
				expense.setNoOfItems(set.getString("NoOfItems"));
				expense.setTotalAccount(set.getString("totalAccount"));
				expense.setByWhom(set.getString("byWhom"));
				expense.setUserid(set.getInt("userId"));
				expense.setId(set.getInt("id"));

				expenses.add(expense);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + expenses);
		} finally {
			DBUtil.closeConnection(connection);

		}
		// log.info("getExpenses:" + expenses);
		return expenses;

	}

	@Override
	public Expense getExpense(int id) {
		Connection connection = null;
		PreparedStatement preparestatement = null;
		Expense expense = null;
		// log.info("getExpense:" + expense);

		try {
			connection = DBUtil.getconnection();

			String query = "select * from expense where id=?";
			preparestatement = connection.prepareStatement(query);
			preparestatement.setInt(1, id);

			ResultSet set = preparestatement.executeQuery();

			while (set.next()) {
				expense = new Expense();

				expense.setId(set.getInt("id"));
				expense.setExpenseType(set.getString("expenseType"));
				expense.setDate(set.getString("date"));
				expense.setPricee(set.getString("price"));
				expense.setNoOfItems(set.getString("NoOfItems"));
				expense.setTotalAccount(set.getString("totalAccount"));
				expense.setByWhom(set.getString("byWhom"));

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + expense);
		} finally {
			DBUtil.closeConnection(connection);

		}
		// log.info("getExpense:" + expense);
		return expense;

	}

	@Override
	public List<Expense> getExpenseReport(String expenseType, String fromDate, String toDate) {
		Connection connection = null;
		PreparedStatement preparestatement = null;
		List<Expense> expenseReport = new ArrayList<Expense>();

		// log.info("getExpenseReport:" + expenseReport);
		try {
			connection = DBUtil.getconnection();

			String query1 = "select * from expense where ExpenseType=? and Date between ? and ?";
			preparestatement = connection.prepareStatement(query1);

			preparestatement.setString(1, expenseType);
			preparestatement.setString(2, fromDate);
			preparestatement.setString(3, toDate);

			// System.out.println("selecting records");

			ResultSet resultSet = preparestatement.executeQuery();

			Expense expense = null;

			while (resultSet.next()) {

				expense = new Expense();

				expense.setExpenseType(resultSet.getString("ExpenseType"));
				expense.setDate(resultSet.getString("Date"));
				expense.setPricee(resultSet.getString("Price"));
				expense.setNoOfItems(resultSet.getString("NoOfItems"));
				expense.setTotalAccount(resultSet.getString("Totalaccount"));
				expense.setByWhom(resultSet.getString("ByWhom"));

				expenseReport.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + expenseReport);
		} finally {
			DBUtil.closeConnection(connection);
		}
		// log.info("getExpenseReport:" + expenseReport);
		return expenseReport;
	}

	@Override
	public boolean resetPassword(String username, String currentPassword, String newPassword) {
		Connection connection = null;
		PreparedStatement preparestatement = null;
		boolean isResetPassword = false;
		// log.info("resetPassword:" + isResetPassword);

		try {
			connection = DBUtil.getconnection();
			String sql = "update user SET password=? where  UserName=? and password=?";
			preparestatement = connection.prepareStatement(sql);
			System.out.println("Updating records into the table...");

			preparestatement.setString(1, newPassword);
			preparestatement.setString(2, username);
			preparestatement.setString(3, currentPassword);

			int number = preparestatement.executeUpdate();

			isResetPassword = number > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + isResetPassword);
		} finally {
			DBUtil.closeConnection(connection);
		}
		// log.info("resetPassword:" + isResetPassword);
		return isResetPassword;

	}

	@Override
	public PersonalInfo getPersonalInfo(String username) {
		Connection connection = null;
		PreparedStatement prst = null;
		PersonalInfo personalinfo = new PersonalInfo();

		// log.info("getPersonalInfo:" + personalInfo);
		try {
			connection = DBUtil.getconnection();
			String query = "select u.*,a.* from user u left join address a on u.id=a.UserId where u.username='"
					+ username + "' ";
			prst = connection.prepareStatement(query);
			ResultSet set = prst.executeQuery();

			while (set.next()) {

				User user = new User();
				user.setFirstName(set.getString("FirstName"));
				user.setMiddleName(set.getString("MiddleName"));
				user.setLastName(set.getString("lastName"));
				user.setUserName(set.getString("UserName"));
				user.setPassword(set.getString("Password"));
				user.setMobileNo(set.getString("MobileNo"));
				user.setId(set.getInt("id"));

				Address address = new Address();

				address.setId(set.getInt("id"));
				address.setAddressLine1(set.getString("AddressLine1"));
				address.setAddressLine2(set.getString("AddressLine2"));
				address.setCity(set.getString("City"));
				address.setState(set.getString("State"));
				address.setZip(set.getString("Zip"));
				address.setCountry(set.getString("Country"));
				address.setUserId(set.getInt("UserId"));

				personalinfo.setAddress(address);
				personalinfo.setUser(user);
				if (address.getUserId() == user.getId()) {
					return personalinfo;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + personalInfo);
		} finally {
			DBUtil.closeConnection(connection);
		}
		// log.info("getPersonalInfo:" + personalInfo);
		// return personalinfo;
		return personalinfo;

	}

	@Override
	public boolean updatePersonalInfo(User user, Address address) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isUpdated = false;

		// log.info("updatePersonalInfo:" + isUpdated);

		try {
			connection = DBUtil.getconnection();
			connection.setAutoCommit(false);

			String sqlquery = "update user set FirstName=?,MiddleName=?,LastName=?,UserName=?,Password=?,MobileNo=?  where id=?";
			preparedStatement = connection.prepareStatement(sqlquery);

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getUserName());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getMobileNo());
			preparedStatement.setInt(7, user.getId());

			int noofRec = preparedStatement.executeUpdate();

			isUpdated = noofRec > 0;

			String query = "";

			if (address.getId() == 0) {

				query = "insert into address (Addressline1,addressline2,City,State,Zip,Country,UserId) values(?,?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, address.getAddressLine1());
				preparedStatement.setString(2, address.getAddressLine2());
				preparedStatement.setString(3, address.getCity());
				preparedStatement.setString(4, address.getState());
				preparedStatement.setString(5, address.getZip());
				preparedStatement.setString(6, address.getCountry());
				preparedStatement.setInt(7, address.getUserId());

				int i = preparedStatement.executeUpdate();
				isUpdated = i > 0;
			} else {
				query = "update address set Addressline1=?,addressline2=?,City=?,State=?,Zip=?,Country=?,UserId=? where id=?";

				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, address.getAddressLine1());
				preparedStatement.setString(2, address.getAddressLine2());
				preparedStatement.setString(3, address.getCity());
				preparedStatement.setString(4, address.getState());
				preparedStatement.setString(5, address.getZip());
				preparedStatement.setString(6, address.getCountry());
				preparedStatement.setInt(7, address.getUserId());
				preparedStatement.setInt(8, address.getId());

				int i = preparedStatement.executeUpdate();
				isUpdated = i > 0;
				if (isUpdated) {
					connection.commit();
				} else {
					connection.rollback();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

			// log.error("SQLException:" + isUpdated);

		}

		finally {

			DBUtil.closeConnection(connection);
		}
		// log.info("updatePersonalInfo:" + isUpdated);
		return isUpdated;
	}

	@Override
	public List<Expense> getdeleteDrop() {
		Connection connection = null;
		PreparedStatement preparestatement = null;
		List<Expense> expenses = new ArrayList<Expense>();
		// log.info("getExpense:" + expense);

		try {
			connection = DBUtil.getconnection();

			String query = "select * from expense";
			preparestatement = connection.prepareStatement(query);
			// preparestatement.setInt(1, id);

			ResultSet set = preparestatement.executeQuery();

			while (set.next()) {
				Expense expense = new Expense();

				expense.setExpenseType(set.getString("expenseType"));
				expense.setDate(set.getString("date"));
				expense.setPricee(set.getString("price"));
				expense.setNoOfItems(set.getString("NoOfItems"));
				expense.setTotalAccount(set.getString("totalAccount"));
				expense.setByWhom(set.getString("byWhom"));
				expense.setId(set.getInt("id"));
				expenses.add(expense);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return (ArrayList<Expense>) expenses;

	}

	@Override
	public boolean isUsernameAvailable(String username) {
		boolean isUsernameAvailable = true;
		Connection connection = null;
		PreparedStatement preparestatement = null;
		// log.info("login:" + username);

		try {
			connection = DBUtil.getconnection();

			String query = "select * from user where UserName=?";
			preparestatement = connection.prepareStatement(query);
			preparestatement.setString(1, username);

			ResultSet set = preparestatement.executeQuery();
			while (set.next()) {
				isUsernameAvailable = false;
				break;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			// log.error("SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		// log.info("isValidUser:" + isValidUser);
		return isUsernameAvailable;
	}

	@Override
	public boolean isMobileNumberAvailable(String mobileNo) {
		boolean isMobileNumberAvailable = true;
		Connection connection = null;

		PreparedStatement statement = null;

		try {
			connection = DBUtil.getconnection();

			String sql = "SELECT * FROM user WHERE mobileNo=?";

			statement = connection.prepareStatement(sql);
			statement.setString(1, mobileNo);

			ResultSet set = statement.executeQuery();

			while (set.next()) {
				isMobileNumberAvailable = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return isMobileNumberAvailable;
	}
	




	}


	
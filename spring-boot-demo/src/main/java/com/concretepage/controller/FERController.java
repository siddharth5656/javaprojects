package com.concretepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concretepage.entity.Expense;
import com.concretepage.entity.User;
import com.concretepage.service.FERService;

@Controller
@RequestMapping("fer")
public class FERController {

	@Autowired
	private FERService ferService;
	
	
	
@PostMapping("/user/username/{username}/password/{password}")
	
	public ResponseEntity<String> login(@PathVariable("username")String username,
			@PathVariable("password") String password){
	int id= ferService.login(username, password);
	return new ResponseEntity<String>((id > 0 ? 
			"User is authorized." : "user is not authorized."), HttpStatus.OK);
}
	
	
	@PostMapping("/user/registration")
	public ResponseEntity<String> registration(@RequestBody User user) {
		int numOfRecInserted = ferService.registration(user);
		return new ResponseEntity<String>((numOfRecInserted > 0 ? "Registration is done successfully."
				: numOfRecInserted == 0 ? "Registration is not done successfully."
						: "Registration is not done successfully due to duplicate username."),
				HttpStatus.OK);
	}
	
	@PostMapping("/expense")
	public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
		boolean addExpenseFlag = ferService.addExpense(expense);
		return new ResponseEntity<String>((addExpenseFlag ? 
				"Expense added successfully." : "Expense add failed."), HttpStatus.OK);
	}
	
	@PostMapping("/expense/{id}")
	public ResponseEntity<String> editExpense(@RequestBody Expense expense) {
		boolean editExpenseFlag = ferService.editExpense(expense);
		return new ResponseEntity<String>((editExpenseFlag ? 
				"Expense edited successfully." : "Expense edit failed."), HttpStatus.OK);
	}
	
	@GetMapping("/expense/{id}")
	public ResponseEntity<Expense> getExpense(@PathVariable("id") int expenseId) {
		Expense expense = ferService.getExpense(expenseId);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
	
	@GetMapping("/expenses")
	public ResponseEntity<List<Expense>> getExpenses() {
		List<Expense> expenses = ferService.getExpenses();
		return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
	}
	
	
	@GetMapping("/users")
	 public ResponseEntity<List<User>> getUsers(){
		List<User> users = ferService.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@GetMapping("/expense/{expenseType}/{fromDate}/{toDate}")
	public ResponseEntity<List<Expense>> getExpenseReport(@PathVariable("expenseType") String expenseType, 
		@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
		List<Expense> expenses = ferService.getExpenseReport(expenseType, fromDate, toDate);
		return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
	}
	
	@DeleteMapping("/expense/{expenseId}")
	public ResponseEntity<String> deleteExpense(@PathVariable("expenseId") int expenseId) {
		boolean deleteExpenseFlag = ferService.deleteExpense(expenseId);
		return new ResponseEntity<String>((deleteExpenseFlag ?
				"Expense deleted successfully." : "Expense delete failed."), HttpStatus.OK);
	}
	
	@PostMapping("/user/id/{id}/oldPassword/{oldPassword}/newPassword/{newPassword}")
	public ResponseEntity<String> resetPassword(@PathVariable("id") int id, 
		@PathVariable("oldPassword") String oldPassword, @PathVariable("newPassword") String newPassword) {
		boolean resetPasswordFlag = ferService.resetPassword(id, oldPassword, newPassword);
		return new ResponseEntity<String>((resetPasswordFlag ?
				"Password reset successfully." : "Password reset failed."), HttpStatus.OK);
	}
	
}

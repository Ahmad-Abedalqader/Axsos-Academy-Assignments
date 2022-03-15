package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Expense;
import com.codingdojo.mvc.repositories.ExpenseRepo;

@Service
public class ExpenseService {
 // adding the Expense repository as a dependency
	private final ExpenseRepo expenseRepo;
 
 public ExpenseService(ExpenseRepo expenseRepo) {
     this.expenseRepo = expenseRepo;
 }
 // returns all the Expenses
 public List<Expense> allExpenses() {
     return expenseRepo.findAll();
 }
 // creates a Expense
 public Expense createExpense(Expense b) {
     return expenseRepo.save(b);
 }
 // retrieves a Expense
 public Expense findExpense(Long id) {
     Optional<Expense> optionalExpense = expenseRepo.findById(id);
     if(optionalExpense.isPresent()) {
         return optionalExpense.get();
     } else {
         return null;
     }
 }
public Expense updateExpense(Expense expense) {
	return expenseRepo.save(expense);
}
public void deleteExpense(Long id) {
	expenseRepo.deleteById(id);
	
}
}


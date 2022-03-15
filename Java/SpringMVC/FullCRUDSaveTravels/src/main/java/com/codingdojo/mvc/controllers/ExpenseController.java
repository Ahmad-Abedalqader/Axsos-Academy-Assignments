package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.mvc.models.Expense;
import com.codingdojo.mvc.services.ExpenseService;

@Controller
public class ExpenseController {
    
	@Autowired
	ExpenseService expenseService;
    
    @GetMapping("/expenses")
    public String index(Model model, @ModelAttribute("expense") Expense expense) {
    	List<Expense> allExpenses = expenseService.allExpenses();
    	model.addAttribute("allExpenses", allExpenses);
        return "Travels.jsp";
    }
    
    
    @PostMapping("/expenses")
    public String showBook(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Expense> allExpenses = expenseService.allExpenses();
        	model.addAttribute("allExpenses", allExpenses);
            return "Travels.jsp";
        } else {
        	expenseService.createExpense(expense);
        	return "redirect:/expenses";
        }
    }
    
    @GetMapping("/expenses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }
    
    @PutMapping("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
    
    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
    @GetMapping("/expenses/{id}")
    public String index(@PathVariable("id") Long id, Model model) {
        model.addAttribute("expense", expenseService.findExpense(id));
        return "ExpDetails.jsp";
    }
    
}

package com.codingdojo.pokebook.controllers;



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

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
////////////////////////// DISPLAY LIST & CREATE NEW /////////////////////////////////	
	@GetMapping("/")
	public String index(Model model) {
		Expense newExpense = new Expense();
		model.addAttribute("newExpense", newExpense);
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String processnew(@Valid @ModelAttribute("newExpense")Expense newExpense,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}else {
			expenseService.createExpense(newExpense);
			return "redirect:/";
		}
	}
////////////////////////// SHOW ///////////////////////////////////////////////	
	@GetMapping("/index/{id}")
	public String showExpense(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
		
		
////////////////////////// EDIT ///////////////////////////////////////////////		
	}
	@GetMapping("/index/{id}/edit")
	public String editExpense(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	@PutMapping("/index/{id}/edit")
	public String processEditExpense(@Valid @ModelAttribute("expense")Expense expense,
			BindingResult result, @PathVariable("id")Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			expenseService.editExpense(expense);
			return "redirect:/";
		}
	}
	
/////////////////////////// DELETE ///////////////////////////////////////////////
	@DeleteMapping("/index/{id}/delete")
	public String processDelete(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
}
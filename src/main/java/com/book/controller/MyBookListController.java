package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.service.MyBookListServiceImpl;

@Controller
public class MyBookListController
{
	@Autowired
	private MyBookListServiceImpl ser;
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		ser.deleteById(id);
		return "redirect:/my_books";
	}
}

package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.entity.Book;
import com.book.entity.MyBookList;
import com.book.service.BookServiceImpl;
import com.book.service.MyBookListServiceImpl;

@Controller
public class BookController 
{
	@Autowired
	private BookServiceImpl service;
	
	@Autowired
	private MyBookListServiceImpl service2;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	
	@RequestMapping("/save")
	public String addBook(@ModelAttribute Book books)
	{
		service.save(books);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/available_books")
	public String getAllBooks(Model model)
	{
		List<Book> list = service.getAllBooks();
		model.addAttribute("list", list);
		return "bookList";
	}
	
	@RequestMapping("/my_books")
	public String myBooks(Model m)
	{
		List<MyBookList> bookListAllMy = service2.bookListAllMy();
		m.addAttribute("book", bookListAllMy);
		return "myBooks";
	}
	
	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Book b = service.getBookById(id);
		MyBookList myBookList = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		service2.saveMyBookList(myBookList);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/deleteBookList/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/book_edit/{id}")
	public String updateBook(@PathVariable("id") int id,Model m)
	{
		Book byId = service.getBookById(id);
		m.addAttribute("blist", byId);
		return "bookEdit";
	}
}

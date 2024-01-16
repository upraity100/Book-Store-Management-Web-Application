package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookRepository repo;

	@Override
	public void save(Book book) 
	{
		repo.save(book);
	}

	@Override
	public List<Book> getAllBooks() 
	{
		return repo.findAll();
	}

	@Override
	public Book getBookById(int id) 
	{
		return repo.findById(id).get();
		
	}

	@Override
	public void deleteById(int id) 
	{
		repo.deleteById(id);
	}
}

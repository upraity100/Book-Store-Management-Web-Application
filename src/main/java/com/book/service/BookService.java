package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface BookService 
{
	public void save(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public void deleteById(int id);
}

package com.book.service;

import java.util.List;

import com.book.entity.MyBookList;

public interface MyBookListService 
{
	public void saveMyBookList(MyBookList bookList);
	public List<MyBookList> bookListAllMy();
	public void deleteById(int id);
}

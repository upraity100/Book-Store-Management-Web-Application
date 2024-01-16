package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.MyBookList;
import com.book.repository.MyBookListRepository;

@Service
public class MyBookListServiceImpl implements MyBookListService
{
	@Autowired
	private MyBookListRepository myBookList;
	
	public void saveMyBookList(MyBookList bookList) 
	{
		myBookList.save(bookList);
	}


	public List<MyBookList> bookListAllMy()
	{
		return myBookList.findAll();
	}

	public void deleteById(int id) 
	{
		myBookList.deleteById(id);
	}

}

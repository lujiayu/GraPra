package com.grapra.dao;

import java.util.List;

import com.grapra.bean.Book;

public interface User {

	/**
	 * 查询自己发布的书籍
	 * @param userName 用户名
	 */
	public List<Book> querySelfBooks(String userName);
	
	/**
	 * 发布书籍
	 * @param book 书籍类
	 * 
	 */
	public boolean addBook(Book book);
	
	/**
	 * 查询所有书籍
	 * @return
	 */
	public List<Book> queryAllBooks();
}

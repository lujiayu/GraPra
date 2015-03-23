package com.grapra.dao;

import java.util.List;

import com.grapra.bean.Book;

public interface User {

	/**
	 * ��ѯ�Լ��������鼮
	 * @param userName �û���
	 */
	public List<Book> querySelfBooks(String userName);
	
	/**
	 * �����鼮
	 * @param book �鼮��
	 * 
	 */
	public boolean addBook(Book book);
	
	/**
	 * ��ѯ�����鼮
	 * @return
	 */
	public List<Book> queryAllBooks();
}

package com.grapra.dao;

import java.util.List;

import com.grapra.bean.Book;
import com.grapra.bean.Need;
import com.grapra.bean.Trading;

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
	 * 查询所有可以购买的书籍
	 * @return
	 */
	public List<Book> queryAllBooks();
	
	/**
	 * 书籍购买
	 * @param book 购买的对应书籍  user 书籍购买人
	 */
	public boolean buyBook(Book book,User user);
	
	/**
	 * 查询所有书籍需求信息
	 * @return
	 */
	public List<Need> queryAll();
	
	/**
	 * 查询该用户发布的需求信息
	 */
	public List<Need> queryNeed(User user);
	
	/**
	 * 发布需求信息
	 */
	public boolean issueNeed(Need need);
	
	/**
	 * 删除需求信息
	 */
	public boolean deleteNeed(Need need);
	
	/**
	 * 查询该用户已经完成的交易记录
	 */
	public List<Trading> queryTrading(User user);
	
	/**
	 * 申请退货
	 */
	public boolean ReturnBook(Trading trading);
	
	/**
	 * 查询该用户未发货的纪录
	 */
	public List<Trading> queryDeliverTrading(User user);
	
	/**
	 * 查询该用户未收货的纪录
	 */
	public List<Trading> queryReceiveTrading(User user);
	
	
}

package com.grapra.dao;

import java.util.List;

import com.grapra.bean.Book;
import com.grapra.bean.Need;
import com.grapra.bean.Trading;

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
	 * ��ѯ���п��Թ�����鼮
	 * @return
	 */
	public List<Book> queryAllBooks();
	
	/**
	 * �鼮����
	 * @param book ����Ķ�Ӧ�鼮  user �鼮������
	 */
	public boolean buyBook(Book book,User user);
	
	/**
	 * ��ѯ�����鼮������Ϣ
	 * @return
	 */
	public List<Need> queryAll();
	
	/**
	 * ��ѯ���û�������������Ϣ
	 */
	public List<Need> queryNeed(User user);
	
	/**
	 * ����������Ϣ
	 */
	public boolean issueNeed(Need need);
	
	/**
	 * ɾ��������Ϣ
	 */
	public boolean deleteNeed(Need need);
	
	/**
	 * ��ѯ���û��Ѿ���ɵĽ��׼�¼
	 */
	public List<Trading> queryTrading(User user);
	
	/**
	 * �����˻�
	 */
	public boolean ReturnBook(Trading trading);
	
	/**
	 * ��ѯ���û�δ�����ļ�¼
	 */
	public List<Trading> queryDeliverTrading(User user);
	
	/**
	 * ��ѯ���û�δ�ջ��ļ�¼
	 */
	public List<Trading> queryReceiveTrading(User user);
	
	
}

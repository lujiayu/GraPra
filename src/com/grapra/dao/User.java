package com.grapra.dao;

import java.util.List;

import com.grapra.bean.Book;
import com.grapra.bean.Need;
import com.grapra.bean.Return;
import com.grapra.bean.Trading;
/**
 * 
 * @author ¬���
 * �û����ܽӿ�
 */
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
	public boolean buyBook(Book book,com.grapra.bean.User user);
	
	/**
	 * ��ѯ�����鼮������Ϣ
	 * @return
	 */
	public List<Need> queryAll();
	
	/**
	 * ��ѯ���û�������������Ϣ
	 */
	public List<Need> queryNeed(com.grapra.bean.User user);
	
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
	public List<Trading> queryTrading(com.grapra.bean.User user);
	
	/**
	 * �����˻�
	 */
	public boolean ReturnBook(Trading trading);
	
	/**
	 * ���û����˻�����ļ�¼
	 */
	public List<Return> queryReturn(com.grapra.bean.User user);
	
	/**
	 * �����˻�����
	 */
	public boolean dealReturn(Return returns);
	
	/**
	 * ��ѯ���û�δ�����ļ�¼
	 */
	public List<Trading> queryDeliverTrading(com.grapra.bean.User user);
	
	/**
	 * ȷ�Ϸ������� 
	 */
	public boolean ensureDeliver(Trading trading);

	/**
	 * ��ѯ���û�δ�ջ��ļ�¼
	 */
	public List<Trading> queryReceiveTrading(com.grapra.bean.User user);
	
	/**
	 * ȷ���ջ�����
	 */
	public boolean ensureReceive(Trading trading);
	
}

package com.grapra.dao;

import java.util.List;

import com.grapra.bean.Return;
import com.grapra.bean.Trading;

/**
 *
 * @author ¬���
 * ����Ա���ܽӿ�
 */
public interface Manager {
	/**
	 * ��ѯ���н��׼�¼
	 * @return
	 */
	public List<Trading> queryTrading();
	
	/**
	 * �˻���Ϣ��ѯ
	 */
	public List<Return> queryReturn();
	
	/**
	 * ��ȡ�û��б�
	 * @return
	 */
	public List<User> queryUser();
	
	/**
	 * �����û�����
	 * @param user
	 * @return
	 */
	public boolean updateUserScore(User user);
	
	/**
	 * �����û�״̬
	 */
	public boolean updateUserStatu(User user);
	
	/**
	 * ɾ���û�
	 * @param user
	 * @return
	 */
	public boolean deleteUser(User user);
}

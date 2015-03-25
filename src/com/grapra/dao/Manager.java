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
	public List<com.grapra.bean.User> queryUser();
	
	/**
	 * �����û�����
	 * @param user
	 * @return
	 */
	public boolean updateUserScore(com.grapra.bean.User user);
	
	/**
	 * �����û�״̬
	 */
	public boolean updateUserStatu(com.grapra.bean.User user);
	
	/**
	 * ɾ���û�
	 * @param user
	 * @return
	 */
	public boolean deleteUser(com.grapra.bean.User user);
}

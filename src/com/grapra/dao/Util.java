package com.grapra.dao;

public interface Util {

	/**
	 * ע��
	 * @param user
	 * @return
	 */
	public boolean register(com.grapra.bean.User user);
	
	/**
	 * ��½
	 */
	public com.grapra.bean.User login(String userName,String password);
}

package com.grapra.dao;

public interface Util {

	/**
	 * ע��
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * ��½
	 */
	public User login(String userName,String password);
}

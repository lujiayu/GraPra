package com.grapra.dao;

public interface Util {

	/**
	 * ×¢²á
	 * @param user
	 * @return
	 */
	public boolean register(com.grapra.bean.User user);
	
	/**
	 * µÇÂ½
	 */
	public com.grapra.bean.User login(String userName,String password);
}

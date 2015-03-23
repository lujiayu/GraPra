package com.grapra.dao;

public interface Util {

	/**
	 * ×¢²á
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * µÇÂ½
	 */
	public User login(String userName,String password);
}

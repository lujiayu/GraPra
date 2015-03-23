package com.grapra.dao;

import java.util.List;

import com.grapra.bean.Return;
import com.grapra.bean.Trading;

/**
 *
 * @author 卢佳瑜
 * 管理员功能接口
 */
public interface Manager {
	/**
	 * 查询所有交易记录
	 * @return
	 */
	public List<Trading> queryTrading();
	
	/**
	 * 退货信息查询
	 */
	public List<Return> queryReturn();
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<User> queryUser();
	
	/**
	 * 更改用户积分
	 * @param user
	 * @return
	 */
	public boolean updateUserScore(User user);
	
	/**
	 * 更改用户状态
	 */
	public boolean updateUserStatu(User user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public boolean deleteUser(User user);
}

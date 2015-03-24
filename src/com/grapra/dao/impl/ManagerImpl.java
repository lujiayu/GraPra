package com.grapra.dao.impl;

import java.util.List;

import com.grapra.bean.Return;
import com.grapra.bean.Trading;
import com.grapra.dao.Manager;
import com.grapra.dao.User;

public class ManagerImpl implements Manager{

	@Override
	public List<Trading> queryTrading() {
		// TODO Auto-generated method stub
		List<Trading> list =new ArrayList<Trading>();
		String selectSql="select * from trading " ;
		try{
			Statement stmt=conn.createStatement();
			ResultSet re= stmt.executeQuery(selectSql);
			while(re.next())
			{
				list.add(new Trading(re.getInt("tradingID"),re.getInt("bookID"),re.getString("ownerID"),re.getString("buyerID"),re.getDate("time"),re.getString("deliver"),re.getString("receive")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Return> queryReturn() {
		// TODO Auto-generated method stub
		List<Return> list=new ArrayList<Return>();
		String selectSql_1="select * from Return";
		try{
			Statement stmt=conn.createStatement();
			ResultSet re_1= stmt.executeQuery(selectSql_1);		
			while(re_1.next())
			{
				String selectSql="select * from trading where tradingID= '"+ re_1.getInt("tradingID")+"'";
				ResultSet re=stmt.executeQuery(selectSql);
				Trading trad= new Trading(re.getInt("tradingID"),re.getInt("bookID"),re.getString("ownerID"),re.getString("buyerID"),re.getDate("time"),re.getString("deliver"),re.getString("receive")));
				list.add(new Return(re_1.getInt("returnID"),trad,re_1.getString("statu")));	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> queryUser() {
		// TODO Auto-generated method stub	
		List<Trading> list =new ArrayList<Trading>();
		String selectSql="select * from usertable " ;
		//
		try{
			Statement stmt=conn.createStatement();
			ResultSet re= stmt.executeQuery(selectSql);
			while(re.next())
			{
				list.add(new Trading(re.getInt("tradingID"),re.getInt("bookID"),re.getString("ownerID"),re.getString("buyerID"),re.getDate("time"),re.getString("deliver"),re.getString("receive")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateUserScore(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserStatu(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}

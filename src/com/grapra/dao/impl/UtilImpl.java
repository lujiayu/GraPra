package com.grapra.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.grapra.dao.Util;
import com.grapra.db.DBConnection;

public class UtilImpl implements Util{
	
	Connection conn;
	public UtilImpl(){
	conn = (Connection) new DBConnection().getConnection();

	}
	@Override
	public boolean register(com.grapra.bean.User user) {
		boolean b=true;
		String insertSql="insert into usertable (name,password,type,score) values(?,?,?,?)";
		try{
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(insertSql);
			pst.setString(1,user.getName());
			pst.setString(2,user.getPassword());
			pst.setInt(3,user.getType());
			pst.setInt(4,user.getScore());
			b=pst.execute();
			b=true;
		}
		catch(Exception e)
		{
			b = false;
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "该账号已存在！");
		}
		System.out.println(b);
		if(b)JOptionPane.showMessageDialog(null, "提交成功，请等待管理员审核！");
		return b;
	}
	@Override
	public com.grapra.bean.User login(String userName,String password)
	{
		List<com.grapra.bean.User> list = new ArrayList<com.grapra.bean.User>();
		String selectSql="select * from usertable where name ='"+userName+"' and  password = '"+ password+"'" ; 
		try{
		Statement stmt = conn.createStatement();
		ResultSet re= stmt.executeQuery(selectSql);
		while(re.next())
		{
			list.add(new com.grapra.bean.User(re.getString("name"),re.getString("password"),re.getInt("type"),re.getInt("score")));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	
}

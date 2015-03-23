package com.grapra.db;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 * 获取数据库连接类
 * @author 卢佳瑜
 *
 */
public class DBConnection
	{
	String DBDRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://127.0.0.1/grapra";
	String DBUSER = "root";
	String DBPASSWORD = "3141592654";
	private Connection conn	= null ;

	public DBConnection()
	{
		try
		{
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
			//this.conn
		}
		catch (Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库连接失败，请检查网络！");
		}
	}
	public Connection getConnection()
	{
		return this.conn ;
	}
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
};
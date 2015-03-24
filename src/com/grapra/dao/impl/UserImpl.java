package com.grapra.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.grapra.bean.Book;
import com.grapra.bean.Need;
import com.grapra.bean.Return;
import com.grapra.bean.Trading;
import com.grapra.bean.User;
import com.grapra.db.DBConnection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserImpl implements com.grapra.dao.User{

	Connection conn;
	
	public UserImpl(){
	conn = (Connection) new DBConnection().getConnection();

	}
/*
 * 增删改查 book 表
 * 
 */
	@Override
	public List<Book> querySelfBooks(String userName) {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		String selectSql="select * from book where OwnerName ='"+userName+"'"; 
		try{
		Statement stmt = conn.createStatement();
		ResultSet re= stmt.executeQuery(selectSql);
		while(re.next())
		{
			list.add(new Book(re.getInt("bookID"),re.getString("bookName"),re.getString("OwnerName"),re.getString("bookStatu")));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		boolean b=false;
		String insertSql="insert into book (bookName.OwnerName,bookStatu) values(?,?,?)";
		try{
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(insertSql);
			pst.setString(1, book.getBookName());
			pst.setString(2,book.getOwnerName());
			pst.setString(3,book.getBookStatu());
			b=pst.execute(insertSql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Book> queryAllBooks() {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		String selectSql="select * from book "; 
		try{
		Statement stmt = conn.createStatement();
		ResultSet re= stmt.executeQuery(selectSql);
		while(re.next())
		{
			list.add(new Book(re.getInt("bookID"),re.getString("bookName"),re.getString("OwnerName"),re.getString("bookStatu")));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
/*
 * 增删改查 trading 表
 */
	@Override
	public boolean buyBook(Book book, User user) {
		// TODO Auto-generated method stub
		boolean b=false;
		String insertSql="insert into trading (bookID,ownerID,buyerID,time,deliver,receive) values(?,?,?,?,?,?)";
		try{
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(insertSql);
			pst.setInt(1,book.getBookID());
			pst.setString(2,book.getOwnerName());
			pst.setString(3,user.getName());
			pst.setDate(4,(java.sql.Date)new Date());
			pst.setString(5,"未发货");
			pst.setString(6,"未收货");
			b=pst.execute(insertSql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	/*
	 * 增删改查 need 表
	 */
	@Override
	public List<Need> queryAll() {
		List<Need> list = new ArrayList<Need>();
		String selectSql="select * from Need "; 
		try{
		Statement stmt = conn.createStatement();
		ResultSet re= stmt.executeQuery(selectSql);
		while(re.next())
		{
			list.add(new Need(re.getInt("needID"),re.getString("bookName"),re.getString("neederName")));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Need> queryNeed(User user) {
		// TODO Auto-generated method stub
		List<Need> list =new ArraryList<Need>();
		String selectSql="select * from Need where neederName =' "+ user.getName() +"'";
		try{
			Statement stmt=conn.createStatement();
			ResultSet re= stmt.executeQuery(selectSql);
			while(re.next())
			{
				list.add(new Need(re.getInt("needID"),re.getString("bookName"),re.getString("neederName")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean issueNeed(Need need) {
		// TODO Auto-generated method stub
		boolean b=false;
		String insertSql="insert into need (bookName.neederName) values(?,?)";
		try{
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(insertSql);
			pst.setString(1, need.getBookName());
			pst.setString(2, need.getNeederName());
			b=pst.execute(insertSql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean deleteNeed(Need need) {
//		String delSql = "delete from studentInfo where StuID = ?";
//        pst = conn.prepareStatement(delSql);
//        pst.setString(1, "20120001");
		
		// TODO Auto-generated method stub
		boolean b=false;
		String insertSql="delete from need where needID = '"+need.getNeedID()+"'";
		try{
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(insertSql);
			b=pst.execute(insertSql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
/*
 * 增删改查 trading 表
 */
	@Override
	public List<Trading> queryTrading(User user) {
		// TODO Auto-generated method stub

		List<Trading> list =new ArraryList<Trading>();
		String selectSql="select * from trading where  deliver= '已发货' and receive = '已收货' and ownerID= '"+ user.getName()+"'" ;
		try{
			Statement stmt=conn.createStatement();
			ResultSet re= stmt.executeQuery(selectSql);
			while(re.next())
			{
				//public Trading(int tradingID, int bookID, String ownerID, String buyerID,
						//Date time, String deliver, String receive) {
				list.add(new Trading(re.getInt("tradingID"),re.getInt("bookID"),re.getString("ownerID"),re.getString("buyerID"),re.getDate("time"),re.getString("deliver"),re.getString("receive")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
//申请退货
	@Override
	public boolean ReturnBook(Trading trading) {
		//在 return表里添加
		//然后 积分表里－1
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public List<Return> queryReturn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dealReturn(Return returns) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Trading> queryDeliverTrading(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ensureDeliver(Trading trading) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Trading> queryReceiveTrading(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ensureReceive(Trading trading) {
		// TODO Auto-generated method stub
		return false;
	}

}

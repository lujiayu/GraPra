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
	
	UserImpl(){
	conn = (Connection) new DBConnection().getConnection();

	}

	@Override
	public List<Book> querySelfBooks(String userName) {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		String selectSql="select * from book where OwnerName ='"+userName+"'"; 
		try{
		Statement stmt = conn.createStatement();
		ResultSet re= stmt.getResultSet();
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
		ResultSet re= stmt.getResultSet();
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
	public boolean buyBook(Book book, User user) {
		// TODO Auto-generated method stub
		boolean b=false;
		String insertSql="insert into trading (bookID.ownerID,buyerID,time,deliver,receive) values(?,?,?,?,?,?)";
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
// 写到这了
	@Override
	public List<Need> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Need> queryNeed(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean issueNeed(Need need) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNeed(Need need) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Trading> queryTrading(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ReturnBook(Trading trading) {
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

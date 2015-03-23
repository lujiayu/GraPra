package com.grapra.bean;

/**
 * 
 * @author 卢佳瑜
 * 书籍信息类，对应数据库中book表
 *
 */
public class Book {

	private int bookID;	//书籍ID(来源于数据库自增长主键)
	private String bookName;	//书籍名称
	private String ownerName;	//书籍提供人姓名
	private String bookStatu;  //书籍状态
	
	
	//构造函数
	public Book(int bookID, String bookName, String ownerName, String bookStatu) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.ownerName = ownerName;
		this.bookStatu = bookStatu;
	}

	
	//默认构造函数
	public Book(){
		this.bookID = -1;
		this.bookName = "";
		this.ownerName = "";
		this.bookStatu = "";
	}
	
	
	
	public int getBookID() {
		return bookID;
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getBookStatu() {
		return bookStatu;
	}


	public void setBookStatu(String bookStatu) {
		this.bookStatu = bookStatu;
	}
	
	
}

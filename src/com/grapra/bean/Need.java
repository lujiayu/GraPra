package com.grapra.bean;

/**
 * 
 * @author 卢佳瑜
 * 需求信息类
 */
public class Need {

	private int needID;//需求ID
	private String bookName;//需求的书籍名称
	private String neederName;//需求人
	
	
	//构造函数
	public Need(int needID, String bookName, String neederName) {
		
		this.needID = needID;
		this.bookName = bookName;
		this.neederName = neederName;
	}
	//默认构造函数
	public Need(){
		this.needID = -1;
		this.bookName = "";
		this.neederName = "";
	}
	
	public int getNeedID() {
		return needID;
	}
	public void setNeedID(int needID) {
		this.needID = needID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getNeederName() {
		return neederName;
	}
	public void setNeederName(String neederName) {
		this.neederName = neederName;
	}
	
	
}

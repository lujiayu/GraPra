package com.grapra.bean;

/**
 * 
 * @author ¬���
 * ������Ϣ��
 */
public class Need {

	private int needID;//����ID
	private String bookName;//������鼮����
	private String neederName;//������
	
	
	//���캯��
	public Need(int needID, String bookName, String neederName) {
		
		this.needID = needID;
		this.bookName = bookName;
		this.neederName = neederName;
	}
	//Ĭ�Ϲ��캯��
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

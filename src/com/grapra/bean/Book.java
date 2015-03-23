package com.grapra.bean;

/**
 * 
 * @author ¬���
 * �鼮��Ϣ�࣬��Ӧ���ݿ���book��
 *
 */
public class Book {

	private int bookID;	//�鼮ID(��Դ�����ݿ�����������)
	private String bookName;	//�鼮����
	private String ownerName;	//�鼮�ṩ������
	private String bookStatu;  //�鼮״̬
	
	
	//���캯��
	public Book(int bookID, String bookName, String ownerName, String bookStatu) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.ownerName = ownerName;
		this.bookStatu = bookStatu;
	}

	
	//Ĭ�Ϲ��캯��
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

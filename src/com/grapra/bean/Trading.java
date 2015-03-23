package com.grapra.bean;

import java.sql.Date;

/**
 * 
 * @author ¬���
 * ������Ϣ��,��Ӧ���ݿ���trading��
 *
 */
public class Trading {

	private int tradingID;//���׼�¼ ID
	private int bookID;//�����׵��鼮ID
	private String ownerID;//ӵ����ID
	private String buyerID;//������ID
	private Date time;//����ʱ��
	private String deliver;//������Ϣ
	private String receive;//�ջ���Ϣ
	

	
	public Trading(int tradingID, int bookID, String ownerID, String buyerID,
			Date time, String deliver, String receive) {
		super();
		this.tradingID = tradingID;
		this.bookID = bookID;
		this.ownerID = ownerID;
		this.buyerID = buyerID;
		this.time = time;
		this.deliver = deliver;
		this.receive = receive;
	}
	
	
	public int getTradingID() {
		return tradingID;
	}
	public void setTradingID(int tradingID) {
		this.tradingID = tradingID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public String getBuyerID() {
		return buyerID;
	}
	public void setBuyerID(String buyerID) {
		this.buyerID = buyerID;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}


	public String getDeliver() {
		return deliver;
	}


	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}


	public String getReceive() {
		return receive;
	}


	public void setReceive(String receive) {
		this.receive = receive;
	}
	
	
}

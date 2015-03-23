package com.grapra.bean;

import java.sql.Date;

/**
 * 
 * @author 卢佳瑜
 * 交易信息类,对应数据库中trading表
 *
 */
public class Trading {

	private int tradingID;//交易记录 ID
	private int bookID;//被交易的书籍ID
	private String ownerID;//拥有者ID
	private String buyerID;//购买者ID
	private Date time;//交易时间
	private String deliver;//发货信息
	private String receive;//收货信息
	

	
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

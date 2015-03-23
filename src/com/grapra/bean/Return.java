package com.grapra.bean;

/**
 * 
 * @author 卢佳瑜
 * 退货信息类
 */
public class Return {

	private int returnID;//退货信息ID
	private String statu;//退货状态
	private Trading trading;//退货对应的交易记录
	
	//构造函数
	public Return(int returnID, Trading trading, String statu) {
		this.returnID = returnID;
		this.trading = trading;
		this.statu = statu;
	}
	//默认构造函数
	public Return(){
		this.returnID = -1;
		this.trading = null;
		this.statu = "";
	}
	
	
	public int getReturnID() {
		return returnID;
	}
	public void setReturnID(int returnID) {
		this.returnID = returnID;
	}
	public Trading getTradingID() {
		return trading;
	}
	public void setTrading(Trading trading) {
		this.trading = trading;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	
}

package com.grapra.bean;

/**
 * 
 * @author 卢佳瑜
 * 退货信息类
 */
public class Return {

	private int returnID;//退货信息ID
	private int tradingID;//对应的交易信息ID
	private String statu;//退货状态
	
	
	//构造函数
	public Return(int returnID, int tradingID, String statu) {
		this.returnID = returnID;
		this.tradingID = tradingID;
		this.statu = statu;
	}
	//默认构造函数
	public Return(){
		this.returnID = -1;
		this.tradingID = -1;
		this.statu = "";
	}
	
	
	public int getReturnID() {
		return returnID;
	}
	public void setReturnID(int returnID) {
		this.returnID = returnID;
	}
	public int getTradingID() {
		return tradingID;
	}
	public void setTradingID(int tradingID) {
		this.tradingID = tradingID;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	
}

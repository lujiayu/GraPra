package com.grapra.bean;

/**
 * 
 * @author ¬���
 * �˻���Ϣ��
 */
public class Return {

	private int returnID;//�˻���ϢID
	private int tradingID;//��Ӧ�Ľ�����ϢID
	private String statu;//�˻�״̬
	
	
	//���캯��
	public Return(int returnID, int tradingID, String statu) {
		this.returnID = returnID;
		this.tradingID = tradingID;
		this.statu = statu;
	}
	//Ĭ�Ϲ��캯��
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

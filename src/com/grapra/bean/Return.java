package com.grapra.bean;

/**
 * 
 * @author ¬���
 * �˻���Ϣ��
 */
public class Return {

	private int returnID;//�˻���ϢID
	private String statu;//�˻�״̬
	private Trading trading;//�˻���Ӧ�Ľ��׼�¼
	
	//���캯��
	public Return(int returnID, Trading trading, String statu) {
		this.returnID = returnID;
		this.trading = trading;
		this.statu = statu;
	}
	//Ĭ�Ϲ��캯��
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

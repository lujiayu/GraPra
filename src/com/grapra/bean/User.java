package com.grapra.bean;

/**
 * 
 * @author ¬���
 * �û���Ϣ��
 */
public class User {
	private String name; //�û���
	private String password;//����
	private int score;//����
	private int type;//�û����ͣ�0Ϊ����Ա��1Ϊ��ͨ�û�,2Ϊ������Ա��׼��ȡȨ�޵��û�
	
	//���캯��
	public User(String name, String password, int score, int type) {
		
		this.name = name;
		this.password = password;
		this.score = score;
		this.type = type;
	}
	//Ĭ�Ϲ��캯��
	public User(){
		this.name = "";
		this.password = "";
		this.score = -1;
		this.type = -1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}

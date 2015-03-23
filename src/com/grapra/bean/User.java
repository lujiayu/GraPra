package com.grapra.bean;

/**
 * 
 * @author 卢佳瑜
 * 用户信息类
 */
public class User {
	private String name; //用户名
	private String password;//密码
	private int score;//分数
	private int type;//用户类型，0为管理员，1为普通用户,2为待管理员批准获取权限的用户
	
	//构造函数
	public User(String name, String password, int score, int type) {
		
		this.name = name;
		this.password = password;
		this.score = score;
		this.type = type;
	}
	//默认构造函数
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

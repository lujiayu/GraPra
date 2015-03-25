package com.grapra.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

import com.grapra.bean.User;

public class ManagerFrame extends JFrame{
	private User user;
	private JPanel leftPane;//左边存放按钮的面板
	private JPanel rightPane;//右边存放内容的面板
	private JTable table;//右边面板中要使用的表格
	public ManagerFrame(User user) {//构造函数
		this.user = user;
		leftPane = new JPanel();
		this.builder();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private void builder (){
		this.setBounds(350, 150, 700, 500);
		this.setBackground(Color.WHITE);
		this.setTitle("欢迎用户："+user.getName());
		this.setLayout(null);
		
		this.table = new JTable();//JTable表格
		
		this.leftPaneBuilder();
		this.rightPaneBuilder();
		
		this.add(leftPane);
		this.add(rightPane);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void leftPaneBuilder(){//构建左边panel的属性

		leftPane.setBounds(0, 0, 100, 500);
		leftPane.setBackground(Color.gray);
		leftPane.setLayout(null);//使用绝对布局
	}
	
	private void rightPaneBuilder(){//构建右边panel的属性
		rightPane = new JPanel();
		rightPane.setBackground(Color.WHITE);
		rightPane.setBounds(110, 0, 580, 500);
		rightPane.setLayout(null);
	}
	
	public static void main(String args[]){
		// 更改窗体样式
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					UIManager.put("RootPane.setupButtonVisible", false);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					new ManagerFrame(new User("管理员", "123", 1, 1)).builder();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}

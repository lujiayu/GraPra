package com.grapra.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

import com.grapra.bean.User;

public class ManagerFrame extends JFrame{
	private User user;
	private JPanel leftPane;//��ߴ�Ű�ť�����
	private JPanel rightPane;//�ұߴ�����ݵ����
	private JTable table;//�ұ������Ҫʹ�õı��
	public ManagerFrame(User user) {//���캯��
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
		this.setTitle("��ӭ�û���"+user.getName());
		this.setLayout(null);
		
		this.table = new JTable();//JTable���
		
		this.leftPaneBuilder();
		this.rightPaneBuilder();
		
		this.add(leftPane);
		this.add(rightPane);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void leftPaneBuilder(){//�������panel������

		leftPane.setBounds(0, 0, 100, 500);
		leftPane.setBackground(Color.gray);
		leftPane.setLayout(null);//ʹ�þ��Բ���
	}
	
	private void rightPaneBuilder(){//�����ұ�panel������
		rightPane = new JPanel();
		rightPane.setBackground(Color.WHITE);
		rightPane.setBounds(110, 0, 580, 500);
		rightPane.setLayout(null);
	}
	
	public static void main(String args[]){
		// ���Ĵ�����ʽ
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					UIManager.put("RootPane.setupButtonVisible", false);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					new ManagerFrame(new User("����Ա", "123", 1, 1)).builder();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}

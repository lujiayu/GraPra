package com.grapra.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MainFrame extends JFrame implements ActionListener {

	protected JTextField username;
	protected JPasswordField password;
	private JTextField ip;

	MainFrame() throws IOException {
		this.setBounds(550, 200, 300, 300);
		this.setTitle("欢迎使用旧书回收系统");
		this.setLayout(null);
		Image icon_title = Toolkit.getDefaultToolkit().getImage("");
		this.setIconImage(icon_title);
		
		// logo 显示panel
		JPanel panel_logo = new JPanel();
		panel_logo.setBounds(0, 0, 300, 80);
		panel_logo.setLayout(null);
		
		JLabel image = new JLabel();
		image.setBounds(0, 0, 300, 100);
		Icon icon=new ImageIcon("image\\login.png"); 
		image.setIcon(icon);
		
		
		panel_logo.add(image);
		
		//账号、密码输入panel
		JPanel panel = new JPanel();
		panel.setBounds(0, 30, 300, 150);
		panel.setLayout(null);

		JLabel username_label = new JLabel("     账号：");
		username_label.setBounds(10, 90, 80, 20);

		username = new JTextField(20);
		username.setBounds(100, 90, 120, 25);

		JLabel password_label = new JLabel("     密码：");
		password_label.setBounds(10, 120, 80, 20);

		password = new JPasswordField(20);
		password.setBounds(100, 120, 120, 25);

		panel.add(username_label);
		panel.add(username);
		panel.add(password_label);
		panel.add(password);


		// 按钮panel
		JPanel panel_button = new JPanel();
		panel_button.setBounds(0, 180, 300, 100);
		panel_button.setLayout(null);

		JButton login = new JButton("登陆");
		login.setBounds(30, 0, 80, 30);
		login.addActionListener(this);	//添加监听

		JButton exit = new JButton("注册");
		exit.setBounds(135, 0, 80, 30);
		exit.addActionListener(new ActionListener() {// 添加监听事件

			@Override
			public void actionPerformed(ActionEvent e) {// 注册Action
				// TODO Auto-generated method stub
				
			}

		});

		panel_button.add(exit);
		panel_button.add(login);

		
		this.add(panel_logo);
		this.add(panel);
		this.add(panel_button);

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {//登陆Action
		
	}

	public static void main(String args[]) {
		// 更改窗体样式
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			new MainFrame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

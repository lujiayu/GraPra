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
		this.setTitle("��ӭʹ�þ������ϵͳ");
		this.setLayout(null);
		Image icon_title = Toolkit.getDefaultToolkit().getImage("");
		this.setIconImage(icon_title);
		
		// logo ��ʾpanel
		JPanel panel_logo = new JPanel();
		panel_logo.setBounds(0, 0, 300, 80);
		panel_logo.setLayout(null);
		
		JLabel image = new JLabel();
		image.setBounds(0, 0, 300, 100);
		Icon icon=new ImageIcon("image\\login.png"); 
		image.setIcon(icon);
		
		
		panel_logo.add(image);
		
		//�˺š���������panel
		JPanel panel = new JPanel();
		panel.setBounds(0, 30, 300, 150);
		panel.setLayout(null);

		JLabel username_label = new JLabel("     �˺ţ�");
		username_label.setBounds(10, 90, 80, 20);

		username = new JTextField(20);
		username.setBounds(100, 90, 120, 25);

		JLabel password_label = new JLabel("     ���룺");
		password_label.setBounds(10, 120, 80, 20);

		password = new JPasswordField(20);
		password.setBounds(100, 120, 120, 25);

		panel.add(username_label);
		panel.add(username);
		panel.add(password_label);
		panel.add(password);


		// ��ťpanel
		JPanel panel_button = new JPanel();
		panel_button.setBounds(0, 180, 300, 100);
		panel_button.setLayout(null);

		JButton login = new JButton("��½");
		login.setBounds(30, 0, 80, 30);
		login.addActionListener(this);	//��Ӽ���

		JButton exit = new JButton("ע��");
		exit.setBounds(135, 0, 80, 30);
		exit.addActionListener(new ActionListener() {// ��Ӽ����¼�

			@Override
			public void actionPerformed(ActionEvent e) {// ע��Action
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
	public void actionPerformed(ActionEvent e) {//��½Action
		
	}

	public static void main(String args[]) {
		// ���Ĵ�����ʽ
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

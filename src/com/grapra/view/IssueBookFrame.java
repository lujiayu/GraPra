package com.grapra.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.grapra.bean.Book;
import com.grapra.dao.impl.UserImpl;

/**
 * �����鼮����
 * @author ¬���
 *
 */
public class IssueBookFrame extends JFrame {

	JPanel pane;
	JTextField jtf;//�ı���
	JLabel jlb;//��ǩ
	JButton jb;//������ť
	
	public IssueBookFrame(final String userName){
		this.setLayout(null);
		this.setBounds(500, 300, 300, 250);
		pane = new JPanel();
		pane.setLayout(null);
		pane.setBackground(Color.white);
		pane.setBounds(0,0,300,250);
		
		jlb = new JLabel("�鼮��:");
		jlb.setBounds(10,20,50,30);
		pane.add(jlb);
		jtf = new JTextField(150);
		jtf.setBounds(70, 20, 150, 30);
		pane.add(jtf);
		
		jb = new JButton("����");
		jb.setBounds(80, 100, 80, 30);
		
		jb.addActionListener(new ActionListener(){//���ò��뺯�������ݿ��в�������

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean b = new UserImpl().addBook(new Book(-1,jtf.getText(),userName,"δ����"));
			
				setVisible(false);
				System.out.println(userName+" - "+jtf.getText() +"  ��ӳɹ�");
			}
			
		});
		
		pane.add(jb);
		
		this.add(pane);
		this.setVisible(true);
	}
}

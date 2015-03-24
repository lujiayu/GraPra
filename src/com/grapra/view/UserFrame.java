package com.grapra.view;
/**
 * ��ͨ�û���½��Ľ���
 * @author ¬���
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.grapra.bean.Book;
import com.grapra.bean.Need;
import com.grapra.bean.User;
import com.grapra.dao.impl.UserImpl;

public class UserFrame extends JFrame{

	private User user;

	private JPanel leftPane;//��ߴ�Ű�ť�����
	private JButton querySelfBooks;//��ѯ�Լ���������ͼ��
	private JButton issueBook;//�����鼮
	private JButton queryOtherBooks;//��ѯ�����˷�����ͼ��
	private JButton queryNeed;//��ѯ������Ϣ
	private JButton querySelfNeed;//��ѯ�Լ���������Ϣ
	private JButton issueNeed;//����������Ϣ
	
	private JPanel rightPane;//�ұߴ�����ݵ����
	private JTable table;//�ұ������Ҫʹ�õı��
	
	public UserFrame(User user) {//���캯��
		this.user = user;
		leftPane = new JPanel();
		querySelfBooks = new JButton("�ҷ�������");
		issueBook = new JButton("�����鼮");
		queryOtherBooks = new JButton("�鼮�б�");
		queryNeed = new JButton("�����б�");
		
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
		//��ѯ�Լ��������鼮�б� ��ť--�����¼�
		querySelfBooks.addActionListener(new ActionListener(){//Ϊ��ť��Ӽ����¼�

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				rightPane.removeAll();
				String[] headers = { "�鼮ID", "�鼮��", "�鼮ӵ����" ,"�鼮״̬"};

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<Book> bookList = new UserImpl().querySelfBooks(user.getName());
					
					for(Book book:bookList){	
						model.addRow(new Object[]{book.getBookID(), book.getBookName(),
								book.getOwnerName(),book.getBookStatu()});
					}

				
				table.setBackground(Color.gray);
				table.setBounds(0, 0, 550, 500);

				JScrollPane jsp = new JScrollPane(table);
				jsp.setBounds(0,0,550,500);
				
				rightPane.add(jsp);
				rightPane.validate();
			}		
		});
		querySelfBooks.setBounds(10, 10, 80, 30);//���ð�ťλ�á���С
		
		
		//�����鼮 ��ť--�����¼�
		issueBook.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new IssueBookFrame(user.getName());
			}
			
		});
		issueBook.setBounds(10,50,80,30);//���ð�ťλ�á���С
		
		//��ѯ�����鼮��Ϣ����������
		queryOtherBooks.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "�鼮ID", "�鼮��", "�鼮ӵ����" ,"�鼮״̬"};

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<Book> bookList = new UserImpl().queryAllBooks();
					
					for(Book book:bookList){	
						model.addRow(new Object[]{book.getBookID(), book.getBookName(),
								book.getOwnerName(),book.getBookStatu()});
					}

				
				table.setBackground(Color.gray);
				table.setBounds(0, 0, 550, 500);

				JScrollPane jsp = new JScrollPane(table);
				jsp.setBounds(0,0,550,500);
				
				rightPane.add(jsp);
				rightPane.validate();
				table.addMouseListener(new MouseListener() {
					public void mousePressed(MouseEvent e) {
					    // ��갴��ʱ�Ĵ���
					}
					public void mouseReleased(MouseEvent e) {
					    // ����ɿ�ʱ�Ĵ���
					}
					public void mouseEntered(MouseEvent e) {
					    // ��������ʱ�Ĵ���
					}
					public void mouseExited(MouseEvent e) {
					    // ����˳����ʱ�Ĵ���
					}
					public void mouseClicked(MouseEvent e) {
					    // �����ʱ�Ĵ���
						int selectRows=table.getSelectedRows().length;// ȡ���û���ѡ�е�����
						DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
						if(selectRows==1){
							int selectedRowIndex = table.getSelectedRow(); // ȡ���û���ѡ���� 
							
							int bookID = (int) tableModel.getValueAt(selectedRowIndex, 0);
							String BookName = (String) tableModel.getValueAt(selectedRowIndex, 1);
							String OwnerName = (String) tableModel.getValueAt(selectedRowIndex, 2);
							
							Book book = new Book(bookID,BookName,OwnerName,"");
							new UserImpl().buyBook(book, user);
							
							System.out.println(bookID+" -- �����ˣ�"+user.getName());
							
							tableModel.removeRow(selectedRowIndex);
						}
					}
					});
			}
			
		});
		queryOtherBooks.setBounds(10,90,80,30);

		queryNeed.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "����ID", "�����鼮��", "����������" };

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<Need> needList = new UserImpl().queryAll();
					
					for(Need need:needList){	
						model.addRow(new Object[]{need.getNeedID(), need.getBookName(),
								need.getNeederName()});
					}

				
				table.setBackground(Color.gray);
				table.setBounds(0, 0, 550, 500);

				JScrollPane jsp = new JScrollPane(table);
				jsp.setBounds(0,0,550,500);
				
				rightPane.add(jsp);
				rightPane.validate();
			}
			
		});
		queryNeed.setBounds(10, 130, 80, 30);
		
		leftPane.add(querySelfBooks);
		leftPane.add(issueBook);
		leftPane.add(queryOtherBooks);
		leftPane.add(queryNeed);
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
					new UserFrame(new User("¬���", "123", 1, 1)).builder();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	
}

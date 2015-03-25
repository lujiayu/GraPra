package com.grapra.view;

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

import com.grapra.bean.Trading;
import com.grapra.bean.User;
import com.grapra.dao.impl.ManagerImpl;

public class ManagerFrame extends JFrame{
	private User user;
	private JPanel leftPane;//��ߴ�Ű�ť�����
	
	private JButton queryTrading;//��ѯ���н��׼�¼
	private JButton queryUser;//��ѯ����ע����û�
	
	private JPanel rightPane;//�ұߴ�����ݵ����
	private JTable table;//�ұ������Ҫʹ�õı��
	
	
	public ManagerFrame(User user) {//���캯��
		this.user = user;
		leftPane = new JPanel();
		
		queryTrading = new JButton("���н���");
		queryUser = new JButton("�û����");
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
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void leftPaneBuilder(){//�������panel������

		leftPane.setBounds(0, 0, 100, 500);
		leftPane.setBackground(Color.gray);
		leftPane.setLayout(null);//ʹ�þ��Բ���
		
		queryTrading.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "����ID", "�鼮ID", "����������","�������" };

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<Trading> tradingList = new ManagerImpl().queryTrading();
					
					for(Trading trading:tradingList){	
						model.addRow(new Object[]{trading.getTradingID(), trading.getBookID(),
								trading.getOwnerID(),trading.getBuyerID()});
					}

				
				table.setBackground(Color.gray);
				table.setBounds(0, 0, 550, 500);

				JScrollPane jsp = new JScrollPane(table);
				jsp.setBounds(0,0,550,500);
				
				rightPane.add(jsp);
				rightPane.validate();
			
			}
			
		});
		queryTrading.setBounds(10, 10, 80, 30);
		
		//��˴���׼�û�
		queryUser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "�û���", "����", "״̬" };

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<User> userList = new ManagerImpl().queryUser();
					
					for(User user:userList){	
						model.addRow(new Object[]{user.getName(),user.getPassword(),"�����"});
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
							
							String userName = (String) tableModel.getValueAt(selectedRowIndex, 0);
							String password = (String) tableModel.getValueAt(selectedRowIndex, 1);
							
							User user = new User();
							user.setName(userName);
							user.setPassword(password);
							user.setType(1);
							new ManagerImpl().updateUserStatu(user);
							
							tableModel.removeRow(selectedRowIndex);
						}
					}
					});
			}
			
		});
		queryUser.setBounds(10, 50, 80, 30);
		
		leftPane.add(queryTrading);
		leftPane.add(queryUser);
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

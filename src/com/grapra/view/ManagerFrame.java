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
	private JPanel leftPane;//左边存放按钮的面板
	
	private JButton queryTrading;//查询所有交易记录
	private JButton queryUser;//查询申请注册的用户
	
	private JPanel rightPane;//右边存放内容的面板
	private JTable table;//右边面板中要使用的表格
	
	
	public ManagerFrame(User user) {//构造函数
		this.user = user;
		leftPane = new JPanel();
		
		queryTrading = new JButton("所有交易");
		queryUser = new JButton("用户审核");
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
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void leftPaneBuilder(){//构建左边panel的属性

		leftPane.setBounds(0, 0, 100, 500);
		leftPane.setBackground(Color.gray);
		leftPane.setLayout(null);//使用绝对布局
		
		queryTrading.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "交易ID", "书籍ID", "卖家人姓名","买家姓名" };

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
		
		//审核待批准用户
		queryUser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "用户名", "密码", "状态" };

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<User> userList = new ManagerImpl().queryUser();
					
					for(User user:userList){	
						model.addRow(new Object[]{user.getName(),user.getPassword(),"待审核"});
					}

				
				table.setBackground(Color.gray);
				table.setBounds(0, 0, 550, 500);

				JScrollPane jsp = new JScrollPane(table);
				jsp.setBounds(0,0,550,500);
				
				rightPane.add(jsp);
				rightPane.validate();
				
				table.addMouseListener(new MouseListener() {
					public void mousePressed(MouseEvent e) {
					    // 鼠标按下时的处理
					}
					public void mouseReleased(MouseEvent e) {
					    // 鼠标松开时的处理
					}
					public void mouseEntered(MouseEvent e) {
					    // 鼠标进入表格时的处理
					}
					public void mouseExited(MouseEvent e) {
					    // 鼠标退出表格时的处理
					}
					public void mouseClicked(MouseEvent e) {
					    // 鼠标点击时的处理
						int selectRows=table.getSelectedRows().length;// 取得用户所选行的行数
						DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
						if(selectRows==1){
							int selectedRowIndex = table.getSelectedRow(); // 取得用户所选单行 
							
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

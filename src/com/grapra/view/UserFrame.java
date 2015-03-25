package com.grapra.view;
/**
 * 普通用户登陆后的界面
 * @author 卢佳瑜
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
import com.grapra.bean.Trading;
import com.grapra.bean.User;
import com.grapra.dao.impl.UserImpl;

public class UserFrame extends JFrame{

	private User user;

	private JPanel leftPane;//左边存放按钮的面板
	private JButton querySelfBooks;//查询自己发布过的图书
	private JButton issueBook;//发布书籍
	private JButton queryOtherBooks;//查询其他人发布的图书
	private JButton queryNeed;//查询需求信息
	private JButton querySelfNeed;//查询自己的需求信息
	private JButton issueNeed;//发布需求信息
	private JButton querySelftrading;//我的交易记录
	private JButton queryDeliver;//获取待发货列表，单击发货
	private JButton queryReceive;//获取待收货列表，单击收货
	
	private JPanel rightPane;//右边存放内容的面板
	private JTable table;//右边面板中要使用的表格
	
	public UserFrame(User user) {//构造函数
		this.user = user;
		leftPane = new JPanel();
		querySelfBooks = new JButton("我发布的书");
		issueBook = new JButton("发布书籍");
		queryOtherBooks = new JButton("书籍列表");
		queryNeed = new JButton("需求列表");
		querySelfNeed = new JButton("我的需求");
		issueNeed = new JButton("发布需求");
		querySelftrading = new JButton("我的交易");
		queryDeliver = new JButton("确认发货");
		queryReceive = new JButton("确认收货");
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
		
		//查询自己发布的书籍列表 按钮--监听事件
		querySelfBooks.addActionListener(new ActionListener(){//为按钮添加监听事件

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				rightPane.removeAll();
				String[] headers = { "书籍ID", "书籍名", "书籍拥有人" ,"书籍状态"};

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
		querySelfBooks.setBounds(10, 10, 80, 30);//设置按钮位置、大小
		
		//发布书籍 按钮--监听事件
		issueBook.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new IssueBookFrame(user.getName());
			}
			
		});
		issueBook.setBounds(10,50,80,30);//设置按钮位置、大小
		
		//查询所有书籍信息、单击购买
		queryOtherBooks.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "书籍ID", "书籍名", "书籍拥有人" ,"书籍状态"};

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
							
							int bookID = (int) tableModel.getValueAt(selectedRowIndex, 0);
							String BookName = (String) tableModel.getValueAt(selectedRowIndex, 1);
							String OwnerName = (String) tableModel.getValueAt(selectedRowIndex, 2);
							
							Book book = new Book(bookID,BookName,OwnerName,"");
							new UserImpl().buyBook(book, user);
							
							System.out.println(bookID+" -- 购买人："+user.getName());
							
							tableModel.removeRow(selectedRowIndex);
						}
					}
					});
			}
			
		});
		queryOtherBooks.setBounds(10,90,80,30);

		//查询需求列表
		queryNeed.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "需求ID", "需求书籍名", "需求人姓名" };

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
		
		//查询自己发布的需求以及删除
		querySelfNeed.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "需求ID", "需求书籍名", "需求人姓名" };

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<Need> needList = new UserImpl().queryNeed(user);
					
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
							
							int needID = (int) tableModel.getValueAt(selectedRowIndex, 0);
							String bookName = (String) tableModel.getValueAt(selectedRowIndex, 1);
							String neederName = (String) tableModel.getValueAt(selectedRowIndex, 2);
							
							Need need = new Need(needID,bookName,neederName);
							new UserImpl().deleteNeed(need);//删除该需求
							
							tableModel.removeRow(selectedRowIndex);
						}
					}
					});
			}
			
		});
		querySelfNeed.setBounds(10,170,80,30);
		
		//发布需求
		issueNeed.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new IssueNeedFrame(user.getName());
			}
			
		});
		issueNeed.setBounds(10, 210, 80, 30);
		
		//自己的交易记录
		querySelftrading.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "交易ID", "书籍ID", "卖家人姓名","买家姓名" };

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<Trading> tradingList = new UserImpl().queryTrading(user);
					
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
		querySelftrading.setBounds(10, 250, 80, 30);
		
		//查询自己没发货的记录，单击确认发货
		queryDeliver.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightPane.removeAll();
				String[] headers = { "交易ID", "书籍ID", "卖家人姓名","买家姓名" };

				DefaultTableModel model = new DefaultTableModel(null, headers){

					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
					table = new JTable(model);
					

					List<Trading> tradingList = new UserImpl().queryDeliverTrading(user);
					

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
							
							int tradingID = (int) tableModel.getValueAt(selectedRowIndex, 0);
							System.out.println(tradingID);
							Trading trading = new Trading(tradingID, -1, "", "", "已发货", "");
							
							new UserImpl().ensureDeliver(trading);
							
							tableModel.removeRow(selectedRowIndex);
						}
					}
					});
			}
			
		});
		queryDeliver.setBounds(10, 290, 80, 30);
		
		//查询自己没收货的纪录，单击确认收货
		queryReceive.addActionListener(new ActionListener(){

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
					

					List<Trading> tradingList = new UserImpl().queryReceiveTrading(user);
					

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
							
							int tradingID = (int) tableModel.getValueAt(selectedRowIndex, 0);
							System.out.println(tradingID);
							Trading trading = new Trading(tradingID, -1, "", "", "已发货", "已收货");
							
							new UserImpl().ensureReceive(trading);
							
							tableModel.removeRow(selectedRowIndex);
						}
					}
					});
			}
			
		});
		queryReceive.setBounds(10,330,80,30);

		
		leftPane.add(querySelfBooks);
		leftPane.add(issueBook);
		leftPane.add(queryOtherBooks);
		leftPane.add(queryNeed);
		leftPane.add(querySelfNeed);
		leftPane.add(issueNeed);
		leftPane.add(querySelftrading);
		leftPane.add(queryDeliver);
		leftPane.add(queryReceive);
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
					new UserFrame(new User("管理员", "123", 1, 1)).builder();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	
}

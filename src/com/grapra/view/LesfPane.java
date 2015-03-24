package com.grapra.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;


public class LesfPane extends JPanel{


		private JTree tree;
		private JPanel  contentPane;//装载Jtree的容器
		private JScrollPane scrollPane;
		
	   public LesfPane(JTree tree2) {
		   tree = tree2;
		   CreateTree();
		   Font newFont =  new Font("Serif", Font.BOLD, 18);
		   tree.setFont(newFont);
		   DefaultTreeCellRenderer cellRender = (DefaultTreeCellRenderer)tree.getCellRenderer();
		   cellRender.setFont(newFont); 
		   cellRender.setBackgroundSelectionColor(new Color(235, 235, 235));
		   
		
		}

	    //创建一颗树
	    public void CreateTree(){
	    	 contentPane=new JPanel();
	    	
	    	 DefaultMutableTreeNode root = new DefaultMutableTreeNode();
	    	 
	         //子节点
	    	 DefaultMutableTreeNode applyProject = new DefaultMutableTreeNode("申报项目");
	         DefaultMutableTreeNode project = new DefaultMutableTreeNode(" 项  目  ");
	         DefaultMutableTreeNode performance = new DefaultMutableTreeNode(" 绩  效  ");
	         DefaultMutableTreeNode assort = new DefaultMutableTreeNode(" 配  套");
	         DefaultMutableTreeNode fundAndEnd = new DefaultMutableTreeNode(" 经费与结题 ");
	         DefaultMutableTreeNode baseUpdate = new DefaultMutableTreeNode(" 基础数据 ");
	         DefaultMutableTreeNode rule = new DefaultMutableTreeNode(" 规 则 ");
	         DefaultMutableTreeNode getData = new DefaultMutableTreeNode(" 数据导入 ");
	         DefaultMutableTreeNode getDataImage = new DefaultMutableTreeNode(" 统计分析 ");
	         
	         
	         //定义tree模型
	         DefaultTreeModel treeModel = new DefaultTreeModel(root);
	         //将子节点加入根节点
	         treeModel.insertNodeInto(applyProject, root, root.getChildCount());
	         treeModel.insertNodeInto(project, root, root.getChildCount());
	         treeModel.insertNodeInto(performance, root, root.getChildCount());
	         treeModel.insertNodeInto(assort, root, root.getChildCount());
	         treeModel.insertNodeInto(fundAndEnd, root, root.getChildCount());
	         treeModel.insertNodeInto(baseUpdate, root, root.getChildCount());
	         treeModel.insertNodeInto(getData, root, root.getChildCount());
	         treeModel.insertNodeInto(rule, root, root.getChildCount());
	         treeModel.insertNodeInto(getDataImage, root, root.getChildCount());
	        
	         //申报项目节点/编辑节点s
	         DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("申报项目编辑");
	         treeModel.insertNodeInto(leafnode, applyProject, applyProject.getChildCount());
	         DefaultMutableTreeNode leafnode1 = new DefaultMutableTreeNode("新建申报项目");
	         leafnode.add(leafnode1);
	         DefaultMutableTreeNode leafnode2 = new DefaultMutableTreeNode("编辑申报项目");
	         leafnode.add(leafnode2);
	         
	         //项目统计节点
	         leafnode = new DefaultMutableTreeNode("申报项目统计");
	         treeModel.insertNodeInto(leafnode, applyProject, applyProject.getChildCount());
	         
	         
	         //项目节点/编辑节点s
	         leafnode = new DefaultMutableTreeNode("项目编辑");
	         treeModel.insertNodeInto(leafnode, project, project.getChildCount());
	         leafnode1 = new DefaultMutableTreeNode("新建项目");
	         leafnode.add(leafnode1);
	         leafnode2 = new DefaultMutableTreeNode("编辑项目");
	         leafnode.add(leafnode2);
	         
	         //项目统计节点
	         leafnode = new DefaultMutableTreeNode("项目统计");
	         treeModel.insertNodeInto(leafnode, project, project.getChildCount());
	         
	         //绩效节点
	         leafnode = new DefaultMutableTreeNode("绩效编辑");
	         treeModel.insertNodeInto(leafnode, performance, performance.getChildCount());
	         leafnode = new DefaultMutableTreeNode("绩效统计");
	         treeModel.insertNodeInto(leafnode, performance, performance.getChildCount());
	         leafnode = new DefaultMutableTreeNode("绩效下放");
	         treeModel.insertNodeInto(leafnode, performance, performance.getChildCount());
	         leafnode = new DefaultMutableTreeNode("绩效导出");
	         treeModel.insertNodeInto(leafnode, performance, performance.getChildCount());
	         
	         //配套节点
	         leafnode = new DefaultMutableTreeNode("配套编辑");
	         treeModel.insertNodeInto(leafnode, assort, assort.getChildCount());
	         leafnode = new DefaultMutableTreeNode("配套统计");
	         treeModel.insertNodeInto(leafnode, assort, assort.getChildCount());
	         leafnode = new DefaultMutableTreeNode("配套下发");
	         treeModel.insertNodeInto(leafnode, assort, assort.getChildCount());
	         
	         //其它节点
	         leafnode = new DefaultMutableTreeNode("经费到账");
	         treeModel.insertNodeInto(leafnode, fundAndEnd, fundAndEnd.getChildCount());
	         leafnode = new DefaultMutableTreeNode("结题登记");
	         treeModel.insertNodeInto(leafnode, fundAndEnd, fundAndEnd.getChildCount());
	         leafnode = new DefaultMutableTreeNode("人员变动");
	         treeModel.insertNodeInto(leafnode, baseUpdate, baseUpdate.getChildCount());
	         leafnode = new DefaultMutableTreeNode("学院变动");
	         treeModel.insertNodeInto(leafnode, baseUpdate, baseUpdate.getChildCount());
	         leafnode = new DefaultMutableTreeNode("团队变动");
	         treeModel.insertNodeInto(leafnode, baseUpdate, baseUpdate.getChildCount());
	         leafnode = new DefaultMutableTreeNode("绩效规则变动");
	         treeModel.insertNodeInto(leafnode, rule, rule.getChildCount());
	         leafnode = new DefaultMutableTreeNode("配套规则变动");
	         treeModel.insertNodeInto(leafnode, rule, rule.getChildCount());
	         leafnode = new DefaultMutableTreeNode("项目信息导入");
	         treeModel.insertNodeInto(leafnode, getData, getData.getChildCount());
	         leafnode = new DefaultMutableTreeNode("申报项目信息导入");
	         treeModel.insertNodeInto(leafnode, getData, getData.getChildCount());
	         leafnode = new DefaultMutableTreeNode("配套信息导入");
	         treeModel.insertNodeInto(leafnode, getData, getData.getChildCount());
	         
	         leafnode = new DefaultMutableTreeNode("学校分析");
	         treeModel.insertNodeInto(leafnode,  getDataImage,  getDataImage.getChildCount());
	         leafnode = new DefaultMutableTreeNode("学院分析");
	         treeModel.insertNodeInto(leafnode,  getDataImage,  getDataImage.getChildCount());
	         leafnode = new DefaultMutableTreeNode("团队分析");
	         treeModel.insertNodeInto(leafnode,  getDataImage,  getDataImage.getChildCount());
	         leafnode = new DefaultMutableTreeNode("个人分析");
	         treeModel.insertNodeInto(leafnode,  getDataImage,  getDataImage.getChildCount());
	        
	         //定义一棵树将模型放入 
	         tree.setModel((treeModel));
	         tree.setRootVisible(false);
	         tree.setRowHeight(20);
	         
	         DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer)tree.getCellRenderer();
	         
	         cellRenderer.putClientProperty("JTree.lineStyle","Angled");//设置是否有分割线
//	        cellRenderer.setLeafIcon(new ImageIcon("Img/4.png"));
//	        cellRenderer.setOpenIcon(new ImageIcon("Img/2.png"));
//	        cellRenderer.setClosedIcon(new ImageIcon("Img/3.png"));
//	         
	         //设置节点字体的格式 
	         cellRenderer.setFont(new Font("幼圆", 1, 20));
	         cellRenderer.setBackgroundNonSelectionColor(new Color(250, 250, 250));
	         cellRenderer.setBackgroundSelectionColor(Color.yellow);
	         cellRenderer.setBorderSelectionColor(Color.red);
	         cellRenderer.setTextSelectionColor(Color.blue);
	         
	         
	         
	         tree.setRowHeight(25);
	         tree.setShowsRootHandles(true);
	         tree.setBackground( new Color(250, 250, 250));
	         tree.setOpaque(true);
	 
	         scrollPane = new JScrollPane(tree);

	         scrollPane.setBounds(0,0,500, 400 );
	         
//	         contentPane.setSize(400, 500);
//	         tree.setBounds(0, 0, 200, 500);
	         scrollPane.setPreferredSize(new Dimension(200,500));
	         contentPane.add(scrollPane);
	         contentPane.setBounds(0, 0, 200, 500);
	         contentPane.setSize(200, 500);
	         
	         this.add(contentPane);
	    	
	    }


}

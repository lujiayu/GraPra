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
		private JPanel  contentPane;//װ��Jtree������
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

	    //����һ����
	    public void CreateTree(){
	    	 contentPane=new JPanel();
	    	
	    	 DefaultMutableTreeNode root = new DefaultMutableTreeNode();
	    	 
	         //�ӽڵ�
	    	 DefaultMutableTreeNode applyProject = new DefaultMutableTreeNode("�걨��Ŀ");
	         DefaultMutableTreeNode project = new DefaultMutableTreeNode(" ��  Ŀ  ");
	         DefaultMutableTreeNode performance = new DefaultMutableTreeNode(" ��  Ч  ");
	         DefaultMutableTreeNode assort = new DefaultMutableTreeNode(" ��  ��");
	         DefaultMutableTreeNode fundAndEnd = new DefaultMutableTreeNode(" ��������� ");
	         DefaultMutableTreeNode baseUpdate = new DefaultMutableTreeNode(" �������� ");
	         DefaultMutableTreeNode rule = new DefaultMutableTreeNode(" �� �� ");
	         DefaultMutableTreeNode getData = new DefaultMutableTreeNode(" ���ݵ��� ");
	         DefaultMutableTreeNode getDataImage = new DefaultMutableTreeNode(" ͳ�Ʒ��� ");
	         
	         
	         //����treeģ��
	         DefaultTreeModel treeModel = new DefaultTreeModel(root);
	         //���ӽڵ������ڵ�
	         treeModel.insertNodeInto(applyProject, root, root.getChildCount());
	         treeModel.insertNodeInto(project, root, root.getChildCount());
	         treeModel.insertNodeInto(performance, root, root.getChildCount());
	         treeModel.insertNodeInto(assort, root, root.getChildCount());
	         treeModel.insertNodeInto(fundAndEnd, root, root.getChildCount());
	         treeModel.insertNodeInto(baseUpdate, root, root.getChildCount());
	         treeModel.insertNodeInto(getData, root, root.getChildCount());
	         treeModel.insertNodeInto(rule, root, root.getChildCount());
	         treeModel.insertNodeInto(getDataImage, root, root.getChildCount());
	        
	         //�걨��Ŀ�ڵ�/�༭�ڵ�s
	         DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("�걨��Ŀ�༭");
	         treeModel.insertNodeInto(leafnode, applyProject, applyProject.getChildCount());
	         DefaultMutableTreeNode leafnode1 = new DefaultMutableTreeNode("�½��걨��Ŀ");
	         leafnode.add(leafnode1);
	         DefaultMutableTreeNode leafnode2 = new DefaultMutableTreeNode("�༭�걨��Ŀ");
	         leafnode.add(leafnode2);
	         
	         //��Ŀͳ�ƽڵ�
	         leafnode = new DefaultMutableTreeNode("�걨��Ŀͳ��");
	         treeModel.insertNodeInto(leafnode, applyProject, applyProject.getChildCount());
	         
	         
	         //��Ŀ�ڵ�/�༭�ڵ�s
	         leafnode = new DefaultMutableTreeNode("��Ŀ�༭");
	         treeModel.insertNodeInto(leafnode, project, project.getChildCount());
	         leafnode1 = new DefaultMutableTreeNode("�½���Ŀ");
	         leafnode.add(leafnode1);
	         leafnode2 = new DefaultMutableTreeNode("�༭��Ŀ");
	         leafnode.add(leafnode2);
	         
	         //��Ŀͳ�ƽڵ�
	         leafnode = new DefaultMutableTreeNode("��Ŀͳ��");
	         treeModel.insertNodeInto(leafnode, project, project.getChildCount());
	         
	         //��Ч�ڵ�
	         leafnode = new DefaultMutableTreeNode("��Ч�༭");
	         treeModel.insertNodeInto(leafnode, performance, performance.getChildCount());
	         leafnode = new DefaultMutableTreeNode("��Чͳ��");
	         treeModel.insertNodeInto(leafnode, performance, performance.getChildCount());
	         leafnode = new DefaultMutableTreeNode("��Ч�·�");
	         treeModel.insertNodeInto(leafnode, performance, performance.getChildCount());
	         leafnode = new DefaultMutableTreeNode("��Ч����");
	         treeModel.insertNodeInto(leafnode, performance, performance.getChildCount());
	         
	         //���׽ڵ�
	         leafnode = new DefaultMutableTreeNode("���ױ༭");
	         treeModel.insertNodeInto(leafnode, assort, assort.getChildCount());
	         leafnode = new DefaultMutableTreeNode("����ͳ��");
	         treeModel.insertNodeInto(leafnode, assort, assort.getChildCount());
	         leafnode = new DefaultMutableTreeNode("�����·�");
	         treeModel.insertNodeInto(leafnode, assort, assort.getChildCount());
	         
	         //�����ڵ�
	         leafnode = new DefaultMutableTreeNode("���ѵ���");
	         treeModel.insertNodeInto(leafnode, fundAndEnd, fundAndEnd.getChildCount());
	         leafnode = new DefaultMutableTreeNode("����Ǽ�");
	         treeModel.insertNodeInto(leafnode, fundAndEnd, fundAndEnd.getChildCount());
	         leafnode = new DefaultMutableTreeNode("��Ա�䶯");
	         treeModel.insertNodeInto(leafnode, baseUpdate, baseUpdate.getChildCount());
	         leafnode = new DefaultMutableTreeNode("ѧԺ�䶯");
	         treeModel.insertNodeInto(leafnode, baseUpdate, baseUpdate.getChildCount());
	         leafnode = new DefaultMutableTreeNode("�Ŷӱ䶯");
	         treeModel.insertNodeInto(leafnode, baseUpdate, baseUpdate.getChildCount());
	         leafnode = new DefaultMutableTreeNode("��Ч����䶯");
	         treeModel.insertNodeInto(leafnode, rule, rule.getChildCount());
	         leafnode = new DefaultMutableTreeNode("���׹���䶯");
	         treeModel.insertNodeInto(leafnode, rule, rule.getChildCount());
	         leafnode = new DefaultMutableTreeNode("��Ŀ��Ϣ����");
	         treeModel.insertNodeInto(leafnode, getData, getData.getChildCount());
	         leafnode = new DefaultMutableTreeNode("�걨��Ŀ��Ϣ����");
	         treeModel.insertNodeInto(leafnode, getData, getData.getChildCount());
	         leafnode = new DefaultMutableTreeNode("������Ϣ����");
	         treeModel.insertNodeInto(leafnode, getData, getData.getChildCount());
	         
	         leafnode = new DefaultMutableTreeNode("ѧУ����");
	         treeModel.insertNodeInto(leafnode,  getDataImage,  getDataImage.getChildCount());
	         leafnode = new DefaultMutableTreeNode("ѧԺ����");
	         treeModel.insertNodeInto(leafnode,  getDataImage,  getDataImage.getChildCount());
	         leafnode = new DefaultMutableTreeNode("�Ŷӷ���");
	         treeModel.insertNodeInto(leafnode,  getDataImage,  getDataImage.getChildCount());
	         leafnode = new DefaultMutableTreeNode("���˷���");
	         treeModel.insertNodeInto(leafnode,  getDataImage,  getDataImage.getChildCount());
	        
	         //����һ������ģ�ͷ��� 
	         tree.setModel((treeModel));
	         tree.setRootVisible(false);
	         tree.setRowHeight(20);
	         
	         DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer)tree.getCellRenderer();
	         
	         cellRenderer.putClientProperty("JTree.lineStyle","Angled");//�����Ƿ��зָ���
//	        cellRenderer.setLeafIcon(new ImageIcon("Img/4.png"));
//	        cellRenderer.setOpenIcon(new ImageIcon("Img/2.png"));
//	        cellRenderer.setClosedIcon(new ImageIcon("Img/3.png"));
//	         
	         //���ýڵ�����ĸ�ʽ 
	         cellRenderer.setFont(new Font("��Բ", 1, 20));
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

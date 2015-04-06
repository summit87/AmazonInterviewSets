package amazon.AllRounds;

import java.io.File;
import java.util.Scanner;

public class TreeCreation {
	
	
	public TreeNode create(String fileName){
		try{
			Scanner sc = new Scanner(new File(fileName));
			String[] st = sc.next().split(",");
			TreeNode tree = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				tree = createTree(tree,data);
			}
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	public void inOrder(TreeNode tree){
		if(tree == null){
			return;
		}
		if(tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getData()+",");
			inOrder(tree.getRight());
		}
	}
	
	
	public TreeNode createTree(TreeNode tree,int data){
		try{
			TreeNode root = new TreeNode(data);
			if(tree == null){
				tree = root;
				return tree;
			}
			if(data > tree.getData()){
				tree.setRight(createTree(tree.getRight(), data));
			}else if(data < tree.getData()){
				tree.setLeft(createTree(tree.getLeft(), data));
			}
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}

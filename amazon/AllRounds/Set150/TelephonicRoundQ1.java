package amazon.AllRounds.Set150;

import amazon.AllRounds.TreeCreation;
import amazon.AllRounds.TreeNode;

public class TelephonicRoundQ1 {

	/**
	 * @param args
	 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
	 */
	public static void main(String[] args) {
		try{
			String fileName = "tree.txt";
			String fileName1 = "tree1.txt";
			TreeCreation treeCreation = new TreeCreation();
			TreeNode tree = treeCreation.create(fileName);
			//treeCreation.inOrder(tree);
			//System.out.println();
			TreeCreation treeCreation1 = new TreeCreation();
			TreeNode tree1 = treeCreation1.create(fileName1);
			//treeCreation.inOrder(tree1);
			System.out.println();
			boolean b = new TelephonicRoundQ1().isIdenticalTree(tree, tree1);
			if(b){
				System.out.println("Identical");
			}else{
				System.out.println("Not Identical");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public boolean isIdenticalTree(TreeNode tree,TreeNode tree1){
		try{
			if(tree == null && tree1 == null){
				return true;
			}
			if(tree == null || tree1 == null){
				return false;
			}
			return ((tree.getData() == tree1.getData()) && 
					(isIdenticalTree(tree.getLeft(), tree1.getLeft()))&&
					(isIdenticalTree(tree.getRight(), tree1.getRight())));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
}

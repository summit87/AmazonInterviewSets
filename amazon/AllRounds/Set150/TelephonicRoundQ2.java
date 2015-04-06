package amazon.AllRounds.Set150;

import amazon.AllRounds.BinaryTree;
import amazon.AllRounds.TreeNode;

public class TelephonicRoundQ2 {

	/**
	 * @param args
	 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
	 */
	public static void main(String[] args) {
		try{
			TelephonicRoundQ2 te = new TelephonicRoundQ2();
			BinaryTree bt = new BinaryTree();
			TreeNode tree = null;
			tree = new BinaryTree().createBT(tree);
			bt.inOrder(tree);
			te.treeSum(tree);
			System.out.println();
			bt.inOrder(tree);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private int treeSum(TreeNode bt){
		try{
			if(bt == null){
				return 0;
			}
			int oldData = bt.getData();
			bt.setData(treeSum(bt.getLeft())+treeSum(bt.getRight()));
			return oldData+bt.getData();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}

package amazon.AllRounds;

public class BinaryTree {


	public TreeNode createBT(TreeNode tree){
		try{
			tree = new TreeNode(10);
			tree.setLeft(new TreeNode(-2));
			tree.setRight(new TreeNode(6));
			tree.getLeft().setLeft(new TreeNode(8));
			tree.getLeft().setRight(new TreeNode(-4));
			tree.getRight().setRight(new TreeNode(5));
			tree.getRight().setLeft(new TreeNode(7));
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public void inOrder(TreeNode tree){
		try{
			if(tree != null){
				inOrder(tree.getLeft());
				System.out.print(tree.getData()+",");
				inOrder(tree.getRight());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}

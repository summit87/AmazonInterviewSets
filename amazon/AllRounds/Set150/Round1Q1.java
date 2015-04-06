package amazon.AllRounds.Set150;

import java.util.LinkedList;
import java.util.Queue;

import amazon.AllRounds.BinaryTree;
import amazon.AllRounds.TreeNode;

public class Round1Q1 {

	/**
	 * @param args
	 *  http://www.geeksforgeeks.org/print-left-view-binary-tree/
	 */
	static int max = 0;
	public static void main(String[] args) {
		try{
			Round1Q1 rq1 = new Round1Q1();
			TreeNode tree = null;
			tree = new BinaryTree().createBT(tree);
			rq1.letfViewByLevelOrderTraversal(tree);
			System.out.println();
			rq1.rightViewByLevelOrderTraversal(tree);
			System.out.println("\nBy Recursion : ");
			rq1.leftViewByRecursion(tree,1);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void letfViewByLevelOrderTraversal(TreeNode tree){
		try{
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			TreeNode tn = tree;
			q.add(tn);
			while(true){
				int n = q.size();
				int k = n;
				boolean flag = true;
				if(n == 0){
					break;
				}
				while(n > 0){
					tn = q.peek();q.poll();
					if(n == k && flag){
						System.out.print(tn.getData()+",");
					}
					if(tn.getLeft()!=null){
						q.add(tn.getLeft());
						flag = true;
					}
					if(tn.getRight() != null){
						q.add(tn.getRight());
						flag = false;
					}
					n--;
				}
			}
		}catch(Exception ex){
			
		}
	}
	
	private void rightViewByLevelOrderTraversal(TreeNode tree){
		try{
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			TreeNode tn = tree;
			q.add(tn);
			while(true){
				int n = q.size();
				int k = n;
				boolean flag = false;
				if(n == 0){
					break;
				}
				while(n > 0){
					tn = q.peek();q.poll();
					if(tn.getLeft()!=null){
						q.add(tn.getLeft());
						flag = true;
					}
					if(tn.getRight() != null){
						q.add(tn.getRight());
						flag = false;
					}
					n--;
					if(n == 0 && !flag){
						System.out.print(tn.getData()+",");
					}
				}
			}
		}catch(Exception ex){
			
		}
	}
	
	
	private void leftViewByRecursion(TreeNode tn,int level){
		try{
			if(tn == null){
				return;
			}
			if(max < level){
				System.out.print(tn.getData()+",");
				max = level;
			}
			leftViewByRecursion(tn.getLeft(), level+1);
			leftViewByRecursion(tn.getRight(),level+1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}

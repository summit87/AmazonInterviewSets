package amazon.AllRounds;

import java.util.HashMap;

public class TrieNode {

	
	private char val;
	private boolean isEnd;
	private int count = 0;
	private HashMap<Character,TrieNode> child;
	public TrieNode(char val){
		this.val = val;
		this.child = new HashMap<Character, TrieNode>();
		this.isEnd = false;
		this.count = 0;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	public void setVal(char val){
		this.val = val;
	}
	public void setChild(HashMap<Character,TrieNode> child){
		this.child = child;
	}
	public void setEnd(boolean isEnd){
		this.isEnd = isEnd;
	}
	public int getCount(){
		return count;
	}
	public boolean isEnd(){
		return isEnd;
	}
	public HashMap<Character,TrieNode> getChild(){
		return child;
	}
	
	
	
}

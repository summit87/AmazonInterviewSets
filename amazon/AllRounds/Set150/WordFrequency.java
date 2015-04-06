package amazon.AllRounds.Set150;

import java.util.*;

import amazon.AllRounds.TrieNode;
public class WordFrequency {
static TrieNode trieNode;

public static void main(String[] args) {
	try{
		WordFrequency wordFre = new WordFrequency();
		String st = "sumit kumar kesar mydad kesar kesar mydad mymom myvillgae";
		HashSet<String> dict = new HashSet<String>();
		dict.add("sumit");
		dict.add("kumar");
		dict.add("kesar");
		dict.add("mydad");
		for(String word : st.split(" ")){
			wordFre.insert(word, dict);
		}
		int count = wordFre.search("kesar", dict);
		System.out.println(count);
	}catch(Exception ex){
		ex.printStackTrace();
	}
}
public WordFrequency(){
	trieNode = new TrieNode((char)0);
}
public void insert(String word,HashSet<String> dict){
	try{
		TrieNode trie = trieNode;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<word.length();i++){
			HashMap<Character,TrieNode> child = trie.getChild();
			char ch = word.charAt(i);
			sb = sb.append(ch);
			if(child.containsKey(ch)){
				trie = child.get(ch);
			}else{
				TrieNode tr = new TrieNode(ch);
				child.put(ch,tr);
				trie = tr;
			}
		}
		int count = 0;
		if(dict.contains(sb.toString())){
			if(trie.isEnd()){
				count = trie.getCount();
				count++;
				trie.setCount(count);
			}else{
				trie.setEnd(true);
				trie.setCount(1);;
			}
		}
	}catch(Exception ex){
		ex.printStackTrace();
	}
}
	public int search(String word,HashSet<String> dict){
	try{
		TrieNode trie = trieNode;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<word.length();i++){
			HashMap<Character,TrieNode> child = trie.getChild();
			char ch = word.charAt(i);
			sb = sb.append(ch);
			if(child.containsKey(ch)){
				trie = child.get(ch);
			}
		}
		if(trie.isEnd()){
			return trie.getCount();
		}else{
			return -1;
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}

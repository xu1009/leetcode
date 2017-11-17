package test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {
	public static void main(String[] args){
		WordSerach wordSerach = new WordSerach();
//		char[][] board = {{'A','B'},{'C','D'}};
//		boolean res = wordSerach.existsWord(board, "ABCD");
		List<Integer> res = new ArrayList<>();
		List<Integer> colRecord = new ArrayList<>();
		colRecord.add(Integer.MAX_VALUE);
		wordSerach.backingQueens(0, 4, res, colRecord);
		System.out.println(res);
	}
}
class WordDictionary {

	private Node root;
	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new Node();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		insert(this.root, word);

	}
	private void insert(Node root, String word){
		char[] temp = word.toLowerCase().toCharArray();
		for (int i = 0; i < temp.length; i++){
			int index = temp[i] - 'a';
			if (root.childs[index] == null){
				root.childs[index] = new Node();
				root.childs[index].prefixNum++;
			}else {
				root.childs[index].prefixNum++;
			}
			root = root.childs[index];
		}
		root.isLeaf = true;
		root.dumpNum++;
	}

	private boolean serach(char[] chs, int k, Node root){
		if (k == chs.length)return root.isLeaf;
		if (chs[k] != '.'){
			return root.childs[chs[k] - 'a'] != null && serach(chs, k + 1, root.childs[chs[k] - 'a']);
		}else {
			for (int i = 0; i < root.childs.length; i++){
				if (root.childs[i] != null){
					if (serach(chs, k + 1, root.childs[i])){
						return true;
					}
				}
			}

		}
		return false;
	}




	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return serach(word.toCharArray(), 0, root);
	}
}

class Node{
	 boolean isLeaf;
	 Node[] childs;
	 int prefixNum;
	 int dumpNum;
	public Node() {
		prefixNum = 0;
		dumpNum = 0;
		isLeaf = false;
		childs = new Node[26];
	}
}
class WordSerach{
	static boolean[][] used;
	public boolean existsWord(char[][] board, String word){
	    used = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if((word.charAt(0) == board[i][j]) && backingWord(board, word, 0, i, j, used)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean backingWord(char[][] board, String word, int index, int row, int col, boolean[][] used){
		if (index == word.length()) return true;
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(index) != board[row][col] || used[row][col])return false;
		used[row][col] = true;
		if (backingWord(board, word, index + 1, row - 1, col, used) || backingWord(board, word, index + 1, row + 1, col, used)
				||backingWord(board, word, index + 1, row, col - 1, used) || backingWord(board, word, index + 1, row, col + 1, used)){
			return true;
		}
		used[row][col] = true;
		return false;
	}

	public boolean backingWordSerach(char[][] board, int i, int j, int index, String word, boolean[][] used){
		if (index == word.length())return true;
		if (i < 0 || i >= board.length || j < 0 || j > board[0].length || word.charAt(index) != board[i][j] || used[i][j])return false;
		used[i][j] = true;
		if (backingWordSerach(board, i - 1, j, index + 1, word, used)
			|| backingWordSerach(board, i + 1, j, index + 1, word, used)
			|| backingWordSerach(board, i, j - 1, index + 1, word, used)
			|| backingWordSerach(board, i, j + 1, index + 1, word, used)){
			return true;
		}
		used[i][j] = false;
		return false;
	}



	public TrieNode buildNode(String[] words){
		TrieNode root = new TrieNode();
		for (String word : words){
			for (int i = 0; i < word.length(); i++){
				if (root.next[word.charAt(i) - 'a']  == null)root.next[word.charAt(i) - 'a'] = new TrieNode();
				root = root.next[word.charAt(i) - 'a'];
			}
			root.word = word;
		}
		return root;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
 // set every ele to begin word and backtracking
	public void backingSerach(char[][] board, int i, int j, TrieNode root, List<String> res){
		char c = board[i][j];
		if (board[i][j] == '#' || root.next[c - 'a'] == null)return;
		root = root.next[c - 'a'];
		if (root.word != null){
			res.add(root.word);
			root.word = null;
		}
		board[i][j] = '#';
		if (i > 0)backingSerach(board, i - 1, j, root, res);
		if (j > 0)backingSerach(board, i, j - 1, root, res);
		if (i < board.length)backingSerach(board, i + 1, j, root, res);
		if (j < board[0].length)backingSerach(board, i, j + 1, root, res);
		board[i][j] = c;
	}

	public void backingQueens(int row, int n, List<Integer> res, List<Integer> lastCol){
		if (res.size() == n){
			String temp = StringUtils.join(res, ",");
			System.out.println(temp);
			return;
		}
		for (int i = row; i < n; i++){
			for (int j = 0; j < n; j++){
				if (!lastCol.contains(j) && j != lastCol.get(lastCol.size() - 1) + 1 && j != lastCol.get(lastCol.size() - 1) - 1){
					res.add(j);
					lastCol.add(j);
					backingQueens(row + 1, n, res, lastCol);
					res.remove(res.size() - 1);
					lastCol.remove(lastCol.size() - 1);
				}
			}
		}
	}
}

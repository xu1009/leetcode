package test;

/**
 * prefix tree 字典树，前缀树
 */
public class Trie {
	private Node root;
	private class Node{
		private int dumpli_num;
		private int prefix_num;
		private Node[] childs;
		private boolean isLeaf;
		Node() {
			dumpli_num = 0;
			prefix_num = 0;
			isLeaf = false;
			childs = new Node[26];  // 26 a-z
		}
	}

	public Trie() {
		root = new Node();
	}

	public void insert(String words){
		insert(this.root, words);
	}
	private void insert(Node root, String words){
		if (words == null || words.length() == 0){
			return;
		}
		words = words.toLowerCase();
		char[] temp = words.toCharArray();
		for (int i = 0; i < temp.length; i++){
			int index = temp[i];
			if (root.childs[index] != null){
				root.childs[index].prefix_num++;
			}else {
				root.childs[index] = new Node();
				root.childs[index].prefix_num++;  // 当前元素
			}

			if (i == temp.length - 1){
				root.childs[index].isLeaf = true;
				root.childs[index].dumpli_num++;
			}
			root = root.childs[index];  // next root
		}
	}

	private boolean serach(String words){
		Node temp = serach(this.root, words);
		return temp != null && temp.isLeaf;
	}
	private boolean startWith(String words){
		Node temp = serach(root, words);
		return temp != null;
	}

	private Node serach(Node root, String words){
		char[] strs = words.toLowerCase().toCharArray();
		for (int i = 0; i < strs.length; i++){
			int index = strs[i] - 'a';
			if (root.childs[index] == null){
				return null;
			}
			root = root.childs[index];
		}
		return root;
	}

}

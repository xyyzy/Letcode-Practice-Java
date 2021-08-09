package 最热100题._208_实现Trie前缀树;

/**
 * @description: TODO
 * @author: ares
 * @modified By: ares
 * @date: Created in 2021/7/21 16:07
 * @version:v1.0
 */
public class Trie {

    private TrieNode root;

    class TrieNode {

        private boolean isEnd;
        TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            trieNode = trieNode.next[c - 'a'];
            if (trieNode == null) {
                return false;
            }
        }
        return trieNode.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (char c : prefix.toCharArray()) {
            trieNode = trieNode.next[c - 'a'];
            if (trieNode == null) {
                return false;
            }
        }
        return true;
    }

}

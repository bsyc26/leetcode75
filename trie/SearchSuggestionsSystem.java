// leetcode 1268
// trie + dfs
// T: O(N)
// S: O(N)

import java.util.List;
import java.util.ArrayList;

class Trie {

    // nested class
    private static class Node {
        boolean isWord = false;
        Node[] next = new Node[26];
    }

    // fields
    private Node root = new Node();
    private List<String> match3 = new ArrayList<>();

    // create method
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.next[i] == null)
                node.next[i] = new Node();
            node = node.next[i];
        }
        node.isWord = true;
    }

    // read method
    public void dfs(Node node, String word) {
        // base case
        if (match3.size() == 3)
            return;
        if (node.isWord)
            match3.add(word);
        // traverse
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.next[c-'a'] != null)
                dfs(node.next[c-'a'], word+c);
        }
    }

    public List<String> getStartsWith(String prefix) {
        Node node = root;
        match3 = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.next[i] == null)
                return match3;
            node = node.next[i];
        }
        dfs(node, prefix);
        return match3;
    }

}

class Solution {

    /** Return a list of lists which contains lexicographically increasing three products
      * for every char of searchWord is inputed */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // res
        List<List<String>> res = new ArrayList<>();
        // DS - trie
        Trie trie = new Trie();
        // add all products
        for (String product : products)
            trie.insert(product);
        // var
        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            res.add(trie.getStartsWith(sb.toString()));
        }
        // return res
        return res;
    }
}

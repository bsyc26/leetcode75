// leetcode 208
// trie
// T: O(N)
// S: O(N)

class Trie {

    // fields
    private static final int R = 26; // English letters
    private int size;
    private Node root;

    // nested class
    private static class Node {
        Node[] next = new Node[R];
        boolean isWord= false;
    }
    
    // constructor
    public Trie() {
        size = 0;
        root = new Node();
    }
    
    // create methods
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

    // read methods
    public boolean search(String word) {
        Node target = get(word); 
        return target != null && target.isWord;
    }

    public boolean startsWith(String prefix) {
        return get(prefix) != null;
    }

    private Node get(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.next[i] == null)
                return null;
            node = node.next[i];
        }
        return node;
    }

}

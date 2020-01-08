package _07_str;

import java.util.Arrays;

public class MyTrieTree {

    private MyTrieNode root;

    static class MyTrieNode {
        int value;
        MyTrieNode[] children;
        boolean isEnd;

        MyTrieNode(int value) {
            this.value = value;
            this.children = new MyTrieNode[26];
            this.isEnd = false;
        }
    }

    public MyTrieTree() {
        this.root = new MyTrieNode('/');
    }

    public void insert(String text) {
        char[] c = text.toCharArray();
        MyTrieNode p = root;
        for (int i = 0; i < c.length; i++) {
            int index = c[i]-'a';
            if (p.children[index] == null) {
                p.children[index] = new MyTrieNode(c[i]);
            }
            p = p.children[index];
        }
        p.isEnd = true;
    }

    public boolean find(String pattern) {
        char[] c = pattern.toCharArray();
        MyTrieNode p = root;
        for (int i = 0; i < c.length; i++) {
            int index = c[i]-'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEnd;
    }

    public static void main(String[] args) {
        var strs = new String[] {"how", "hi", "her", "hello", "so", "see"};
        var trieTree = new MyTrieTree();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            trieTree.insert(str);
        }

        System.out.println(trieTree.find("good"));
        System.out.println(trieTree.find("hello"));
    }
}

package Trie;


public class TrieImp {
    public static void main(String[] args) {

        String[] dictionary = {"Mode", "Module", "Modulus", "Morning", "Mowing"};


        Trie trie = new Trie();

        for (String i : dictionary)
            trie.put(i);

        trie.contains("Modes");
        trie.longestPrefix();
//        trie.print();
    }

    private static class Trie {
        private int MAX = 26;
        private Node root;

        Trie() {
            root = new Node();
        }

        private class Node {
            boolean isLeaf;
            Node[] links = new Node[MAX];

            Node() {
                this.isLeaf = false;
                for (int i = 0; i < MAX; i++)
                    links[i] = null;
            }
        }

        void print() {
//            print(root);
        }

        void put(String key) {
            key = key.toLowerCase();
            if (key.isEmpty()) throw new RuntimeException("Key is empty");
            insert(key);
        }

        void contains(String key) {
            key = key.toLowerCase();
            if (key.isEmpty()) throw new RuntimeException("Key is empty");
            if (getKey(key))
                System.out.println("contains " + key);
            else System.out.println("does not contain " + key);
        }

        private void insert(String key) {
            Node current = root;
            for (int i = 0; i < key.length(); i++) {
                int charIndex = key.charAt(i) - 'a';

//                System.out.println(charIndex);
                if (current.links[charIndex] == null) {
                    current.links[charIndex] = new Node();
                }
                current = current.links[charIndex];
            }
            current.isLeaf = true;
        }

        private boolean getKey(String key) {
            Node current = root;
            for (int i = 0; i < key.length(); i++) {
                int charIndex = key.charAt(i) - 'a';
//                System.out.println(charIndex);
                if (current.links[charIndex] == null)
                    return false;
                current = current.links[charIndex];
            }
            return (current != null && current.isLeaf);
        }

        int index = -1;

        private void longestPrefix(){
            System.out.println("Prefix: " + longestPrefix(root));
        }


        private String longestPrefix(Node node) {

            StringBuilder prefix = new StringBuilder();

            while (linkCount(node) == 1 && !node.isLeaf) {
                prefix.append((char) ('a' + index));
                node = node.links[index];
            }
            return prefix.toString();
        }

        private int linkCount(Node node) {
            int count = 0;
            for (int i = 0; i < MAX; i++) {
                if (node.links[i] != null) {
                    count++;
                    index = i;
                }
            }
            return count;
        }


    }

}

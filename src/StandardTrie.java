import java.util.Arrays;

public class StandardTrie {
    public static void main(String[] args) {
        String item = "them";
        Trie trie = new Trie();
        trie.add("they");
        trie.add(item);
        trie.add("thyme");
        System.out.println("Contains '" + item + "' ? " + trie.contains(item));

        System.out.println("Longest prefix is :" + trie.longestPrefix());


    }
}

class Node {
    int MAX = 26;
    Node[] links = new Node[MAX];
    boolean isLeaf;

    Node() {
        this.isLeaf = false;
        for (int i = 0; i < MAX; i++)
            links[i] = null;
    }
}


class Trie {
    Node head;

    Trie() {
        head = new Node();
    }

    void add(String KEY) {
        head = this.add(head, KEY);
    }

    String longestPrefix() {
        return longestPrefix(this.head);
    }

    private Node add(Node head, String KEY) {
        for (int i = 0; i < KEY.length(); i++) {
            int index = KEY.charAt(i) - 'a';
            if (head.links[index] == null)
                head.links[index] = new Node();
            head = head.links[index];
        }
        head.isLeaf = true;
        return head;
    }

//    boolean contains(String KEY) {
//        return this.contains(this.head, KEY);
//    }

    private int _index = 0;

    private String longestPrefix(Node node) {
        StringBuilder string = new StringBuilder();
        while (childCount(node) == 1 && !node.isLeaf) {
            node = node.links[_index];
            string.append((char) ('a' + _index));
        }
        return string.toString();
    }

    private int childCount(Node node) {
        int count = 0;
        for (int i = 0; i < node.MAX; i++)
            if (node.links[i] != null) {
                count++;
                _index = i;
            }

        return count;
    }

    boolean contains(String KEY) {
        for (int i = 0; i < KEY.length(); i++) {
            int index = KEY.charAt(i) - 'a';
            System.out.println(index + "");
            System.out.println(Arrays.toString(head.links) + "");
            if (head.links[index] == null)
                return false;


            head = head.links[index];
        }
        return (head != null && head.isLeaf);
    }
}
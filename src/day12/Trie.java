package day12;

import java.util.*;

public class Trie {


    private final Node root;

    public Trie(Node node){
        this.root = node;
    }

    public boolean contains(Node curr, String text, int pos){
        if (pos == text.length() - 1){
            return true;
        }
        if (!curr.isRoot() && !Character.valueOf(text.charAt(pos)).equals(curr.value)) {
            return false;
        }

        boolean contains = false;

        for (Node n : curr.next.values()){
            if (contains(n, text, pos+1)){
                contains = true;
            }
        }

        return contains;
    }






    static class Node{
        Character value;
        Map<Character, Node> next;

        public Node(Character c){
            this.value = c;
            this.next = new HashMap<>();
        }

        public void add(Character c){
            next.put(c, new Node(c));
        }

        public Node search(Character c){

            return next.get(c);
        }

        public void insert(String text, int pos){
            if (pos == text.length()){
                return;
            }

            Node n = new Node(text.charAt(pos));
            next.put(text.charAt(pos), n);
            n.insert(text, pos+1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        public boolean isRoot() {
            return value == 'R';
        }
    }

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("###.#");
        inputs.add(".####");
        inputs.add("##...");
        inputs.add("##.##");
        inputs.add(".#.##");
        inputs.add("#.#..");
        inputs.add("...##");
        inputs.add("####.");
        inputs.add("#.#.#");
        inputs.add("##.#.");
        inputs.add(".#...");
        inputs.add("###..");
        inputs.add("##..#");
        inputs.add("#..#.");
        inputs.add(".#..#");
        inputs.add(".#.#.");

        Node root = new Node('R');
        for (String input : inputs) {
            root.insert(input, 0);
        }
        System.out.println(root.next.size());
        Trie t = new Trie(root);
        System.out.println(t.contains(root, ".###.", -1));

        String initGen = "##.#############........##.##.####..#.#..#.##...###.##......#.#..#####....##..#####..#.#.##.#.##";

        StringBuilder genBuilder = new StringBuilder();

        for (int i = 0; i < initGen.length(); ++i){
            Character c = '.';

        }



    }
}

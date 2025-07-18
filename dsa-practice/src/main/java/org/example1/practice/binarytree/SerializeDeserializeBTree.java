package org.example1.practice.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBTree {

    public static String serialize(Node root) {
        if (root == null) return "";
        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                res.append("#").append(" ");
                continue;
            }
            res.append(node.data).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public static Node deserialize(String data) {
        if (data.equalsIgnoreCase("")) return null;
        Queue<Node> q = new LinkedList<>();
        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 0; i < values.length; i++) {
            Node parent = q.poll();
            if (!values[i].equalsIgnoreCase("#")) {
                Node left = new Node(Integer.parseInt(values[i]));
                assert parent != null;
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("#")) {
                Node right = new Node(Integer.parseInt(values[i]));
                assert parent != null;
                parent.right = right;
                q.add(right);
            }

        }
        return root;
    }

    public static void main(String[] args) {

    }


}

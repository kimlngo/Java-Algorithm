package data.structure.api.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int val) {
        if (this.root == null) {
            this.root = new Node(val);
            return;
        }

        Node cur = this.root;

        while (true) {
            if (val < cur.getValue()) {
                if (cur.left == null) {
                    cur.left = new Node(val);
                    return;
                }
                cur = cur.left;
            } else if (val > cur.getValue()) {
                if (cur.right == null) {
                    cur.right = new Node(val);
                    return;
                }
                cur = cur.right;
            } else {
                //node already exists, just return
                return;
            }
        }
    }

    public boolean contains(int val) {
        if (this.root == null) {
            return false;
        }

        var cur = this.root;
        while (cur != null) {
            if (val == cur.getValue()) return true;
            else if (val < cur.getValue()) cur = cur.left;
            else cur = cur.right;
        }
        return false;
    }

    public Node find(int val) {
        if (this.root == null) {
            return null;
        }

        var cur = this.root;
        while (cur != null) {
            if (val == cur.getValue()) return cur;
            else if (val < cur.getValue()) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }

    public String breathFirstSearch() {
        if (this.root == null) {
            return "";
        }

        List<Node> queue = new ArrayList<>();
        queue.add(this.root);

        Node cur = null;
        List<String> visited = new ArrayList<>();
        while (!queue.isEmpty()) {
            cur = queue.removeFirst();
            visited.add(String.valueOf(cur.getValue()));

            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);

        }

        return "[" + String.join(", ", visited) + "]";
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
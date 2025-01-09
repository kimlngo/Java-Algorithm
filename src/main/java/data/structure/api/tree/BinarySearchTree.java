package data.structure.api.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
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

    public String depthFirstSearch_PreOrder() {
        return this.depthFirstSearch(this::traversePreOrder);
    }

    public String depthFirstSearch_PostOrder() {
        return this.depthFirstSearch(this::traversePostOrder);
    }

    public String depthFirstSearch_InOrder() {
        return this.depthFirstSearch(this::traverseInOrder);
    }

    private String depthFirstSearch(BiConsumer<Node, List<String>> traversePattern) {
        if(this.root == null) return "";

        List<String> visited = new ArrayList<>();
        traversePattern.accept(this.root, visited);
        return String.format("[%s]", String.join(", ", visited));
    }

    private void traversePreOrder(Node node, List<String> visited) {
        visited.add(String.valueOf(node.getValue()));
        if(node.left != null) traversePreOrder(node.left, visited);
        if(node.right != null) traversePreOrder(node.right, visited);
    }

    private void traverseInOrder(Node node, List<String> visited) {
        if(node.left != null) traverseInOrder(node.left, visited);
        visited.add(String.valueOf(node.getValue()));
        if(node.right != null) traverseInOrder(node.right, visited);
    }

    private void traversePostOrder(Node node, List<String> visited) {
        if(node.left != null) traversePostOrder(node.left, visited);
        if(node.right != null) traversePostOrder(node.right, visited);
        visited.add(String.valueOf(node.getValue()));
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
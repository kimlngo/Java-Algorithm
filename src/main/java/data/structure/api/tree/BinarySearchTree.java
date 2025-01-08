package data.structure.api.tree;

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
            if(val == cur.getValue()) return true;
            else if(val < cur.getValue()) cur = cur.left;
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
            if(val == cur.getValue()) return cur;
            else if(val < cur.getValue()) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
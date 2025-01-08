package data.structure.api.tree;

public class Node {
    private final int value;
    public Node left;
    public Node right;

    public Node(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

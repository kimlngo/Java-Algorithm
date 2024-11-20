package data.structure.node;

public class Node<E> {
    public E val;
    public Node<E> next;

    public Node(E val) {
        this.val = val;
        this.next = null;
    }
}

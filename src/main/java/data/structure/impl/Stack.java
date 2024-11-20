package data.structure.impl;

import data.structure.api.IStack;
import data.structure.node.Node;

public class Stack <E> implements IStack<E> {

    private Node<E> first;
    private Node<E> last;
    public int size;

    @Override
    public int push(E e) {
        Node<E> newNode = new Node(e);

        if(this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.next = this.first;
            this.first = newNode;
        }
        this.size++;
        return this.size;
    }

    @Override
    public E pop() {
        if(this.size == 0) return null;

        Node<E> popNode = this.first;
        if(this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
        }

        popNode.next = null;
        this.size--;
        return popNode.val;
    }

    public void print() {
        if(this.size == 0) {
            System.out.println("empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        var cur = this.first;
        while (cur != null) {
            sb.append(cur.val + " ");
            cur = cur.next;
        }

        System.out.println("size = " + this.size + " | " + sb);
    }
}

package data.structure.impl;

import data.structure.api.IQueue;
import data.structure.node.Node;

public class Queue<E> implements IQueue<E> {
    private Node<E> first;
    private Node<E> last;
    int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public int enqueue(E e) {
        Node newNode = new Node(e);

        if(this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }

        this.size++;
        return this.size;
    }

    @Override
    public E dequeue() {
        if(this.size == 0) return null;

        Node dequeueNode = this.first;
        if(this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
        }
        dequeueNode.next = null;
        this.size--;
        return (E) dequeueNode.val;
    }

    public void print() {
        if(this.size == 0) {
            System.out.println("empty");
            return;
        }

        Node tmp = this.first;
        StringBuilder sb = new StringBuilder();
        while(tmp != null) {
            sb.append(tmp.val);
        }
        System.out.println("size = " + this.size + " | " + sb);
    }
}

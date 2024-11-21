package data.structure.impl;

import data.structure.api.ICustomLinkedList;
import data.structure.node.Node;

public class CustomSinglyLinkedListImpl<E> implements ICustomLinkedList<E> {
    private Node head;
    private Node tail;
    private int length;

    public CustomSinglyLinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public int push(E e) {
        Node<E> newNode = new Node<>(e);

        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        return ++this.length;
    }

    @Override
    public E pop() {
        if(this.length == 0) return null;

        Node<E> popNode = this.tail;
        if(this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node<E> newTail = this.head;
            int count = 0;
            while(count != this.length - 2) {
                newTail = newTail.next;
                count++;
            }
            newTail.next = null;
            this.tail = newTail;
        }

        this.length--;
        return popNode.val;
    }

    @Override
    public int unshift(E e) {
        return 0;
    }

    @Override
    public E shift() {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E e) {

    }

    @Override
    public int insert(int index, E e) {
        return 0;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public void reverse() {

    }

    @Override
    public int getLength() {
        return length;
    }
}

package data.structure.api;

public interface ICustomLinkedList<E> {
    int push(E e);

    E pop();

    int unshift(E e);

    E shift();

    E get(int index);

    void set(int index, E e);

    int insert(int index, E e);

    int remove(int index);

    void reverse();

    int getLength();
}

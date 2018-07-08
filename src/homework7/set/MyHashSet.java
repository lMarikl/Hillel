package homework7.set;

import java.util.Arrays;

public class MyHashSet<E> implements MySet<E> {
    protected int capacity;
    protected int size;
    protected Node[] cells;

    private class Node{
        Object value;
        Node next;

        public Node(E value){
            this.value = value;
        }
    }

    MyHashSet() {
        capacity = 16;
        cells =
    }

    @Override
    public void add(E e) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void toArray() {

    }
}

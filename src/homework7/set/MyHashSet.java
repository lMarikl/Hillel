package homework7.set;

import java.util.Arrays;

public class MyHashSet<E> implements MySet<E> {
    private Node[] buckets;

    private int currentSize;
    private int current;
    public MyHashSet(){
        //buckets = new Node[16];
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
        return 0;
    }

    @Override
    public void toArray() {

    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "buckets=" + (buckets == null ? null : Arrays.asList(buckets)) +
                '}';
    }

    public class Node {
        public Object data;
        public Node next;
    }
}

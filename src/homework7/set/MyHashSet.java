package homework7.set;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashSet<E> implements MySet<E> {
    private int capacity;
    private int size = 0;
    private LinkedList[] table;

    MyHashSet() {
        this.capacity = 16;
        table = new LinkedList[capacity];
    }

    private double currentLoadFactor() {
        return (double) size / (double) capacity;
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }

    @Override
    public boolean contains(E e) {
        int bucketIndex = hash();
        if (table[bucketIndex] != null) {
            LinkedList bucket = table[bucketIndex];
            for (Object element : bucket) {
                if (element.equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        float maxLoad = 0.75f;
        if (currentLoadFactor() > maxLoad) {
            rehash();
        }
        int bucketIndex = hash();
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<>();
        }
        table[bucketIndex].add(e);
        size++;
        return true;
    }

    private int hash() {
        return hashCode() % table.length;
    }

    private void rehash() {
        ArrayList<E> list = toArray();
        capacity = size * 2;
        table = new LinkedList[capacity];
        size = 0;
        for (E element : list) {
            add(element);
        }
    }

    @Override
    public ArrayList<E> toArray() {
        ArrayList<E> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                list.addAll(table[i]);
            }
        }
        return list;
    }

    @Override
    public boolean remove(E e) {
        if (!contains(e)) {
            return false;
        }
        int bucketIndex = hash();
        if (table[bucketIndex] != null) {
            LinkedList bucket = table[bucketIndex];
            for (Object element : bucket) {
                if (e.equals(element)) {
                    bucket.remove(element);
                    break;
                }
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        ArrayList<E> list = toArray();
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i)).append(", ");
        }
        if (list.size() == 0) {
            builder.append("]");
        } else {
            builder.append(list.get(list.size() - 1)).append("]");
        }
        return builder.toString();
    }
}
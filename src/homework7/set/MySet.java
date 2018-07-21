package homework7.set;

import java.util.ArrayList;

public interface MySet<E> {
    boolean add(E e);
    void clear();
    boolean contains(E e);
    boolean isEmpty();
    boolean remove(E o);
    int size();
    ArrayList<E> toArray();
}

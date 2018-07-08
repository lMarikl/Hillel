package homework7.set;

public interface MySet<E> {
    void add(E e);
    void clear();
    boolean contains(Object o);
    boolean isEmpty();
    void remove(Object o);
    int size();
    void toArray();
}

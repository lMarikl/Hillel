package homework7.arrayList;

public interface IntList<E> {
    void add(E element);
    void add(int index, E element);
    void clear();
    boolean contains(E value);
    E get(int index);
    boolean isEmpty();
    void remove(int index);
    void removeElement(E element);
    void set(int index, E element);
    int size();
}

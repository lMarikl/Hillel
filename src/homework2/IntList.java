package homework2;

public interface IntList {
    void add(int element);
    int add(int index, int element);
    void clear();
    boolean contains(int value);
    int get(int index);
    boolean isEmpty();
    void remove(int index);
    void removeElement(int element);
    void set(int index, int element);
    int size();
}

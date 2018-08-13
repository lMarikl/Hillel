package homework8.TreeMap;

import java.util.ArrayList;

public interface MyTree<K, V> {
    void add(K key, V value);
    boolean containsKey(K key);
    void remove(K o);
    int size();
}

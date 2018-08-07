package homework8;

public interface myTree<K, V> {
    V add(K key, V value);
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    boolean remove(Object o);
    int size();
}

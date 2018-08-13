package homework8.TreeMap;

public class MyTreeMap<K extends Comparable<? super K>, V> implements MyTree<K, V> {
    private Node<K, V> root;
    private int size;

    MyTreeMap() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private SearchResult<K, V> find(K key) {
        Node<K, V> current = root;
        Node<K, V> parent = null;
        int dir;
        while (current != null && (dir = key.compareTo(current.key)) != 0) {
            parent = current;
            if (dir < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return new SearchResult<>(current, parent);
    }

    public void add(K key, V value) {
        SearchResult<K, V> result = find(key);
        if (result.curr != null) {
            result.curr.value = value;
        } else {
            Node<K, V> newNode = new Node<>(key, value);
            newNode.parent = result.parent;
            if (result.parent == null) {
                root = newNode;
            }
            else if (result.parent.key.compareTo(key) > 0) {
                result.parent.left = newNode;
            } else {
                result.parent.right = newNode;
            }
            size++;
        }
    }

    public boolean containsKey(K key) {
        return find(key).curr != null;
    }

    public V get(K key) {
        SearchResult<K, V> result = find(key);
        if (result.curr != null) {
            return result.curr.value;
        } else {
            return null;
        }
    }

    public void remove(K key) {
        SearchResult<K, V> result = find(key);
        Node<K, V> curr = result.curr;
        if (curr != null) {
            size--;
            if (curr.left == null && curr.right == null) {
                Node<K, V> parent = curr.parent;
                if (curr.isLeftChild()) {
                    parent.left = null;
                } else if (curr.isRightChild()) {
                    parent.right = null;
                } else {
                    root = null;
                }
            } else if (curr.left == null) {
                Node<K, V> parent = curr.parent;
                if (curr.isLeftChild()) {
                    parent.left = curr.right;
                    curr.right.parent = parent;
                } else if (curr.isRightChild()) {
                    parent.right = curr.right;
                    curr.right.parent = parent;
                } else {
                    root = curr.right;
                    root.parent = null;
                }

            } else if (curr.right == null) {
                Node<K, V> parent = curr.parent;
                if (curr.isLeftChild()) {
                    parent.left = curr.left;
                    curr.left.parent = parent;
                } else if (curr.isRightChild()) {
                    parent.right = curr.left;
                    curr.left.parent = parent;
                } else {
                    root = curr.left;
                    root.parent = null;
                }
            } else {
                Node<K, V> replacement = curr.right;
                while (replacement.left != null) {
                    replacement = replacement.left;
                }
                if (curr.isLeftChild()) {
                    curr.parent.left = replacement;
                }
                else if (curr.isRightChild()) {
                    curr.parent.right = replacement;
                } else {
                    root = replacement;
                }

                if(replacement.parent == curr) {
                    replacement.left = curr.left;
                    curr.left.parent = replacement;
                } else {
                    Node<K, V> replacementChild = replacement.right;
                    replacement.parent.left = replacementChild;

                    if (replacementChild != null) {
                        replacementChild.parent = replacement.parent;
                    }
                    replacement.right = curr.right;
                    curr.right.parent = replacement;
                    replacement.left = curr.left;
                    curr.left.parent = replacement;
                    replacement.parent = curr.parent;
                }
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        buildOutput(root, s);
        return s.toString();
    }

    private void buildOutput(Node<K, V> curr, StringBuilder s) {
        if (curr != null) {
            buildOutput(curr.left, s);
            s.append(curr.key).append(" = ").append(curr.value).append(", ");
            buildOutput(curr.right, s);
        }
    }

    private static class Node<K extends Comparable<? super K>, V> {
        private Node<K, V> parent;
        private Node<K, V> left;
        private Node<K, V> right;
        private K key;
        private V value;

        private Node(K k, V val) {
            key = k;
            value = val;
        }

        private boolean isLeftChild() {
            return (parent != null && parent.left == this);
        }

        private boolean isRightChild() {
            return (parent != null && parent.right == this);
        }
    }

    public static class SearchResult<K extends Comparable<? super K>, V> {
        private Node<K, V> curr;
        private Node<K, V> parent;

        SearchResult(Node<K, V> c, Node<K, V> p) {
            curr = c;
            parent = p;
        }
    }
}
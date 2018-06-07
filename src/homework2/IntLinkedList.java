package homework2;

public class IntLinkedList implements IntList {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(int element) {
        Node newEntry = new Node(element);
        if (first == null) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.prev = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    public int add(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node newEntry = new Node(element);
        Node oldEntry = first;
        if(index == 0) {
            newEntry.value = element;
            first = newEntry;
            first.prev = null;
            first.next = oldEntry;
        }
        if (index == size - 1) {
            newEntry.value = element;
            last = newEntry;
            last.prev = oldEntry;
            last.next = null;
        }
        for (int i = 0; i < index; i++) {
            oldEntry = oldEntry.next;
        }
        Node oldPrevious = oldEntry.prev;
        oldPrevious.next = newEntry;
        oldEntry.prev = newEntry;
        newEntry.prev = oldPrevious;
        newEntry.next = oldEntry;
        size++;
        return index;
    }

    @Override
    public void clear() {
        while (first != null){
            remove(0);
        }
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size ; i++) {
            if (get(i) == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        removeElement(get(index));
    }

    @Override
    public void removeElement(int element) {
        for (Node x = first; x != null; x = x.next) {
            if (element == x.value) {
                unlink(x);
            }
        }
    }

    private void unlink(Node x) {
        Node next = x.next;
        Node prev = x.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        size--;
    }

    @Override
    public void set(int index, int element) {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i != size - 1){
                sb.append(", ");
            }
        }
        return "[" + sb.toString() + "]";
    }

    private static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }
}

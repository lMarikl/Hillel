package homework7;

public class IntArrayList<E> implements IntList<E>{
    private Object[] values = new Object[10];
    private int size;

    public void add(E value) {
        if (size >= values.length) {
            resize();
        }
        values[size] = value;
        size++;
    }

    private void resize() {
        int newSize = values.length * 3 / 2 + 1;
        Object[] newArr = new Object[newSize];
        for (int i = 0; i < values.length; i++) {
            newArr[i] = values[i];
        }
        values = newArr;
    }

    public void add(int index, E element) {
        if (size >= values.length) {
            resize();
        }
        resize();
        values[index] = element;
    }

    public void clear() {
        values = new Object[0];
    }

    public boolean contains(E value) {
        for (Object value1 : values) {
            if (value1.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        return (E) values[index];
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public void remove(int index) {
        Object[] tmpArray = values;
        values = new Object[values.length - 1];
        System.arraycopy(tmpArray, 0, values, 0, index);
        System.arraycopy(tmpArray, index + 1, values, index, tmpArray.length - index - 1);
    }

    public void removeElement(E element) {
        for (int i = 0; i < values.length ; i++) {
            if (values[i] == element){
                remove(i);
            }
        }
    }

    public void set(int index, E element) {
        values[index] = element;
    }

    public int size() {
        return values.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i != values.length-1){
                sb.append(", ");
            }
        }
        return "[" + sb.toString() + "]";
    }
}

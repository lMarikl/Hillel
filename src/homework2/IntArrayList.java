package homework2;

public class IntArrayList implements IntList {
    private int[] values = new int[10];
    private int size;

    @Override
    public void add(int value) {
        if (size >= values.length) {
            resize();
        }
        values[size] = value;
        size++;
    }

    private void resize() {
        int newSize = values.length * 3 / 2 + 1;
        int[] newArr = new int[newSize];
        for (int i = 0; i < values.length; i++) {
            newArr[i] = values[i];
        }
        values = newArr;
    }

    @Override
    public int add(int index, int element) {
        if (size >= values.length) {
            resize();
        }
        resize();
        values[index] = element;
        return index;
    }

    @Override
    public void clear() {
        values = new int[0];
    }

    @Override
    public boolean contains(int value) {
        for (int value1 : values) {
            if (value1 == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        return values[index];
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }

    @Override
    public void remove(int index) {
        int[] tmpArray = values;
        values = new int[values.length - 1];
        System.arraycopy(tmpArray, 0, values, 0, index);
        System.arraycopy(tmpArray, index + 1, values, index, tmpArray.length - index - 1);
    }

    @Override
    public void removeElement(int element) {
        for (int i = 0; i < values.length ; i++) {
            if (values[i] == element){
                remove(i);
            }
        }
    }

    @Override
    public void set(int index, int element) {
        values[index] = element;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
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

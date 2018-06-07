package homework2;

public class Main {
    private static int currentSize = 10;
    private static int size;
    private static int countReSize;

    public static void main(String[] args) {
        IntArrayList myArrayList = new IntArrayList();
        for (int i = 0; i < 1000 ; i++) {
            myArrayList.add(1);
        }

        for (int i = 0; i < 1000000000; i++) {
            if (i == currentSize) {
                resize();
            }
            size++;
        }
        System.out.println(countReSize);
    }

    private static void resize() {
        currentSize = size * 3 / 2 + 1;
        countReSize++;
    }

    static void sort(IntList list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}

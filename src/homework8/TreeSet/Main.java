package homework8.TreeSet;

public class Main {
    public static void main(String[] args) {
        MyTreeSet<Integer> treeSet = new MyTreeSet<>();
        treeSet.add(18);
        treeSet.add(13);
        treeSet.add(29);
        treeSet.add(672);
        treeSet.add(8);
        System.out.println(treeSet);
        System.out.println(treeSet.size());
        System.out.println(treeSet.contains(5));
        System.out.println(treeSet.contains(672));
        treeSet.remove(8);
        System.out.println(treeSet);
    }
}

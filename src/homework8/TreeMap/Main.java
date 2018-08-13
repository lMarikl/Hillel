package homework8.TreeMap;


import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        MyTreeMap<Integer, String> treeMap = new MyTreeMap<>();
        treeMap.add(1, "Java");
        treeMap.add(2, "C#");
        treeMap.add(3, "Android");
        treeMap.add(4, "QA");
        treeMap.add(1, "C++");
        System.out.println(treeMap);
        System.out.println(treeMap.size());
        System.out.println(treeMap.containsKey(2));
        treeMap.remove(1);
        treeMap.remove(3);
        treeMap.remove(4);
        System.out.println(treeMap.size());
        System.out.println(treeMap);
    }
}

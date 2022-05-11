package MethodOne;

public class Driver {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 20};
        StaticHashTable table = new StaticHashTable(values);
        System.out.println(table.search(1));
        System.out.println(table.search(232));
    }
}

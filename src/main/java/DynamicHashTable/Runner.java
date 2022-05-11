package DynamicHashTable;

public class Runner {

    public static void main(String[] args) {
        DynamicHashTable ht = new DynamicHashTable();
        ht.insert(5);
        ht.insert(10);
        ht.insert(25);
        ht.insert(76);
        ht.insert(93);
        ht.insert(832);


        System.out.println(ht.search(5));
        ht.delete(5);
        System.out.println(ht.search(5));

        System.out.println(ht.search(10));
        System.out.println(ht.search(25));
        System.out.println(ht.search(76));
        System.out.println(ht.search(93));
        System.out.println(ht.search(94));
        System.out.println(ht.search(832));
        System.out.println(ht.search(833));
    }
}

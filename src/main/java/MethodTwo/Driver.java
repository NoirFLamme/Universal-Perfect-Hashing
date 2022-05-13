package MethodTwo;

import java.sql.Time;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        int size = 10000;
        int[] values = new int[size];
        Random random = new Random();
        for (int i=0; i < size; i++) {
            values[i] = random.nextInt();
        }

        Method2HashTable table = new Method2HashTable(values);
        for (int i=0; i < size; i++) {
            boolean found = table.search(values[i]);
            if(!found) {
                System.out.println("NOT FOUND " + values[i]);
            }
            else {
                System.out.println("Found " + values[i]);
            }
        }



//        System.out.println("\n\n\n");
//        for (int i=0; i < size; i++) {
//            int value = random.nextInt();
//            boolean found = table.search(value);
//            if (found)
//                System.out.println("FOUND " + value);
//            else
//                System.out.println("NOT FOUND");
//        }

//        System.out.println(table.search(1));
//        System.out.println(table.search(232));
    }
}

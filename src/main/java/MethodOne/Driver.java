package MethodOne;

import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        int size = 10000;

        int[] values = new int[size];
        Random random = new Random();
        for (int i=0; i < size; i++) {
            values[i] = random.nextInt();
        }

        Method1HashTable table = new Method1HashTable(values);

        for (int i=0; i < size; i++) {
            boolean found = table.search(values[i]);
            if(found)
                System.out.println("FOUND " + values[i]);
            else
                System.out.println("NOT FOUND");

        }

        System.out.println("\nCollisions: " + table.getCollisionsCounter() + " of total: " + size);

    }
}

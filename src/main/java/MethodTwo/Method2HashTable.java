package MethodTwo;

import MethodOne.Method1HashTable;
import java.util.*;

public class Method2HashTable {
    private final Method1HashTable[] table;
    private final int m;
    private int[] hashMatrix;
    private int collisionsCounter = 0;

    public Method2HashTable(int[] values) {
        this.m = values.length;
        this.table = new Method1HashTable[m];
        setHashFunction();
        buildHashTable(values);
    }

    public boolean search(int key) {
        int index = hash(key);
        if (table[index] == null)
            return false;

        return table[index].search(key);
    }

    public int getCollisionsCounter() {
        return collisionsCounter;
    }

    private void buildHashTable(int[] keys) {
        ArrayList<Integer>[] entryKeys = new ArrayList[m];

        for (int key: keys) {
            int index = hash(key);

            if (table[index] == null) {
                table[index] = new Method1HashTable(new int[]{key});
                entryKeys[index] = new ArrayList<>();
                entryKeys[index].add(key);
            }
            else {
                collisionsCounter++;
                entryKeys[index].add(key);
                // make a new array of the updated entryKeys
                int[] arr = castToArray(entryKeys[index]);
                table[index] = new Method1HashTable(arr);
            }
        }
    }

    private int[] castToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private void setHashFunction() {
        hashMatrix = new int[m];

        Random random = new Random();
        // fill hash vector with random 32-bit integers
        for (int i = 0; i < hashMatrix.length; i++) {
            hashMatrix[i] = random.nextInt();
        }
    }

    private int hash(int key) {
        int hash = 0;
        for (int i = 0; i < m; i++)
        {
            hash = hash<<1;
            hash = hash | parity(key & hashMatrix[i]);
        }
        hash = hash & Integer.MAX_VALUE; // zero out the sign bit
        return hash % m;
    }

    private int parity(int p) {
        int flag = 0;
        while(p != 0)
        {
            flag = flag ^ 1;
            p = p & (p-1);
        }
        return flag;
    }

}

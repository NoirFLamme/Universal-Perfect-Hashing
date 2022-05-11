package MethodTwo;

import MethodOne.StaticHashTable;
import java.util.*;

public class HashTableON {
    private final StaticHashTable[] table;
    private final int m;
    private int[] hashMatrix;

    public HashTableON(int[] values) {
        this.m = values.length;
        this.table = new StaticHashTable[m];
        setHashFunction();
        buildHashTable(values);
    }

    public boolean search(int key) {
        int index = hash(key);
        if (table[index] == null)
            return false;

        return table[index].search(key);
    }

    private void buildHashTable(int[] keys) {
        LinkedList<Integer>[] temp = new LinkedList[m];

        for (int key: keys) {
            int index = hash(key);
            if(temp[index] == null){
                temp[index] = new LinkedList<>();
            }
            temp[index].add(key);
        }

        for (int i=0; i < temp.length; i++) {
            LinkedList<Integer> bucketList = temp[i];
            if (bucketList == null) continue;

            int[] arr = new int[bucketList.size()];
            for (int j=0; j<bucketList.size(); j++) {
                arr[j] = bucketList.get(j);
            }
            table[i] = new StaticHashTable(arr);
        }
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
        hash = hash  & Integer.MAX_VALUE; // zero out the sign bit
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

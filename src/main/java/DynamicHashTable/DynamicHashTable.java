package DynamicHashTable;

import java.util.Random;

public class DynamicHashTable {
    protected LinkedListBucket[] table;
    private int m; // table size
    private int[] hashMatrix;

    public DynamicHashTable() {
        // assume fixed m for now
        this.m = 100;
        this.table = new LinkedListBucket[m];
        setHashFunction();
    }

    public void insert(int key) {
        int index = hash(key);
        if(table[index] == null) {
            table[index] = new LinkedListBucket();
        }

        if(!table[index].search(key))
            // o(1)
            table[index].insert(key);
    }

    public void delete(int key) {
        int index = hash(key);
        if(table[index] != null) {
            // o(n) of n: size(bucket linked list)
            table[index].delete(key);
        }
    }

    public boolean search(int key) {
        int index = hash(key);
        if(table[index] != null) {
            // o(n) of n: size(bucket linked list)
            return table[index].search(key);
        }
        return false;
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
        hash = hash  & Integer.MAX_VALUE; // zero out the sign bit  (msh 3arf mfrod n3ml kda wla la2)
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

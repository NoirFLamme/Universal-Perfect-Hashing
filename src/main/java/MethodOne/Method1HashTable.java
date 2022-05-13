package MethodOne;

import java.util.Arrays;
import java.util.Random;

public class Method1HashTable {
    private final int m; // table size
    private final int dictSize;
    private final int[] table;
    private final boolean[] visited;
    private int[] hashMatrix;

    public Method1HashTable(int[] values)
    {
        this.dictSize = values.length;
        this.table = new int[(int) Math.pow(dictSize, 2)];
        this.visited = new boolean[(int) Math.pow(dictSize, 2)];
        this.m = (int) Math.ceil(Math.log(Math.pow(dictSize, 2)) / Math.log(2));
        buildHashTable(values);
    }

    private void buildHashTable(int[] values)
    {
        setHashFunction();
        int i = 0;
        while (i < this.dictSize)
        {
            boolean flag = insert(values[i]);
            i++;
            if (!flag)
            {
                i = 0;
                reset();
                setHashFunction();
            }
        }
    }

    private void reset()
    {
        Arrays.fill(visited, false);
    }

    public boolean search(int key) {
        int index = hash(key);
        return table[index] == key;
    }

    private boolean insert(int key)
    {
        int index = hash(key);
        if (this.visited[index])
            return false;

        this.table[index] = key;
        this.visited[index] = true;
        return true;
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
        return hash % (int) Math.pow(dictSize, 2);
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

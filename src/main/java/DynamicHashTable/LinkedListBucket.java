package DynamicHashTable;

import java.util.LinkedList;

public class LinkedListBucket {
    private LinkedList<Integer> keys;

    public LinkedListBucket() {
        this.keys = new LinkedList<>();
    }

    public void insert(int key) {
        keys.add(key);
    }

    public void delete(int key) {
        for (int i = 0; i < keys.size(); i++) {
            int currentKey = keys.get(i);
            if(currentKey == key) {
                keys.remove(i);
                return;
            }
        }
    }

    public boolean search(int key) {
        for (int currentKey: keys) {
            if(currentKey == key)
                return true;
        }
        return false;
    }
}

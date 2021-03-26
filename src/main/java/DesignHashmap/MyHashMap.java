package DesignHashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    class Entry{
        int key;
        int value;
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<Entry>[] bucket;
    final int SIZE = 1001;

    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new ArrayList[SIZE];
        for(int i = 0; i < SIZE; i++) {
            bucket[i] = new ArrayList<Entry>();
        }
    }

    public int getHash(int key) {
        return key % SIZE;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        List<Entry> list = bucket[getHash(key)];

        for(Iterator<Entry> it = list.iterator(); it.hasNext();) {
            Entry entry = it.next();

            if(entry.key == key) {
                it.remove();
            }
        }
        list.add(new Entry(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(Entry entry: bucket[getHash(key)]) {
            if(entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        List<Entry> list = bucket[getHash(key)];

        list.removeIf(entry -> entry.key == key);
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

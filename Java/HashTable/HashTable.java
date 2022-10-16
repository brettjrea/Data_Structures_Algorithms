package HashTable;

import java.util.LinkedList;

public class HashTable {

    public static class HashObject {
        @Override
        public String toString() {
            return "HashObject{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }

        // hash table methods
        private String key;
        private Integer value;
    }

    // set array of linked lists size to avoid collision
    private int ARR_SIZE = 8;
    @SuppressWarnings("unchecked")
    private LinkedList<HashObject>[] arr = new LinkedList[ARR_SIZE];

    public HashTable() {
        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = null;
        }
    }

    // hash function start (chaining)
    // return value of provided key
    private HashObject getObject(String key) {
        int count = 0;
        if (key == null)
            return null;

        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HashObject> items = arr[index];

        if (items == null)
            return null;

        for (HashObject item : items) {
            if (!item.key.equals(key)) {
                count++;
            } else {
                System.out.println(count + " elements searched to find " + key);
                return item;
            }

        }

        return null;
    }

    public Integer findObject(String key) {
        HashObject item = getObject(key.toLowerCase());

        if (item == null) {
            return null;
        } else {
            return item.value;
        }
    }

    // updates hash table
    public void put(String key, Integer value) {
        int index = Math.abs(key.hashCode() % ARR_SIZE);
        LinkedList<HashObject> items = arr[index];
        if (items == null) {
            items = new LinkedList<>();

            HashObject item = new HashObject();
            item.key = key.toLowerCase();
            item.value = value;

            items.add(item);
            arr[index] = items;
        } else {
            for (HashObject item : items) {
                if (item.key.equals(key)) {
                    item.value = value;
                    return;
                }
            }

            HashObject item = new HashObject();
            item.key = key.toLowerCase();
            item.value = value;

            items.add(item);
        }
    }

    // remove key/value pair objects from the table
    public void delete(String key) {
        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HashObject> items = arr[index];

        if (items == null) {
            return;
        }
        for (HashObject item : items) {
            if (item.key.equals(key)) {
                items.remove(item);
                return;
            }
        }
    }

    // prints the table
    public void displayTable() {
        for (int i = 0; i < ARR_SIZE; i++) {
            System.out.println(arr[i]);
        }
    }

}

// Time complexity: For n entries in the list, the time complexity will be O(n)
// regardless of whatever hash function you're using.
// Note that this is worst case (the last item), and on average the search runs
// in O(1).
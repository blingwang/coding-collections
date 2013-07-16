import java.util.*;
class Solution8Q10 {}
class HashTable<K, V> {
    private final int MAX_SIZE = 10;
    LinkedList<Cell<K, V>>[] items;

    public HashTable() {
        items = (LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
    }

    // Really, really stupid hash
    public int hashCodeOfKey(K key) {
        return key.toString().length() % items.length;
    }

    public void put(K key, V value) {
        int x = hashCodeOfKey(key);
        if (items[x] == null) {
            items[x] = new LinkedList<Cell<K, V>>();
        }

        LinkedList<Cell<K, V>> collided = items[x];

        // Look for items with same key and replace if found
        for (Cell<K, V> c : collided) {
            if (c.equivalent(key)) {
                collided.remove(c);
                break;
            }
        }

        Cell<K, V> cell = new Cell<K, V>(key, value);
        collided.add(cell);
    }

    public V get(K key) {
        int x = hashCodeOfKey(key);
        if (items[x] == null) {
            return null;
        }

        LinkedList<Cell<K, V>> collided = items[x];
        for (Cell<K, V> c : collided) {
            if (c.equivalent(key)) {
                return c.getValue();
            }
        }

        return null;
    }

    private class Cell<K, V> {
        private K key;
        private V value;
        public Cell(K k, V v) {
            key = k;
            value = v;
        }

        boolean equivalent(Cell<K, V> c) {
            return equivalent(c.getKey());
        }

        boolean equivalent(K k) {
            return key.equals(k);
        }

        K getKey() { return key; }
        V getValue() { return value;}
    }
}
   

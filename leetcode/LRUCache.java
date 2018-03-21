public class LRUCache {
    private Map<Integer, Entry> map;
    private transient Entry header; // dummy head, transient var is not to be serialized
    private final int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Entry>();
        header = new Entry(-1, -1);
        header.after = header;
        header.before = header;
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Entry entry = map.get(key);
        entry.remove();
        entry.addAfter(header);
        
        return entry.val;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            entry.val = value;
            entry.remove();
            entry.addAfter(header);
        } else {
            addEntry(key, value);
        }
    }
    
    private void addEntry(int key, int value) {
        if (size == capacity) removeLastEntry();
        
        Entry entry = new Entry(key, value);
        entry.addAfter(header);
        map.put(key, entry);
        size++;
    }
    
    private void removeLastEntry() {
        Entry last = header.before;
        last.remove();
        map.remove(last.key);
        size--;
    }
    
    private static class Entry { // doubly-linked entry node
        private final int key;
        private int val;
        private Entry before, after;
        
        Entry (int key, int val) {
            this.key = key;
            this.val = val;
        }
        
        private void remove() {
            before.after = after;
            after.before = before;
        }
        
        private void addAfter(Entry existingEntry) {
            before = existingEntry;
            after = existingEntry.after;
            before.after = this;
            after.before = this;
        }
    }
}

import java.util.LinkedHashMap;
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
}

class LRUConcurrentCache {
    private final Map<K,V> cache;   

    public LRUConcurrentCache(final int maxEntries) {
        this.cache = new LinkedHashMap<K,V>(maxEntries, 0.75F, true) {
           private static final long serialVersionUID = -1236481390177598762L;
           @Override
           protected boolean removeEldestEntry(Map.Entry<K,V> eldest){            
              return size() > maxEntries;
           }
        };
    }

    public void put(K key, V value) {
        synchronized(cache) {
            cache.put(key, value);
        }
    }
    
    public V get(K key) {
        synchronized(cache) {
            return cache.get(key);
        }
    }    
}

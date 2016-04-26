public class LRUCache {
    private Map<Integer, Entry> map;
    private transient Entry header; // dummy head
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
import java.util.Map.Entry;

public class LRUCache extends LinkedHashMap<Integer, Integer>{
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (containsKey(key)) return super.get(key);
        return -1;
    }
    
    public void set(int key, int value) {
        put(key, value);   
    }
    
    protected boolean removeEldestEntry(Entry entry) {
        return (size() > this.capacity);
    }
}

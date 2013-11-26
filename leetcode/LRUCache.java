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
        
        Entry node = map.get(key);
        node.remove();
        node.addAfter(header);
        
        return node.val;
    }
    
    public void set(final int key, int value) {
        Entry node = map.get(key);
        if (map.containsKey(key)) {
            node.val = value;
            node.remove();
            node.addAfter(header);
        } else {
            if (size == capacity) {
                removeLastEntry();
                size--;
            }
            
            node = new Entry(key, value);
            node.addAfter(header);
            size++;
            map.put(key, node);
        }
    }
    
    private void removeLastEntry() {
        Entry last = header.before;
        last.remove();
        map.remove(last.key);
    }
    
    private static class Entry { // doubly-linked list node
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

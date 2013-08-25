public class Solution8Q10 { 
    public static void main(String[] args) {
        HashTable<Integer, Character> map = new HashTable<Integer, Character>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(3, 'c');
        
        System.out.println(map.get(2));
    }
}

class HashTable<K, V> {
    private static final int INIT_CAPACITY = 37;
    private int N; // # of entries
    private int M; // hash table size;
    private Entry<K, V>[] table; // array of key-value pairs
    
    public HashTable() {
        this(INIT_CAPACITY);
    }
    
    @SuppressWarnings("unchecked")
    public HashTable(int M) {
        this.M = M;
        table = (Entry<K, V>[])new Entry[M];
    }
    
    private int hash(K key) {
        return (key.hashCode() & 0xfffffff) % M;
    }
    
    public V get(K key) {
        for (Entry<K, V> e = table[hash(key)]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                return e.val;
            }
        }
        return null;
    }
    
    public void put(K key, V val) {
        if (val == null) throw new IllegalArgumentException();
        
        Entry<K, V> first = table[hash(key)];
        for (Entry<K, V> e = first; e != null; e = e.next) {
            if (e.key.equals(key)) {
                e.val = val;
                return;
            }
        }
        
        table[hash(key)] = new Entry<K, V>(key, val, first);
        N++;
    }
    
    // a helper linked list data type
    private static class Entry<K, V> {
        private K key;
        private V val;
        private Entry<K, V> next;

        public Entry(K key, V val, Entry<K, V> next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
}

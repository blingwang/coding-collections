class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }
        
        return result;
    }
}

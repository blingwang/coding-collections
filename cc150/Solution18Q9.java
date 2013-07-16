import java.util.*;
class Solution18Q9 {
    private Comparator<Integer> maxHeapComparator;
    private Comparator<Integer> minHeapComparator;
    private PriorityQueue<Integer> maxHeap, minHeap;

    private class MinHeapComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    private class MaxHeapComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public Solution18Q9() {
        maxHeapComparator = new MaxHeapComparator();
        minHeapComparator = new MinHeapComparator();
        maxHeap = new PriorityQueue<Integer>(11, maxHeapComparator);
        minHeap = new PriorityQueue<Integer>(11, minHeapComparator);
    }

    public void addNewNumber(int number) {
        // maintain two heaps: 0 <= maxHeap.size() - minHeap.size() <= 1
        if (maxHeap.size() == minHeap.size()) {
           if ((minHeap.peek() != null) && number > minHeap.peek()) {
              maxHeap.offer(minHeap.poll());
              minHeap.offer(number);
           } else {
              maxHeap.offer(number);
           }
        } else {
           if (number < maxHeap.peek()) {
              minHeap.offer(maxHeap.poll());
              maxHeap.offer(number);
           }
        } 
    }

    public double getMedian() {
        // make sure at least one integer exists
        if (maxHeap.isEmpty()) {
            return 0;
        }

        if (maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

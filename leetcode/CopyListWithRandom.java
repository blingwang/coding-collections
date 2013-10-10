import java.util.*;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
 
public class CopyListWithRandom {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode current = head;
        while (current != null) {
            RandomListNode nextNode = current.next;
            current.next = new RandomListNode(current.label);
            current.next.next = nextNode;
            current = nextNode;
        }
        
        current = head;
        while(current != null) {
            if (current.random != null) current.next.random = current.random.next;
            current = current.next.next;
        }
        
        RandomListNode copy = head.next;
        current = head;
        while (current != null) {
            RandomListNode currentCopy = current.next;
            RandomListNode nextNode = current.next.next;
            current.next = nextNode;
            if (nextNode != null) currentCopy.next = nextNode.next;
            current = nextNode;
        }
        
        return copy;
    }
    
    /***** use IdentityHashMap *******/
    
    public RandomListNode copyRandomList1(RandomListNode head) {
        IdentityHashMap<RandomListNode, RandomListNode> copied = new 
                            IdentityHashMap<RandomListNode, RandomListNode>();
        return copyRandomListHelper(head, copied);
    }
    
    private RandomListNode copyRandomListHelper(RandomListNode head, 
                            IdentityHashMap<RandomListNode, RandomListNode> copied) {
        if (head == null) {
            return null;
        }
        
        if (copied.containsKey(head)) {
            return copied.get(head);
        }
        
        RandomListNode copy = new RandomListNode(head.label);
        copied.put(head, copy);
        copy.next = copyRandomListHelper(head.next, copied);
        copy.random = copyRandomListHelper(head.random, copied);
        
        return copy;
    }
    
    /***** use label as key *******/
    // causing stack overflow for large case
    public RandomListNode copyRandomList2(RandomListNode head) {
        Map<Integer, RandomListNode> copied = new HashMap<Integer, RandomListNode>();
        return copyRandomListHelper2(head, copied);
    }
    
    private RandomListNode copyRandomListHelper2(RandomListNode head, Map<Integer, RandomListNode> copied) {
        if (head == null) {
            return null;
        }
        
        if (copied.containsKey(head.label)) {
            return copied.get(head.label);
        }
        
        RandomListNode copy = new RandomListNode(head.label);
        copied.put(head.label, copy);
        copy.next = copyRandomListHelper2(head.next, copied);
        copy.random = copyRandomListHelper2(head.random, copied);
        
        return copy;
    }
}

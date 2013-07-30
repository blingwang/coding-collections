import java.util.*;
public class MergeKSortedLists {
   public ListNode mergeKLists(ArrayList<ListNode> lists) {
       if (lists == null || lists.isEmpty()) return null;
       
       ListNode dummyHead = new ListNode(-1);
       
       Comparator<ListNode> comparator = new Comparator<ListNode>() {
           @Override
           public int compare(ListNode n1, ListNode n2) {
               if (n1.val < n2.val) return -1;
               if (n1.val > n2.val) return 1;
               return 0;
           }
       };
       
       PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
       for (ListNode node : lists) {
           if (node != null) heap.add(node);
       }
       
       ListNode pre = dummyHead;
       while (!heap.isEmpty()) {
           ListNode curMin = heap.poll();
           pre.next = curMin;
           pre = pre.next;
           if (curMin.next != null) heap.add(curMin.next);
       }
       
       return dummyHead.next;
   }
   
   public ListNode mergeKListsDivideAndConquer(ArrayList<ListNode> lists) {
       if (lists.isEmpty()) return null;
       
       int last = lists.size() - 1;
       
       while (last > 0) {
           int cur = 0;
           while (cur < last) {
               lists.set(cur, mergeTwoLists(lists.get(cur++), lists.get(last--)));
           }
       }
       
       return lists.get(0);
   }
   
   public ListNode mergeKListsTopDown(ArrayList<ListNode> lists) {
        //if (lists.isEmpty()) return null;
        return mergeKLists(lists, 0, lists.size()-1);
    }
    
    private ListNode mergeKLists(ArrayList<ListNode> lists, int lo, int hi) {
        if (lo > hi) return null;
        if (lo == hi) return lists.get(lo);
        
        int mid = lo + (hi - lo) / 2;
        ListNode left = mergeKLists(lists, lo, mid);
        ListNode right = mergeKLists(lists, mid+1, hi);
        return mergeTwoLists(left, right);
    }
   
   private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
       ListNode dummyHead = new ListNode(-1);
       ListNode pre = dummyHead;
       while (true) {
           if (l1 == null) {
               pre.next = l2;
               break;
           }
           if (l2 == null) {
               pre.next = l1;
               break;
           }
           if (l2.val < l1.val) {
               pre.next = l2;
               pre = l2;
               l2 = l2.next;
           } else {
               pre.next = l1;
               pre = l1;
               l1 = l1.next;
           }
       }
       
       return dummyHead.next;
   }

   private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}

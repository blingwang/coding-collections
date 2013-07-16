import java.util.*;

public class Solution2Q1{
    class LinkedListNode{
        LinkedListNode next = null;
        int data;

        public LinkedListNode(int d){
            data = d;
        }
    }

    public static void deleteDups(LinkedListNode n){
        Set<Integer> elemsFound = new HashSet<Integer>();
        LinkedListNode previous = null;

        while(n != null){
            if(elemsFound.contains(n.data)){
                previous.next = n.next;
            }else{
                elemsFound.add(n.data);
                previous = n;
            }

            n = n.next;
        }
    }

    public static void deleteDupsNoBuffer(LinkedListNode head) {
        if (head == null) return;
        LinkedListNode current = head;
        while (current != null) {
            // remove all future nodes that have the same value
            LinkedListNode runner = current;

            while (runner.next != null ) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}


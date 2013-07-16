public class Solution2Q3{
    class LinkedListNode{
        LinkedListNode next = null;
        int data;

        public LinkedListNode(int d){
            data = d;
        }
    }

    public static boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false; // failure
        }

        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}

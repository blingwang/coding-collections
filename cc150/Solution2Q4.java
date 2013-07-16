public class Solution2Q4{
    class LinkedListNode{
        LinkedListNode next = null;
        int data;

        public LinkedListNode(int d){
            data = d;
        }
    }

    public LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;

        // partition list
        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                //insert node into start of before list
                node.next = beforeStart;
                beforeStart = node;
            } else {
                // insert node into start of after list
                node.next = afterStart;
                afterStart = node;
            }

            node = next;
        }

        // merge before list and after list
        if (beforeStart == null) {
            return afterStart;
        }

        // find end of before list and merge the lists
        LinkedListNode head = beforeStart;
        while (beforeStart.next != null) {
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;

        return head;
    }
}


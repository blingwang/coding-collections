class ReverseList {
    private class Node {
        int data;
        Node next;
    }

    public static Node reverseListRecur(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static Node reverseListIter(Node head) {
        if (head == null || head.next == null) {// this check can be removed
            return head;
        }
          
        Node pre = null;
        Node cur = head;

        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        Node newHead = pre;
        return newHead;
    }
}


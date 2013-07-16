public class Solution2Q5{
    class LinkedListNode{
        LinkedListNode next = null;
        int data;

        public LinkedListNode(int d){
            data = d;
        }
    }

    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        return addLists(l1, l2, 0);
    }

    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        // we are done if both lists are null and the carry value is 0
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode(carry);

        // add value, and data from l1 and l2
        int value = carry;
        if(l1 != null) {
            value += l1.data;
        }
        if(l2 != null) {
            value += l2.data;
        }

        result.data = value % 10; 

        // recurse
        if (l1 != null || l2 != null || value >=10) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                                           l2 == null ? null : l2.next,
                                           value >= 10 ? 1 : 0);
            result.next = more;
        }

        return result;
    }
    
    // for lists with reverse order
    private class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }

    LinkedListNode addReverseLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        // pad the shorter lists with leading zeros
        if(len1 < len2){
            l1 = padList(l1, len2-len1);
        } else {
            l2 = padList(l2, len1-len2);
        }

        // add lists
        PartialSum sum = addListsHelper(l1, l2);

        // if there was a carry value left over, insert this at the front of the list
        // otherwise, just return the linked list
        if(sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if(l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        // add smaller digits recursively
        PartialSum sum = addListsHelper(l1.next, l2.next);

        // add carry to current data
        int val = sum.carry + l1.data + l2.data;

        // insert sum of current digits
        LinkedListNode full_result = insertBefore(sum.sum, val % 10);

        // return sum so far, and the carry value
        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }

    // pad the list with zeros
    LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;

        for (int i = 0; i < padding; i++) {
            LinkedListNode n = new LinkedListNode(0);
            n.next = head;
            head = n;
        }
        return head;
    }

    // helper function to insert node in the front of a linked list
    LinkedListNode insertBefore(LinkedListNode list, int data){
        LinkedListNode node = new LinkedListNode(data);
        node.next = list;
        return node;
    }
    
    int length(LinkedListNode list) {
        int length = 0;
        while(list != null) {
            length++;
            list = list.next;
        }

        return length;
    }
}

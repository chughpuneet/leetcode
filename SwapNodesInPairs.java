public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = null;
        ListNode current = head;
        ListNode swappedHead = null;
        ListNode prevElem = null;

        while(current != null){

            ListNode firstElem = current;
            ListNode secondElem = current.next;

            if(secondElem != null){
                temp = secondElem.next;
                secondElem.next = firstElem;
                firstElem.next = temp;

                if(swappedHead == null){
                    swappedHead = secondElem;
                }
                if(prevElem != null)
                    prevElem.next = secondElem;
            }else{
                temp = null;
            }
            current = temp;
            prevElem = firstElem;
        }

        return swappedHead;

    }
}

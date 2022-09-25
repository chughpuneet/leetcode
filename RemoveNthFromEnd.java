import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> nodeWithIndex = new HashMap<>();
        int i=1;
        ListNode current = head;
        while(current.next != null){
            nodeWithIndex.put(i++,current);
            current = current.next;
        }
        nodeWithIndex.put(i++,current);

        int total = nodeWithIndex.size();
        int removalNode = total -n +1;
        //System.out.println(removalNode);
        if(total == 1 && n == 1) return null;
        ListNode leftNode = nodeWithIndex.get(removalNode -1);
        ListNode rightNode = nodeWithIndex.get(removalNode +1);
        if(leftNode != null){
            leftNode.next = rightNode;
        }else{
            head = rightNode;
        }
        return head;

    }
}

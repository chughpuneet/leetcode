/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1,  l2;
        l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);


        l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode finalRes = null;
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        ListNode finalResCurrentPointer = null;
        while(currentNode1 != null ||currentNode2 != null){
            if(currentNode1 != null && currentNode2 != null){
                int sum = currentNode1.val + currentNode2.val + carryOver;

                String append = String.valueOf(sum);

                ListNode current = null;
                if(sum > 9){
                    current = new ListNode(Integer.valueOf(append.substring(1)));
                    carryOver = Integer.valueOf(append.substring(0,1));

                }else{
                    current = new ListNode(sum);
                    carryOver = 0;
                }

                if(finalRes == null){
                    finalRes = current;
                    finalResCurrentPointer = current;
                }else{
                    finalResCurrentPointer.next = current;
                    finalResCurrentPointer = current;
                }

                currentNode1 = currentNode1.next;
                currentNode2 = currentNode2.next;

            }else if(currentNode1 != null){
                finalResCurrentPointer.next = addRemainingListNodes(currentNode1, carryOver);
                carryOver = 0;
            }else if(currentNode2 != null){
                finalResCurrentPointer.next = addRemainingListNodes(currentNode2, carryOver);
                carryOver = 0;
            }
        }

        if(carryOver > 0){
            finalResCurrentPointer.next  =  new ListNode(carryOver);
        }
        return finalRes;

    }

    private static ListNode addRemainingListNodes(
            ListNode currentNode, int carryOver){

        if(currentNode == null){
            return new ListNode(carryOver);
        }
        if(carryOver == 0 ){
            return currentNode;
        }else{
            ListNode tempNode;
            int sum = currentNode.val + carryOver;
            if(sum>9){
                String sumStr = String.valueOf(sum);
                carryOver = Integer.valueOf(sumStr.substring(0,1));
                tempNode = new ListNode(Integer.valueOf(sumStr.substring(1)));
            }else{
                tempNode = new ListNode(sum);
                carryOver = 0;
            }

            tempNode.next = addRemainingListNodes(currentNode.next, carryOver);

            return tempNode;
        }
    }
}
 class ListNode {
      int val;
      public ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
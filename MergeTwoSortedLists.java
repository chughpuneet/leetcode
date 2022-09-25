public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1== null)return list2;
        if(list2== null)return list1;
        ListNode currentList1 = list1;
        ListNode currentList2 = list2;

        ListNode merged = null, mergedHead = null;

        while(currentList1 != null && currentList2 != null){
            ListNode smallNode = null;

            if(currentList1.val<=currentList2.val){
                smallNode = currentList1;
                currentList1 = currentList1.next;
            }else if(currentList2.val<currentList1.val){
                smallNode = currentList2;
                currentList2 = currentList2.next;
            }

            if(mergedHead == null){
                mergedHead = smallNode;
            }else{
                merged.next = smallNode;
            }
            merged = smallNode;

        }

        if(currentList1 != null){
            merged.next = currentList1;
        }

        if(currentList2 != null){
            merged.next = currentList2;
        }

        return mergedHead;
    }
}

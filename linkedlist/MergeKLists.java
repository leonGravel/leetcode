package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MergeKLists
 * @Description: 合并K个有序链表，归并排序，将K个链表，两两合并
 * @Author gravel
 * @Date 2020/2/15
 * @Version V1.0
 **/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }
        int half = lists.length/2;
        ListNode[] l1 = new ListNode[half];
        ListNode[] l2 = new ListNode[lists.length-half];
        int i,j;
        for(i=0;i<half;i++){
            l1[i] = lists[i];
        }
        for(j=0;j<l2.length;j++){
            l2[j] = lists[j+i];
        }
        ListNode node1 = mergeKLists(l1);
        ListNode node2 = mergeKLists(l2);
        return mergeTwoLists(node1,node2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if(l1.val<=l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else{
            head  = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }

}

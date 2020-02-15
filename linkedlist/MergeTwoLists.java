package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MergeTwoLists
 * @Description: 合并两个有序链表
 * @Author gravel
 * @Date 2019/11/12
 * @Version V1.0
 * <p>
 * 递归的方式，看起来很清晰。。
 **/
public class MergeTwoLists {
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

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(5);
        a.next.next = new ListNode(7);

        ListNode b = new ListNode(1);
        b.next = new ListNode(4);
        b.next.next = new ListNode(6);
        b.next.next.next = new ListNode(8);
        ListNode result = new MergeTwoLists().mergeTwoLists(a, b);
        System.out.println(result.val);
    }
}

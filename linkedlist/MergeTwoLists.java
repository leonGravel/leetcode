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
 * 双重循环，压入队列
 **/
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        List<ListNode> q = new ArrayList<>();
        for (ListNode t1 = l1; t1 != null; ) {
            for (; ; ) {
                ListNode t2 = l2;
                if (t1 == null) {
                    while (t2 != null) {
                        q.add(t2);
                        t2 = t2.next;
                    }
                    break;
                }
                if (t2 == null) {
                    while (t1 != null) {
                        q.add(t1);
                        t1 = t1.next;
                    }
                    break;
                }
                if (t1.val == t2.val) {
                    q.add(t1);
                    q.add(t2);
                    t1 = t1.next;
                    t2 = t2.next;
                } else if (t1.val < t2.val) {
                    q.add(t1);
                    t1 = t1.next;
                } else {
                    q.add(t2);
                    t2 = t2.next;
                }
                l2 = t2;
            }
        }
        q.stream().peek(listNode -> listNode.next = null).reduce((listNode, listNode2) -> listNode.next = listNode2);

        return q.get(0);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
//        a.next = new ListNode(5);
//        a.next.next = new ListNode(7);

        ListNode b = new ListNode(1);
//        b.next = new ListNode(4);
//        b.next.next = new ListNode(6);
//        b.next.next.next = new ListNode(8);
        new MergeTwoLists().mergeTwoLists(a, b);
    }
}

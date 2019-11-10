package linkedlist;

/**
 * @author Gravel
 * @date 2019/10/16.
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 *
 * 思路：用两个指针，第一个指针先走 n-1步，然后第二个指针开始走，当第一个指针走到末尾的时候，第二个指针所在的
 * 位置就是第n个节点，然后删掉他，需要考虑首尾节点删除的问题
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = 0;
        int deleteindex = n;
        boolean isLastNode = false;

        if(deleteindex==1){
            isLastNode = true;
            deleteindex += 1;
        }
        ListNode secendNode = head;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            if (index >= deleteindex) {
                secendNode = secendNode.next;
            }

            index++;
        }
        if (index == n) {
            return head.next;
        }
        if(isLastNode){
            secendNode.next = null;
            return head;
        }
        secendNode.val = secendNode.next.val;
        secendNode.next = secendNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        new RemoveNthFromEnd().removeNthFromEnd(a, 1);
    }
}

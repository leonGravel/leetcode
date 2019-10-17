package linkedlist;

/**
 * @author Gravel
 * @date 2019/10/16.
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int index = 0;
        for (ListNode temp = head; temp!=null;temp = temp.next){
            index++;
        }
        if(index == n){
            return head.next;
        }
        int deleteIndex = 0;
        if(n==1){
            for (ListNode temp = head; temp!=null;temp = temp.next){
                if(deleteIndex ==(index-n-1) ){
                    temp.next = null;
                    return head;
                }
                deleteIndex++;
            }
        }
        deleteIndex = 0;
        for (ListNode temp = head; temp!=null;temp = temp.next){
            deleteIndex++;
            if(deleteIndex ==(index-n+1) ){
                temp.val = temp.next.val;
                temp.next = temp.next.next;
                break;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        new RemoveNthFromEnd().removeNthFromEnd(a,1);
    }
}

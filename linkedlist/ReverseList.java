package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName ReverseList
 * @Description: 反转链表
 * @Author gravel
 * @Date 2019/11/11
 * @Version V1.0
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 **/
public class ReverseList {
    /**
     * 迭代
     * 根据栈先进后出的概念，遍历这个链表，压栈。
     * 然后输出这个栈，处理节点间的关联关系即可。
     * @return
     */
    public ListNode ReverseList_1(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            stack.push(temp);
        }
        ListNode top = stack.pop();

        for (ListNode temp = top; !stack.isEmpty(); temp = temp.next) {
            ListNode item = stack.pop();
            item.next = null;
            temp.next = item;
        }

        return top;
    }

    /**
     * 递归
     *
     * @return
     */
    public ListNode ReverseList_2(ListNode head,List<ListNode> item) {
        if (head != null) {
            if (head.next != null) {

                ReverseList_2(head.next,item);
            }
        }
        item.add(head);
        System.out.println(head.val);
        return head;
    }

    public ListNode getHead(ListNode head){
        if (head == null || head.next == null) return head;

        List<ListNode> list = new ArrayList<>();
        ReverseList_2(head,list);
        list.stream().peek(listNode -> listNode.next = null).reduce((listNode, listNode2) -> listNode.next=listNode2);
        return list.get(0);
    }

    // 打印逆序链表
    public void printReverseList(ListNode head){
        if(head==null){
            return;
        }
        printReverseList(head.next);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(5);

        new ReverseList().getHead(a);
    }
}

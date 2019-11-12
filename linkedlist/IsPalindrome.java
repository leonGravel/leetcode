package linkedlist;

import java.util.Stack;

/**
 * @ClassName IsPalindrome
 * @Description: 回文链表
 * @Author gravel
 * @Date 2019/11/12
 * @Version V1.0
 * <p>
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 将数据压入栈，然后再遍历一半，并和出栈的数据做比较
 **/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        for (ListNode temp = head; temp != null; temp = temp.next) {
            stack.push(temp);
        }
        int len = stack.size();
        int size;
        if (len % 2 == 0) {
            size = len / 2;

        } else {
            size = (len - 1) / 2;
        }
        for (ListNode temp = head; size > 0; temp = temp.next) {
            size--;
            if (stack.pop().val != temp.val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        b.next.next.next = new ListNode(2);
        b.next.next.next.next = new ListNode(1);

        System.out.println(new IsPalindrome().isPalindrome(b));
    }
}

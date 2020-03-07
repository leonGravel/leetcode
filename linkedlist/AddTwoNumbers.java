package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AddTwoNumbers
 * @Description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author gravel
 * @Date 2020/3/7
 * @Version V1.0
 *
 * 思路：
 * 用两个list把链表中的元素分别取出来，用一个长度为Math.max(s1.size(), s2.size())+1；的数组来接收每一位相加的值。
 **/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        for (ListNode temp = l1; temp != null; temp = temp.next) {
            s1.add(temp.val);
        }
        for (ListNode temp = l2; temp != null; temp = temp.next) {
            s2.add(temp.val);
        }

        int len = Math.max(s1.size(), s2.size());
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int temp = res[i];
            if (i < s1.size()) {
                temp += s1.get(i);
            }
            if (i < s2.size()) {
                temp += s2.get(i);
            }
            if (temp > 9) {
                res[i] = temp - 10;
                res[i + 1] = 1;
            } else {
                res[i] = temp;
            }
        }

        ListNode root = new ListNode(res[0]);
        ListNode temp = root;
        for (int index = 1; index < res.length; index++) {
            int item = res[index];
            if (index == res.length - 1 && item == 0) {
                continue;
            }
            temp.next = new ListNode(item);
            temp = temp.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode b = new ListNode(6);
//        b.next.next.next = new ListNode(2);

        ListNode a = new ListNode(5);

        new AddTwoNumbers().addTwoNumbers(a, b);
    }
}

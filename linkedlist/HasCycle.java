package linkedlist;

import java.util.HashMap;

/**
 * @ClassName HasCycle
 * @Description: 回形链表
 * @Author gravel
 * @Date 2019/11/12
 * @Version V1.0
 *
 * 通过哈希表实现，往哈希表中添加对象数据，如果有重复的节点出现，可通过value判断出，就是回形链表
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        HashMap<ListNode, Integer> map = new HashMap<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            map.putIfAbsent(temp, 1);
            if (map.get(temp) > 1) {
                return true;
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        b.next.next.next = new ListNode(2);
        b.next.next.next.next = new ListNode(1);
        b.next.next.next.next.next = b.next.next.next;

        System.out.println(new HasCycle().hasCycle(b));
    }
}

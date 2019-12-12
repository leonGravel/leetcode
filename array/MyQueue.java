package array;

import java.util.Stack;

/**
 * @ClassName MyQueue
 * @Description: TODO
 * @Author gravel
 * @Date 2019/12/11
 * @Version V1.0
 **/
public class MyQueue {
    private Stack<Integer> stack = new Stack<>();

    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int pop = stack.firstElement();
        stack.remove(0);
        return pop;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.firstElement();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
    }
}

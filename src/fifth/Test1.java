package fifth;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test1 {
    public static void stack(Queue<Integer> queue1, Queue<Integer> queue2) {
        while (queue1.size() > 0 || queue2.size() > 0) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            if (queue1.peek() != null)
                System.out.println(queue1.poll());
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            if (queue2.peek() != null)
                System.out.println(queue2.poll());
        }

    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new PriorityQueue<>();
        Queue<Integer> queue2 = new PriorityQueue<>();
        int[] a = {1, 2, 3};
        int i = 0;
        while (i < a.length) {
            queue1.offer(a[i]);
            i++;
        }
        stack(queue1, queue2);
    }
}

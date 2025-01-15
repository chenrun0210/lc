package test;

import java.util.Deque;
import java.util.LinkedList;

public class DequeueTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);

        System.out.println(deque);

        System.out.println("peek first:" + deque.peekFirst());
        System.out.println("peek last:" + deque.peekLast());

        System.out.println("________________");
        System.out.println("offer first 0:");
        deque.offerFirst(0);
        System.out.println(deque);


        System.out.println("________________");
        System.out.println("offer last 5:");
        deque.offerLast(5);
        System.out.println(deque);


        System.out.println("________________");
        System.out.println("offer 6:");
        deque.offer(6);
        System.out.println(deque);

        System.out.println("________________");
        System.out.println("int k =  poll first:");
        Integer k = deque.pollFirst();
        System.out.println("k=" + k + "\n" + deque);


        System.out.println("________________");
        System.out.println("int k =  poll last:");
        k = deque.pollLast();
        System.out.println("k=" + k + "\n" + deque);

    }
}

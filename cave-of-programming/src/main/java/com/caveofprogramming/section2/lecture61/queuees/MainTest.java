package com.caveofprogramming.section2.lecture61.queuees;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MainTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayBlockingQueue<>(3);
        queue.add(12);
        queue.add(13);
        queue.add(127);

        try {
            queue.add(129);
        } catch (IllegalStateException ex) {
            System.out.println("Tried to add to many items");
        }
        System.out.println("Only one element" + queue.element());
        System.out.println();
        for (Integer element : queue) {
            System.out.println("Queue elements=" + element);
        }
        System.out.println();

        queue.remove();
        queue.remove();
        queue.remove();

        try {
            System.out.println("Removed From Queue" + queue.remove());
        } catch (NoSuchElementException ex) {
            System.out.println("Tried to remove too many items from queue");
        }
        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        queue2.offer(20);
        queue2.offer(21);
        if(queue2.offer(30)==false){
            System.out.println("Offer failed to add third item");
        }
        for(Integer value: queue2){
            System.out.println("Queue 2 value="+value);
        }   
        System.out.println("Queue 2 poll"+queue2.poll());
        System.out.println("Queue 2 poll"+queue2.poll());
        System.out.println("Queue 2 poll"+queue2.poll());
    }

}

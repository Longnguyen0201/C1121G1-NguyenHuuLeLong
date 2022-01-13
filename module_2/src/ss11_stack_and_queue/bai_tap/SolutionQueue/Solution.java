package ss11_stack_and_queue.bai_tap.SolutionQueue;


public class Solution {
    public static class Queue {
        private Node front;
        private Node rear;

    }

    public class Node {
        private int data;
        private Node link;

    }

    public void enQueue(Queue queue, int data) {
        Node newNode = new Node();
        if (queue.front == null) {
            newNode = queue.front;
        } else {
            newNode = queue.rear.link;
        }
        newNode = queue.rear;
        queue.rear.link = queue.front;

    }

    public void deQueue(Queue queue) {
        int data;
        if (queue.front == null) {
            System.out.println(" Queue is empty ");
        } else if (queue.front == queue.rear) {
            data = queue.front.data;
            queue.rear = null;
            queue.front = null;
        } else {
            data = queue.front.data;
            queue.front = queue.front.link;
            queue.rear.link = queue.front;
        }
    }
}
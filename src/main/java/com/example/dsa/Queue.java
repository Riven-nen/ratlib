package com.example.dsa;

import java.util.ArrayList;

public class Queue {
    public int length = -1;
    ArrayList<Object> queue = new ArrayList<>();

    public Queue() {
        length = -1;
    }

    public boolean empty() {
        return length == -1;
    }

    /**
     * Add an element to the end of the queue
     * @param data to be appended
     */
    public void enqueue(Object data) {
        queue.add(data);
        length++;
    }

    /**
     * Remove the first element in the queue
     * Return the dequeued element
     */
    public Object dequeue() {
        if (empty()) {
            System.out.println("Stack Empty");
            System.exit(1);
        }
        Object return_value = queue.get(0);
        queue.remove(0);
        length--;

        return return_value;
    }

    public Object peek() {
        if (empty()) {
            System.out.println("Stack Empty");
            return null;
        }

        return queue.get(0);
    }
}

package com.example.dsa;

import java.util.ArrayList;

public class Stack {
    int top;
    ArrayList<Object> stack = new ArrayList<>();

    public Stack() {
        top = -1;
    }
    /**
     * Pushes a new element onto the stack
     * @param data the element to add
     */
    public void push(Object data) {
        top++;
        stack.add(data);
    }

    /**
     * Returns whether the stack is empty or not.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        // If the top of the stack is -1, there are no elements
        // in the stack and isEmpty should return true
        return top == -1;
    }

    /**
     * Removes the top element from the stack
     * @return the popped element
     */
    public Object pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        Object return_value = stack.get(top);
        stack.remove(top);
        top--;
        return return_value;
    }

    /**
     * Return the top element without removing it.
     * @return the top element in the stack
     */
    public Object peek() {
        if(isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }

        return stack.get(top);
    }

}


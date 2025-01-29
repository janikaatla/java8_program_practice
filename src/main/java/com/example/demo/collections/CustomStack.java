package com.example.demo.collections;

import java.util.EmptyStackException;

public class CustomStack<T> {

    private T[] data;
    private int top;
    private int capacity;

    // Constructor
    public CustomStack(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        top = -1; // Initially stack is empty
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if stack is full
    public boolean isFull() {
        return (top == capacity - 1);
    }

    // Push an element onto the stack
    public void push(T item) {
        if (isFull()) {
            throw new StackOverflowError("Stack Overflow");
        }
        top++;
        data[top] = item;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = data[top];
        top--;
        return item;
    }

    // Peek at the top element of the stack
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    // Get the size of the stack
    public int size() {
        return top + 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
    }
}
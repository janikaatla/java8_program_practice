package com.example.demo.collections;

public class CustomQueue<T> {

    private T[] data;
    private int front;
    private int rear;
    private int capacity;

    // Constructor
    public CustomQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        front = rear = -1; // Initially empty
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return (front == -1);
    }

    // Check if queue is full
    public boolean isFull() {
        return ((rear + 1) % capacity == front);
    }

    // Enqueue: Add an element to the rear
    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue Overflow");
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        data[rear] = item;
    }

    // Dequeue: Remove and return the element at the front
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }
        T item = data[front];
        if (front == rear) {
            front = rear = -1; // If only one element
        } else {
            front = (front + 1) % capacity;
        }
        return item;
    }

    // Peek: Return the element at the front without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    // Main method for testing
    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());
    }
}
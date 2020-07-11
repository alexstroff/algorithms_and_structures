package Lesson3;

import java.util.NoSuchElementException;

public class Queue {
    private int capacity;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        head = 0;
        tail = -1;
        items = 0;
    }

    public int getHead() {
        return head;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int[] getQueue() {
        return queue;
    }

    public void setQueue(int[] queue) {
        this.queue = queue;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == capacity;
    }

    public int size() {
        return items;
    }

    public int getSize(){
        return items;
    }

    public void setSize(int val){
         items = val;
    }



    public void insert(int value) {
        if (isFull()) {
            capacity *= 2;
            int[] newQ = new int[capacity];
            if (tail >= head) {
                System.arraycopy(queue, 0, newQ, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, newQ, 0, tail + 1);
                System.arraycopy(queue, head,
                        newQ, capacity - (queue.length - head),
                        queue.length - head - 1);
            }
            queue = newQ;
        }
        if (tail == capacity - 1)
            tail = -1;
        queue[++tail] = value;
        items++;
    }

    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[head++];
        head %= capacity; // if (head == capacity) head = 0;
        items--;
        return temp;
    }

    public int peek() {
        return queue[head];
    }

    //t[h.........]
    // [h||||||t..]
    // [....h||t..]
    // [|t..h|||||]
    // [|t..................]

}
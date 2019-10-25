package com.trojan.algs.less3;

import com.trojan.algs.less2.Array;

public class Queue {
    private int maxSize;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Queue(int size){
        this.maxSize = size;
        queue = new int[size];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty(){
        return items == 0;
    }

    public  boolean isFull(){
        return items == maxSize;
    }

    public int size(){
        return items;
    }

    public void insert(int i){
        if (isFull()){
            maxSize *= 2;
            int[] temp = new int[maxSize];
            if (tail >= head){
                System.arraycopy(queue,0,temp,0,queue.length);
            } else {
                System.arraycopy(queue,0,temp,0,tail+1);
                System.arraycopy(queue,head,temp,maxSize - (queue.length - head),queue.length - head);
                head = maxSize - head - 1;
            }
            queue = temp;
        }
        if (tail == maxSize - 1)
            tail = - 1;
        queue[++tail] = i;
        items++;
    }

    public int remove(){
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        if(head == maxSize)
            head = 0;
        items--;
        return temp;
    }

    public int peek(){
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return queue[head];
    }
}

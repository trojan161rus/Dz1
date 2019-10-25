package com.trojan.algs.less4;

public class DoubleRelatedList {

    private Node head;
    private Node tail;

    public DoubleRelatedList(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;

    }

    public void push(String name, int age){
        Node n = new Node(name,age);
        n.next = head;
        if (head == null){
            tail = n;
        }else{
            head.prev = n;
        }
        head = n;
    }

    public Node pop(){
        if (isEmpty()){
            return null;
        } else {
            Node tmp = tail;
            tail.prev.next = null;
            tail = tail.prev;
            return tmp;
        }
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null){
            sb.append(current);
            current = current.next;
            sb.append((current == null)?" ]":", ");
        }
        return sb.toString();
    }

    public Node find(String name, int age){
        Node n = new Node(name, age);
        Node current = head;
        while(!current.equals(n)){
            if (current.next == null) return null;
            else current = current.next;
        }
//        meta info
        return current;
    }

}

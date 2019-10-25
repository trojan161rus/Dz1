package com.trojan.algs.less4;

import java.util.Objects;

public class RelatedList {

    private Node head;

    public RelatedList(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(String name, int age){
        Node n = new Node(name,age);
        n.next = head;
        head = n;
    }

    public Node pop(){
        if (isEmpty()){
            return null;
        } else {
            Node tmp = head;
            head = head.next;
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

    public Node delete(String name, int age){
        Node n = new Node(name, age);
        Node current = head;
        Node previous = head;
        while(!current.equals(n)){
            if (current.next == null) return null;
            else{
                previous = current;
                current = current.next;
            }
        }
        if (current == head){
            head = head.next;
        }else {
            previous.next = current.next;
        }
        return current;
    }



}

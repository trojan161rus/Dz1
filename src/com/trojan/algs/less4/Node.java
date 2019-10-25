package com.trojan.algs.less4;

import java.util.Objects;

public class Node {

    Node next;
    Node prev;

    String  name;
    int age;

    public Node(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("(Name: %s, age: %s)", name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return age == node.age &&
                Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

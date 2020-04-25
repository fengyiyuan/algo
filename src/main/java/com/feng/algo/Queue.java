package com.feng.algo;

public class Queue<T> {


    private Node first;
    private Node last;
    private int N;

    private class Node {
        T t;
        Node next;
    }

    public void enqueue(T t) {
        Node oldLast = last;

        last = new Node();
        last.next = null;
        last.t = t;

        if (first == null) {
            first = last;
        } else {
            oldLast.next = last;
        }

        N++;


    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T t = first.t;

        first = first.next;
        if (isEmpty()) {
            last = null;
        }

        N--;

        return t;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }


}

package com.feng.algo;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node first;
    private int N = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public T next() {
                return pop();
            }
        };
    }

    private class Node {
        T t;
        Node next;
    }

    public void push(T t) {
        Node old = first;
        first = new Node();
        first.t = t;
        first.next = old;
        N++;
    }

    public T pop() {

        if (isEmpty()) {
            return null;
        }

        Node tmp = first;
        first = first.next;
        N--;
        return tmp.t;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

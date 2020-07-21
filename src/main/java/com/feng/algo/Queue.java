package com.feng.algo;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Queue<T> implements Iterable<T> {


    private Node first;
    private Node last;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return isEmpty();
            }

            @Override
            public T next() {
                return dequeue();
            }
        };
    }


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

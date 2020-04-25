package com.feng.algo;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return N > 0;
            }

            @Override
            public T next() {
                return arr[--N];
            }
        };
    }


    private int N = 0;

    private T[] arr;

    public ResizingArrayStack () {

        arr = (T[]) new Object[N];
    }

    public void push(T t) {
        resize();
        arr[N++] = t;
    }

    public T pop() {

        if (isEmpty()) {
            return null;
        }

        T t = arr[--N];
        resize();

        return t;

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void resize() {

        if (arr.length > N && arr.length <= N * 2) {
            return;
        }

        int max = 0;
        if (arr.length <= N) {
            max = N * 2;
            if (N == 0) {
                max = 1;
            }

        } else if (arr.length > N * 2) {
            max = arr.length / 2;
        }

        T[] tmp = (T[]) new Object[max];

        for (int i = 0; i < N; i++) {
            tmp[i] = arr[i];
        }

        arr = tmp;
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");


        Iterator<String> iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------------");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}

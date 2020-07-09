package com.feng.sort2;

import java.util.concurrent.ConcurrentHashMap;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] arr;

    private int size = 0;

    public MaxPQ(int size) {
        arr = (Key[])new Comparable[size + 1];
    }

    public void insert(Key key) {

        arr[++size] = key;

        swim(size);
    }

    private void swim(int pos) {

        int par = pos / 2;

        while (par > 0 && less(par, pos)) {

            exec(par, pos);

            pos = par;

            par = pos / 2;

        }

    }

    private void sink(int p) {


        int c = p * 2;

        if (c + 1 <= size && less(c, c + 1)) {
            c = c + 1;
        }



    }

    private void exec(int i,int j) {
        Key tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    private boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }


    public Key max() {

        if (isEmpty())
            return null;

        return arr[1];
    }

    public Key delMax() {

        Key max = max();


        exec(1, size);

        arr[size] = null;
        size--;

        sink(1);

        return max;
    }

    public boolean isEmpty() {

        return size() == 0;
    }

    public int size() {

        return size;
    }



}

package com.feng.sort;

import java.util.HashMap;
import java.util.Map;

public class IndexMinPQ<Item extends Comparable<Item>> {

    Item[] items;

    int[] pq;

    int[] qp;

    int N = 0;

    public IndexMinPQ(int maxN) {
        items = (Item[])new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i < maxN + 1; i++) {
            qp[i] = -1;
        }
    }

    public void insert(int k, Item item) {
        if (!contains(k)) {
            N++;
            qp[k] = N;
            pq[N] = k;
            items[k] = item;
            swim(N);
        } else {
            int n = qp[k];
            swim(n);
            sink(n);
        }

    }

    public boolean contains(int k) {
        return items[k] != null;
    }

    public void swim(int k) {

        while (k > 0) {
            int p  = k / 2;
            if (less(p, k)) break;
            exec(p, k);
            k = p;
        }

    }

    public void sink(int k) {
        while (k * 2 <= N) {
            int c = k * 2;
            if (c < N && less(c + 1, c)) c++;
            if (less(k, c)) break;

            exec(k, c);
            k = c;
        }
    }

    public Item min() {
        return items[pq[1]];
    }

    public int delMin() {
        int minIdx = pq[1];
        exec(1, N--);
        sink(1);
        items[minIdx] = null;


        return minIdx;

    }

    public boolean less (int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    public void exec(int i, int j) {
        int tmp = pq[j];
        pq[j] = pq[i];
        pq[i] = tmp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;


    }



}

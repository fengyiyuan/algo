package com.feng.sort;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int max) {
        pq = (Key[])new Comparable[max];
    }


    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {

        Key max = pq[1];
        exec(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int c = k * 2;
            if (less(pq[c], pq[c + 1])) c++;
            if (!less(pq[k], pq[c])) break;
            exec(k, c);
            k = c;
        }
    }

    private void swim(int k) {

        while (k > 1) {
            int p = k / 2;
            if (!less(pq[p], pq[k])) {
                break;
            }
            exec(k, p);
            k = p;
        }

    }

    private boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }

    private void exec(int i, int j) {

        Key tmp  = pq[i];
        pq[i] = pq [j];
        pq[j] = tmp;

    }

}

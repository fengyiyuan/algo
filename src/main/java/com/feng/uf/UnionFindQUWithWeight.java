package com.feng.uf;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindQUWithWeight {

    private int[] id;
    private int[] sz;
    private int conut;

    public UnionFindQUWithWeight(int count) {
        this.conut = count;
        this.id = new int[count];
        this.sz = new int[count];

        for(int i = 0; i < count; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {

        if (p != id[p]) {
            id[p] = find(id[p]);
        }

        return id[p];

    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        int pSzie = sz[pRoot];
        int qSzie = sz[qRoot];

        if (pSzie > qSzie) {
            id[qRoot] = pRoot;
            sz[pRoot] += qSzie;
        } else {
            id[pRoot] = qRoot;
            sz[qRoot] += pSzie;
        }

        conut--;
    }

    public int getConut() {
        return this.conut;
    }


    public static void main(String[] args) {

        int total = StdIn.readInt();
        UnionFindQUWithWeight uf = new UnionFindQUWithWeight(total);

        long s = System.currentTimeMillis();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (uf.connected(p, q)){
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + "  " + q);
        }

        StdOut.println(uf.getConut() + " components");
        long e = System.currentTimeMillis();

        StdOut.println("times: " + (e - s));
    }



}

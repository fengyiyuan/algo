package com.feng.uf;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindQU {

    private int[] id;
    private int conut;

    public UnionFindQU(int count) {
        this.conut = count;
        this.id = new int[count];

        for(int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {

        while (p != id[p]) {
            p = id[p];
        }

        return p;
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

        id[pRoot] = qRoot;

        conut--;
    }

    public int getConut() {
        return this.conut;
    }


    public static void main(String[] args) {

        int total = StdIn.readInt();
        UnionFindQU uf = new UnionFindQU(total);

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
    }



}

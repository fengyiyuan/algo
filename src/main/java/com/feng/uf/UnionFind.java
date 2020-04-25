package com.feng.uf;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {

    private int[] id;
    private int conut;

    public UnionFind(int count) {
        this.conut = count;
        this.id = new int[count];

        for(int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {

        if (connected(p, q)) {
           return ;
        }

        int pId = id[p];
        int qId = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }

        conut--;
    }

    public int getConut() {
        return this.conut;
    }


    public static void main(String[] args) {

        int total = StdIn.readInt();
        UnionFind uf = new UnionFind(total);

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

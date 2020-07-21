package com.feng.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Digraph {

    private int V;
    private int E;

    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        adj = new Bag[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }

    }

    public Digraph(In in) {
        this(in.readInt());
        int e = in.readInt();

        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {

        return this.V;
    }

    public int E() {

        return this.E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;


    }

    public Iterable<Integer> adj(int v) {

        return adj[v];
    }

    public Digraph reverse() {

        Digraph dg = new Digraph(this.V);

        for (int i = 0; i < this.V; i++) {
            for (Integer v : this.adj(i)) {
                dg.addEdge(v, i);
            }
        }

        return dg;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.V).append(" vetrics, ").append(this.E).append(" edges.\n");

        for (int i = 0; i < this.V; i++) {
            sb.append(i).append(": ");

            for (Integer w : this.adj(i)) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In(args[0]));

        System.out.println(digraph.toString());;

    }
}

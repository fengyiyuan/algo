package com.feng.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {

    private Integer V;

    private Integer E;

    private Bag<Integer>[] adj;


    public Graph(int V) {
        this.V = V;
        this.E = 0;

        adj = new Bag[this.V];

        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();

        for (int i = 0; i < E; i++) {

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

        this.adj[v].add(w);
        this.adj[w].add(v);
        E++;

    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.V).append(" verties, ").append(this.E).append(" edges\n");

        for (int i = 0; i < this.V; i++) {
            Iterable<Integer> adj = this.adj(i);
            sb.append(i).append(": ");
            adj.forEach(w -> sb.append(w).append(" "));
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));

        System.out.println(g.toString());
    }

}

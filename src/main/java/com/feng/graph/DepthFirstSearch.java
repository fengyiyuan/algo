package com.feng.graph;

import edu.princeton.cs.algs4.In;

public class DepthFirstSearch extends Search {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        int v = g.V();
        marked = new boolean[v];

        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;

        Iterable<Integer> adj = g.adj(v);

        for (Integer w : adj) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }


    @Override
    boolean marked(int v) {
        return marked[v];
    }

    @Override
    int count() {
        return count;
    }


    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        int s = Integer.valueOf(args[1]);

        DepthFirstSearch search = new DepthFirstSearch(g, s);

        StringBuilder sb = new StringBuilder();

        for (int v = 0; v < g.V(); v++) {
            if (search.marked(v)) {
                sb.append(v).append(" ");
            }
        }

        sb.append("\n");

        if (search.count() != g.V()) {
            sb.append("NOT ");
        }

        sb.append("CONNECTED.");

        System.out.println(sb.toString());
    }

}

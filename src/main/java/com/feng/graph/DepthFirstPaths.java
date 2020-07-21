package com.feng.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths implements Paths {

    private boolean[] marked;

    private int[] edgeTo;

    private final int s;


    public DepthFirstPaths(Graph g, int s) {

        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;

        for(int i = 0; i < g.V(); i++) {
            edgeTo[i] = i;
        }





    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        Iterable<Integer> adj = g.adj(v);

        for (Integer w : adj) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }



    @Override
    public boolean hasPathsTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {

        if (!hasPathsTo(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }

        stack.push(s);

        return stack;
    }
}

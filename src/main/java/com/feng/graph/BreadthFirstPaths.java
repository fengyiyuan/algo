package com.feng.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths implements Paths {


    private boolean[] marked;

    private int[] edgeTo;

    private final int s;


    public BreadthFirstPaths(Graph g, int s) {

        this.s = s;
        this.marked = new boolean[g.V()];

        this.edgeTo = new int[g.V()];

        for (int i = 0; i < this.edgeTo.length; i++) {
            this.edgeTo[i] = i;
        }


        bfs(g, s);

    }

    private void bfs(Graph g, int s) {

        Queue<Integer> list = new LinkedList<Integer>();

        marked[s] = true;

        list.add(s);

        while (!list.isEmpty()) {

            Integer v = list.poll();

            for (Integer w : g.adj(v)) {

                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    list.add(w);
                }

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

        Stack stack = new Stack();


        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);

        }
        stack.push(s);

        return stack;
    }
}

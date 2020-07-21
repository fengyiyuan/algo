package com.feng.graph;


import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Search {

    private boolean[] marked;

    private int count;



    public BreadthFirstSearch(Graph g, int s) {

        this.marked = new boolean[g.V()];
        bfs(g, s);

    }

    private void bfs(Graph g, int v) {

        Queue<Integer> queue = new LinkedList<>();

        marked[v] = true;
        queue.offer(v);

        while (!queue.isEmpty()) {

            Integer t = queue.poll();

            for (Integer w : g.adj(t)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }


    }


    @Override
    boolean marked(int v) {
        return false;
    }

    @Override
    int count() {
        return 0;
    }
}

package com.feng.graph;

public class Cycle {


    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph g) {

        int v = g.V();

        marked = new boolean[v];

        for (int x = 0; x < v; x++) {
            if (!marked[x]) {
                dfs(g, x, x);
            }
        }



    }

    private void dfs(Graph g, int v, int u) {
        marked[v] = true;

        for (Integer w : g.adj(v)) {

            if (!marked[w]) {
                dfs(g, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }



    public boolean hasCycle() {
        return hasCycle;
    }

}

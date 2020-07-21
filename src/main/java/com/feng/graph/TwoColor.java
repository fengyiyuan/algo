package com.feng.graph;

public class TwoColor {

    private boolean[] marked;
    private boolean[] color;

    private boolean isTwoColorable = true;

    public TwoColor(Graph g) {

        int v = g.V();

        marked = new boolean[v];
        color = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }

    }

    private void dfs(Graph g, int v) {

        marked[v] = true;

        for (Integer w : g.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(g, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }

    }


    public boolean isTwoColorable() {
        return isTwoColorable;
    }

}

package com.feng.graph;

public class CC {


    private boolean[] marked;

    private int conut;

    private int[] id;


    public CC(Graph g) {

        int v = g.V();
        marked = new boolean[v];
        id = new int[v];

        for (int i = 0; i < v; i++) {

            if (!marked[i]) {
                dfs(g, i);
                conut++;
            }
        }
    }


    private void dfs(Graph g, int v) {

        marked[v] = true;
        id[v] = conut;

        for (Integer w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }

    }


    public boolean connected(int v, int w) {

        return id[v] == id[w];
    }


    public int count() {

        return conut;
    }

    public int id(int v) {

        return id[v];
    }

}

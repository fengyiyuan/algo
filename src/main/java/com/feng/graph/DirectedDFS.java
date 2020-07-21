package com.feng.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class DirectedDFS {

    private boolean marked[];

    public DirectedDFS(Digraph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    public DirectedDFS(Digraph g, Iterable<Integer> sources) {
        marked = new boolean[g.V()];

        sources.forEach(s -> {
            dfs(g, s);
        });

    }

    private void dfs(Digraph g, int s) {

        marked[s] = true;

        for (Integer w : g.adj(s)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }

    }


    public static void main(String[] args) {

        Digraph g = new Digraph(new In(args[0]));

        Bag<Integer> sources = new Bag<>();
        for (int i = 1; i < args.length; i++) {
            sources.add(Integer.parseInt(args[i]));
        }

        DirectedDFS reachable = new DirectedDFS(g, sources);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g.V(); i++) {
            if (reachable.marked[i]) {
                sb.append(i).append(" ");
            }
        }


        System.out.println(sb.toString());



    }

}

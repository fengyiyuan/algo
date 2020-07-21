package com.feng.graph;

public interface Paths {

    public boolean hasPathsTo(int v);

    public Iterable<Integer> pathTo(int v);

}

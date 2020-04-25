package com.feng.sort;

import edu.princeton.cs.algs4.StdIn;

public class InsertionX extends AbstractSortable {

    @Override
    public void sort(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
                }
            }
        }

    }

    public static InsertionX getInstance() {
        return new InsertionX();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        getInstance().sort(a);
        assert isSorted(a);
        show(a);

    }
}

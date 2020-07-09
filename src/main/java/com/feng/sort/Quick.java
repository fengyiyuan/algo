package com.feng.sort;

import edu.princeton.cs.algs4.StdIn;

public class Quick extends AbstractSortable  {

    private Comparable[] aux = null;

    @Override
    public void sort(Comparable[] a) {

        sort(a, 0, a.length - 1);

    }

    private void sort(Comparable[] a, int lo, int hi) {

        if (lo >= hi) return;

        int p = partition(a, lo, hi);

        sort(a, lo, p - 1);
        sort(a, p + 1, hi);

    }


    private int partition(Comparable[] a, int lo, int hi) {

        Comparable c = a[lo];


        int i = lo, j = hi + 1;

        while (true) {


            while (less(a[++i], c)){
                if (i >= hi) {
                    break;
                }
            }

            while (less(c, a[--j])) {
                if (j <= lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);

        }

        exch(a, lo, j);

        return j;
    }





    public static Quick getInstance() {
        return new Quick();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        show(a);
        getInstance().sort(a);
        assert isSorted(a);
        show(a);

    }
}

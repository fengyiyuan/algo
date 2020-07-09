package com.feng.sort;

import edu.princeton.cs.algs4.StdIn;

public class Merge extends AbstractSortable {

    private Comparable[] aux = null;
    @Override
    public void sort(Comparable[] a) {

        aux = new Comparable[a.length];


        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {

        if (hi < lo) return;

        int mid = lo + (hi - lo) / 2;


        if (mid > lo) {
            sort(a, lo, mid);
        }

        if (hi - mid > 1) {
            sort(a, mid + 1, hi);
        }

        merge(a, lo, mid, hi);

    }

    public void merge(Comparable[] a, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {

            if (i > mid) a[k] = aux[j++];
            else if( j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];

        }


    }

    public static Merge getInstance() {
        return new Merge();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        getInstance().sort(a);
        assert isSorted(a);
        show(a);

    }

}

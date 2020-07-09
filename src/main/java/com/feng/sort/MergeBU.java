package com.feng.sort;

import edu.princeton.cs.algs4.StdIn;

public class MergeBU extends AbstractSortable  {

    private Comparable[] aux = null;

    @Override
    public void sort(Comparable[] a) {

       aux = new Comparable[a.length];

        for (int sz = 1; sz <= a.length; sz += sz) {

            System.out.println(String.format("size: %d =============", sz));

            for (int lo = 0; lo < a.length - sz; lo = lo + sz * 2) {
                int hi = lo + sz * 2 - 1;
                if (hi > a.length - 1) {
                    hi = a.length - 1;
                }
                int mid = lo + (hi - lo) / 2;

                System.out.println(String.format("lo: %d, mid: %d, hi: %d", lo, mid, hi));

                merge(a, lo, mid, hi);
                for (int i = lo; i <= hi; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
            }

        }
    }




    public void merge(Comparable[] a, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {

            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }




    public static MergeBU getInstance() {
        return new MergeBU();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        show(a);
        getInstance().sort(a);
        assert isSorted(a);
        show(a);

    }
}

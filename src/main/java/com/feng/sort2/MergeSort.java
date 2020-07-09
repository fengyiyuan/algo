package com.feng.sort2;

import java.util.Arrays;

public class MergeSort<T extends Comparable>  extends AbsSort  {

    private Comparable[] aux;

    public MergeSort(T[] t) {
        super(t);
        aux = new Comparable[t.length];
    }

    @Override
    public AbsSort sort() {

        sort(0, arr.length - 1);

        return this;
    }

    private void sort(int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = (lo + hi) / 2;

        sort(lo, mid);
        sort(mid + 1, hi);

        merge(lo, mid, hi);

    }

    private void merge(int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {

            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (less(aux, i, j)) arr[k] = aux[i++];
            else arr[k] = aux[j++];

        }


    }

}

package com.feng.sort2;

public class SelectionSort<T extends Comparable>  extends AbsSort {


    public SelectionSort(T[] t) {
        super(t);
    }

    public SelectionSort sort() {
        if (arr == null || arr.length == 0) {
            return this;
        }

        int len = arr.length;

        for (int i =0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(j, min)) {
                    min = j;
                }
            }

            if (min != i) {
                exec(i, min);
            }

        }

        return this;


    }




}

package com.feng.sort2;

public class InsertionSort<T extends Comparable>  extends AbsSort {
    public InsertionSort(Comparable[] t) {
        super(t);
    }

    @Override
    public AbsSort sort() {

        for (int i = 1; i < arr.length; i++) {

            Comparable v = arr[i];
            for (int j = i; j > 0 && less(j, j - 1); j--) {
                    exec(j - 1, j);
            }

        }



        return this;
    }
}

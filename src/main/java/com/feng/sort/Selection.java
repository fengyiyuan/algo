package com.feng.sort;

import com.feng.algo.In;
import edu.princeton.cs.algs4.StdIn;

public class Selection extends AbstractSortable {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {

            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static Selection getInstance() {
        return new Selection();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        getInstance().sort(a);
        assert isSorted(a);
        show(a);

    }

}

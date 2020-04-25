package com.feng.sort;

import edu.princeton.cs.algs4.StdIn;

public class Insertion extends AbstractSortable {

    @Override
    public void sort(Comparable[] a) {

        int exangeTime = 0;
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
                    exangeTime++;
                }
            }
        }

        if (exangeTime == 0) {
            return;
        }

        for (int i = 2; i < a.length; i++) {
            Comparable v = a[i];

            int j = i;
            while (less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }

            if (j != i) {
                a[j] = v;
            }

        }


    }

    public static Insertion getInstance() {
        return new Insertion();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        getInstance().sort(a);
        assert isSorted(a);
        show(a);

    }
}

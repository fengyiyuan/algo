package com.feng.sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Shell extends AbstractSortable {

    @Override
    public void sort(Comparable[] a) {

        int N = a.length;
        int h = N / 3;
        while (h > 0 ) {
            System.out.println(h);
            for(int i = h; i < a.length; i += h) {
                if (less(a[i], a[i - h])) {
                    for (int j = i; j > 0 && less(a[j], a[j - h]); j -= h) {
                        exch(a, j, j - h);
                    }
                }
            }

            if (h == 1) {
                h = 0;
            } else if (h < 3) {
                h = 1;
            } else {
                h = h / 3;
            }
        }



    }

    public static Shell getInstance() {
        return new Shell();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        getInstance().sort(a);
        assert isSorted(a);
        show(a);


    }
}

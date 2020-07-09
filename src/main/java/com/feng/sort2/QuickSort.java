package com.feng.sort2;

public class QuickSort<T extends Comparable>  extends AbsSort  {

    public QuickSort(Comparable[] t) {
        super(t);
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

        int p = partition(lo, hi);

        sort(lo, p - 1);
        sort(p + 1, hi);

    }

    private int partition(int lo, int hi) {

        int i = lo, j = hi + 1;

        while (true) {
            while (less(++i, lo)) {
                if (i >= hi) {
                    break;
                }
            }

            while (less(lo, --j)) {
                if (j <= lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exec(i, j);

        }

        exec(lo, j);

        return j;
    }

}

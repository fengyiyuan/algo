package com.feng.sort2;

public class ShellSort<T extends Comparable>  extends AbsSort  {

    public ShellSort(Comparable[] t) {
        super(t);
    }

    @Override
    public AbsSort sort() {


        int len = arr.length;

        int h = 1;

        while (h < len / 3) h = 3 * h + 1;

        while (h > 0) {

            for (int i = h; i < len; i = i + h) {

                for (int j = i; j > 0 && less(j, j - h); j = j - h) {
                    exec(j - h, j);
                }

            }

            h = h / 3;

        }


        return this;
    }

}

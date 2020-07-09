package com.feng.sort2;

public class BubbleSort<T extends Comparable>  extends AbsSort  {

    public BubbleSort(Comparable[] t) {
        super(t);
    }

    @Override
    public AbsSort sort() {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (less(j, i)) {
                    exec(i, j);
                }
            }
        }


        return this;
    }

}

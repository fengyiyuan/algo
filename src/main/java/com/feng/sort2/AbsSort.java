package com.feng.sort2;

import java.util.Arrays;

public abstract class AbsSort<T extends Comparable> {

    protected T[] arr;

    public AbsSort(T[] t) {
        arr = Arrays.copyOf(t, t.length);
    }

    protected boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    protected boolean less(Comparable[] a, int i , int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    protected void exec(int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public void print() {

        if (arr == null || arr.length == 0) {
            System.out.println("arr is null.");
        }
        System.out.println();
        for (T s : arr) {
            System.out.print(s + "\t");
        }
        System.out.println(this.getClass().getSimpleName());
    }

    public abstract AbsSort sort();

}

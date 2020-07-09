package com.feng.sort;

import java.util.Comparator;

public class Quick2<T> {


    public static <T> void sort(T[] arr, Comparator<T> comparator) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        sort(arr, 0, arr.length - 1, comparator);

    }

    private static <T> void sort(T[] arr, int lo, int hi, Comparator c) {

        if (lo >= hi) {
            return;
        }

        int p = partation(arr, lo, hi, c);


        sort(arr, lo, p - 1, c);
        sort(arr, p + 1, hi, c);


    }

    private static <T> int partation(T[] arr, int lo, int hi, Comparator c) {

        int p = lo;

        int i = lo + 1, j = hi;


        while (true) {

            while (i < hi && compare(arr[p], arr[i], c)) {
                i++;
            }

            while (j > lo && compare(arr[j], arr[p], c)) {
                j--;
            }

            if (i >= j) {
                break;
            }

            exch(arr, i, j);

        }
        exch(arr, p, j);

        return j;
    }

    private static <T> boolean compare(T t1, T t2, Comparator c) {
        return c.compare(t1, t2) > 0;
    }

    private static <T> void exch(T[] arr, int i , int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        String[] sarr = new String[] {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        sort(sarr, Comparator.naturalOrder());

        for (int i = 0; i < sarr.length; i++) {
            System.out.print(sarr[i] + " ");
        }
        System.out.println();

    }
}

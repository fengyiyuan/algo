package com.feng.sort;

public class HeapSort extends AbstractSortable {



    @Override
    public void sort(Comparable[] a) {
        int n = a.length;

        for (int i = n / 2; i > 0; i--) {
            sink(a, i, n);
        }
        
        while (n > 1){
            exch(a, 1, n);
            n--;
            sink(a, 1, n);
        }

    }

    public void sink(Comparable[] a, int k, int n) {

        while (k * 2 <= n) {
            int c = k * 2;
            if (less(a[c], a[c + 1])) c++;
            if (less(a[c], a[k])) break;
            exch(a, k, c);
            k = c;
        }


    }


}

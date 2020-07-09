package com.feng.sort2;

public class MergeBUSort<T extends Comparable>  extends AbsSort  {

    private Comparable[] aux;

    public MergeBUSort(T[] t) {
        super(t);
        aux = new Comparable[t.length];
    }

    @Override
    public AbsSort sort() {

        for (int sz = 1; sz < arr.length; sz+=sz) {

            for (int i = 0; i < arr.length - sz; i += sz * 2) {

                merge(i, i + sz - 1, Math.min(arr.length - 1, i + sz * 2 - 1));

            }

        }



        return this;
    }

    private void merge(int lo, int mid, int hi) {

//        System.out.println("lo : " + lo + ", mid: " + mid + ", hi: " + hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {

            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (less(aux, i, j)) arr[k] = aux[i++];
            else arr[k] = aux[j++];


        }

    }

}

package com.feng.sort2;

import java.util.Arrays;

public class TestSort2 {


    public static void main(String[] args) {
        String[] arr = {"S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};

        new SelectionSort(arr).sort().print();
        new BubbleSort(arr).sort().print();
        new InsertionSort(arr).sort().print();
        new ShellSort(arr).sort().print();
        new MergeSort(arr).sort().print();
        new MergeBUSort(arr).sort().print();
        new QuickSort(arr).sort().print();

    }
}

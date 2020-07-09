package com.feng.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test4 {

    public static void main(String[] args) {
        Test4 t = new Test4();

        t.addNum(1);
        t.addNum(2);
        System.out.println(t.findMedian());
        t.addNum(3);
        System.out.println(t.findMedian());

    }


    /**
     * 最大堆 存小的一半，最小堆存大的一半 minPQ.size() - maxPQ.size() <=1
     */
    private PriorityQueue<Integer> maxPQ = null; // 小的一半
    private PriorityQueue<Integer> minPQ = null; // 大的一半


    /** initialize your data structure here. */
    public Test4() {

        maxPQ = new PriorityQueue<>((n1, n2) -> n2 - n1);
        minPQ = new PriorityQueue<>((n1, n2) -> n1 - n2);


    }


    public void addNum(int num) {

        if (minPQ.size() == 0) {
            minPQ.add(num);
        } else {
            Integer midMax = minPQ.peek();
            Integer midMin = maxPQ.peek();
            if (minPQ.size() == maxPQ.size()) {
                if (num >= midMin) {
                    minPQ.add(num);
                } else {
                    maxPQ.poll();
                    minPQ.add(midMin);
                    maxPQ.add(num);
                }
            } else {
                if (num <= midMax) {
                    maxPQ.add(num);
                } else {
                    minPQ.poll();
                    maxPQ.add(midMax);
                    minPQ.add(num);
                }
            }


        }


    }

    public double findMedian() {

        if (minPQ.size() == 0) {
            return 0;
        }

        if (minPQ.size() == maxPQ.size()) {
            return ((double)minPQ.peek() + (double)maxPQ.peek()) / 2;
        } else {
            return (double)minPQ.peek();
        }

    }

}

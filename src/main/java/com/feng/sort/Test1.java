package com.feng.sort;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, -3,9,1,7,7,9,10,2,2,10,10,3,-1,3,7,-9,-1,3,3};

        Map<Integer, Integer> map = new HashMap<>();

        Comparator.naturalOrder();
        Comparator.reverseOrder();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        pq.addAll(map.keySet());


        List<Integer> list = new ArrayList();

        while(pq.peek() != null) {
            list.add(pq.poll());
        }


        list.toArray(new Integer[list.size()]);

    }
}

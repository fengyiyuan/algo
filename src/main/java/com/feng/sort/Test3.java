package com.feng.sort;

public class Test3 {

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] ret = new double[nums.length - k + 1];
        int [] tmp = new int[nums.length];
        for(int i = 0; i <= nums.length - k; i++) {
            ret[i] = mid(nums, i, i + k - 1);
        }
        return ret;
    }

    private double mid(int[] nums, int lo, int hi) {

        int[] tmp = new int[hi - lo + 1];

        for (int i = lo; i <= hi; i++) {
            tmp[i - lo] = nums[i];
        }

        int c = tmp.length;
        double ret;
        if (c % 2 == 0) {
            ret = (select(tmp, 0, c - 1, c >> 1) + select(tmp, 0, c - 1, (c >> 1) - 1)) / 2;
        } else {
            ret = select(tmp, 0, c - 1, (c >> 1));
        }
        return ret;
    }


    private double select(int[] nums, int lo, int hi, int k) {

        while(lo < hi) {
            int p = partion(nums, lo, hi);
            if (p == k) {
                break;
            }
            else if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            }
        }

        return (double)nums[k];
    }

    private int partion(int[] nums, int lo, int hi) {

        int p = lo;
        int i = lo + 1, j = hi;

        while(true) {
            while(i < hi && less(nums, i, p)) {
                i++;
            }

            while(j > lo && less(nums, p, j)) {
                j--;
            }
            if (i >= j) {
                break;
            }
            exch(nums, i, j);

        }

        exch(nums, p, j);


        return j;
    }

    private boolean less(int[] nums, int i, int j) {
        return nums[i] <= nums[j];
    }
    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,2,7,3,7,9,0,2,3};

        double[] doubles = new Test3().medianSlidingWindow(nums, 9);

        for (double v : doubles) {
            System.out.print(v + " ");
        }
        System.out.println();

    }
}

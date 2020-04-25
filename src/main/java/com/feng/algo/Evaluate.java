package com.feng.algo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Evaluate {


    public static void main(String[] args) {

        Stack<String> opers = new Stack<>();
        Stack<Double> nums = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            StdOut.println(s);

            if (")".equals(s)) {
                Double b = nums.pop();
                Double a = nums.pop();
                String oper = opers.pop();

                if ("+".equals(oper))
                    nums.push(a + b);
                if ("-".equals(oper))
                    nums.push(a - b);
                if ("*".equals(oper))
                    nums.push(a * b);
                if ("/".equals(oper))
                    nums.push(a / b);


            } else if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                opers.push(s);
            } else if (!"(".equals(s)){
                nums.push(Double.valueOf(s));
            }

        }
        StdOut.println(nums.pop());
    }

}

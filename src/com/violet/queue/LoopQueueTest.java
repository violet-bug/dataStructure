package com.violet.queue;

public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue lq = new LoopQueue("1111", 5);
        lq.add("aaaa");
        lq.add("bbbb");
        lq.add("cccc");
        lq.add("dddd");


        System.out.println(lq.toString());
    }
}

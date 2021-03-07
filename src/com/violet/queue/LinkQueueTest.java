package com.violet.queue;

public class LinkQueueTest {
    public static void main(String[] args) {
        LinkQueue lq = new LinkQueue();
        lq.add("aaaa");
        lq.add("bbbb");
        lq.add("cccc");
        lq.add("dddd");

        System.out.println(lq.remove());

        System.out.println(lq.toString());
    }
}

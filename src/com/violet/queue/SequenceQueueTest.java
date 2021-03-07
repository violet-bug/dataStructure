package com.violet.queue;

public class SequenceQueueTest {
    public static void main(String[] args) {
        SequenceQueue sq = new SequenceQueue();
        sq.add("aaaa");
        sq.add("bbbb");
        sq.add("cccc");
        sq.add("dddd");

        sq.clear();

        System.out.println(sq.toString());
    }
}

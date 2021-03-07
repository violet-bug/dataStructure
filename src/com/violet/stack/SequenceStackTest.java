package com.violet.stack;

public class SequenceStackTest {
    public static void main(String[] args) {
        SequenceStack ss = new SequenceStack();
        ss.push("aaaa");
        ss.push("bbbb");
        ss.push("cccc");
        ss.push("dddd");

        ss.clear();

        System.out.println(ss.toString());
    }
}

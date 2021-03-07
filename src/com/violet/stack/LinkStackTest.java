package com.violet.stack;

public class LinkStackTest {
    public static void main(String[] args) {
        LinkStack ls = new LinkStack();
        ls.push("aaaa");
        ls.push("bbbb");
        ls.push("cccc");
        ls.push("dddd");

        System.out.println(ls);

        System.out.println(ls.toString());
    }
}

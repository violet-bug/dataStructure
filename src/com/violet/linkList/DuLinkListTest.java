package com.violet.linkList;

public class DuLinkListTest {
    public static void main(String[] args) {
        DuLInkList dl = new DuLInkList();
        dl.add("aaaa");
        dl.add("bbbb");
        dl.add("cccc");
        dl.add("dddd");

        System.out.println(dl.remove());
        System.out.println(dl.toString());
    }
}

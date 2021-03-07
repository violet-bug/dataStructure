package com.violet.linkList;

public class LinkList<T> {

    private class Node {
        //保存节点的数据
        private T data;
        //指针指向下一个节点的引用
        private Node next;

        //无参构造方法
        public Node() {}

        //初始化全部属性的构造器
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    //初始化头节点
    private Node header;
    //初始化尾节点
    private Node tail;

    //用于记录链表的长度
    private int size;

    public LinkList() {
        this.header = null;
        this.tail = null;
    }

    //以一个元素初始化链表
    public LinkList(T element) {
        header = new Node(element, null);
        tail = header;
        size++;
    }

    //返回链表的长度
    public int length() {
        return size;
    }

    //返回index索引的数据
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    //根据index获取相应的节点
    public Node getNodeByIndex(int index) {
        if (index < 0 || index > size -1) new IndexOutOfBoundsException("链表越界异常");
        Node current = header;
        for (int i = 0; i < size && current != null; i++, current = current.next) {
            if (i == index) {
                return current;
            }
        }
        return null;
    }

    //查找链式表中指定元素的索引
    public int locate(T element) {
        Node current = header;
        for (int i = 0; i < size - 1 && current != null; i++, current = current.next) {
            if (element.equals(current.data)) {
                return i;
            }
        }
        return -1;
    }

    //向链表指定位置插入一个元素
    public void insert(T element, int index) {
        if (index < 0 || index > size) new IndexOutOfBoundsException("数组越界异常");
        if (header == null) {
            add(element);
        }else {
            if (index == 0) {
                addHeader(element);
            } else {
                Node pre = getNodeByIndex(index - 1);
                pre.next = new Node(element, pre.next);
                size++;
            }

        }
    }

    //采用尾插法插入新节点
    public void add(T element) {
        if (header == null) {
            header = new Node(element, null);
            tail = header;
        }else {
            Node newNode = new Node(element, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //采用头插法向链表插入新节点
    public void addHeader(T element) {
        header = new Node(element, header);
        if (tail == null) {
            tail = header;
        }
        size ++;
    }

    //删除链表中指定索引的元素
    public T delete(int index) {
        if (index < 0 || index > size -1) new IndexOutOfBoundsException("数组越界异常");
        Node del = null;
        if(index == 0) {
            del = header;
            header = header.next;
        } else {
            Node pre = getNodeByIndex(index - 1);
            del = pre.next;
            pre.next = del.next;
            del.next = null;
        }
        size--;
        return del.data;
    }

    //删除链表中最后一个元素
    public T remove() {
        return delete(size -1);
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //清空链表
    public void clear() {
        header = null;
        tail = null;
        size = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.next) {
                sb.append(current.data.toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len-2, len).append("]").toString();
        }
    }
}


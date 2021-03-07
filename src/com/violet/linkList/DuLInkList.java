package com.violet.linkList;

public class DuLInkList<T> {
    private class Node {
        //数据
        private T data;
        //前一个元素
        private Node next;
        //后一个元素
        private Node prev;

        //无参构造函数
        public Node() {
        }

        //有参构造函数
        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    //头节点
    private Node header;
    //尾节点
    private Node tail;
    //链表的长度
    private int size;


    //初始化一个空链表
    public DuLInkList() {
        header = null;
        tail = null;
    }

    //以一个元素初始化链表
    public DuLInkList(T element) {
        header = new Node(element, null, null);
        tail = header;
        size++;
    }

    //返回链表的长度
    public int length() {
        return size;
    }

    //返回链表中索引为index的元素
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) new IndexOutOfBoundsException("数组越界异常");

        if (index < size / 2) {
            Node current = header;
            for (int i = 0; i < size / 2 && current != null; i++, current = current.next) {
                if (i == index) {
                    return current;
                }
            }
        } else {
            Node current = tail;
            for (int i = size - 1; i > size / 2 && current != null; i++, current = current.prev) {
                if (i == index) {
                    return current;
                }
            }
        }
        return null;
    }

    //查找链表中指定元素的索引
    public int locate(T element) {
        Node current = header;
        for (int i = 0; i < size && current != null; i++, current = current.next) {
            if (element.equals(current.data)) {
                return i;
            }
        }
        return -1;
    }

    //向线性表指定位置插入一个元素
    public void insert(T element, int index) {
        if (index < 0 || index > size) new IndexOutOfBoundsException("数组越界异常");

        if (header == null) {
            add(element);
        } else {
            if (size == 0) {
                addHeader(element);
            }

            Node prev = getNodeByIndex(index - 1);
            Node next = prev.next;
            Node newNode = new Node(element, prev, next);
            prev.next = newNode;
            next.prev = newNode;
            size++;
        }
    }

    //采用尾插法来为链表添加新元素
    public void add(T element) {
        if (header == null) {
            header = new Node(element, null, null);
            tail = header;
        } else {
            Node newNode = new Node(element, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //采用头插法为链表添加新元素
    public void addHeader(T element) {
        header = new Node(element, null, header);
        if (tail == null) {
            tail = header;
        }
        size++;
    }

    //删除链表中指定索引处的元素
    public T delete(int index) {
        if (index < 0 || index > size - 1) new IndexOutOfBoundsException("数组越界异常");

        Node del = null;
        if (index == 0) {
            del = header;
            header = header.next;
            header.prev = null;
        } else {
            Node prev = getNodeByIndex(index - 1);
            del = prev.next;
            prev.next = del.next;
            if (del.next != null) {
                del.next.prev = prev;
            }
            del.next = null;
            del.prev = null;

        }
        size--;
        return del.data;
    }

    //删除链表的最后一个元素
    public T remove() {
        return delete(size - 1);
    }

    //链表是否为空
    public boolean isEmpty() {
        return size == 0;
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
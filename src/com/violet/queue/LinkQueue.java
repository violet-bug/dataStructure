package com.violet.queue;

public class LinkQueue<T> {

    private class Node {
        //指针指向下一个引用
        private Node next;

        //数据
        private T data;

        public Node() {
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //保存该队列的头节点
    private Node front;
    //保存该队列的尾节点
    private Node rear;
    //保存该队列中已包含的节点数
    private int size;

    //创建空链队列
    public LinkQueue() {
        front = null;
        rear = null;
    }

    //已指定的元素来创建链队列，该队列只有一个元素
    public LinkQueue(T element) {
        front = new Node(element, null);
        rear = front;
        size++;
    }

    //返回队列的长度
    public int length() {
        return size;
    }

    //将新元素加入队列
    public void add(T element) {
        if (front == null) {
            front = new Node(element, null);
            rear = front;
        } else {
            Node newNode = new Node(element, null);
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    //删除front段的元素
    public T remove() {
        Node oldNode = front;
        front = front.next;
        oldNode.next = null;
        size--;
        return oldNode.data;
    }

    //返回最后一个元素，但不删除
    public T element() {
        return rear.data;
    }

    //判断队列是否为空队列
    public boolean isEmpty() {
        return size == 0;
    }

    //清空队列
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (Node current = front; current != null; current = current.next) {
            sb.append(current.data.toString() + ", ");
        }
        int len = sb.length();
        return sb.delete(len - 2, len).append("]").toString();
    }

}

package com.violet.stack;


public class LinkStack<T> {
    private class Node {
        //节点数据
        private T data;
        //指针指向下一个节点的引用
        private Node next;

        public Node() {
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //保存该链栈的栈顶元素
    private Node top;
    //保存该栈的长度
    private int size;

    public LinkStack() {
        top = null;
    }

    //以一个元素初始化栈
    public LinkStack(T element) {
        top = new Node(element, null);
        size++;
    }

    //返回链栈的长度
    public int length() {
        return size;
    }

    //进栈
    public void push(T element) {
        top = new Node(element, top);
        size++;
    }

    //出栈
    public T pop() {
        Node oldValue = top;
        top = top.next;
        oldValue.next = null;
        size--;
        return (T)oldValue.data;
    }

    //访问栈顶元素
    public T peek() {
        return (T)top.data;
    }

    //判断链栈是否为空栈
    public boolean isEmpty() {
        return size == 0;
    }

    //清空栈
    public void clear() {
        top = null;
        size = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = top; current != null; current = current.next) {
                sb.append(current.data.toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len-2, len).append("]").toString();
        }
    }


}

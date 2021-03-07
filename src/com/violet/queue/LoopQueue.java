package com.violet.queue;

import java.util.Arrays;

public class LoopQueue<T> {
    private int DEFAULT_SIZE = 10;

    //保存数组的长度
    private int capacity;

    //定义一个数组用于保存循环队列的元素
    private Object[] elementData;

    //头节点，尾节点
    private int front;
    private int rear;

    //初始化一个空的循环队列
    public LoopQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个元素来初始化循环队列
    public LoopQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    //以指定长度来创建循环队列
    public LoopQueue(T element, int initSize) {
        capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    //返回队列的长度
    public int length() {
        if (isEmpty()) {
            return 0;
        }
        return rear > front ? rear - front : capacity - (front - rear);
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear && elementData[front] == null;
    }

    //插入队列
    public void add(T element) {
        if (front == rear && elementData[front] != null) new IndexOutOfBoundsException("队列已满");
        elementData[rear++] = element;
        if (front == rear && elementData[front] != null) rear = rear == capacity ? 0 : rear;
    }

    //移出队列
    public T remove() {
        if (isEmpty()) {
            new IndexOutOfBoundsException("队列为空");
        }
        T oldValue = (T)elementData[front];
        elementData[front++] = null;
        front = front == capacity ? 0 : front;
        return oldValue;
    }

    //返回队列顶的元素
    public T element() {
        if (isEmpty()) {
            new IndexOutOfBoundsException("队列为空");
        }
        return (T)elementData[front];
    }

    //清空循环链表
    public void clear() {
        Arrays.fill(elementData, null);
        rear = 0;
        front = 0;
    }

    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        if (front < rear) {
            for (int i =front; i < rear; i++) {
                sb.append(elementData[i].toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }else {
            for (int i = front; i < capacity; i++) {
                sb.append(elementData[i].toString() + ", ");
            }
            for (int i = 0; i < rear; i++) {
                sb.append(elementData[i].toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

}

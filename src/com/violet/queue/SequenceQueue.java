package com.violet.queue;

import java.util.Arrays;

public class SequenceQueue<T> {
    private int DEFAULT_SIZE = 10;
    //保存数组的长度
    private int capacity;

    //定义一个数组用于保存顺序队列的元素
    private Object[] elementData;

    //头节点与尾节点
    private int front = 0;
    private int rear = 0;

    //以默认长度创建空顺序队列
    public SequenceQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始化元素来创建顺序队列
    public SequenceQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    //获取队列的大小
    public int length() {
        return rear - front;
    }

    //插入队列
    public void add(T element) {
        if (rear > capacity) {
            new IndexOutOfBoundsException("队列已满");
        }
        elementData[rear++] = element;
    }

    //移出队列
    public T remove() {
        if (isEmpty()) new IndexOutOfBoundsException("队列为空");

        T oldValue = (T)elementData[front];
        elementData[front++] = null;
        return oldValue;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return (rear - front) == 0;
    }

    //取队列首元素, 但不删除元素
    public T element() {
        if (isEmpty()) new IndexOutOfBoundsException("队列为空");

        return (T) elementData[front];
    }

    //清空队列
    public void clear() {
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for(int i = front; i < rear; i++){
                sb.append(elementData[i].toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len-2, len).append("]").toString();
        }
    }
}

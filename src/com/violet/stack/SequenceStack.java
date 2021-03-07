package com.violet.stack;

import java.util.Arrays;

public class SequenceStack<T> {
    private int DEFAULT_SIZE = 10;
    //保存数组的长度
    private int capacity;
    //定义当底层数组长度不够是，程序每次增加的数组长度
    private int capacityIncrement;
    //定义一个数组用于保存每个顺序栈的元素
    private Object[] elementData;
    //保存顺序栈中当前元素的个数
    private int size;

    //以默认数组长度创建空顺序栈
    public SequenceStack() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个元素初始化顺序栈
    public SequenceStack(T element) {
        this();
        elementData[0] = element;
        size++;
    }

    //以指定长度初始化顺序栈
    public SequenceStack(T element, int initSize) {
        capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    //以指定长度初始化顺序栈，并指定扩容数组长度的步长
    public SequenceStack(T element, int initSize, int capacityIncrement) {
        capacity = initSize;
        this.capacityIncrement = capacityIncrement;
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    //获取栈的长度
    public int length() {
        return size;
    }

    //入栈
    public void push(T element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;

    }

    //动态扩容数组长度
    private void ensureCapacity(int minCapacity) {
        if (capacity < minCapacity) {
            if (capacityIncrement > 0) {
                while(capacity < minCapacity) {
                    capacity += capacityIncrement;
                }

            }else {
                while(capacity < minCapacity) {
                    capacity <<= 1;
                }
            }
        }

        elementData = Arrays.copyOf(elementData, capacity);
    }

    //出栈
    public T pop() {
        T oldValue = (T) elementData[size-1];
        elementData[--size] = null;
        return oldValue;
    }

    //返回栈顶元素
    public T peek() {
        return (T)elementData[size - 1];
    }

    //判断是否为空栈
    public boolean isEmpty() {
        return size == 0;
    }

    //清空顺序栈
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }


    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for(int i = size - 1; i > -1; i--){
                sb.append(elementData[i].toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len-2, len).append("]").toString();
        }
    }


}

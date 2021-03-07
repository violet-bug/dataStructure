package com.violet.list;

import java.util.Arrays;

public class SequenceList<T> {
   //初始化数组默认长度
   private int  DEFAULT_SIZE = 16;
   //数组的长度
   private int capacity;
   //定义一个数组用于保存顺序线性表的元素
   private Object[] elementData;

   //保存顺序线性表中的当前个数
   private int size;

   //以默认长度创建一个空顺序线性表
   public SequenceList() {
       capacity = DEFAULT_SIZE;
       elementData = new Object[capacity];
   }

   //以一个初始化元素来创建顺序线性表
   public SequenceList(T element) {
       this();
       elementData[0] = element;
       size++;
   }

    /**
     * 指定长度来创建一个顺序线性表
     * @param element 初始化元素
     * @param initSize 初始化长度
     */
   public SequenceList(T element, int initSize) {
       capacity = 1;
       while(capacity < initSize) {
           capacity <<= 1;
       }
       elementData = new Object[capacity];
       elementData[0] = element;
       size++;
   }

   //获取顺序线性表的大小
   public int length() {
       return size;
   }

   //获取索引 i 处的元素
   public Object get(int i) {
       if (i < 0 || i > size -1) new IndexOutOfBoundsException("数组越界异常");

       return (T)elementData[i];
   }

   //获取某个元素的索引
   public int locate(T element) {
       for (int i = 0; i < size - 1; i++) {
           if (element.equals(elementData[i])) {
               return i;
           }
       }
       return -1;
   }

   //在指定位置插入一个元素
   public void insert(T element, int index) {
       if (index < 0 || index > size) new IndexOutOfBoundsException("数组越界异常");
       ensureCapacity(size + 1);
       System.arraycopy(elementData, index, elementData, index +1, size - index);
       elementData[index] = element;
       ++size;
   }

    //在顺序线性表的结尾处添加一个元素
    public void add(T element) {
        insert(element, size);
    }

   //扩容数组的长度
   public void ensureCapacity(int initCapacity) {
       //如果所需的数组长度大于当前数组的长度
       if (initCapacity > capacity) {
           while(capacity < initCapacity) {
               capacity <<= 1;
           }
       }
       elementData = Arrays.copyOf(elementData, capacity);
   }

   //删除指定位置的元素
   public T delete(int index) {
       if (index < 0 || index > size - 1) new IndexOutOfBoundsException("数组越界异常");

       T oldValue = (T)elementData[index];
       int numMove = size - index -1;
       if (numMove > 0) {
           System.arraycopy(elementData, index + 1, elementData, index, numMove);
       }
       elementData[--size] = null;
       return oldValue;
   }

   //删除最后一个位置的元素
   public T remove() {
       return delete(size - 1);
   }

   //判断这个顺序线性表是否为空
   public boolean isEmpty() {
       return size == 0;
   }

   //将数组清空
   public void clear() {
       Arrays.fill(elementData, null);
       size = 0;
   }

   //打印数组
   public void display() {
       for (int i = 0; i < size; i++) {
           System.out.println(elementData[i]);
       }
   }
}

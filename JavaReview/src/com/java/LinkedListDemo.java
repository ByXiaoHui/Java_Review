package com.java;

import java.util.LinkedList;

/**
 * @ClassName LinkedListDemo
 * @Author 何辉
 * @Date 2021/3/19 15:49
 **/
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(123);
        linkedList.add(false);
        linkedList.add("abc");
        System.out.println(linkedList);
        linkedList.add(2,"mashibing");
        System.out.println(linkedList);
        linkedList.addFirst("1111");
        System.out.println(linkedList);
        linkedList.addLast("2222");
        System.out.println(linkedList);
        System.out.println(linkedList.element());
        linkedList.offer("3333");
        System.out.println(linkedList);
    }
}

package com.java;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName CollectionDemo
 * @Author 何辉
 * @Date 2021/3/18 18:08
 **/
public class CollectionDemo {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        System.out.println(collection.size());
        Object[] objects = collection.toArray();

    }
}

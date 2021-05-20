package com.xiaohui.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName BookFactroy
 * @Author 何辉
 * @Date 2021/5/11 19:51
 **/
public class BookFactroy implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setBname("java");
        book.setAuthor("程序员");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}

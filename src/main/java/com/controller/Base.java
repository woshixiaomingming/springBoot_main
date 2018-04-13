package com.controller;

import com.common.Page;

/**
 * 保证所有的请求进来所需要的参数都存在与page中
 */
public class Base {

    private static final ThreadLocal<Page> local = new ThreadLocal<Page>();

    public static void set (Page page) {
        local.set(page);
    }

    public static Page get () {
        return local.get();
    }
}

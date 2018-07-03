package com.main;

import java.util.concurrent.*;

public class SyncService {

    /**
     * 核心池的大小
     */
    private int corePoolSize;

    /**
     * 线程池所能容忍的最大的线程数量
     */
    private int maximumPoolSize;

    /**
     * 线程存活的时间 当前线程被挂起之后
     */
    private long keepAliveTime;

    /**
     * 线程时间操作的属性 可以用来暂停等操作
     */
    private TimeUnit unit;

    /**
     * 任务缓存队列
     */
    private BlockingQueue<Runnable> workQueue;

    /**
     * 线程工厂用来创建线程
     */
    private ThreadFactory threadFactory;

    /**
     * 线程中出现错误的处理
     */
    private RejectedExecutionHandler handler;

    /**
     * 创建当前的
     * @return
     */
    public ThreadPoolExecutor threadPool () {
        return Executors.newScheduledThreadPool();
    }

    public static void main(String[] args) {

    }

}

package com.main;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

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
     * 创建当前的自定义线程池
     * @return
     */
    public ThreadPoolExecutor threadPool () {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MINUTES, workQueue, handler);
    }


    /*public boolean addWorkQueue (Runnable run) {
        final ReentrantLock rt = new ReentrantLock();
        rt.lock();
        try {

        } finally {
            rt.unlock();
        }
    }*/

    public static boolean dd = false;

    public void aa () {
        if (!dd) {
            synchronized (SyncService.class){
                if (dd) {
                    System.out.println(11);
                    return;
                }
                System.out.println(222);
                SyncService.dd = true;
            }
        } else {
            System.out.println(333);
        }
    }



    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("aaa");
                    SyncService syncService = new SyncService();
                    syncService.aa();
                }
            }).start();
        }
    }

}

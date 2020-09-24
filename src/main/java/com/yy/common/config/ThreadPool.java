package com.yy.common.config;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: com.fantasi.zhulihexie
 * @ClassName: ThreadPool
 * @Author: Created By Yy
 * @Date: 2020-05-09 09:27
 */
public class ThreadPool {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(15,
            20,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(300),
            new DefaultThreadFactory());


    public static void execute(Runnable runnable){
        executor.execute(runnable);
    }




    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "source-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}

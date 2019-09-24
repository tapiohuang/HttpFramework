package org.hystudio.httpframework.framework2.executor;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpSessionExecutorThreadPool {
    private ThreadPoolExecutor pool;

    public HttpSessionExecutorThreadPool() {
        pool = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new HttpSessionExecutorThreadPool.HttpSessionExecutorThreadPoolFactory()
        );
    }

    public void addHttpSessionExecutor(HttpSessionExecutor httpSessionExecutor) {
        pool.execute(httpSessionExecutor);
    }

    private static class HttpSessionExecutorThreadPoolFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        private HttpSessionExecutorThreadPoolFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(group, r, "HttpSessionExecutorThreadPool-" + threadNumber.getAndIncrement(), 0);
        }
    }
}
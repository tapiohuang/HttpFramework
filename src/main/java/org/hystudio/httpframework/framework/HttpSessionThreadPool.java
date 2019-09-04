package org.hystudio.httpframework.framework;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpSessionThreadPool {
    private ThreadPoolExecutor pool;

    public HttpSessionThreadPool() {
        pool = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new HttpSessionThreadPoolFactory()
        );
    }

    public void addSessionExecutor(HttpSession httpSession) {
        pool.execute(httpSession.getHttpSessionExecutor());
    }

    public static class HttpSessionThreadPoolFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public HttpSessionThreadPoolFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(group, r, "HttpSessionThread-" + threadNumber.getAndIncrement(), 0);
        }
    }
}

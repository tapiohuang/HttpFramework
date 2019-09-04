package org.hystudio.httpframework.framework;


import org.hystudio.httpframework.framework.exception.HttpSessionLockException;

public class HttpSessionLock {
    private final Object lock = new Object();
    /**
     * 0.未加锁，原始的Session
     * 1.执行中的锁，阻塞读取数据
     * 2.执行完成
     * 3。执行出错
     */
    private int status = 0;
    private Thread owner = null;

    public void executeLock() {
        synchronized (lock) {
            if (status != 0) {
                throw new HttpSessionLockException("执行锁加锁时，状态不为初始状态，status:" + status);
            } else {
                owner = Thread.currentThread();
                this.setStatus(1);
            }
        }
    }

    public void readLock() {
        synchronized (lock) {
            while (status == 0 || status == 1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            owner = Thread.currentThread();
        }
    }


    public void setStatus(int status) {
        Thread me = Thread.currentThread();
        if (me == owner) {
            this.status = status;
        }
    }

    public void unlock() {
        synchronized (lock) {
            Thread me = Thread.currentThread();
            if (me != owner) {
                return;
            }
            owner = null;
            lock.notifyAll();
        }
    }
}

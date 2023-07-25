package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    private String data;

    private ThreadSafeSingleton(String data){
        this.data = data;
    }
    public static  ThreadSafeSingleton getInstance(String data){
        ThreadSafeSingleton res = instance;
        if (res == null){
            synchronized (ThreadSafeSingleton.class){
                res = instance;
                if (res == null){
                    instance=res = new ThreadSafeSingleton(data);
                }
            }
        }
        return res;
    }

}

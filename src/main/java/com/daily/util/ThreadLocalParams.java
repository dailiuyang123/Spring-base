package com.daily.util;

/**
 * Created by Azir on 2018/2/1.
 */
public class ThreadLocalParams {

    //用来获取当前线程 内的参数  不用多次传参

    public static  final  ThreadLocal<String> threadLocal=new ThreadLocal<>();


    public void  setCurrentThreadParam(String param){
        threadLocal.set(param);
    }

    public String getCurrentThreadParam(){
        return threadLocal.get();
    }
}

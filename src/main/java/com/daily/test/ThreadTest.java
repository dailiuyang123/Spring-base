package com.daily.test;



/**
 * Created by Azir on 2017/12/28.
 */
public class ThreadTest {

    /**
    *  Author: 代刘洋
    *  Time：  2017/12/28  23:49
    *  Title:
    *  Param:
    *  Response:
    *  多线程 ：通过继承Thread 类。重载了 run()方法。实现了多线程
    */
    public static void main(String[] args) {
       Mythread mythread1=new Mythread("A");
       Mythread mythread2=new Mythread("B");


        mythread1.start();
        mythread2.start();

    }
}

class  Mythread  extends  Thread{
    private String  name;
    public   Mythread(String name){
            this.name=name;
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

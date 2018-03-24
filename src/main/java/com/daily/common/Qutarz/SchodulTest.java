package com.daily.common.Qutarz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Azir on 2018/2/1.
 *  使用spring 注解实现 定时任务
 */

//@Component
public class SchodulTest {

    public static  int i=0;
    @Scheduled(cron = "0/30 * * * * ? ")   //每30秒执行一次
    public void  DoJob(){
        System.out.println("----------定时任务开始---------");
        System.out.println("---------执行第"+i+1+"次 当前时间为："+ new Date()+"-----------");
        System.out.println("----------此次任务完成-------------");
    }

}

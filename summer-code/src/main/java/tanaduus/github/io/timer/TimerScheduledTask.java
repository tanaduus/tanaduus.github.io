package tanaduus.github.io.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 夏加龙
 * @date 2022/10/7
 */
public class TimerScheduledTask {

    /**
     * 原理：
     * 1.Timer构造器会启动一个线程抓取任务执行
     * 2.新建任务TimeTask会加入到TaskQueue
     * 3.下面就一样了
     */
    public static void main(String[] args) {
        Timer timer = new Timer("timer");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : 我5秒后执行");
            }
        }, 5000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : 我10秒后执行");
            }
        }, 10000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : 我15秒后执行");
            }
        }, 15000);
    }
}

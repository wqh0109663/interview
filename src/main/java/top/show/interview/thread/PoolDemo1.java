package top.show.interview.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-6-23 下午4:23
 */
public class PoolDemo1 {
    public static void main(String[] args) {
        /*
         * 阿里巴巴手册不推荐使用Executors创建
         */

        ExecutorService threadPool = Executors.newCachedThreadPool();


        ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(10,
                new BasicThreadFactory.Builder()
                        .namingPattern("")
                        .daemon(true)
                        .build());
        poolExecutor.execute(new Demo2());
        poolExecutor.shutdown();


    }


}

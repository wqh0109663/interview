package top.show.interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**创建线程的第三种方式
 * 实现Callable接口，重写call方法，结合FutureTask类
 * FutureTask类实现了Runnable接口
 *
 *
 *
 * @author 吴启欢
 * @version 1.0
 * @date 19-6-20 下午3:55
 */
public class Demo3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        return "start...";
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        FutureTask<String> stringFutureTask = new FutureTask<>(demo3);
        Thread thread = new Thread(stringFutureTask);
        thread.start();
        String s = null;
        try {
            s = stringFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);


    }


}

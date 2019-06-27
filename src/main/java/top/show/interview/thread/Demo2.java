package top.show.interview.thread;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-6-20 上午10:38
 */
public class Demo2 implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }

    public static void main(String[] args) {
        Demo2 demo1 = new Demo2();
        Thread thread = new Thread(new Demo2());
        thread.start();


        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}

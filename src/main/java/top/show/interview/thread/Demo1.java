package top.show.interview.thread;

/**创建线程的第一种方式，继承Thread类
 *
 * @author 吴启欢
 * @version 1.0
 * @date 19-6-19 下午8:35
 */
public class Demo1 extends Thread{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }

    public static void main(String[] args)  {

        Demo1 demo1 = new Demo1();
        demo1.start();
        Demo1 demo2 = new Demo1();
        demo2.start();

        String name = Thread.currentThread().getName();
        System.out.println(name);
    }





}

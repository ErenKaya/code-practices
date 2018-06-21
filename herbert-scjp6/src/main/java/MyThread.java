

public class MyThread extends Thread{
    public void run(){
        m1();
    }

    public MyThread(String threadName) {
        super(threadName);
    }
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        MyThread a=new MyThread("A");
        MyThread b=new MyThread("B");
        b.start();
        Thread.yield();
        a.run();
        
    }
}

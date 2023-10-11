package ThreadDemo1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer_Consumer {
    private static BlockingQueue<Integer> q=new ArrayBlockingQueue<Integer>(10);
    public static void main(String args[]) throws InterruptedException{
        Thread t1=new Thread(new Runnable(){
            public void run(){
                
                try {
                    Producer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable(){
            public void run(){
                
                try {
                    Consumer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
    public static void Producer() throws InterruptedException{
        Random random=new Random();
        while(true){
            q.put(random.nextInt(100));
        }
    }
    public static void Consumer() throws InterruptedException{
        Random random=new Random();
        while(true){
            Thread.sleep(100);
            if(random.nextInt(10)==0){
            Integer value=q.take();
            System.out.println("Int taken:"+value+" ;Array size:"+q.size());
            }
        }
    }
}

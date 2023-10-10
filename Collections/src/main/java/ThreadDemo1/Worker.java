package ThreadDemo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
    private Object lock1=new Object();
    private Object lock2=new Object();
    private Random random=new Random();
    private static List<Integer> l1=new ArrayList<>();
    private static List<Integer> l2=new ArrayList<>();
    public void stageOne(){
        synchronized(lock1){
            try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        l1.add(random.nextInt(100));

        }
    }
    public void stageTwo(){
        synchronized(lock2){
            try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        l2.add(random.nextInt(100));

        }
    }
    public void process(){
        for(int i=0;i<1000;i++){
            stageOne();
            stageTwo();
        }
    }
    public static void main(String args[]){
        Worker w1=new Worker();
        System.out.println("starting...");
        long start=System.currentTimeMillis();
        Thread t1=new Thread(new Runnable(){
            public void run(){
                w1.process();
            }
        });
        
        Thread t2=new Thread(new Runnable(){
            public void run(){
                w1.process();
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("Time taken "+ (end-start));
        System.out.println("List 1:"+l1.size()+"; List 2:"+l2.size());
    }
}

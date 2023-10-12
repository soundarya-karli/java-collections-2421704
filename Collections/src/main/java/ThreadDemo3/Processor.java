package ThreadDemo3;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Processor {
    LinkedList<Integer> list=new LinkedList<>();
    int LIMIT=10;
    Object lock=new Object();
    public void producer() throws InterruptedException{
        int value=0;
        while(true){
        synchronized(lock){
            while(list.size()==LIMIT){
                lock.wait();
            }
            System.out.println("Started Producer..");
            list.add(value++);
            lock.notify();  
        }
    }
    }
    public void consumes() throws InterruptedException{
        Random r=new Random();
       // Scanner sc=new Scanner(System.in);
        //Thread.sleep(3000);
        while(true){
        synchronized(lock){
           // System.out.println("Entry return key..");
           // sc.nextLine();
           // System.out.println("Return key pressed");
           while(list.size()==0){
            lock.wait();
           }
           System.out.println("Started Consumer..");
           System.out.print("Size:"+list.size());
           int val=list.removeFirst();
           System.out.println(";Value:"+val);
           lock.notify();
            Thread.sleep(r.nextInt(2000));
        }
    }
    }
}

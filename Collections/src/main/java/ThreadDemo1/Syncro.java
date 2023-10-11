package ThreadDemo1;

import java.util.Scanner;

class Processor1 extends Thread{
    private volatile boolean running=true;
    public void run(){
        int i=0;
        while(running){
        System.out.println("Hello "+i);
        i++;
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    }
    public void shutdown(){
        running=false;
    }
}
public class Syncro {
    public static void main(String args[]){
        Processor1 p1=new Processor1();
        p1.start();
        System.out.println("Press to shutdown..");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        p1.shutdown();
        sc.close();

    }
}

package ThreadDemo3;

import java.util.Scanner;

public class Processor {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Started Producer..");
            wait();
            System.out.println("Resume Producer");
        }

    }
    public void consumes() throws InterruptedException{
        Scanner sc=new Scanner(System.in);
        Thread.sleep(3000);
        synchronized(this){
            System.out.println("Entry return key..");
            sc.nextLine();
            System.out.println("Return key pressed");
            notify();
            Thread.sleep(5000);
        }

    }
}

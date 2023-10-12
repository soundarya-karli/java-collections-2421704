package ThreadDemo3;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
   Account a1=new Account();
       Account a2=new Account();
       private Lock lock1=new ReentrantLock();
       private Lock lock2=new ReentrantLock();

    public void first(){
      Random random=new Random();
      for(int i=0;i<1000;i++){
        lock1.lock();
        lock2.lock();
        try{
      Account.transfer(a1,a2,random.nextInt(100));}
      finally{
        lock1.unlock();
        lock2.unlock();
      }
      }
    }
    public void second(){
         Random random=new Random();
      for(int i=0;i<1000;i++){
      lock1.lock();
        lock2.lock();
        try{
      Account.transfer(a2,a1,random.nextInt(100));}
      finally{
        lock1.unlock();
        lock2.unlock();
      }
      }
    }
    public void finished(){
         System.out.println("Account 1 Bal: "+a1.getBalance());
         System.out.println("Account 2 Bal: "+a1.getBalance());
         System.out.println("Total Bal: "+(a1.getBalance()+a2.getBalance()));
    }
}

package ThreadDemo3;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
   Account a1=new Account();
       Account a2=new Account();
       private Lock lock1=new ReentrantLock();
       private Lock lock2=new ReentrantLock();
       private void acquireLocks(Lock l1, Lock l2){
        while(true){
            boolean gotl1=false;
            boolean gotl2=false;
            try{
                gotl1=l1.tryLock();
                gotl2=l2.tryLock();
            }
            finally{
                if(gotl1 && gotl2) return;
                if(gotl1){
                    l1.unlock();
                }
                if(gotl2){
                    l2.unlock();
                }
            }
        }
       }

    public void first(){
      Random random=new Random();
      for(int i=0;i<1000;i++){
        acquireLocks(lock1, lock2);
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
        acquireLocks(lock2, lock1);
      
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
         System.out.println("Account 2 Bal: "+a2.getBalance());
         System.out.println("Total Bal: "+(a1.getBalance()+a2.getBalance()));
    }
}

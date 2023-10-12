package ThreadDemo3;

public class Account {
    private int balance=10000;
    public void deposite(int amt){
         balance+=amt;
    }
    public void withdraw(int amt){
        balance-=amt;
    }
    public int getBalance(){
        return balance;
    }
    public static void transfer(Account a1,Account a2,int amt){
        a1.deposite(amt);
        a2.withdraw(amt);
    }
    
}

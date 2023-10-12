package ThreadDemo3;

public class App {
    public static void main(String args[]) throws InterruptedException{
        final Processor p=new Processor();
        Thread t1=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    p.producer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                }
            });
            Thread t2=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    p.consumes();
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
}

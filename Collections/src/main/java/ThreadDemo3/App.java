package ThreadDemo3;

public class App {
    public static void main(String args[]) throws InterruptedException{
       // final Processor p=new Processor();
        final Runner r=new Runner();
        Thread t1=new Thread(new Runnable() {

            @Override
            public void run() {
                // p.producer();
                   r.first();
                }
            });
            Thread t2=new Thread(new Runnable() {

            @Override
            public void run() {
                //p.consumes();
                r.second();
                }
            });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        r.finished();
    }
}

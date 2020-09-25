import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RPCThreadSync extends Thread {
    private static final int MYTHREADS = 2;
    public boolean first = true;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);

        for(int i = 0; i < 10; i++){
//            Runnable helloThread = new HelloThread();
//            Runnable byeThread = new ByeThread();
            Runnable helloThread = new RPCThreadSync().helloSync;
            Runnable byeThread = new RPCThreadSync().byeSync;
            Object lock = new RPCThreadSync().lock2;
//            Runnable thread = new RPCThreadSync().runCount;
            synchronized (lock){
                executor.execute(helloThread);
                executor.execute(byeThread);
//                executor.execute(helloThread);
//                executor.execute(byeThread);
            }
//            executor.execute(thread);

//            executor.execute(helloThread);
//            executor.execute(byeThread);
//            Runnable helloThread = new HelloThread();
//            executor.execute(helloThread);
//            Runnable byeThread = new ByeThread();
//            executor.execute(byeThread);

        }
        executor.shutdown();
    }

    Runnable helloSync = () -> {
        helloSync();
//        synchronized (this.lock1){
//            helloSync();
//        }

    };

    Runnable byeSync = () -> {
        byeSync();
//        synchronized (this.lock1){
//            byeSync();
//        }
    };

    public synchronized void helloSync(){
        System.out.print("1");
    }

    public synchronized void byeSync(){
        System.out.print("2");
    }
}
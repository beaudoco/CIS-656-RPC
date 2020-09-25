import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RPCThread extends Thread {
    private static final int MYTHREADS = 5;

    public static void main(String args[]) throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);

        for(int i = 0; i < 10; i++){
            Runnable helloThread = new HelloThread();
            executor.execute(helloThread);
            Runnable byeThread = new ByeThread();
            executor.execute(byeThread);

        }
        executor.shutdown();
    }
}

class HelloThread implements Runnable {

    @Override
    public void run() {
        System.out.print("1");
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

class ByeThread implements Runnable {

    @Override
    public void run() {
        System.out.print("2");
//        try {
//            Thread.sleep(350);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
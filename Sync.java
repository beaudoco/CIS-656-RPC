public class Sync {

    public volatile static Object obj =  new Object();

    public static void main(String[] args) {
        Runnable helloThread = new Sync().helloSync;
        Runnable byeThread = new Sync().byeSync;
        synchronized (obj){
            helloThread.run();
            byeThread.run();
        }
    }

    Runnable helloSync = () -> {
        for(int i = 0; i < 10; i++){
            helloSync();
        }
    };

    Runnable byeSync = () -> {
        for(int i = 0; i < 10; i++){
            byeSync();
        }
    };

    public void helloSync(){
        System.out.print("1");
    }

    public void byeSync(){
        System.out.print("2");
    }

}
public class Interleaved {

    public volatile static Object obj =  new Object();

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            Runnable helloThread = new Interleaved().helloSync;
            Runnable byeThread = new Interleaved().byeSync;
            synchronized (obj){
                helloThread.run();
                byeThread.run();
            }

        }
    }

    Runnable helloSync = () -> {
        helloSync();
    };

    Runnable byeSync = () -> {
        byeSync();
    };

    public void helloSync(){
        System.out.print("1");
    }

    public void byeSync(){
        System.out.print("2");
    }

}
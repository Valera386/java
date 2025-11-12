public class MyThread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.print("A");
        }
    }
}
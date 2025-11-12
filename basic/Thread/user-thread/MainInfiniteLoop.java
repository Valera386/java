public class MainInfiniteLoop {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
        while (true) {
            System.out.print(".");
        }
    }
}
public class MainFiniteLoop {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
        int laps = 10000;
        while (laps > 0) {
            System.out.print(".");
            laps--;
        }
    }
}
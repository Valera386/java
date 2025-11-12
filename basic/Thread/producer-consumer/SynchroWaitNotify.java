import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchroWaitNotify {
    public static String line = "";

    public static void main(String[] args) {
        Object locker = new Object();
        MyReader reader = new MyReader("lines.txt", locker);
        MyWriter writer = new MyWriter("lines_out.txt", locker);
        Thread t1 = new Thread(reader);
        Thread t2 = new Thread(writer);
        t1.setDaemon(true);
        t2.setDaemon(true);

        t2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchroWaitNotify.class.getName()).log(Level.SEVERE, null, ex);
        }
        t1.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(SynchroWaitNotify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class MyReader implements Runnable {
    FileReader fr = null;
    Object locker;

    public MyReader(String filePath, Object locker) {
        try {
            this.fr = new FileReader(filePath);
            this.locker = locker;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        int lineCounter = 0;
        String str = "";
        BufferedReader br = new BufferedReader(fr);
        try {
            while ((str = br.readLine()) != null) {
                System.out.println("Reader:" + str);
                if ((lineCounter++) % 2 == 0) {
                    synchronized (locker) {
                        SynchroWaitNotify.line = str;
                        locker.notify();
                        locker.wait();
                    }
                }
            }
            synchronized (locker) {
                SynchroWaitNotify.line = "exit";
                locker.notify();
                locker.wait();
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class MyWriter implements Runnable {
    FileWriter fw = null;
    Object locker;

    public MyWriter(String filePath, Object locker) {
        try {
            this.fw = new FileWriter(filePath, true);
            this.locker = locker;
        } catch (IOException ex) {
            Logger.getLogger(MyWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        synchronized (locker) {
            while (!SynchroWaitNotify.line.equals("exit")) {
                try {
                    locker.wait();
                    if (!SynchroWaitNotify.line.equals("exit")) {
                        fw.write(SynchroWaitNotify.line + System.getProperty("line.separator"));
                    }
                    System.out.println("*** Written line:" + SynchroWaitNotify.line);
                    locker.notify();
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(MyWriter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(MyWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

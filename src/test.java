public class test {
    private static boolean flagA = true;
    private static boolean flagB = false;


    public static void main(String[] args) {
        final Object lock = new Object();

        Thread at = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<26;) {
                    synchronized (lock) {
                        if(flagA) {
                            System.out.println(2*i+1);
                            System.out.println(2*i+2);
                            flagA = false;
                            flagB = true;
                            lock.notify();
                            i++;
                        }
                        else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread bt = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<26;) {
                    synchronized (lock) {
                        if(flagB) {
                            System.out.println(Character.toString('A'+i));
                            i++;
                            flagB=false;
                            flagA=true;
                            lock.notify();
                        }
                        else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });


//        Thread t1 = new Thread(new outputThread(1, lock));
//        Thread t2 = new Thread(new outputThread(2, lock));
        at.start();
        bt.start();
    }

}

class outputThread implements Runnable {
    private int num;
    private Object lock;

    public outputThread(int num, Object lock) {
        super();
        this.num = num;
        this.lock = lock;
    }

    public void run() {
        try {
            while(true) {
                synchronized (lock) {
                    lock.notifyAll();
                    lock.wait();
                    System.out.println(num);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
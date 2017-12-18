import com.fm.login.Authentication;

public class ThreadAttack extends Thread {

    private String name;
    private String start;
    private int num;
    private int diff;
    private int totalDigits;
    private static int countThread = 0;
    private static boolean running = true;

    public ThreadAttack(String name, int start, int num, int diff, int totalDigits) {

        this.name = name;
        this.start = String.format("%d",start);
        this.num = num;
        this.diff = diff;
        this.totalDigits = totalDigits;
//        System.out.println("The thread name is " + name);

    }

    public static boolean isRunning() {
        return running;
    }
    public static int getCountThread() { return  countThread;}

    @Override
    public synchronized void run() {

        countThread++;
        Authentication a = new Authentication();

        try {
            int end = num - diff;
//            System.out.println("Running thread " + name);
            String limit = "%0" + totalDigits + "d";
            for (Integer i = this.num; i >= end; i--) {
                String endNum = String.format(limit, i);
                if (a.login(name, this.start + endNum)) {
                    ThreadAttack.running = false;
                    System.out.println("\nThe system was cracked.\nUser: " + name + "\nPassword: " + start + endNum + "\n");
                    throw new RuntimeException(this.name + " thread interrupted the process");
                } else if (!isRunning())
                    throw new RuntimeException(this.name);
            }
//            System.out.println("Finished 1 by " + name);
        } catch(RuntimeException e) {
//            System.out.println(e.getMessage() + " exited safely");
            return;
        }
    }
}
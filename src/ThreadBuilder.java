import  java.lang.Math;
public class ThreadBuilder extends Thread{
    private String[] names;
    private int[] numbers;

    private int diff;
    private int len;
    private int diffDigits;

    private int totalDigits;

    public ThreadBuilder(String[] names, int[] numbers, int totalDigits, int diff) {
        this.names = names;
        this.numbers = numbers;
        this.totalDigits = totalDigits;
        this.diffDigits = this.totalDigits - String.format("%d",numbers[0]).length();
        this.len = ((int)Math.pow(10,diffDigits)) - 1;
        this.diff = diff;
    }

    public void start() {
        for(String name: names) {
            for(int num: numbers) {
                for(int i = len; i >= 0; i = i-diff) {
                    if(ThreadAttack.isRunning() == true) {
                        ThreadAttack t = new ThreadAttack(name, num, i, diff, diffDigits);
                        t.start();
                    } else {
                        break;
                    }
                }
                if(ThreadAttack.isRunning() == false)
                    break;
            }
            if(ThreadAttack.isRunning() == false)
                break;
        }
        System.out.println("The number of threads is: " + ThreadAttack.getCountThread());
    }


}

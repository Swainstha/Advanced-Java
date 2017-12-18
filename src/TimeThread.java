import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread extends Thread{

    public void run() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            while (!this.isInterrupted()) {
                Date date = new Date();
                System.out.println(dateFormat.format(date));
                this.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("The crack was found");
        }
    }
}

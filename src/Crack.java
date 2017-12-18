
public class Crack {
    public static void main(String[] args) {

        String[] names = {"ram", "sita", "roshan", "prajwal"};
        int[] numbers = {9841, 9848, 9849};
        ThreadBuilder threadBuilder = new ThreadBuilder(names,numbers,10,1000);
        threadBuilder.start();
    }

}

import java.util.Random;

public class goOrNot {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(2);
        if(n==0){
            System.out.println("no");
        }else{
            System.out.println("yes");
        }
    }
}
